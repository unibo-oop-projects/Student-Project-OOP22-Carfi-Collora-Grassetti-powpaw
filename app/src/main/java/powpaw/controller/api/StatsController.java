package powpaw.controller.api;

/**
 * StatsController interface to increase or decrease a stat
 * 
 * @author Simone Collorà
 */
public interface StatsController {

    int increase(int stat);

    int decrease(int stat);

}