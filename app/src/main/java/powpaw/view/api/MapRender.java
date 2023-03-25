package powpaw.view.api;

import java.util.ArrayList;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.Pane;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;
import powpaw.controller.impl.WorldController;
import powpaw.view.impl.TransitionFactory;

public class MapRender {

    private WorldController worldController;
    private ArrayList<Rectangle> terrains;
    private ImagePattern textureBlock;
    private ArrayList<Rectangle> weapons;
    private TransitionFactory transition = new TransitionFactory();

    public MapRender() {
        this.worldController = new WorldController();
        this.terrains = worldController.getPlatforms();
        this.weapons = worldController.getWeapons();
        this.textureBlock = new ImagePattern(new Image("/block.png"));

    }

    public void createScene(Pane worldPane) {
        worldPane.setBackground(Background.fill(new ImagePattern(new Image("/backgroundWorld.png"))));
        drawBlocks();
        worldPane.getChildren().addAll(this.terrains);
        worldPane.getChildren().addAll(this.weapons);
        // Scene scene = new Scene(worldPane, ScreenController.SIZE_HD_W,
        // ScreenController.SIZE_HD_H);
        // return scene;
    }

    private void drawBlocks() {
        this.terrains.stream().forEach(b -> b.setFill(this.textureBlock));
    }

    public void update() {
        for (Rectangle weapon : weapons) {
            transition.doVerticalTransition(weapon, weapon.getY(), terrains);
        }
    }

}
