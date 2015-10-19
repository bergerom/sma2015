import gui.GUISimulator;
import gui.Oval;
import gui.Simulable;

import java.awt.*;

/**
 * Created by matthieu on 17/10/15.
 */
public class BallsSimulator implements Simulable{

    Balls ballsbucket = null;
    Balls oldBalls = null;
    GUISimulator gui;

    public BallsSimulator(GUISimulator gui) {
        this.gui = gui;
    }

    /**
     * Translation de toutes les balles de (1,1)
     */
    @Override
    public void next() {
        if(ballsbucket == null)
            return;

        //Reset de l'écran
        gui.reset();

        //Translation
        ballsbucket.translate();
        System.out.print(ballsbucket.toString() + "\n");

        //Dessin des 3 balles
        gui.addGraphicalElement(
                new Oval(ballsbucket.getBalle1().x,
                        ballsbucket.getBalle1().y,
                        Color.WHITE,
                        Color.GRAY,
                        10));

        gui.addGraphicalElement(
                new Oval(ballsbucket.getBalle2().x,
                        ballsbucket.getBalle2().y,
                        Color.WHITE,
                        Color.GRAY,
                        10));

        gui.addGraphicalElement(
                new Oval(ballsbucket.getBalle3().x,
                        ballsbucket.getBalle3().y,
                        Color.WHITE,
                        Color.GRAY,
                        10));
    }

    /**
     * Remise à zéro des position des balles
     */
    @Override
    public void restart() {
        if(ballsbucket == null)
            ballsbucket = new Balls();
        else
            ballsbucket.reInit();

        System.out.print(ballsbucket.toString() + "\n");
    }

}
