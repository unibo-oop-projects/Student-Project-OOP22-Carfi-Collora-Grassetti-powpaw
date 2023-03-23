package powpaw.view.impl;

import powpaw.controller.impl.StatsControllerImpl;
import powpaw.model.impl.StatsImpl;
import powpaw.view.api.ButtonAction;

public class ButtonActionImpl implements ButtonAction {
    @Override
    public StatsImpl setIncreaseAttack(StatsImpl stats, StatsControllerImpl control) {
        stats = new StatsImpl.StatsBuilder().attack(control.increaseAtt(stats.getAttack()))
                .defence(stats.getDefence()).speed(stats.getSpeed())
                .build();
        return stats;
    }

    @Override
    public StatsImpl setDecreaseAttack(StatsImpl stats, StatsControllerImpl control) {
        stats = new StatsImpl.StatsBuilder().attack(control.decreaseAtt(stats.getAttack()))
                .defence(stats.getDefence()).speed(stats.getSpeed())
                .build();
        return stats;
    }

    @Override
    public StatsImpl setIncreaseDefence(StatsImpl stats, StatsControllerImpl control) {
        stats = new StatsImpl.StatsBuilder().attack(stats.getAttack())
                .defence(control.increaseDef(stats.getDefence())).speed(stats.getSpeed())
                .build();
        return stats;
    }

    @Override
    public StatsImpl setDecreaseDefence(StatsImpl stats, StatsControllerImpl control) {
        stats = new StatsImpl.StatsBuilder().attack(stats.getAttack())
                .defence(control.decreaseDef(stats.getDefence())).speed(stats.getSpeed())
                .build();
        return stats;
    }

    @Override
    public StatsImpl setIncreaseSpeed(StatsImpl stats, StatsControllerImpl control) {
        stats = new StatsImpl.StatsBuilder().attack(stats.getAttack())
                .defence(stats.getDefence()).speed(control.increaseSpe(stats.getSpeed()))
                .build();
        return stats;
    }
    @Override
    public StatsImpl setDecreaseSpeed(StatsImpl stats, StatsControllerImpl control) {
        stats = new StatsImpl.StatsBuilder().attack(stats.getAttack())
                .defence(stats.getDefence()).speed(control.decreaseSpe(stats.getSpeed()))
                .build();
        return stats;
    }
}