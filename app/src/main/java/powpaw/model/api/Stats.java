package powpaw.model.api;

public interface Stats {

    int getAttack();

    int getDefence();

    int getSpeed();

    void increaseAtt();

    void increaseDef();

    void increaseSpe();

    void decreaseAtt();

    void decreaseDef();

    void decreaseSpe();

    double toDouble(int value);

}