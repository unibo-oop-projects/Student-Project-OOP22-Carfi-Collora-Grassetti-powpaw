package powpaw;

import java.time.Duration;
import java.time.Instant;

import javafx.animation.AnimationTimer;
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import powpaw.model.api.World;
import powpaw.model.impl.WorldImpl;
import powpaw.view.impl.WorldRender;

public class GameLoop extends AnimationTimer {

    private WorldRender worldRender = new WorldRender();
    private Scene worldScene;
    private Stage  currentStage;

    private Instant lastFrameTime;
    private World world = new WorldImpl();

    public GameLoop(Stage stage){
        this.worldScene = worldRender.createScene();
        this.currentStage = stage;
        currentStage.setScene(worldScene);
        currentStage.setOnCloseRequest(new EventHandler<WindowEvent>() {
            @Override
            public void handle(WindowEvent t) {
               stop();
            }
        });  
    }
    

    @Override
    public void start() {
        super.start();
        lastFrameTime = Instant.now();
    }

    @Override
    public void handle(long now) {
        Instant currentFrameTime = Instant.now();
        Duration deltaTime = Duration.between(lastFrameTime, currentFrameTime);
        lastFrameTime = currentFrameTime;
        update(deltaTime);
    }

    private void update(Duration deltaTime) {
        world.update(deltaTime);
        worldRender.update();
        
    }

    @Override
    public void stop() {
        super.stop();
        Platform.exit();
        System.exit(0);
    }

}
