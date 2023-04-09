package powpaw.view.impl;

import java.util.List;

import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import javafx.scene.paint.ImagePattern;
import powpaw.controller.api.MapController;
import powpaw.controller.impl.MapControllerImpl;
import powpaw.model.impl.BlockImpl;
import powpaw.view.api.MapRender;

/**
 * Class creates a pane and draws blocks on it using a ImagePattern.
 * 
 * @author Giacomo Grassetti
 */
public final class MapRenderImpl implements MapRender {

    private MapController mapController;
    private final List<BlockImpl> terrains;
    private final ImagePattern textureBlock;

    /**
     * Constructor of MapRenderImpl that gets the list of platforms from the
     * mapController object and assigns it to the terrains variable, and creates a
     * new ImagePattern object with the block image.
     */
    public MapRenderImpl() {
        this.mapController = new MapControllerImpl();
        this.terrains = mapController.getPlatforms();
        this.textureBlock = new ImagePattern(new Image("/block.png"));
    }

    @Override
    public Pane createPane() {
        final Pane worldPane = new Pane();
        drawBlocks();
        return worldPane;
    }

    /**
     * Setter that fill color of the hitbox shape of each terrain block to a texture
     * block.
     */
    private void drawBlocks() {
        this.terrains.stream().forEach(b -> b.getHitbox().getShape().setFill(this.textureBlock));
    }

    @Override
    public List<BlockImpl> getTerrains() {
        return this.terrains;
    }

}
