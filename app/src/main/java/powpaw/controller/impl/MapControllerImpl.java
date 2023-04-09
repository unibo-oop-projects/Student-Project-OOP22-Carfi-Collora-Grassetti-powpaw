package powpaw.controller.impl;

import java.util.ArrayList;

import powpaw.controller.api.MapController;
import powpaw.controller.api.ScreenController;
import powpaw.model.impl.BlockImpl;
import powpaw.model.impl.CreateMap;

/**
 * Class MapController that creates and sets the map entities and their
 * respective proportions with the screen size.
 * 
 * @author Giacomo Grassetti
 */

public class MapControllerImpl implements MapController {

    private CreateMap worldMap;
    private ArrayList<BlockImpl> terrains;

    /**
     * Costrutor of MapController class
     */
    public MapControllerImpl() {
        worldMap = new CreateMap();
        this.terrains = worldMap.getTerrains();
        setProportions();
    }

    /**
     * Method to sets the proportions of terrains based on the screen size.
     */
    private void setProportions() {
        this.terrains.stream().forEach(b -> {
            b.setX(b.getPosition().getX() * (ScreenController.SIZE_HD_W / 30));
            b.setY(b.getPosition().getY() * (ScreenController.SIZE_HD_H / 10));
            b.setWidth(b.getWidth() * (ScreenController.SIZE_HD_W / 30));
            b.setHeight(b.getHeight() * (ScreenController.SIZE_HD_H / 10));
        });
    }

    @Override
    public ArrayList<BlockImpl> getPlatforms() {
        return this.terrains;
    }

}
