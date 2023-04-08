package powpaw.model.api;

import powpaw.model.impl.PlayerStats;
/**
 * StatsBuilder interface
 * 
 * @author Simone Collorà
 */
public interface StatsBuilder {

    void setAttack(int attack);

    void setDefence(int defence);

    void setSpeed(int speed);

    PlayerStats build();
}