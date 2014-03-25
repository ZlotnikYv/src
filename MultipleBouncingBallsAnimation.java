import java.util.Random;

import biuoop.DrawSurface;
import biuoop.GUI;
/**
 *
 * @author Yakov Zlotnik
 *
 */
public class MultipleBouncingBallsAnimation {
    private BouncingBallAnimation[] ballarray;
    private int guiwidth;
    private int guiheight;
    private int sleeper;
    /**
     *
     * @param s input string, that should contain numbers
     * @param guiwidth width of the gui surface
     * @param guiheight height of the gui surface
     * @param sleeper pause timer in milliseconds
     */
    public MultipleBouncingBallsAnimation(String[] s, int guiwidth,
                                         int sleeper, int guiheight) {
        this.ballarray = new BouncingBallAnimation[s.length];
        this.guiheight = guiheight;
        this.guiwidth = guiwidth;
        this.sleeper = sleeper;
        for (int i = 0; i < s.length; i++) {
           this.ballarray[i] = new BouncingBallAnimation(Integer.parseInt(s[i]),
           this.guiwidth, this.guiheight);
        }
    }
    /**
     *
     * @param s input string, that should contain numbers
     */
    public MultipleBouncingBallsAnimation(String[] s) {
        this.ballarray = new BouncingBallAnimation[s.length];
        this.sleeper = 50;
        this.guiheight = 600;
        this.guiwidth = 800;
        for (int i = 0; i < s.length; i++) {
           this.ballarray[i] = new BouncingBallAnimation(Integer.parseInt(s[i]),
           this.guiwidth, this.guiheight);
        }
    }
    /**.
     *
     * Default constructor
     * Generates random number of balls up to 120
     * with random size that is lesser then 70
     */
    public MultipleBouncingBallsAnimation() {
        Random rand = new Random();
        int ballammount = rand.nextInt(120) + 1;
        this.ballarray = new BouncingBallAnimation[ballammount];
        this.guiheight = 600;
        this.guiwidth = 800;
        this.sleeper = 20;
        for (int i = 0; i < ballammount; i++) {
            this.ballarray[i] = new BouncingBallAnimation(rand.nextInt(70) + 1,
            this.guiwidth, this.guiheight);
        }
    }
    /**
     *
     * @return gui height of the animation
     */
    public int getGuiHeight() {
        return this.guiheight;
    }
    /**
     *
     * @return gui width of the animation
     */
    public int getGuiWidth() {
       return this.guiwidth;
    }
    /**
     *
     * @return gui width of the animation
     */
    public int getSleeper() {
      return this.sleeper;
    }
    /**
     *
     * @return array of the ball objects for animation
     */
    public BouncingBallAnimation[] getBallArray() {
        return this.ballarray;
    }
    /**
     *
     * @param sarray input array of strings
     * Main method for animation balls
     */
    public static void multipleBallAnimShow(String[] sarray) {
        MultipleBouncingBallsAnimation mbanim;
        //mbanim = multiple ball animation
        mbanim = new MultipleBouncingBallsAnimation(sarray);
        if (sarray.length == 0) {
            mbanim = new MultipleBouncingBallsAnimation();
        }
        GUI gui = new GUI("Title", mbanim.guiwidth, mbanim.guiheight);
        biuoop.Sleeper sleeper = new biuoop.Sleeper();
        while (true) {
            DrawSurface d = gui.getDrawSurface();
            //bba = bouncing ball animation
            //simply keeps a single BouncingBallAnimation
            for (BouncingBallAnimation bba : mbanim.ballarray) {
                bba.getBall().moveOneStep();
                bba.getBall().drawOn(d);
            }
            sleeper.sleepFor(mbanim.getSleeper());
            gui.show(d);
        }
    }
    /**
     *
     * @param args console input
     */
    public static void main(String[] args) {
            multipleBallAnimShow(args);
    }
}