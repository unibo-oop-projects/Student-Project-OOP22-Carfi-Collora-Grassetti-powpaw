package powpaw.model.api;

import powpaw.model.impl.PlayerStats;

public interface StatsBuilder {

    void setAttack(int attack);

    void setDefence(int defence);

    void setSpeed(int speed);

    PlayerStats build();
}