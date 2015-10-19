package automata;

import gui.GUISimulator;

import java.awt.*;
import java.util.Random;

/**
 * Created by matthieu on 18/10/15.
 * Classe pour tester le Conway
 */
public class TestConway {

    public static void main(String[] args) {
        Random rnd = new Random();
        rnd.setSeed(22);

        int[][] initTab = new int[50][10];
        //Initialisation avec un nombre aléatoire entre 0 et 1
        for (int i = 0; i < 50; i++) {
            for (int j = 0; j < 10; j++) {
                initTab[i][j] = rnd.nextInt(2);
            }
        }
        new Conway(initTab,50,10);

    }
}
