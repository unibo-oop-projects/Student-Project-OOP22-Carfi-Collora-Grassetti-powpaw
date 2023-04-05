package powpaw.model.impl;

import powpaw.model.api.PowerUp;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.util.Duration;

public class AttackPowerUp extends PowerUp {

    @Override
    public void statPowerUp(PlayerStats stats) {
        double oldAttack = stats.getAttack();
        stats.setAttack(oldAttack + POWNUMBER);
        System.out.print(stats.getAttack());
        new Timeline(new KeyFrame(Duration.seconds(5), event -> {
            stats.setAttack(oldAttack);
            System.out.print(stats.getAttack());
        })).play();
    }
}
