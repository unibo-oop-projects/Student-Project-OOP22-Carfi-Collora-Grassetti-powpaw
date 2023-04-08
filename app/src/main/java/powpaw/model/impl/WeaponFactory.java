package powpaw.model.impl;

import java.util.Random;

import javafx.geometry.Point2D;
import powpaw.controller.api.ScreenController;
import powpaw.model.api.Weapon;

/**
 * Class creates different types of weapons with specific attack values based on the
 * given ID.
 * 
 * @author Giacomo Grassetti
 */
public class WeaponFactory {

    private final static double START_TERRAIN = 300;
    private final static double END_TERRAIN = ScreenController.SIZE_HD_W - 300;

    /**
     * Static method that creates a weapon with a random position and type based on the given id.
     * 
     * @param id The id parameter is an integer value that represents the type of weapon to be created (0 = sowrd, 1 = hammer)
     * 
     * @return Weapon object.
     */
    public static Weapon createWeapon(int id) {
        Random rand = new Random();
        Point2D position = new Point2D(rand.nextDouble(START_TERRAIN, END_TERRAIN), 200);
        Weapon weapon = new WeaponImpl(position, id);
        switch (id) {
            case 0:
                weapon = createSword(position, id);
                break;
            case 1:
                weapon = createHammer(position, id);
                break;
        }
        return weapon;
    }

    private static Weapon createSword(Point2D pos, int id) {
        Weapon sword = new WeaponImpl(pos, id);
        sword.setAttack(0.25);
        return sword;
    }

    private static Weapon createHammer(Point2D pos, int id) {
        Weapon hammer = new WeaponImpl(pos, id);
        hammer.setAttack(0.4);
        return hammer;
    }

}
