package powpaw.controller.impl;

import java.util.Random;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.shape.Circle;
import javafx.util.Duration;
import powpaw.controller.api.ScreenController;
import powpaw.model.api.Player;
import powpaw.model.api.PowerUp;
import powpaw.model.impl.AttackPowerUp;
import powpaw.model.impl.PlayerStats;
import powpaw.model.impl.SpeedPowerUp;
import powpaw.view.impl.PowerUpRender;

public class PowerUpController {
    private PowerUpRender powerUpRender;
    private PowerUp factoryPow;
    private final Random rand = new Random();
    private Circle powerUp;
    private boolean isCollected = false;
    private int powerUpIndex;

    public PowerUpController() {
        randomPowerUp();
        powerUpRender = new PowerUpRender(powerUp);
    }

    public PowerUpRender getRender() {
        return this.powerUpRender;
    }

    public void pickPowerUp(PlayerController playerController, PlayerStats statsP1, PlayerStats statsP2) {

        for (Player player : playerController.getPlayerObservable().getPlayers()) {
            if (powerUp.getBoundsInParent().intersects(player.getHitbox().getShape().getBoundsInParent())) {
                if (!isCollected) {
                    if (player.getNumber() == 1) {
                        factoryPow.statPowerUp(statsP1);
                    } else {
                        factoryPow.statPowerUp(statsP2);
                    }
                    isCollected = true;
                    powerUp.setVisible(false);
                    Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(10), event -> {
                        isCollected = false;
                        powerUp.setVisible(true);
                        powerUp = factoryPow.createPowerUp(ScreenController.SIZE_HD_W / rand.nextDouble(1.5, 5.0),
                                ScreenController.SIZE_HD_H / rand.nextDouble(1.5, 5.0));
                        // randomPowerUp();
                    }));
                    timeline.play();
                }
            }
        }
    }

    private void randomPowerUp() {
        powerUpIndex = rand.nextInt(2);
        if (powerUpIndex == 0) {
            factoryPow = new SpeedPowerUp();
            powerUp = factoryPow.createPowerUp(ScreenController.SIZE_HD_W / rand.nextDouble(1.5, 5.0),
                    ScreenController.SIZE_HD_H / rand.nextDouble(1.5, 5.0));
        } else {
            factoryPow = new AttackPowerUp();
            powerUp = factoryPow.createPowerUp(ScreenController.SIZE_HD_W / rand.nextDouble(1.5, 5.0),
                    ScreenController.SIZE_HD_H / rand.nextDouble(1.5, 5.0));
        }
    }
}
