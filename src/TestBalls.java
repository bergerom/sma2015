/**
 * Created by matthieu on 17/10/15.
 * Test simple de la classe Balls
 */
public class TestBalls {

    public static void main(String [] args) {
        //Initialisation
        Balls b = new Balls();
        System.out.print("Initialisation : " + b.toString() + "\n");
        //translation
        b.translate();
        System.out.print("Translation de (2,1) : " + b.toString() + "\n");
        // On réinitialise aux valeurs initiales
        b.reInit();
        System.out.print("Remise à zéro :" + b.toString() + "\n");
    }
}
