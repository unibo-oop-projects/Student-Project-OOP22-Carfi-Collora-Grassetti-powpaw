package powpaw.model.api;

public interface Stats {

    int getAttack();

    int getDefence();

    int getSpeed();

    int getDexterity();

    void increaseAtt();

    void increaseDef();

    void increaseSpe();

    void increaseDex();

    void decreaseAtt();

    void decreaseDef();

    void decreaseSpe();

    void decreaseDex();

    double toDouble(int value);

}