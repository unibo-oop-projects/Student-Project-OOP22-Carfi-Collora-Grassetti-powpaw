package powpaw.model.impl;

import javafx.geometry.Point2D;
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
    public static WeaponImpl createWeapon(Point2D pos, double width, double height){
        WeaponImpl weapon = new WeaponImpl(pos);
        return weapon;
    }

}
