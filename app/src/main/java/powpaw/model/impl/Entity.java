package powpaw.model.impl;

import javafx.geometry.Point2D;

public class Entity {

    // factory for block entity
    public static BlockImpl createBlock(double x, double y) {
        BlockImpl block = new BlockImpl(new Point2D(x, y), 1, 1);
        return block;
    }

    // factory for weapon entity
    public static WeaponImpl createWeapon(Point2D pos, double width, double height) {
        WeaponImpl weapon = new WeaponImpl(pos);
        return weapon;
    }

}
