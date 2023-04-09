package powpaw.model.impl;

import powpaw.model.api.PowerUp;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.util.Duration;
/**
 * PowerUp for increase attack
 * 
 * @author Simone Collorà
 */
public class AttackPowerUp extends PowerUp {
    /**
     * increase attack by POWNUMBER for 7 seconds
     * 
     * @param stats
     */
    @Override
    public void statPowerUp(PlayerStats stats) {
        double oldAttack = stats.getAttack();
        stats.setAttack(oldAttack + POWNUMBER);
        new Timeline(new KeyFrame(Duration.seconds(7), event -> {
            stats.setAttack(oldAttack);
        })).play();
    }
}
