package powpaw.view.impl;

import java.util.ArrayList;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;
import powpaw.controller.impl.MapController;

public class MapRender {

    private MapController mapController;
    private ArrayList<Rectangle> terrains;
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
        this.terrains.stream().forEach(b -> b.setFill(this.textureBlock));
    }

    public ArrayList<Rectangle> getTerrains(){
        return this.terrains;
    }

    

}
