package powpaw.controller.impl;

import java.util.Random;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.util.Duration;
import powpaw.controller.api.PlayerController;
import powpaw.controller.api.PowerUpController;
import powpaw.model.api.PowerUp;
import powpaw.model.impl.AttackPowerUp;
import powpaw.model.impl.SpeedPowerUp;
import powpaw.view.api.PowerUpRender;
import powpaw.view.impl.PowerUpRenderImpl;

/**
 * PowerUpController that create render and set powerUp behaviour
 * 
 * @author Simone Collorà
 */
public class PowerUpControllerImpl implements PowerUpController {
    private PowerUpRender powerUpRender;
    private PowerUp powerUp;
    private boolean isCollected = false;
    private int powerUpIndex;
    private Random rand = new Random();

    public PowerUpControllerImpl() {
        this.powerUpRender = new PowerUpRenderImpl();
        this.choosePowerUp();
    }

    @Override
    public PowerUpRender getRender() {
        return this.powerUpRender;
    }

    @Override
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
