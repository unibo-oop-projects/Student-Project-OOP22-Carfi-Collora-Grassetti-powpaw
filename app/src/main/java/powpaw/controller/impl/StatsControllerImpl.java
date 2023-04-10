package powpaw.controller.impl;

import powpaw.controller.api.StatsController;

/**
 * StatsController implementation. For balance reason every stat have a minimum
 * of 5 and a max of 10.
 * 
 * @author Simone Collorà
 */
public final class StatsControllerImpl implements StatsController {
    private static final int MAXPOINTS = 10;
    private static final int MINPOINTS = 5;
    private static final int PLUSMINUS = 1;

    @Override
    public int increase(int stat) {
        if (stat < MAXPOINTS) {
            stat += PLUSMINUS;
        }
        return stat;
    }

    @Override
    public int decrease(int stat) {
        if (stat > MINPOINTS) {
            stat -= PLUSMINUS;
        }
        return stat;
    }

}
