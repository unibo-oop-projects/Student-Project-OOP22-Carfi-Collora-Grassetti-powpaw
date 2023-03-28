package powpaw.view.impl;

import java.util.ArrayList;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;
import powpaw.controller.impl.MapController;
import powpaw.model.impl.BlockImpl;

public class MapRender {

    private MapController mapController;
    private ArrayList<BlockImpl> terrains;
    private ImagePattern textureBlock;

    public MapRender() {
        this.mapController = new MapController();
        this.terrains = mapController.getPlatforms();
        this.textureBlock = new ImagePattern(new Image("/block.png"));
    }

    public Pane createPane() {
        Pane worldPane = new Pane();
        drawBlocks();
        return worldPane;
    }

    private void drawBlocks() {
        this.terrains.stream().forEach(b -> b.getHitbox().getHitbox().setFill(this.textureBlock));
    }

    public ArrayList<BlockImpl> getTerrains() {
        return this.terrains;
    }



}
