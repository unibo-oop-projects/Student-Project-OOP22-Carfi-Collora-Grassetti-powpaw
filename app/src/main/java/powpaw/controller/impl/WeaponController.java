package powpaw.controller.impl;

import java.util.ArrayList;

import javafx.scene.shape.Rectangle;
import powpaw.controller.api.ScreenController;
import powpaw.model.impl.Entity;
import powpaw.view.impl.WeaponRender;

public class WeaponController {
    
    private ArrayList<Rectangle> weapons;
    private WeaponRender weaponRender;

    public WeaponController(){
        this.weapons = createWeapons();
        weaponRender = new WeaponRender(this.weapons);
    }

    private ArrayList<Rectangle> createWeapons(){
        //PROVA!!
        weapons = new ArrayList<>();
        weapons.add(Entity.createWeapon(15 * ScreenController.SIZE_HD_W/30, 1 * ScreenController.SIZE_HD_H/10 , ScreenController.SIZE_HD_W/50, ScreenController.SIZE_HD_H/30));
        weapons.add(Entity.createWeapon(1 * ScreenController.SIZE_HD_W/30, 1 * ScreenController.SIZE_HD_H/10, ScreenController.SIZE_HD_W/50, ScreenController.SIZE_HD_H/30));
        weapons.add(Entity.createWeapon(5 * ScreenController.SIZE_HD_W/30, 1 * ScreenController.SIZE_HD_H/10, ScreenController.SIZE_HD_W/50, ScreenController.SIZE_HD_H/30));
        weapons.add(Entity.createWeapon(10 * ScreenController.SIZE_HD_W/30, 1 * ScreenController.SIZE_HD_H/10, ScreenController.SIZE_HD_W/50, ScreenController.SIZE_HD_H/30));
        weapons.add(Entity.createWeapon(25* ScreenController.SIZE_HD_W/30, 1 * ScreenController.SIZE_HD_H/10, ScreenController.SIZE_HD_W/50, ScreenController.SIZE_HD_H/30));
        return weapons;
    }

    public ArrayList<Rectangle> getWeapons(){
        return this.weapons;
    }

    public WeaponRender getRender(){
        return this.weaponRender;
    }
    
}
