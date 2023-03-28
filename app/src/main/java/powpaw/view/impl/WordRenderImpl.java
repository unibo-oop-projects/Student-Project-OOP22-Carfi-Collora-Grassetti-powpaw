package powpaw.view.impl;

import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.Pane;
import javafx.scene.paint.ImagePattern;
import powpaw.controller.api.ScreenController;
import powpaw.controller.impl.PlayerController;
import powpaw.controller.impl.WeaponController;
import powpaw.view.api.WordRender;

public class WordRenderImpl implements WordRender {

    private final MapRender mapRender = new MapRender();
    private final WeaponController weaponController = new WeaponController();
    private final PlayerController playerController = new PlayerController();
    private Scene worldScene;

    @Override
    public PlayerController getPlayerController() {
        return this.playerController;
    }

    public WeaponController getWeaponController() {
        return this.weaponController;
    }

    @Override
    public MapRender getMapRender() {
        return this.mapRender;
    }

    @Override
    public Scene render() {
        Pane worldPane = mapRender.createPane();
        worldPane.setBackground(Background.fill(new ImagePattern(new Image("/backgroundWorld.png"))));
        worldPane.getChildren().add(playerController.getRender().getSpritePlayerOne());
        worldPane.getChildren().add(playerController.getRender().getSpritePlayerTwo());
        worldPane.getChildren().addAll(mapRender.getTerrains());
        worldPane.getChildren().addAll(weaponController.getWeapons());
        weaponController.getRender().setTerrains(mapRender.getTerrains());
        this.worldScene = new Scene(worldPane, ScreenController.SIZE_HD_W, ScreenController.SIZE_HD_H);
        return worldScene;
    }

    public void playersCommands() {

        this.worldScene.setOnKeyPressed(new EventHandler<KeyEvent>() {

            @Override
            public void handle(KeyEvent event) {
                playerController.getPlayerObservable().getKeyObservable().notifyObserversPressed(event);
            }
        });

        this.worldScene.setOnKeyReleased(new EventHandler<KeyEvent>() {

            @Override
            public void handle(KeyEvent event) {
                playerController.getPlayerObservable().getKeyObservable().notifyObserversReleased(event);
            }

        });
    }
}
