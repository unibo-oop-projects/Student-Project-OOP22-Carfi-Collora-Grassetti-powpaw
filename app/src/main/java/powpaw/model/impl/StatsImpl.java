package powpaw.model.impl;

import powpaw.model.api.Stats;

public class StatsImpl implements Stats {

    private int attack;
    private int defence;
    private int speed;

    private StatsImpl(StatsBuilder build) {
        attack = build.attack;
        defence = build.defence;
        speed = build.speed;
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

    @Override
    public double toDouble(int value) {
        return (double) value / 10;
    }

    public static class StatsBuilder {
        private int attack;
        private int defence;
        private int speed;

        public StatsBuilder() {

        }

        public StatsBuilder newBuilder() {
            return new StatsBuilder();
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
