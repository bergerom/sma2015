package immigration;

import gui.GUISimulator;

import java.awt.*;
import java.util.Random;

/**
 * Created by Germain on 25/10/15.
 * Classe pour tester Immigration
 */
public class TestImmigration {

    public static void main(String[] args) {
        Random rnd = new Random();
        rnd.setSeed(22);

        int[][] initTab = new int[50][10];
        //Initialisation avec un nombre aléatoire entre 0 et 1
        for (int i = 0; i < 50; i++) {
            for (int j = 0; j < 10; j++) {
                initTab[i][j] = rnd.nextInt(5);
            }
        }
        new Immigration(initTab,50,10,5);

    }
}
