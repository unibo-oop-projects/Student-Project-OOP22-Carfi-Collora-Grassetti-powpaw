package powpaw.controller.impl;

import javafx.geometry.Point2D;
import powpaw.controller.api.ScreenController;
import powpaw.model.impl.Entity;
import powpaw.model.impl.WeaponImpl;
import powpaw.view.impl.WeaponRender;

public class WeaponController {
    
    private WeaponImpl weapons;
    private WeaponRender weaponRender;

    public WeaponController(){
        this.weapons = Entity.createWeapon(new Point2D(15 * ScreenController.SIZE_HD_W/30, 1 * ScreenController.SIZE_HD_H/10), ScreenController.SIZE_HD_W/50, ScreenController.SIZE_HD_H/30);
        weaponRender = new WeaponRender(this.weapons);
    }

    public WeaponImpl getWeapons(){
        return this.weapons;
    }

    public WeaponRender getRender(){
        return this.weaponRender;
    }
    
}
