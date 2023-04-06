package powpaw.controller.impl;

import powpaw.controller.api.StatsController;

public class StatsControllerImpl implements StatsController {
    private final static int maxPoint = 10;
    private final static int minPoint = 5;
    private final static int plusMinus = 1;
    
    @Override
    public int increaseAtt(int attack) {
        if (attack < maxPoint) {
            attack += plusMinus;
        } else {
            System.err.println("Max Point Reached");
        }
        return attack;
    }

    @Override
    public int increaseDef(int defence) {
        if (defence < maxPoint) {
            defence += plusMinus;
        } else {
            System.err.println("Max Point Reached");
        }
        return defence;
    }

    @Override
    public int increaseSpe(int speed) {
        if (speed < maxPoint) {
            speed += plusMinus;
        } else {
            System.err.println("Max Point Reached");
        }
        return speed;
    }

    @Override
    public int decreaseAtt(int attack) {
        if (attack > minPoint) {
            attack -= plusMinus;
        } else {
            System.err.println("Min Point Reached");
        }
        return attack;
    }

    @Override
    public int decreaseDef(int defence) {
        if (defence > minPoint) {
            defence -= plusMinus;
        } else {
            System.err.println("Min Point Reached");
        }
        return defence;
    }

    @Override
    public int decreaseSpe(int speed) {
        if (speed > minPoint) {
            speed -= plusMinus;
        } else {
            System.err.println("Min Point Reached");
        }
        return speed;
    }

}
