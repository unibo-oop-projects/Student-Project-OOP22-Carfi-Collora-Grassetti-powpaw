<<<<<<<< HEAD:app/src/main/java/powpaw/view/impl/WorldRender.java
package powpaw.view.impl;
import java.util.ArrayList;

import javafx.scene.Scene;
========
package powpaw.view.api;

import java.util.ArrayList;
>>>>>>>> Carfì:app/src/main/java/powpaw/view/api/MapRender.java
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.Pane;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;
<<<<<<<< HEAD:app/src/main/java/powpaw/view/impl/WorldRender.java
import powpaw.controller.api.ScreenController;
import powpaw.controller.impl.WorldController;
========
import powpaw.controller.api.WorldController;
>>>>>>>> Carfì:app/src/main/java/powpaw/view/api/MapRender.java

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
<<<<<<<< HEAD:app/src/main/java/powpaw/view/impl/WorldRender.java
        worldPane.getChildren().addAll(this.weapons);
        Scene scene = new Scene(worldPane, ScreenController.SIZE_HD_W, ScreenController.SIZE_HD_H);
        return scene;
    } 
========
        // Scene scene = new Scene(worldPane, ScreenController.SIZE_HD_W,
        // ScreenController.SIZE_HD_H);
        // return scene;
    }
>>>>>>>> Carfì:app/src/main/java/powpaw/view/api/MapRender.java

    private void drawBlocks() {
        this.terrains.stream().forEach(b -> b.setFill(this.textureBlock));
    }

    public void update(){
        for (Rectangle weapon : weapons) {
            transition.doVerticalTransition(weapon, weapon.getY(), terrains);   
        }
    }

}
