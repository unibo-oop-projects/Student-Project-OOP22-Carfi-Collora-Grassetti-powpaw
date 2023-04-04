package powpaw.model.impl;


import powpaw.model.api.PowerUp;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.util.Duration;

public class SpeedPowerUp extends PowerUp {

    @Override
    public void statPowerUp(PlayerStats stats) {
        // Circle powerUp = createPowerUp(x, y);
        double oldSpeed = stats.getSpeed();
        stats.setSpeed(oldSpeed + 0.2);
        System.out.print(stats.getSpeed());
        Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(5), event -> {
            stats.setSpeed(oldSpeed);
            System.out.print(stats.getSpeed());
        }));
        timeline.play();
       // return powerUp;
    }
}