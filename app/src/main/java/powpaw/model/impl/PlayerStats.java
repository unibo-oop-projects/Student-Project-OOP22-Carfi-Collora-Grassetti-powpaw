package powpaw.model.impl;

public class PlayerStats {

    private final double attack;
    private final double defence;
    private final double speed;

    public PlayerStats(double attack, double defence, double speed) {
        this.attack = attack;
        this.defence = defence;
        this.speed = speed;
    }

    public double getAttack() {
        return this.attack;
    }

    public double getDefence() {
        return this.defence;
    }

    public double getSpeed() {
        return this.speed;
    }
}
