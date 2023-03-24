package powpaw.model.impl;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Entity {

    //factory for block entity
    public static Rectangle createBlock(double x, double y, double height, double width){
        Rectangle block = new Rectangle(width, height);
        block.setX(x);
        block.setY(y);
        return block;
    }

    //factory for weapon entity
    public static Rectangle createWeapon(double x, double y, double height, double width){
        Rectangle weapon = new Rectangle(width, height);
        weapon.setX(x);
        weapon.setY(y);
        weapon.setFill(Color.RED);
        return weapon;
    }

}
