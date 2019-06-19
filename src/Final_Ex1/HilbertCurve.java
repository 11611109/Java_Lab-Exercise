package Final_Ex1;
import java.awt.*;
import java.awt.geom.Line2D;
import java.util.ArrayList;
import java.util.List;

/**
 * 
 * Representation as Lindenmayer system
 * The Hilbert Curve can be expressed by a rewrite system (L-system). 
 *
 * Alphabet : a, b
 * Constants : F, R, L
 * Axiom : a
 * Production rules:
 *    a => L b F R a F a R F b L
 *    b => R a F L b F b L F b R
 * 
 * Constants: F, R, L
 * A1 = LFRFRFL
 * B1 = RFLFLFR
 * A(n) = L + B(n-1) + FR + A(n-1) + F + A(n-1) + RF + B(n-1) + L
 * B(n) = R + A(n-1) + FL + B(n-1) + F + B(n-1) + LF + B(n-1) + R
 *
 */
 
public class HilbertCurve {
   private int level;
   private List<Line2D.Double> lines;
   private double minX, maxX, minY, maxY;
   private VirtualTurtle turtle;
    
   public HilbertCurve (int level) {
      this(level, .0, .0, .0);
   }
   
   public HilbertCurve (int level, double x, double y, double angle) {
      this.level = level;
      turtle = new VirtualTurtle( x, y, angle);
      lines = new ArrayList<Line2D.Double>();
      A(level);
      calculateCanvasSize();
   }

   public void draw() {
      StdDraw.setXscale(minX, maxX);
      StdDraw.setYscale(minY, maxY);

      for (Line2D.Double s : lines) 
         StdDraw.line(s.x1, s.y1, s.x2, s.y2);
   }
   
   private void calculateCanvasSize() {
      double size = Math.max(maxX - minX, maxY - minY) * 1.2;
      double centerX = (minX + maxX) / 2;
      double centerY = (minY + maxY) / 2;
      minX = centerX - size / 2;
      maxX = centerX + size / 2;
      minY = centerY + size / 2;
      maxY = centerY - size / 2;
   }


/* A1 = LFRFRFL
 * B1 = RFLFLFR
 * A(n) = L + B(n-1) + FR + A(n-1) + F + A(n-1) + RF + B(n-1) + L
 * B(n) = R + A(n-1) + FL + B(n-1) + F + B(n-1) + LF + B(n-1) + R
 */
   private void A(int n) {
      if (n == 1) {  L(); F(); R(); F(); R(); F(); L(); return; }

      L(); B(n-1); F(); R(); A(n-1); 
      F(); A(n-1); R(); F(); B(n-1); L();
   }

   private void B(int n) {
      if (n == 1) {  R(); F(); L(); F(); L(); F(); R(); return; }

      R(); A(n-1); F(); L(); B(n-1); 
      F(); B(n-1); L(); F(); A(n-1); R();
   }

   private void L() { turtle.left(); }

   private void R() { turtle.right(); }

   private void F() {
      lines.add( turtle.forward() );
      minX = Math.min( turtle.getX(), minX);
      maxX = Math.max( turtle.getX(), maxX);
      minY = Math.min( turtle.getY(), minY);
      maxY = Math.max( turtle.getY(), maxY);
   }
   
   public static void main(String[] args) {
      System.out.println("use \"java HilbertCurves <Integer> \" to " + 
         "set the level of HilbertCurves (the default level is 5)");
      System.out.println("use \"java HilbertCurves <Integer> -d \" to " +
         "disable double buffering");
      int level = (args.length >= 1) ? Integer.parseInt(args[0]) : 5;
   
      boolean enableDoubleBuffering =
         !(args.length >= 2 && args[1].equals("-d"));
      if (enableDoubleBuffering)
         StdDraw.enableDoubleBuffering();
      HilbertCurve hc = new HilbertCurve(level);
      hc.draw();
      StdDraw.show();
   }
}
