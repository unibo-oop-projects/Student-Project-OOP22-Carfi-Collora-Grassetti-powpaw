package powpaw.model.impl;

import powpaw.model.api.PowerUp;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.util.Duration;

public class SpeedPowerUp extends PowerUp {

    @Override
    public void statPowerUp(PlayerStats stats) {
        double oldSpeed = stats.getSpeed();
        stats.setSpeed(oldSpeed + POWNUMBER);
        System.out.print(stats.getSpeed());
        new Timeline(new KeyFrame(Duration.seconds(5), event -> {
            stats.setSpeed(oldSpeed);
            System.out.print(stats.getSpeed());
        })).play();
    }
}