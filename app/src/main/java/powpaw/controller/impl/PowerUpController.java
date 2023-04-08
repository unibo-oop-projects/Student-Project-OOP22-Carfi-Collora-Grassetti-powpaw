package powpaw.controller.impl;

import java.util.Random;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.util.Duration;
import powpaw.controller.api.PlayerController;
import powpaw.model.api.PowerUp;
import powpaw.model.impl.AttackPowerUp;
import powpaw.model.impl.SpeedPowerUp;
import powpaw.view.impl.PowerUpRender;

/**
 * PowerUpController that create render and set powerUp behaviour
 * 
 * @author Simone Collorà
 */
public class PowerUpController {
    private PowerUpRender powerUpRender;
    private PowerUp powerUp;
    private boolean isCollected = false;
    private int powerUpIndex;
    private Random rand = new Random();

    public PowerUpController() {
        this.powerUpRender = new PowerUpRender();
        this.choosePowerUp();
    }

    public PowerUpRender getRender() {
        return this.powerUpRender;
    }

    /**
     * pickPowerUp check if a player pick the PowerUp and increase a determinated stat of the player
     * who pick the PowerUp, When someone pick the power up after the stat is increased isCollected became true
     * in order to block the powerUp to be picked more than one time and became invisble. After 10 seconds
     * isCollected return false and another powerUp is created.
     * 
     * @param playerController
     */
    public void pickPowerUp(PlayerController playerController) {

        playerController.getPlayerObservable().getPlayers().forEach(player -> {
            if (powerUp.getHurtbox().getBoundsInParent()
                    .intersects(player.getHitbox().getShape().getBoundsInParent())) {
                if (!isCollected) {
                    powerUp.statPowerUp(player.getNumber() == 1
                            ? playerController.getPlayerObservable().getPlayers().get(0).getPlayerStats()
                            : playerController.getPlayerObservable().getPlayers().get(1).getPlayerStats());
                    isCollected = true;
                    powerUp.setVisible(false);
                    new Timeline(new KeyFrame(Duration.seconds(10), event -> {
                        isCollected = false;
                        this.choosePowerUp();
                        powerUp.setVisible(true);
                    })).play();
                }
            }
        });
    }

    /**
     * This method chose with a random number what powerUp will be created
     */
    private void choosePowerUp() {
        powerUpIndex = rand.nextInt(2);
        powerUp = powerUpIndex == 0 ? new SpeedPowerUp() : new AttackPowerUp();
        powerUpRender.setPowerUp(powerUp, powerUpIndex);
    }
}
