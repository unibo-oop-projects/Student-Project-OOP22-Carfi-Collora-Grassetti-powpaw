package powpaw.controller.impl;

import java.util.ArrayList;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.util.Duration;
import powpaw.controller.api.ScreenController;
import powpaw.model.impl.WeaponFactory;
import powpaw.model.impl.WeaponImpl;
import powpaw.view.impl.WeaponRender;

public class WeaponController {
    
    private ArrayList<WeaponImpl> weapons;
    private WeaponImpl weapon;
    private WeaponRender weaponRender;

    public WeaponController(){
        //this.weapon = Entity.createWeapon(new Point2D(15 * ScreenController.SIZE_HD_W/30, 1 * ScreenController.SIZE_HD_H/10), ScreenController.SIZE_HD_W/50, ScreenController.SIZE_HD_H/30);
        this.weapons = createWeapons();
        this.weapons.forEach(w -> {
            weaponRender = new WeaponRender(w); 
        });
        //weaponRender = new WeaponRender(this.weapon);
    }

    public ArrayList<WeaponImpl> createWeapons(){
        this.weapons = new ArrayList<>();
        this.weapons.add(WeaponFactory.createWeapon(ScreenController.SIZE_HD_W/2 ,
        ScreenController.SIZE_HD_H/2));
        Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(10), event ->{
            if( this.weapons.size()<4){
                this.weapons.add(WeaponFactory.createWeapon(ScreenController.SIZE_HD_W/2, ScreenController.SIZE_HD_H/2));
            }
        }));
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.play();
        return  this.weapons;
    }

    public WeaponImpl getWeapon(){
        return this.weapon;
    }

    
    public ArrayList<WeaponImpl> getWeapons(){
        return this.weapons;
    }

    public WeaponRender getRender(){
        return this.weaponRender;
    }
    
}
