package powpaw;

import java.time.Duration;
import java.time.Instant;
import javafx.animation.AnimationTimer;
import powpaw.controller.api.WeaponController;
import powpaw.controller.api.DamageMeterController;
import powpaw.controller.api.PlayerController;
import powpaw.controller.api.PowerUpController;

/**
 * This class is responsible for running the game loop for the game. It extends
 * the {@code AnimationTimer} class of JavaFx lib that allows it to update the
 * game at a fixed interval, and is triggered by the JavaFX Application Thread.
 */
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

    /**
     * Calls the update method of the PlayerObservable class to update the game
     * state and the render method of the Render classes to render the game objects.
     * 
     * @param deltaTime the time since the last frame
     */
    private void update(Duration deltaTime) {
        playerController.getPlayerObservable().update(deltaTime);
        playerController.getRender().forEach(player -> player.renderPlayer());
        powerUpController.pickPowerUp(playerController);
        powerUpController.getRender().render();
        weaponController.pickWeapon();
        weaponController.getRender().render();
        weaponController.getWeapon().update();
        damageMeterController.getRender().update(playerController.getPlayers());
    }

    /**
     * Sets the PlayerController for the game loop.
     * 
     * @param playerController the PlayerController to be set
     */
    public void setPlayerController(PlayerController playerController) {
        this.playerController = playerController;
    }

    /**
     * Sets the WeaponController for the game loop.
     * 
     * @param weaponController the WeaponController to be set
     */
    public void setWeaponController(WeaponController weaponController) {
        this.weaponController = weaponController;
    }

    /**
     * Sets the PowerUpController for the game loop.
     * 
     * @param powerUpController the PowerUpController to be set
     */
    public void setPowerUpController(PowerUpController powerUpController) {
        this.powerUpController = powerUpController;
    }

    /**
     * Sets the DamageMeterController for the game loop.
     * 
     * @param damageMeterController the DamageMeterController to be set
     */
    public void setDamageMeterController(DamageMeterController damageMeterController) {
        this.damageMeterController = damageMeterController;
    }
}