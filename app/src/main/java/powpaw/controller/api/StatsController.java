package powpaw.controller.api;

public interface StatsController {

    int increaseAtt(int attack);

    int increaseDef(int defence);

    int increaseSpe(int speed);

    int decreaseAtt(int attack);

    int decreaseDef(int defence);

    int decreaseSpe(int speed);

}