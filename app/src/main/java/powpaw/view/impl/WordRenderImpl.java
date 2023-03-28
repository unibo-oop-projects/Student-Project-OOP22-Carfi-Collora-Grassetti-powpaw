package powpaw.view.impl;

import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import powpaw.controller.api.ScreenController;
import powpaw.controller.impl.PlayerController;
import powpaw.view.api.MapRender;
import powpaw.view.api.WordRender;

public class WordRenderImpl implements WordRender {

    private final MapRender worldRender = new MapRender();
    private final PlayerController playerController = new PlayerController();

    private Scene worldScene;

    @Override
    public PlayerController getPlayerController() {
        return this.playerController;
    }

    @Override
    public MapRender getMapRender() {
        return this.worldRender;
    }

    @Override
    public Scene render() {
        Pane worldPane = new Pane();
        worldRender.createScene(worldPane);
        worldPane.getChildren().add(playerController.getRender().getSprite());

        this.worldScene = new Scene(worldPane, ScreenController.SIZE_HD_W, ScreenController.SIZE_HD_H);
        return worldScene;
    }

    // questa cosa mettila nel gameloop, serve un controller del word per
    // passarglielo
    @Override
    public void setKeyCommands() {

        this.worldScene.setOnKeyPressed((EventHandler<? super KeyEvent>) new EventHandler<KeyEvent>() {

            @Override
            public void handle(KeyEvent event) {
                playerController.getWorld().getKeyObservable().notifyObserversPressed(event);
            }
        });

        worldScene.setOnKeyReleased(new EventHandler<KeyEvent>() {

            @Override
            public void handle(KeyEvent event) {
                playerController.getWorld().getKeyObservable().notifyObserversReleased(event);
            }

        });
    }
}
