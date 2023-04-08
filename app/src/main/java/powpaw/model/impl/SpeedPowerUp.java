package powpaw.model.impl;

import powpaw.model.api.PowerUp;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.util.Duration;

/**
 * PowerUp for increase speed
 * 
 * @author Simone Collorà
 */
public class SpeedPowerUp extends PowerUp {

     /**
     * increase speed by POWNUMBER for 7 seconds
     * 
     * @author Simone Collorà
     * @param stats
     */
    @Override
    public void statPowerUp(PlayerStats stats) {
        double oldSpeed = stats.getSpeed();
        stats.setSpeed(oldSpeed + POWNUMBER);
        System.out.print(stats.getSpeed());
        new Timeline(new KeyFrame(Duration.seconds(7), event -> {
            stats.setSpeed(oldSpeed);
            System.out.print(stats.getSpeed());
        })).play();
    }
}