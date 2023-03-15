package powpaw.model.api;

import java.util.Map;

public interface Stats {

    void increaseAtt();

    void increaseDef();

    void increaseSpe();

    void increaseDex();

    void decreaseAtt();

    void decreaseDef();

    void decreaseSpe();

    void decreaseDex();

    Map<String, Double> getMap();

}