package powpaw.view.impl;


import java.util.ArrayList;
import javafx.geometry.Point2D;
import javafx.scene.shape.Rectangle;
import powpaw.model.impl.WeaponImpl;

public class TransitionFactory {

    public Point2D positionTransition(Point2D pos, ArrayList<Rectangle> obstacles){       
        if(!checkCollision(pos, obstacles)){
            System.out.println(pos.getY());
            return pos.add(0, 2);
        }
        return pos;
    }

    private boolean checkCollision(Point2D pos, ArrayList<Rectangle> obstacles){
        Rectangle tmp = new Rectangle(pos.getX(), pos.getY(), WeaponImpl.WIDTH, WeaponImpl.HEIGHT);
        for (Rectangle obs : obstacles) {
            if(tmp.getBoundsInParent().intersects(obs.getBoundsInParent())) {
                return true;
            }
        }
        return false;
    }
}
