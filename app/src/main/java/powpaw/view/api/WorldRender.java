package powpaw.view.api;

import java.net.URL;
import java.util.ArrayList;

import org.checkerframework.checker.units.qual.C;

import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;
import powpaw.controller.api.ScreenController;
import powpaw.controller.api.WorldController;

public class WorldRender {

    private WorldController worldController;
    private ArrayList<Rectangle> terrains;
    private ImagePattern textureBlock;

    public WorldRender(){
        this.worldController = new WorldController();
        this.terrains = worldController.getPlatforms();
        this.textureBlock = new ImagePattern(new Image("/block.png"));
    }
    
    public Scene createScene(){
        Pane worldPane = new Pane();
        worldPane.setBackground(Background.fill(new ImagePattern(new Image("/backgroundWorld.png"))));
        drawBlocks();
        worldPane.getChildren().addAll(this.terrains);
        Scene scene = new Scene(worldPane, ScreenController.SIZE_HD_W, ScreenController.SIZE_HD_H);
        return scene;
    } 

    private void drawBlocks(){
        this.terrains.stream().forEach(b -> b.setFill(this.textureBlock));
    }

}
