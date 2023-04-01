package powpaw.controller.impl;

import java.util.ArrayList;
import powpaw.controller.api.ScreenController;
import powpaw.model.impl.BlockImpl;
import powpaw.model.impl.CreateMap;

public class MapController {

    private CreateMap worldMap;
    private ArrayList<BlockImpl> terrains;

    public MapController() {
        worldMap = new CreateMap();
        this.terrains = worldMap.getTerrains();
        setProportions();
    }

    private void setProportions() {
        this.terrains.stream().forEach(b -> {
            b.setX(b.getPosition().getX() * (ScreenController.SIZE_HD_W / 30));
            b.setY(b.getPosition().getY() * (ScreenController.SIZE_HD_H / 10));
            b.setWidth(b.getWidth() * (ScreenController.SIZE_HD_W / 30));
            b.setHeight(b.getHeight() * (ScreenController.SIZE_HD_H / 10));
        });
    }

    public ArrayList<BlockImpl> getPlatforms() {
        return this.terrains;
    }



}
