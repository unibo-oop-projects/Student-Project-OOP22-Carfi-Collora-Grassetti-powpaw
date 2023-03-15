package powpaw.model.impl;

import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;
import java.math.*;

import powpaw.model.api.Stats;

public class StatsImpl implements Stats {

    private double attack;
    private double defense;
    private double speed;
    private double dexterity;
    private final String att;
    private final double maxPoint;
    private final double minPoint;
    private static final DecimalFormat df = new DecimalFormat("0.0");

    private final Map<String, Double> stats;

    public StatsImpl() {
        stats = new HashMap<>();
        attack = 0.5;
        defense = 0.5;
        speed = 0.5;
        dexterity = 0.5;
        att = new String("Attack");
        stats.put("Attack", attack);
        stats.put("Defense", defense);
        stats.put("Speed", speed);
        stats.put("Dexterity", dexterity);
        maxPoint = 1.0;
        minPoint = 0;
    }

    @Override
    public void increaseAtt() {
        if (stats.get("Attack") < maxPoint - 0.1) {
            stats.computeIfPresent(att, (v, k) -> k + 0.1);
        } else {
            System.out.println("Max range reached!");
        }
    }

    @Override
    public void increaseDef() {

    }

    @Override
    public void increaseSpe() {

    }

    @Override
    public void increaseDex() {

    }

    @Override
    public void decreaseAtt() {

    }

    @Override
    public void decreaseDef() {

    }

    @Override
    public void decreaseSpe() {

    }

    @Override
    public void decreaseDex() {

    }

    @Override
    public Map<String, Double> getMap() {
        return this.stats;
    }

}
