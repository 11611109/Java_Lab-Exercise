package Final_Ex1;
import java.awt.*;
import java.awt.geom.Line2D;
import java.util.ArrayList;
import java.util.List;

/**
 * d0 = "F";
 * r0 = "F";
 *
 * d(n) = d(n-1) + "L" + r(n-1);
 * r(n) = d(n-1) + "R" + r(n-1);
 */

class DragonCurve {
   private int level;
   private List<Line2D.Double> lines;
   private double minX, maxX, minY, maxY;
   private VirtualTurtle turtle;
    
   public DragonCurve (int level) {
      this(level, .0, .0, .0);
   }
   
   public DragonCurve (int level, double x, double y, double angle) {
      this.level = level;
      turtle = new VirtualTurtle( x, y, angle);
      lines = new ArrayList<Line2D.Double>();
      dragon(level);
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

   private void dragon(int i) {
      if (i == 0) { forward(); return; }
      dragon( i-1 );
      left();
      nogard( i-1 );
   }

   private void nogard(int i) {
      if (i == 0) { forward(); return; }
      dragon( i-1 );
      right();
      nogard( i-1 );
   }

   private void left()  { turtle.left(); }

   private void right() { turtle.right(); }

   private void forward() {
      lines.add( turtle.forward() );
      minX = Math.min( turtle.getX(), minX);
      maxX = Math.max( turtle.getX(), maxX);
      minY = Math.min( turtle.getY(), minY);
      maxY = Math.max( turtle.getY(), maxY);
   }
   
   public static void main(String[] args) {
      System.out.println("use \"java DragonCurves <Integer> \" to set " +
         "the level of DragonCurves (the default level is 16)");
      System.out.println("use \"java DragonCurves <Integer> -d \" to " +
         "disable double buffering");
      int level = (args.length >= 1) ? Integer.parseInt(args[0]) : 16;
   
      boolean enableDoubleBuffering =
         !(args.length >= 2 && args[1].equals("-d"));
      if (enableDoubleBuffering)
         StdDraw.enableDoubleBuffering();
      DragonCurve dc = new DragonCurve(level);
      dc.draw();
      StdDraw.show();
   }
}
