package automata;
import gui.GUISimulator;
import gui.Rectangle;
import gui.Simulable;

import java.awt.*;

/**
 * Created by matthieu on 18/10/15.
 * Classe abstrate pour modéliser et afficher des automates cellulaires.
 * Un automate cellulaire est défini par un tableau d'entiers à deux dimensions.
 * Le sens donné à ces valeurs est laissé libre au programmeur.
 *
 * Seulement deux fonctions à définir pour hériter cette classe:
 * - ComputeNewState qui calcule le nouvel état d'une case donnée
 * - stateColor qui associe une couleur à chaque état
 */
public abstract class CellularAutomata implements Simulable {

    // Le gui et ses paramêtres
    private GUISimulator gui;
    private static final int cellWidth = 30;
    private static final int cellHeight = 30;
    // Un tableau d'integer représentant les cellules et leurs état
    private int initTab[][] = null;
    private int tabCells[][] = null;
    // Le nombre de cellules selon I et J
    private int lengthI;
    private int lengthJ;

    /**
     * Constructeur à appeller avec le super()
     *
     * @param initTab  tableau d'initialisation, qui DOIT etre alloué et rempli avant
     *                de l'envoyer à cette fonction.
     * @param width nombre de cellules selon la dimension 1 (= longueur selon i du tableau)
     * @param height nombre de cellules selon la dimension 2 (= longueur selon j du tableau)
     */
    public CellularAutomata(int[][] initTab,int width,int height) {
        this.lengthI = width;
        this.lengthJ = height;
        this.tabCells = initTab;
        this.initTab = new int[lengthI][lengthJ];
        array2dCopy(tabCells,this.initTab);
        this.configureGUI(width, height);
    }

    /**
     * Retourne l'étate de la cellule (i,j)
     * @param i indice i de la cellule
     * @param j indice j de la cellule
     * @return l'état de la cellule (i,j)
     */
    public int getCell(int i,int j){
        return tabCells[i][j];
    }

    @Override
    public void next() {
        if(tabCells == null)
            return;

        //Sauvegarde du tableau de l'état courant
        int[][] tabNextStep = new int[lengthI][lengthJ];
        array2dCopy(tabCells,tabNextStep);

        // Calcul du nouvel état de chaque case du tableau
        for(int i=0;i< lengthI;i++){
            for(int j=0;j< lengthJ;j++){
                tabNextStep[i][j] = computeNewState(getCell(i,j),
                        neighboursState(i, j));
            }
        }
        tabCells = tabNextStep;

        // Dessin du nouveau tableau dans le gui
        for(int i = 0;i< lengthI;i++) {
            for (int j = 0; j < lengthJ; j++) {
                gui.addGraphicalElement(
                        new Rectangle(i * cellWidth,
                                j * cellHeight,
                                stateColor(getCell(i, j)),
                                stateColor(getCell(i, j)),
                                cellWidth,
                                cellHeight));
            }
        }
    }

    @Override
    public void restart() {
        array2dCopy(initTab,tabCells);
        for(int i = 0;i< lengthI;i++){
            for(int j = 0;j< lengthJ;j++){
                gui.addGraphicalElement(
                        new Rectangle(i*cellWidth,
                                j*cellHeight,
                                Color.BLACK,
                                stateColor(getCell(i,j)),
                                cellWidth,
                                cellHeight));
            }
        }
    }

    /**
     * Retourne les états des voisins de la case (i,j) sous la forme d'un tableau
     */
    private int[] neighboursState(int i,int j){
        int[] neighboursTab = new int[8];

        neighboursTab[0] = tabCells[(i-1+ lengthI) % lengthI][(j-1+ lengthJ) % lengthJ];
        neighboursTab[1] = tabCells[(i-1+ lengthI) % lengthI][j];
        neighboursTab[2] = tabCells[(i-1+ lengthI) % lengthI][(j+1) % lengthJ];
        neighboursTab[3] = tabCells[i][(j+1) % lengthJ];
        neighboursTab[4] = tabCells[i][(j-1+ lengthJ) % lengthJ];
        neighboursTab[5] = tabCells[(i+1) % lengthI][(j-1+ lengthJ) % lengthJ];
        neighboursTab[6] = tabCells[(i+1) % lengthI][j];
        neighboursTab[7] = tabCells[(i+1) % lengthI][(j+1) % lengthJ];

        return  neighboursTab;
    }

    /**
     * Copie le tableau src dans le tableau dest.
     *  Note : dest et src doivent êtres de même dimension (lengthI*lengthJ).
     * @param src tableau source
     * @param dest tableau destination
     */
    private void array2dCopy(int[][] src,int[][] dest){
        for(int i = 0;i< lengthI;i++) {
            System.arraycopy(src, 0, dest, 0, lengthI);
        }
    }

    /**
     * Configure le gui
     * @param nbCellsX nombre de cellules selon la dimension 1 du tableau
     * @param nbCellsY nombre de cellules selon la dimension 2 du tableau
     */
    private void configureGUI(int nbCellsX,int nbCellsY) {
        this.gui = new GUISimulator(cellWidth*nbCellsX, cellHeight*nbCellsY, Color.BLACK);
        gui.setSimulable(this);
    }

    /**
     * Calcule le nouvel état d'une cellule à partir des états des cellules voisines.
     * @param neighboursTab : le tableau des voisins de la case considérée. Chaque case du
     *                      tableau contient l'état d'un voisin de la case courante.
     * @return l'état suivant de la case considérée
     */
    abstract int computeNewState(int cellState,int[] neighboursTab);

    /**
     * Retourne la couleur associée a l'état : choix laissé libre au programmeur.
     * @param cellState l'état de la cellule considérée. L'interprêtation
     *             de cet état dépend de l'implémentation.
     * @return la couleur associée à cet état
     */
    abstract Color stateColor(int cellState);

}