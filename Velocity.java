/**
 *
 * @author Yakov Zlotnik
 *
 */
// Velocity specifies the change in position on the `x` and the `y` axes.
public class Velocity {
   private double dx;
   private double dy;
    // constructor
   /**
    *
    * @param dx - change of x coordinate
    * @param dy - change of y coordinate
    */
   public Velocity(double dx, double dy) {
       this.dx = dx;
       this.dy = dy;
   }
   /**
    *
    * @return change of x coordinate
    */
   public double getdx() {
       return this.dx;
   }
   /**
    *
    * @return change of y coordinate
    */
   public double getdy() {
       return this.dy;
   }
   /**
    *
    * @param angle - angle of velocity to apply
    * @param speed - scalar of velocity to apply
    * @return Velocity through the constructor
    * used this to determine the way to go around the circle
    */
   public static Velocity fromAngleAndSpeed(double angle, double speed) {
          double dx = (Math.sin(angle * (3.14 / 180))) * speed;
          double dy = (-Math.cos(angle * (3.14 / 180))) * speed;
          return new Velocity(dx, dy);
   }
   // Take a point with position (x,y) and return a new point
   // with position (x+dx, y+dy)
   /**
    *
    * @param p - Point to apply coordinate change via velocity
    * @return Point with applied coordinate change
    */
   public Point applyToPoint(Point p) {
       return new Point(p.getX() + this.dx, p.getY() + this.dy);
   }
}