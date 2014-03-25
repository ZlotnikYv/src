import biuoop.DrawSurface;
/**
 *
 * @author Yakov Zlotnik
 *
 */
public class Ball {
    private Point center;
    private int r;
    private java.awt.Color color;
    private Velocity v;
    private int guiwidth;
    private int guiheight;
    /**
     *
     * @param center Point of the center of the ball
     * @param r Radius of the ball
     * @param color Color of the ball
     */
    public Ball(Point center, int r, java.awt.Color color) {
       this.center = center;
       this.r = r;
       this.color = color;
       this.guiwidth = 800;
       this.guiheight = 600;
   }
    /**
    *
    * @param x coordinate of the center of the ball
    * @param y coordinate of the center of the ball
    * @param r Radius of the ball
    * @param color Color of the ball
    */
   public Ball(double x, double y, int r, java.awt.Color color) {
       this.center = new Point(x, y);
       this.r = r;
       this.color = color;
       this.guiwidth = 800;
       this.guiheight = 600;
   }
   /**
   *
   * @param x coordinate of the center of the ball
   * @param y coordinate of the center of the ball
   * @param r Radius of the ball
   * @param color Color of the ball
   * @param guiwidth width of the gui surface
   * @param guiheight guiheight of the gui surface
   */
   public Ball(double x, double y, int r, java.awt.Color color,
                     int guiwidth, int guiheight) {
      this.center = new Point(x, y);
      this.r = r;
      this.color = color;
      this.guiwidth = guiwidth;
      this.guiheight = guiheight;
   }
   /**
    *
    * @param x coordinate of the center of the ball
    * @param y coordinate of the center of the ball
    * @param r Radius of the ball
    */
   public Ball(double x, double y, int r) {
       this.center = new Point(x, y);
       this.r = r;
       this.color = java.awt.Color.BLUE;
       this.guiwidth = 800;
       this.guiheight = 600;
   }
   /**
    *
    * @param center Point of the center of the ball
    * @param r Radius of the ball
    */
   public Ball(Point center, int r) {
       this.center = center;
       this.r = r;
       this.color = java.awt.Color.BLUE;
   }
   /**
    *
    * @return x coordinate of the center of the ball
    */
   public int getX() {
      return (int) this.center.getX();
   }
   /**
    *
    * @return y coordinate of the center of the ball
    */
   public int getY() {
      return (int) this.center.getY();
   }
  /**
   *
   * @return radius of the ball
   */
   public int getSize() {
       return this.r;
   }
  /**
   *
   * @return y color of the ball
   */
  public java.awt.Color getColor() {
       return this.color;
   }
  /**
   * @param vel sets up a velocity of the ball
   */
   public void setVelocity(Velocity vel) {
       this.v = vel;
   }
   /**
    *
    * @param dx velocity by the x axis
    * @param dy velocity by the y axis
    */
   public void setVelocity(double dx, double dy) {
       this.v = new Velocity(dx, dy);
   }
  /**
   *
   * @return velocity of the ball
   */
   public Velocity getVelocity() {
       return v;
   }
   /**
    *
    * @param surface to draw the ball on
    * draw the ball on the given DrawSurface
    */
   public void drawOn(DrawSurface surface) {
       surface.setColor(this.color);
       surface.fillCircle((int) this.center.getX(),
                          (int) this.center.getY(), this.r);
   }
   /**.
    * Moves the ball according to its velocity
    * if the border of the surface is reached
    * it changes velocity of this axis to opposite one
    */
   public void moveOneStep() {
       if (this.center.getX() + this.r >= this.guiwidth
         || this.center.getX() - this.r < 0) {
           this.v = new Velocity(-this.v.getdx(), this.v.getdy());
       }
       if (this.center.getY() + this.r >= this.guiheight
         || this.center.getY() - this.r < 0) {
           this.v = new Velocity(this.v.getdx(), -this.v.getdy());
       }
       this.center = this.getVelocity().applyToPoint(this.center);
   }
}