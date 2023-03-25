package powpaw.controller.impl;

import java.util.ArrayList;

import javafx.scene.shape.Rectangle;
import powpaw.controller.api.ScreenController;
import powpaw.model.impl.CreateMap;
import powpaw.model.impl.Entity;

public class WorldController {
    
    private CreateMap worldMap;
    private ArrayList<Rectangle> terrains;
    private ArrayList<Rectangle> weapons;


    public WorldController(){
        worldMap = new CreateMap();
        this.terrains = worldMap.getTerrains();
        createWeapons();
        setProportions();
    }

    private void createWeapons(){
        //PROVA!!
        weapons = new ArrayList<>();
        weapons.add(Entity.createWeapon(15 * ScreenController.SIZE_HD_W/30, 1 * ScreenController.SIZE_HD_H/10 , ScreenController.SIZE_HD_W/50, ScreenController.SIZE_HD_H/30));
        weapons.add(Entity.createWeapon(1 * ScreenController.SIZE_HD_W/30, 1 * ScreenController.SIZE_HD_H/10, ScreenController.SIZE_HD_W/50, ScreenController.SIZE_HD_H/30));
        weapons.add(Entity.createWeapon(5 * ScreenController.SIZE_HD_W/30, 1 * ScreenController.SIZE_HD_H/10, ScreenController.SIZE_HD_W/50, ScreenController.SIZE_HD_H/30));
        weapons.add(Entity.createWeapon(10 * ScreenController.SIZE_HD_W/30, 1 * ScreenController.SIZE_HD_H/10, ScreenController.SIZE_HD_W/50, ScreenController.SIZE_HD_H/30));
        weapons.add(Entity.createWeapon(25* ScreenController.SIZE_HD_W/30, 1 * ScreenController.SIZE_HD_H/10, ScreenController.SIZE_HD_W/50, ScreenController.SIZE_HD_H/30));
    }
    

    private void setProportions(){
        this.terrains.stream().forEach(b -> {
            b.setX(b.getX()*(ScreenController.SIZE_HD_W/30));
            b.setY(b.getY()*(ScreenController.SIZE_HD_H/10));
            b.setWidth(b.getWidth()*(ScreenController.SIZE_HD_W/30));
            b.setHeight(b.getHeight()*(ScreenController.SIZE_HD_H/10));
        });
    }

    public ArrayList<Rectangle> getPlatforms(){
        return this.terrains;
    }

    public ArrayList<Rectangle> getWeapons(){
        return this.weapons;
    }

}
