package powpaw.view.impl;
import java.util.ArrayList;
import java.util.List;

import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.Pane;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import powpaw.controller.api.ScreenController;
import powpaw.controller.impl.WorldController;
import powpaw.model.api.World;
import powpaw.model.impl.WorldImpl;

public class WorldRender {

    private WorldController worldController;
    private ArrayList<Rectangle> terrains;
    private ImagePattern textureBlock;
    private World world = new WorldImpl();
    private ArrayList<Rectangle> weapons;
    private TransitionFactory transition = new TransitionFactory();

    public WorldRender(){
        this.worldController = new WorldController();
        this.terrains = worldController.getPlatforms();
        this.textureBlock = new ImagePattern(new Image("/block.png"));
        this.weapons = world.getWeapons();

    }
    
    public Scene createScene(){
        Pane worldPane = new Pane();
        worldPane.setBackground(Background.fill(new ImagePattern(new Image("/backgroundWorld.png"))));
        drawBlocks();
        worldPane.getChildren().addAll(this.terrains);
        worldPane.getChildren().addAll(this.weapons);
        Scene scene = new Scene(worldPane, ScreenController.SIZE_HD_W, ScreenController.SIZE_HD_H);
        return scene;
    } 

    private void drawBlocks(){
        this.terrains.stream().forEach(b -> b.setFill(this.textureBlock));
    }

    public void update(){
        for (Rectangle weapon : weapons) {
            transition.doVerticalTransition(weapon, weapon.getY(), terrains);   
        }
    }

}
