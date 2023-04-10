package powpaw.model.impl;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.util.Duration;
import powpaw.model.api.PlayerStats;

/**
 * PowerUp for increase speed.
 * 
 * @author Simone Collorà
 */
public class SpeedPowerUp extends PowerUpImpl {

    /**
     * increase speed by POWNUMBER for 7 seconds.
     *
     * @param stats
     */
    @Override
    public void statPowerUp(final PlayerStats stats) {
        double oldSpeed = stats.getSpeed();
        stats.setSpeed(oldSpeed + POWNUMBER);
        new Timeline(new KeyFrame(Duration.seconds(POWERUPDURATION), event -> {
            stats.setSpeed(oldSpeed);
        })).play();
    }
}
