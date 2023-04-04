package powpaw.controller.impl;

import powpaw.model.api.StatsBuilder;
import powpaw.model.impl.PlayerStats;

public class StatsHandler {
    private static PlayerStats statsP1;
    private static PlayerStats statsP2;

    public static PlayerStats getStatsP1() {
        return statsP1;
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
