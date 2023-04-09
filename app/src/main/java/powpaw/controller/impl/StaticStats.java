package powpaw.controller.impl;

import powpaw.model.api.StatsBuilder;
import powpaw.model.impl.PlayerStats;

/**
 * this class contain the static stats of every player and the limit. It also have getter for stats and limit
 *  and build for stats
 * 
 * @author Simone Collorà
 */
public class StaticStats {
    private static PlayerStats statsP1;
    private static PlayerStats statsP2;
    private static int limit = 22;

    public static PlayerStats getStatsP1() {
        return statsP1;
    }

    public static int getLimit() {
        return limit;
    }

    public static PlayerStats getStatsP2() {
        return statsP2;
    }

    public static PlayerStats buildStatsP1(StatsBuilder build) {
        statsP1 = build.build();
        return statsP1;
    }

    public static PlayerStats buildStatsP2(StatsBuilder build) {
        statsP2 = build.build();
        return statsP2;
    }
}
