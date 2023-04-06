package powpaw;

import java.time.Duration;
import java.time.Instant;
import javafx.animation.AnimationTimer;
import powpaw.controller.impl.DamageMeterController;
import powpaw.controller.impl.PlayerController;
import powpaw.controller.impl.PowerUpController;
import powpaw.controller.impl.WeaponController;

public class GameLoop extends AnimationTimer {

    private Instant lastFrameTime;
    private PlayerController playerController;
    private WeaponController weaponController;
    private PowerUpController powerUpController;
    private DamageMeterController damageMeterController;

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
        playerController.getPlayerObservable().update(deltaTime);
        playerController.getRender().forEach(player -> player.renderPlayer());
        powerUpController.pickPowerUp(playerController);
        powerUpController.getRender().render();
        weaponController.pickWeapon(playerController);
        weaponController.getRender().render();
        weaponController.getWeapon().update();
        damageMeterController.getRender().update(playerController.getPlayerList());
    }

    public void setPlayerController(PlayerController playerController) {
        this.playerController = playerController;
    }

    public void setWeaponController(WeaponController weaponController) {
        this.weaponController = weaponController;
    }

    public void setPowerUpController(PowerUpController powerUpController) {
        this.powerUpController = powerUpController;
    }
    public void setDamageMeterController(DamageMeterController damageMeterController){
        this.damageMeterController = damageMeterController;
    }
}