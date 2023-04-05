package powpaw.model.impl;

import java.util.Random;

import javafx.geometry.Point2D;
import powpaw.controller.api.ScreenController;

public class WeaponFactory {

    private final static double START_TERRAIN = 300;
    private final static double END_TERRAIN = ScreenController.SIZE_HD_W - 300;

    public static WeaponImpl createWeapon(int id) {
        Random rand = new Random();
        Point2D position = new Point2D(rand.nextDouble(START_TERRAIN, END_TERRAIN), 200);
        WeaponImpl weapon = new WeaponImpl(position, id);
        switch (id) {
            case 0:
                System.out.println("SWORD");
                weapon = createSword(position, id);
                break;
            case 1:
                System.out.println("Hammer");
                weapon = createHammer(position, id);
                break;
        }
        return weapon;
    }

    private static WeaponImpl createSword(Point2D pos, int id) {
        WeaponImpl sword = new WeaponImpl(pos, id);
        sword.setAttack(0.25);
        sword.setSpeed(0.4);
        return sword;
    }

    private static WeaponImpl createHammer(Point2D pos, int id) {
        WeaponImpl hammer = new WeaponImpl(pos, id);
        hammer.setAttack(0.4);
        hammer.setSpeed(0.2);
        return hammer;
    }

}
