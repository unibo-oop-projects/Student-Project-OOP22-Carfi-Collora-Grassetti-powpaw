package powpaw.controller.impl;

import java.util.ArrayList;
import java.util.List;

import javafx.scene.shape.Rectangle;
import powpaw.controller.api.ScreenController;
import powpaw.model.api.Player;
import powpaw.model.api.World;
import powpaw.model.impl.CreateMap;
import powpaw.model.impl.WorldImpl;

public class WorldController {
    
    private CreateMap worldMap;
    private ArrayList<Rectangle> terrains;

    public WorldController(){
        worldMap = new CreateMap();
        this.terrains = worldMap.getTerrains();
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
