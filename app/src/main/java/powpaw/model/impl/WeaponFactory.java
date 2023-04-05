package powpaw.model.impl;

import java.util.Random;

import javafx.geometry.Point2D;

public class WeaponFactory {

    public static WeaponImpl createWeapon(double x, double y){
        Random rand = new Random();
        WeaponImpl weapon = new WeaponImpl(new Point2D(x, y));
        switch(rand.nextInt(2)){
            case 0:
                weapon = createSword(x, y);
                break;
            case 1:
                weapon = createHammer(x, y);
                break;
        }
        return weapon;
    }

    
    private static WeaponImpl createSword(double x, double y) {
        
        WeaponImpl sword = new WeaponImpl(new Point2D(x, y));
        sword.setAttack(0.25);
        sword.setSpeed(0.4);
        return sword;
    }

    private static  WeaponImpl createHammer(double x, double y){
        WeaponImpl hammer = new WeaponImpl(new Point2D(x, y));
        hammer.setAttack(0.4);
        hammer.setSpeed(0.2);
        return hammer;
    }

}
