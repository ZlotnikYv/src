import biuoop.GUI;
import biuoop.DrawSurface;

import java.util.Random;
import java.awt.Color;
/**
 *
 * @author Yakov ZLotnik
 *
 */
public class AbstractArtDrawing {
    private int guiwidth;
    private int guiheight;
    private int numoflines;
    private int dotradius;
    private Color intersectioncolor;
    private Color midlinecolor;
    private Color linecolor;
    /**
     *
     * @param guiwidth width of the gui surface
     * @param guiheight guiheight of the gui surface
     * @param numoflines number of lines to draw
     * @param dotradius radius of the intersection dots
     * @param intersectioncolor
     */
    public AbstractArtDrawing(int guiwidth, int guiheight,
                              int numoflines, int dotradius) {
        this.guiwidth = guiwidth;
        this.guiheight = guiheight;
        this.numoflines = numoflines;
        this.dotradius = dotradius;
        this.intersectioncolor = Color.RED;
        this.midlinecolor = Color.BLUE;
        this.linecolor = Color.BLACK;
    }
    /**.
     *
     *Default constructor
     */
    public AbstractArtDrawing() {
        this.guiwidth = 800;
        this.guiheight = 600;
        this.numoflines = 16;
        this.dotradius = 3;
        this.intersectioncolor = Color.RED;
        this.midlinecolor = Color.BLUE;
        this.linecolor = Color.BLACK;
    }
    /**
     *
     * @return Random-generated Line-segment;
     */
    public Line generateRandomLine() {
        Random rand = new Random();
        int x1 = rand.nextInt(this.guiwidth) + 1;
        int y1 = rand.nextInt(this.guiheight) + 1;
        int x2 = rand.nextInt(this.guiwidth) + 1;
        int y2 = rand.nextInt(this.guiheight) + 1;
        return new Line(x1, y1, x2, y2);
    }
    /**
     *
     * @param l - Line to draw
     * @param d - DrawSurface to use
     */
      public void drawLine(Line l, DrawSurface d) {
        d.setColor(this.linecolor);
        d.drawLine((int) l.start().getX(), (int) l.start().getY(),
                   (int) l.end().getX(), (int) l.end().getY());
     }
     /**.
      * Main Drawing sequence
      */
    public void drawRandomLines() {
      GUI gui = new GUI("Random Lines Example", this.guiwidth, this.guiheight);
      DrawSurface d = gui.getDrawSurface();
      // array to store Lines for further use
      Line[] larray = new Line[this.numoflines];
      // array to store Lines for further use
      //Line-drawing + middle-dotting loop
      for (int i = 0; i < this.numoflines; i++) {
          larray[i] = generateRandomLine();
          drawLine(larray[i], d);
          d.setColor(this.midlinecolor);
          d.fillCircle((int) larray[i].middle().getX(),
                       (int) larray[i].middle().getY(), dotradius);
      }
      //Intersection dots loop
      for (int i = 0; i < this.numoflines; i++) {
          for (int j = i + 1; j < this.numoflines; j++) {
              if (larray[i].isIntersecting(larray[j])) {
                d.setColor(this.intersectioncolor);
                d.fillCircle((int) larray[i].intersectionWith(larray[j]).getX(),
                             (int) larray[i].intersectionWith(larray[j]).getY(),
                             dotradius);
              }
          }
      }
      gui.show(d);
  }
  /**
   *
   * @param args not used
   */
  public static void main(String[] args) {
      AbstractArtDrawing example = new AbstractArtDrawing();
      example.drawRandomLines();
  }
}