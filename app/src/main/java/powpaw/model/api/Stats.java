package powpaw.model.api;


public interface Stats {

    double getAttack();

    double getDefence();

    double getSpeed();

    double getDexterity();

    void increaseAtt();

    void increaseDef();

    void increaseSpe();

    void increaseDex();

    void decreaseAtt();

    void decreaseDef();

    void decreaseSpe();

    void decreaseDex();

}