package powpaw.Word.view.impl;

import java.util.stream.Collectors;

import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.Pane;
import javafx.scene.paint.ImagePattern;
import powpaw.Map.view.api.MapRender;
import powpaw.Map.view.impl.MapRenderImpl;
import powpaw.Player.controller.api.DamageMeterController;
import powpaw.Player.controller.api.PlayerController;
import powpaw.Player.controller.impl.DamageMeterControllerImpl;
import powpaw.Player.controller.impl.PlayerControllerImpl;
import powpaw.PowerUp.controller.api.PowerUpController;
import powpaw.PowerUp.controller.impl.PowerUpControllerImpl;
import powpaw.Weapon.controller.api.WeaponController;
import powpaw.Weapon.controller.impl.WeaponControllerImpl;
import powpaw.Word.controller.ScreenController;
import powpaw.Word.view.api.WorldRender;

/**
 * Implementation of the {@code WorldRender} interface that provides the ability
 * to render the game world.
 * 
 * @author Alessia Carfì
 */
public final class WorldRenderImpl implements WorldRender {

    private final MapRender mapRender = new MapRenderImpl();
    private final PlayerController playerController = new PlayerControllerImpl();
    private final WeaponController weaponController = new WeaponControllerImpl(playerController);
    private final PowerUpController powerUpController = new PowerUpControllerImpl();
    private final DamageMeterController damageMeterController = new DamageMeterControllerImpl(playerController);

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

    @Override
    public DamageMeterController getDamageMeterController() {
        return this.damageMeterController;
    }

    @Override
    public MapRender getMapRender() {
        return this.mapRender;
    }

    @Override
    public Scene render() {
        final Pane worldPane = mapRender.createPane();
        worldPane.setBackground(
                Background.fill(new ImagePattern(new Image("/backgroundWorld.png"))));
        worldPane.getChildren()
                .addAll(playerController.getRender().stream().map(r -> r.getSprite()).collect(Collectors.toList()));

        worldPane.getChildren()
                .addAll(playerController.getRender().stream().map(r -> r.getArmSprite()).collect(Collectors.toList()));

        mapRender.getTerrains().forEach(b -> worldPane.getChildren().add(b.getHitbox().getShape()));
        worldPane.getChildren().add(weaponController.getRender().getWeaponSprite());
        worldPane.getChildren().add(powerUpController.getRender().getSprite());
        worldPane.getChildren().add(damageMeterController.getRender().getDamage().get(0));
        worldPane.getChildren().add(damageMeterController.getRender().getDamage().get(1));
        weaponController.getRender().setTerrains(mapRender.getTerrains());
        this.worldScene = new Scene(worldPane, ScreenController.SIZE_HD_W, ScreenController.SIZE_HD_H);
        return worldScene;
    }

    @Override
    public void playersCommands() {

        this.worldScene.setOnKeyPressed(event -> playerController.getPlayerObservable().getKeyObservable()
                .notifyObserversPressed(event.getCode()));

        this.worldScene.setOnKeyReleased(event -> playerController.getPlayerObservable().getKeyObservable()
                .notifyObserversReleased(event.getCode()));
    }
}
