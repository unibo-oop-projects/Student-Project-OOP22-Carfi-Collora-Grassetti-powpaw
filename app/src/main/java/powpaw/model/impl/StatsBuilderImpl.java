package powpaw.model.impl;

import powpaw.model.api.StatsBuilder;

public class StatsBuilderImpl implements StatsBuilder {
    private double attack = 0.5;
    private double defence = 0.5;
    private double speed = 0.5;

    public void setAttack(int attack) {
        this.attack += toDouble(attack);
    }

    public void setDefence(int defence) {
        this.defence += toDouble(defence);
    }

    public void setSpeed(int speed) {
        this.speed += toDouble(speed);
    }

    public PlayerStats build() {
        return new PlayerStats(this.attack, this.defence, this.speed);
    }

    private double toDouble(int value) {
        return value / 10;
    }
}
