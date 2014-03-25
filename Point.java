/**
 * @author Yakov Zlotnik
 *
 */
public class Point {
    private double x;
    private double y;
    /**
     *
     * @param x - coordinate
     * @param y - coordinate
     */
    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }
    /**
     *
     * @return x - coordinate of the Point
     */
    public double getX() {
        return this.x;
    }

    /**
     *
     * @return y - coordinate of the Point
     */
    public double getY() {
        return this.y;
    }
    /**
     *
     * @param other Point to check equality with
     * @return true if equals false if not
     */
    public boolean equals(Point other) {
        if ((this.x == other.getX()) && (this.y == other.getY())) {
            return true;
        }
        return false;
    }
   /**
    *
    * @param other Point to count the distance
    * @return distance between 2 Points
    */
   public double distanceTo(Point other) {
       double dx = this.x - other.getX();
       double dy = this.y - other.getY();
       return Math.sqrt((dx * dx) + (dy * dy));
   }
}
