package powpaw.view.impl;

import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.Pane;
import javafx.scene.paint.ImagePattern;
import powpaw.controller.api.ScreenController;
import powpaw.controller.impl.AttackControllerImpl;
import powpaw.controller.impl.DamageMeterControllerImpl;
import powpaw.controller.impl.PlayerController;
import powpaw.controller.impl.PowerUpController;
import powpaw.controller.impl.WeaponController;
import powpaw.view.api.WorldRender;

public class WorldRenderImpl implements WorldRender {

    private final MapRender mapRender = new MapRender();
    private final WeaponController weaponController = new WeaponController();
    private final PlayerController playerController = new PlayerController();
    private PowerUpController powerUpController = new PowerUpController();
    private final DamageMeterControllerImpl damageMeterController = new DamageMeterControllerImpl();

    // TODO qui o nel PlayerController?
    private final AttackControllerImpl attackController = new AttackControllerImpl(
            playerController.getPlayerObservable().getPlayers().get(0),
            playerController.getPlayerObservable().getPlayers().get(1));

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

    public AttackControllerImpl getAttackController() {
        return this.attackController;
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
        worldPane.getChildren().add(playerController.getRender().get(0).getSprite());
        worldPane.getChildren().add(playerController.getRender().get(1).getSprite());
        mapRender.getTerrains().forEach(b -> worldPane.getChildren().add(b.getHitbox().getShape()));
        worldPane.getChildren().add(weaponController.getRender().getWeaponSprite());
        worldPane.getChildren().add(powerUpController.getRender().getSprite());
        worldPane.getChildren().add(damageMeterController.getRender().getDamageP1());
        worldPane.getChildren().add(damageMeterController.getRender().getDamageP2());
        System.out.println(damageMeterController.getRender().getDamageP1());
        weaponController.getRender().setTerrains(mapRender.getTerrains());
        this.worldScene = new Scene(worldPane, ScreenController.SIZE_HD_W, ScreenController.SIZE_HD_H);
        return worldScene;
    }

    public void playersCommands() {

        this.worldScene.setOnKeyPressed(new EventHandler<KeyEvent>() {

            @Override
            public void handle(KeyEvent event) {
                playerController.getPlayerObservable().getKeyObservable()
                        .notifyObserversPressed(event);
            }
        });

        this.worldScene.setOnKeyReleased(new EventHandler<KeyEvent>() {

            @Override
            public void handle(KeyEvent event) {
                playerController.getPlayerObservable().getKeyObservable()
                        .notifyObserversReleased(event);
            }
        });
    }
}
