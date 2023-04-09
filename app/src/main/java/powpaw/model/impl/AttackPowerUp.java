package powpaw.model.impl;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.util.Duration;
import powpaw.model.api.PlayerStats;

/**
 * PowerUp for increase attack.
 * 
 * @author Simone Collorà
 */
public class AttackPowerUp extends PowerUpImpl {
    /**
     * increase attack by POWNUMBER for 7 seconds.
     * 
     * @param stats
     */
    @Override
    public void statPowerUp(final PlayerStats stats) {
        double oldAttack = stats.getAttack();
        stats.setAttack(oldAttack + POWNUMBER);
        new Timeline(new KeyFrame(Duration.seconds(7), event -> {
            stats.setAttack(oldAttack);
        })).play();
    }
}
