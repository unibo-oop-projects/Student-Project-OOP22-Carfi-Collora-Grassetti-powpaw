package powpaw.model.impl;

import powpaw.model.api.PlayerStats;

/**
 * PlayerStats implementation.
 * 
 * @author Simone Collorà
 */
public class PlayerStatsImpl implements PlayerStats {

    private double attack;
    private double defence;
    private double speed;

    public PlayerStatsImpl(double attack, double defence, double speed) {
        this.attack = attack;
        this.defence = defence;
        this.speed = speed;
    }

    @Override
    public double getAttack() {
        return this.attack;
    }

    @Override
    public double getDefence() {
        return this.defence;
    }

    @Override
    public double getSpeed() {
        return this.speed;
    }

    @Override
    public void setAttack(double attack) {
        this.attack = attack;
    }

    @Override
    public void setDefence(double defence) {
        this.defence = defence;
    }

    @Override
    public void setSpeed(double speed) {
        this.speed = speed;
    }

}
