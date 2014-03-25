/**
 *
 * @author Yakov Zlotnik
 *
 */
public class Line {
    private Point start;
    private Point end;
    /**
     *
     * @param start - start Point of the Line
     * @param end - end Point of the Line
     */
    public Line(Point start, Point end) {
        this.start = start;
        this.end = end;
    }
    /**
     *
     * @param x1 - y of the start Point of the Line
     * @param x2 - x of the end Point of the Line
                 * @param y1 - y of the start Point of the Line
                 * @param y2 - y of the end Point of the Line
                 */
    public Line(double x1, double y1, double x2, double y2) {
        this.start = new Point(x1, y1);
        this.end = new Point(x2, y2);
    }
    /**
     *
     * @return Line length
     */
    public double length() {
        return start.distanceTo(end);
    }
    /**
     *
     * @return Point at the middle of the Line
     */
    public Point middle() {
        return new Point((start.getX() + end.getX()) / 2,
                       ((start.getY() + end.getY()) / 2));
    }
    /**
     *
     * @return Point of the start of the Line
     */
    public Point start() {
        return this.start;
    }
    /**
     *
     * @return Point of the end of the Line
     */
    public Point end() {
        return this.end;
    }
    /**
     *
     * @param other Line to check intersection with
     * @return Point of intersection of two infinite Lines (not segments)
     */
    public Point intersectionPoint(Line other) {
        double a1 = this.end.getY() - this.start.getY();
        double b1 = this.start.getX() - this.end.getX();
        double c1 = a1 * this.start.getX() + b1 * this.start.getY();
        double a2 = other.end.getY() - other.start.getY();
        double b2 = other.start.getX() - other.end.getX();
        double c2 = a2 * other.start.getX() + b2 * other.start.getY();
        double det = (a1 * b2) - (a2 * b1);
        if (det == 0) {
            return null;
        }
        return new Point(((b2 * c1 - b1 * c2) / det),
                        ((a1 * c2 - a2 * c1) / det));
    }
    /**
     *
     * @param other segment Line to check intersection with
     * @return if there is an intersection with other Line
     */
    public boolean isIntersecting(Line other) {
        Point intersec = intersectionPoint(other);
        return intersec != null
          && intersec.getX() >= Math.min(this.start.getX(), this.end.getX())
          && intersec.getY() >= Math.min(this.start.getY(), this.end.getY())
          && intersec.getX() <= Math.max(this.start.getX(), this.end.getX())
          && intersec.getY() <= Math.max(this.start.getY(), this.end.getY())
          && intersec.getX() >= Math.min(other.start.getX(), other.end.getX())
          && intersec.getY() >= Math.min(other.start.getY(), other.end.getY())
          && intersec.getX() <= Math.max(other.start.getX(), other.end.getX())
          && intersec.getY() <= Math.max(other.start.getY(), other.end.getY());
    }
    /**
     *
     * @param other segmented Line to get an intersection Point
     * @return Intersection Point if there is an intersection
     * or null if there are no intersections
     */
    public Point intersectionWith(Line other) {
        if (!(this.isIntersecting(other))) {
            return null;
        }
        return intersectionPoint(other);
    }
}