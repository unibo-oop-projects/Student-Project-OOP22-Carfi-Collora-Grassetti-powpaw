package powpaw.view.impl;

import java.util.stream.Collectors;

import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.Pane;
import javafx.scene.paint.ImagePattern;
import powpaw.controller.api.ScreenController;
import powpaw.controller.impl.DamageMeterController;
import powpaw.controller.impl.PlayerController;
import powpaw.controller.impl.PowerUpController;
import powpaw.controller.impl.WeaponController;
import powpaw.view.api.WorldRender;

public class WorldRenderImpl implements WorldRender {

    private final MapRender mapRender = new MapRender();
    private final WeaponController weaponController = new WeaponController();
    private final PlayerController playerController = new PlayerController();
    private final PowerUpController powerUpController = new PowerUpController();
    private final DamageMeterController damageMeterController = new DamageMeterController(playerController);

    private Scene worldScene;

    @Override
    public PlayerController getPlayerController() {
        return this.playerController;
    }

    @Override
    public WeaponController getWeaponController() {
        return this.weaponController;
    }

    @Override
    public PowerUpController getPowerUpController() {
        return this.powerUpController;
    }
    public DamageMeterController getDamageMeterController() {
        return this.damageMeterController;
    }

    @Override
    public MapRender getMapRender() {
        return this.mapRender;
    }

    @Override
    public Scene render() {
        Pane worldPane = mapRender.createPane();
        worldPane.setBackground(
                Background.fill(new ImagePattern(new Image("/backgroundWorld.png"))));
        worldPane.getChildren()
                .addAll(playerController.getRender().stream().map(r -> r.getSprite()).collect(Collectors.toList()));

        // debug
        worldPane.getChildren().add(playerController.getRender().get(0).getPlayer().getHitbox().getShape());
        worldPane.getChildren().add(playerController.getRender().get(0).getPlayer().getFeetBox());
        worldPane.getChildren().add(playerController.getRender().get(0).getPlayer().getArmHitbox());
        /*
         * worldPane.getChildren().add(playerController.getRender().get(0).getPlayer().
         * getHitbox().getHitboxLeft());
         * worldPane.getChildren().add(playerController.getRender().get(0).getPlayer().
         * getHitbox().getHitboxRight());
         */
        worldPane.getChildren().add(playerController.getRender().get(1).getPlayer().getHitbox().getShape());
        worldPane.getChildren().add(playerController.getRender().get(1).getPlayer().getFeetBox());
        worldPane.getChildren().add(playerController.getRender().get(1).getPlayer().getArmHitbox());
        /*
         * worldPane.getChildren().add(playerController.getRender().get(1).getPlayer().
         * getHitbox().getHitboxLeft());
         * worldPane.getChildren().add(playerController.getRender().get(1).getPlayer().
         * getHitbox().getHitboxRight());
         */

        mapRender.getTerrains().forEach(b -> worldPane.getChildren().add(b.getHitbox().getShape()));
        worldPane.getChildren().add(weaponController.getRender().getWeaponSprite());
        worldPane.getChildren().add(powerUpController.getRender().getSprite());
        worldPane.getChildren().add(damageMeterController.getRender().getDamage().get(0));
        worldPane.getChildren().add(damageMeterController.getRender().getDamage().get(1));
        weaponController.getRender().setTerrains(mapRender.getTerrains());
        this.worldScene = new Scene(worldPane, ScreenController.SIZE_HD_W, ScreenController.SIZE_HD_H);
        return worldScene;
    }

    public void playersCommands() {

        this.worldScene.setOnKeyPressed(event -> playerController.getPlayerObservable().getKeyObservable()
                .notifyObserversPressed(event.getCode()));

        this.worldScene.setOnKeyReleased(event -> playerController.getPlayerObservable().getKeyObservable()
                .notifyObserversReleased(event.getCode()));
    }
}
