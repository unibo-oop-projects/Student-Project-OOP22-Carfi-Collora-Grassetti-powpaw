package powpaw.model.impl;

public class PlayerStats {

    private double attack;
    private double defence;
    private double speed;

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
    public void setAttack(double attack){
        this.attack = attack;
    }
    public void setDefence(double defence){
        this.defence = defence;
    }
    public void setSpeed(double speed){
        this.speed = speed;
    }

}
