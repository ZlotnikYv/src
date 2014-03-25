import java.util.Random;

import biuoop.GUI;
import biuoop.DrawSurface;
/**
 *
 * @author Yakov Zlotnik
 *
 */
public class BouncingBallAnimation {
    private int guiwidth;
    private int guiheight;
    private int size;
    private int sleeper;
    private Ball randball;
    /**
     *
     * @param guiwidth width of the gui surface
     * @param guiheight guiheight of the gui surface
     * @param size size of the ball
     */
    BouncingBallAnimation(int size, int guiwidth, int guiheight) {
        this.guiwidth = guiwidth;
        this.guiheight = guiheight;
        this.size = size;
        this.sleeper = 50;
        Random rand = new Random();
        int angle = rand.nextInt(360) + 1;
        int x = rand.nextInt(this.guiwidth - 2 * size - 1) + size + 1;
        int y = rand.nextInt(this.guiheight - 2 * size - 1) + size + 1;
        int speed = evalVelocityScalar(this.size);
        //generating random hue for color of the ball
        float h = rand.nextFloat();
        //maxed-out saturation and brightness
        float s = 1f;
        float b = 1f;
        this.randball = new Ball(x, y, this.size,
            java.awt.Color.getHSBColor(h, s, b), this.guiwidth, this.guiheight);
        Velocity v = Velocity.fromAngleAndSpeed((double) angle, (double) speed);
        randball.setVelocity(v);
    }
    /**
    *
    * @param size size of the ball
    */
    public BouncingBallAnimation(int size) {
        this.guiwidth = 800;
        this.guiheight = 600;
        this.size = size;
        this.sleeper = 50;
        Random rand = new Random();
        int angle = rand.nextInt(360) + 1;
        int x = rand.nextInt(this.guiwidth - 2 * size - 1) + size + 1;
        int y = rand.nextInt(this.guiheight - 2 * size - 1) + size + 1;
        //generating random hue for color of the ball
        float h = rand.nextFloat();
        //maxed-out saturation and brightness
        float s = 1f;
        float b = 1f;
        this.randball = new Ball(x, y, this.size,
            java.awt.Color.getHSBColor(h, s, b), this.guiwidth, this.guiheight);
        int speed = evalVelocityScalar(this.size);
        Velocity v = Velocity.fromAngleAndSpeed((double) angle, (double) speed);
        randball.setVelocity(v);
    }
   /**.
    * Default constructor
    */
    public BouncingBallAnimation() {
        Random rand = new Random();
        this.guiwidth = 800;
        this.guiheight = 600;
        this.size = rand.nextInt(40) + 1;
        this.sleeper = 50;
        int angle = rand.nextInt(360) + 1;
        int x = rand.nextInt(this.guiwidth - 2 * size - 1) + size + 1;
        int y = rand.nextInt(this.guiheight - 2 * size - 1) + size + 1;
        //generating random hue for color of the ball
        float h = rand.nextFloat();
        //maxed-out saturation and brightness
        float s = 1f;
        float b = 1f;
        this.randball = new Ball(x, y, this.size,
            java.awt.Color.getHSBColor(h, s, b), this.guiwidth, this.guiheight);
        int speed = evalVelocityScalar(this.size);
        Velocity v = Velocity.fromAngleAndSpeed((double) angle, (double) speed);
        randball.setVelocity(v);
    }
    /**
     *
     * @return width of the gui
     */
    public int getGuiWidth() {
        return this.guiwidth;
    }
    /**
     *
     * @return height of the gui
     */
    public int getGuiHeight() {
        return this.guiheight;
    }
    /**
     *
     * @return Ball for animation
     */
    public Ball getBall() {
        return this.randball;
    }
    /**
     * @param bsize the size of the ball for velocity calculation
     * @return calculated value of velocity
     */
    public int evalVelocityScalar(int bsize) {
        return 200 / (bsize + 10) + 1;
    }
    /**
     *
     * @return pause time between animations
     */
    public int getSleeper() {
        return this.sleeper;
    }
    /**
     * @param sarray input array to size from
     * Main function for ball animation
     */
    public static void ballAnimShow(String[] sarray) {
        BouncingBallAnimation banim;
        banim = new BouncingBallAnimation();
        if (sarray.length != 0) {
            banim = new BouncingBallAnimation(Integer.parseInt(sarray[0]));
        }
        GUI gui = new GUI("Title", banim.getGuiWidth(), banim.getGuiHeight());
        biuoop.Sleeper sleeper = new biuoop.Sleeper();
        while (true) {
            banim.randball.moveOneStep();
            DrawSurface d = gui.getDrawSurface();
            banim.randball.drawOn(d);
            gui.show(d);
            sleeper.sleepFor(banim.sleeper);
        }
    }
    /**
     *
     * @param args console input
     */
    public static void main(String[] args) {
        if (args.length == 1 || args.length == 0) {
            ballAnimShow(args);
        }
        System.out.println("Arg Error!");
    }
}