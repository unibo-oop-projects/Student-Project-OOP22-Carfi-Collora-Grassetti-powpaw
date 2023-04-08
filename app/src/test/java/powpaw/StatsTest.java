package powpaw;

import org.junit.jupiter.api.Test;

import powpaw.controller.api.PlayerController;
import powpaw.controller.impl.DamageMeterController;
import powpaw.controller.impl.PlayerControllerImpl;
import powpaw.model.api.DamageMeter;
import powpaw.model.api.Player;
import powpaw.model.api.StatsBuilder;
import powpaw.model.impl.DamageMeterImpl;
import powpaw.model.impl.PlayerStats;
import powpaw.model.impl.StatsBuilderImpl;

import static org.junit.jupiter.api.Assertions.*;

public class StatsTest {

    @Test
    void getStats(){

        PlayerStats stats;
        PlayerStats stats_eq = new PlayerStats(0.5, 0.2, 0.7);
        StatsBuilder builder = new StatsBuilderImpl();
        builder.setAttack(5);
        builder.setDefence(6);
        builder.setSpeed(7);
        stats = builder.build();
        assertEquals(stats_eq.getAttack(), stats.getAttack());
        assertEquals(stats_eq.getDefence(), stats.getDefence());
        assertEquals(stats_eq.getSpeed(), stats.getSpeed());
    }   
    @Test
    void getDamage(){
        DamageMeter meter = new DamageMeterImpl();
        meter.setDamage(15);
        meter.setDamage(20);
        assertEquals(35, meter.getDamage());
    }
}
