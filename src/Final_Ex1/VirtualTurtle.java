package Final_Ex1;
import java.awt.geom.Line2D;

public class VirtualTurtle extends Turtle {

	public VirtualTurtle(double x, double y, double angle) {
		super( x, y, angle);
	}

   public void left()  { turnLeft(90); }
   public void right() { turnRight(90); }

	public Line2D.Double forward() {
		double oldx = getX();
		double oldy = getY();
		double x = getX() + Math.cos( Math.toRadians( getAngle()));
		double y = getY() + Math.sin( Math.toRadians( getAngle()));
		setX( x); setY( y);
		return new Line2D.Double( oldx, oldy, x, y);
	}
}
