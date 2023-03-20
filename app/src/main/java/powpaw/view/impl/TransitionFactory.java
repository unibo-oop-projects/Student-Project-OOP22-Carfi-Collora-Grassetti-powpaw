package powpaw.view.impl;


import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import javafx.scene.shape.Rectangle;

public class TransitionFactory {

    public void doVerticalTransition(Rectangle node, double y, ArrayList<Rectangle> obstacles){
        double currentY = node.getY();
        double currentX = node.getX();
        List<Double> obstacleY = obstacles.stream().map(o -> o.getY()).collect(Collectors.toList());
        List<Double> obsstacleX = obstacles.stream().map(o -> o.getX()).collect(Collectors.toList());
        for (Double obsY : obstacleY) {
            for (Double obsX : obsstacleX) {
                if(( 
                    currentY + node.getHeight() == obsY && 
                    currentX > obsX )){
                   
                        return;
                }
            }   
        }
        node.setY(currentY + 1);
       
    }
}
