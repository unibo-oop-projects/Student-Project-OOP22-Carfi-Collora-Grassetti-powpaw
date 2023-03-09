package powpaw.controller.api;

import java.util.ArrayList;

import javafx.scene.shape.Rectangle;
import powpaw.model.api.World;

public class WorldController {
    
    private World world;
    private ArrayList<Rectangle> terrains;

    public WorldController(){
        world = new World();
        this.terrains = world.getTerrains();
        setProportions();
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

}
