package powpaw.view.impl;


import java.util.ArrayList;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;

public class TransitionFactory {

    public void doVerticalTransition(Rectangle node, double y, ArrayList<Rectangle> obstacles){
        double currentY = node.getY();
        if(!checkBlockCollision(node, obstacles)){
            node.setY(currentY + 2);
        }
        
       
    }

    private boolean checkBlockCollision(Shape node, ArrayList<Rectangle> obstacles){
        for (Rectangle obs : obstacles) {
            if(node.getBoundsInParent().intersects(obs.getBoundsInParent())){
                return true;
            }
        }
        return false;
    }

    /*private boolean checkWindowsBoundsCollision(Shape node){
        if(node.getBoundsInParent().intersects())
    }*/
}
