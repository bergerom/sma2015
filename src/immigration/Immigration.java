package immigration;
import java.awt.*;

/**
 * Created by Germain on 25/10/15.
 * Implémentatation du immigration
 */
public class Immigration extends CellularAutomata{


    /*n représente le nombre d'états*/
    int n;

    public Immigration(int[][] initTab, int width, int height,int n) {
        super(initTab, width, height);
        this.n=n;
        
    }

    @Override
    int computeNewState(int cellState,int[] neighboursTab) {
        //calcul du nombre de voisins dans l'état k+1
        int nb_sup = 0;
        for(int k=0;k<8;k++){
            if(neighboursTab[k] == (cellState+1) % n)
                nb_sup++;
        }

        //la cellule passe dans l'état k+1
        if(nb_sup >=3)
            return ((cellState+1) % n);

        // cas ou la cellule ne change pas
        return cellState;

    }
 
    
        private int Red(int r){
        r=(int)(255*r/n);
        return r;
    }
    
    private int Green(int g){
        g=(int)(255*g/n);
        g=(g+50) % 255;
        return g;
    }
    
     private int Blue(int b){
        b=(int)(255*b/n);  
        b=(b+100) % 255;    
        return b;
    }
    
     
    @Override
    Color stateColor(int cellState) {
        return new Color(Red(cellState),Green(cellState),Blue(cellState));
    }
}
