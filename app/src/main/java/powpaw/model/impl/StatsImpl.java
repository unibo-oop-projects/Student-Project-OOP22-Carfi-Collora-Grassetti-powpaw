package powpaw.model.impl;

import powpaw.model.api.Stats;

public class StatsImpl implements Stats {

    private String name;
    private int attack;
    private int defence;
    private int speed;
    private final static int maxPoint = 10;
    private final static int minPoint = 5;
    private final static int plusMinus = 1;

    private StatsImpl(StatsBuilder build) {
        attack = build.attack;
        defence = build.defence;
        speed = build.speed;
        name = "Player";
    }

    public StatsImpl() {
        attack = 5;
        defence = 5;
        speed = 5;
    }

    @Override
    public int getAttack() {
        return attack;
    }

    @Override
    public int getDefence() {
        return defence;
    }

    @Override
    public int getSpeed() {
        return speed;
    }

    public String getName() {
        return name;
    }

    @Override
    public void increaseAtt() {
        if (attack < maxPoint) {
            attack += plusMinus;
        } else {
            System.err.println("Max Point Reached");
        }
    }

    @Override
    public void increaseDef() {
        if (defence < maxPoint) {
            defence += plusMinus;
        } else {
            System.err.println("Max Point Reached");
        }
    }

    @Override
    public void increaseSpe() {
        if (speed < maxPoint) {
            speed += plusMinus;
        } else {
            System.err.println("Max Point Reached");
        }
    }

    @Override
    public void decreaseAtt() {
        if (attack > minPoint) {
            attack -= plusMinus;
        } else {
            System.err.println("Max Point Reached");
        }
    }

    @Override
    public void decreaseDef() {
        if (defence > minPoint) {
            defence -= plusMinus;
        } else {
            System.err.println("Max Point Reached");
        }
    }

    @Override
    public void decreaseSpe() {
        if (speed > minPoint) {
            speed -= plusMinus;
        } else {
            System.err.println("Max Point Reached");
        }
    }

    @Override
    public double toDouble(int value) {
        return (double) value / 10;
    }

    public static class StatsBuilder {
        private String name;
        private int attack;
        private int defence;
        private int speed;

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

        public StatsImpl build() {
            return new StatsImpl(this);
        }
    }

}
