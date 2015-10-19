import java.awt.*;

/**
 * Created by matthieu on 17/10/15.
 */
public class Ball extends Point{
    Point translation;

    public Ball(int x, int y, int tx, int ty) {
        super(x, y);
        this.translation = new Point(tx,ty);
    }

    public void translate(){
        if(this.x + translation.x > 500){
            this.translate(-translation.x,translation.y);
            translation.x = -translation.x;
        }else if(this.x + translation.x < 0){
            this.translate(-translation.x,translation.y);
            translation.x = -translation.x;
        }else if(this.y + translation.y < 0){
            this.translate(translation.x,-translation.y);
            translation.y = -translation.y;
        }else if(this.y + translation.y > 500){
            this.translate(translation.x,-translation.y);
            translation.y = -translation.y;
        }else{
            this.translate(translation.x,translation.y);
        }
    }

    @Override
    public String toString() {
        return "Ball{" +
                "translation=" + translation +
                '}';
    }
}
