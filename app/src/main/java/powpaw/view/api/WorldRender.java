package powpaw.view.api;

import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import powpaw.model.api.World;

public class WorldRender {

    private World world = new World();
    
    public Scene createScene(){
        Pane worldPane = new Pane();
        System.out.println(world.getTerrains());
        worldPane.getChildren().addAll(world.getTerrains());
        Scene scene = new Scene(worldPane, 1280, 720);
        return scene;
    } 

}
