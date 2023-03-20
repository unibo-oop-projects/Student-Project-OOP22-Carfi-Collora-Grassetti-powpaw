package powpaw.model.impl;

import java.math.BigDecimal;
import java.math.MathContext;

import powpaw.model.api.Stats;

public class StatsImpl implements Stats {

    private String name;
    private int attack;
    private int defence;
    private int speed;
    private int dexterity;
    private final static int maxPoint = 10;
    private final static double minPoint = 5;
    private final static double plusNminus = 1;

    public StatsImpl(StatsBuilder build) {
        attack = build.attack;
        defence = build.defence;
        speed = build.speed;
        dexterity = build.dexterity;
        name = "Player";
    }
    public StatsImpl(){
        attack = 5;
        defence = 5;
        dexterity = 5;
        speed = 5;
    }

    @Override
    public double getAttack() {
        return (double)attack/10;
    }

    @Override
    public double getDefence() {
        return (double)defence/10;
    }

    @Override
    public double getSpeed() {
        return (double)speed/10;
    }

    @Override
    public double getDexterity() {
        return (double)dexterity/10;
    }
    public String getName(){
        return name;
    }

    @Override
    public void increaseAtt() {
        if (attack < maxPoint - plusNminus) {
            attack += plusNminus;
        } else {
            System.err.println("Max Point Reached");
        }
    }

    @Override
    public void increaseDef() {
        if (defence < maxPoint - 0.1) {
            defence += 0.1;
        } else {
            System.err.println("Max Point Reached");
        }
    }

    @Override
    public void increaseSpe() {
        if (speed < maxPoint - 0.1) {
            speed += 0.1;
        } else {
            System.err.println("Max Point Reached");
        }
    }

    @Override
    public void increaseDex() {
        if (dexterity < maxPoint - 0.1) {
            dexterity += 1;
        } else {
            System.err.println("Max Point Reached");
        }
    }

    @Override
    public void decreaseAtt() {
        if (attack > minPoint) {
            attack -= 1;
        } else {
            System.err.println("Max Point Reached");
        }
    }

    @Override
    public void decreaseDef() {
        if (defence > minPoint) {
            defence -= 1;
        } else {
            System.err.println("Max Point Reached");
        }
    }

    @Override
    public void decreaseSpe() {
        if (speed > minPoint) {
            speed -= 1;
        } else {
            System.err.println("Max Point Reached");
        }
    }

    @Override
    public void decreaseDex() {
        if (dexterity > minPoint) {
            dexterity -= 1;
        } else {
            System.err.println("Max Point Reached");
        }
    }

    public static class StatsBuilder {
        private String name;
        private int attack;
        private int defence;
        private int speed;
        private int dexterity;

        public StatsBuilder(String name) {
            this.name = name;
        }

        public StatsBuilder newBuilder(String name) {
            return new StatsBuilder(name);
        }

        public StatsBuilder attack(int attack) {
            this.attack = attack;
            return this;
        }

        public StatsBuilder defence(int defence) {
            this.defence = defence;
            return this;
        }

        public StatsBuilder speed(int speed) {
            this.speed = speed;
            return this;
        }

        public StatsBuilder dexterity(int dexterity) {
            this.dexterity = dexterity;
            return this;
        }

        public StatsImpl build() {
            return new StatsImpl(this);
        }
    }

}
