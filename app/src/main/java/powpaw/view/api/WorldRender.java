package powpaw.view.api;

import java.util.ArrayList;

import javafx.scene.Scene;
import javafx.scene.layout.Background;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import powpaw.controller.api.ScreenController;
import powpaw.controller.api.WorldController;

public class WorldRender {

    private WorldController worldController;
    private ArrayList<Rectangle> terrains;

    public WorldRender(){
        this.worldController = new WorldController();
        this.terrains = worldController.getPlatforms();
    }

    private void drawBlocks(){
        this.terrains.stream().forEach(b -> {
            b.setFill(Color.BROWN);
        });
    }
    
    public Scene createScene(){
        Pane worldPane = new Pane();
        worldPane.setBackground(Background.fill(Color.BLUE));
        drawBlocks();
        worldPane.getChildren().addAll(this.terrains);
        Scene scene = new Scene(worldPane, ScreenController.SIZE_HD_W, ScreenController.SIZE_HD_H);
        return scene;
    } 

}
