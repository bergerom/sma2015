import java.awt.Point;

class Balls{
    Ball balle1,balle2,balle3;

    public Balls() {
        this.balle1 = new Ball(0,0,1,1);
        this.balle2 = new Ball(250,250,-1,-2);
        this.balle3 = new Ball(0,350,0,-1);
    }

    public Ball getBalle1() {
        return balle1;
    }

    public Ball getBalle2() {
        return balle2;
    }

    public Ball getBalle3() {
        return balle3;
    }

    void translate(){
        balle1.translate();
        balle2.translate();
        balle3.translate();
    }

    void reInit(){
        balle1.setLocation(6,3);
        balle2.setLocation(2,2);
        balle3.setLocation(1,1);
    }

    @Override
    public String toString() {
        return "Balls{" +
                 balle1 +
                 balle2 +
                 balle3 +
                '}';
    }
}