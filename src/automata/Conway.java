package automata;
import java.awt.*;

/**
 * Created by matthieu on 18/10/15.
 * Implémentatation du Conway
 */
public class Conway extends CellularAutomata{

    public Conway(int[][] initTab, int width, int height) {
        super(initTab, width, height);
    }

    @Override
    int computeNewState(int cellState,int[] neighboursTab) {

        int nbAlive = 0;
        for(int k=0;k<8;k++){
            if(neighboursTab[k] == 1)
                nbAlive++;
        }

        //Cellule morte : elle renait si elle possède 3 voisins vivants
        if(cellState == 0 && nbAlive == 3)
            return 1;

        //Cellule vivante : elle meurt si :
        // -un seul voisin vivant
        // et/ou
        // - plus de 3 voisins vivants
        if(cellState == 1 && (nbAlive == 1 || nbAlive > 3))
            return 0;

        // Autres cas ou il ne se passe rien
        return cellState;
    }

    @Override
    Color stateColor(int cellState) {
        if(cellState == 0)
            return Color.WHITE;
        else
            return Color.cyan;
    }
}
