package powpaw.model.api;

import javafx.scene.shape.Rectangle;

public class Entity {

    //factory for block entity
    public static Rectangle createBlock(double x, double y, double height, double width){
        Rectangle block = new Rectangle(width, height);
        block.setX(x);
        block.setY(y);
        return block;
    }




}
