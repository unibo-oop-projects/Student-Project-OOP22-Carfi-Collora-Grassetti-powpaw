package powpaw.view.api;

import powpaw.controller.impl.StatsControllerImpl;
import powpaw.model.impl.StatsImpl;

public interface ButtonAction {

    StatsImpl setIncreaseAttack(StatsImpl stats, StatsControllerImpl control);

    StatsImpl setDecreaseAttack(StatsImpl stats, StatsControllerImpl control);

    StatsImpl setIncreaseDefence(StatsImpl stats, StatsControllerImpl control);

    StatsImpl setDecreaseDefence(StatsImpl stats, StatsControllerImpl control);

    StatsImpl setIncreaseSpeed(StatsImpl stats, StatsControllerImpl control);

    StatsImpl setDecreaseSpeed(StatsImpl stats, StatsControllerImpl control);

}