package powpaw.model.api;

import javafx.scene.Node;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Entity {

    //factory for block entity
    public static Node createBlock(int x, int y, int height, int width, Color color){
        //Rectangle extends Node
        Rectangle block = new Rectangle(width, height);
        block.setTranslateX(x);
        block.setTranslateY(y);
        block.setFill(color);
        return block;
    }




}
