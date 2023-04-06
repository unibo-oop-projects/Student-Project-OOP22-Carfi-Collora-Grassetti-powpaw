package powpaw.model.impl;

import powpaw.model.api.StatsBuilder;

public class StatsBuilderImpl implements StatsBuilder {
    private double attack = 0;
    private double defence = 0;
    private double speed = 0;

    @Override
    public void setAttack(int attack) {
        this.attack = toDouble(attack);
    }

    @Override
    public void setDefence(int defence) {
        this.defence = toDouble(defence/3);
    }

    @Override
    public void setSpeed(int speed) {
        this.speed = toDouble(speed);
    }

    @Override
    public PlayerStats build() {
        return new PlayerStats(this.attack, this.defence, this.speed);
    }

    private double toDouble(int value) {
        return (double) value / 10;
    }
}
