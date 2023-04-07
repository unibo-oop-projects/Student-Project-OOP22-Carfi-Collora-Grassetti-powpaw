package powpaw.model.api;

import java.time.Duration;
import java.util.List;

import powpaw.controller.impl.AttackControllerImpl;
import powpaw.view.api.KeyObservable;

public interface PlayerObservable {

    List<Player> getPlayers();

    KeyObservable getKeyObservable();

    void update(Duration deltaTime);

    AttackControllerImpl getAttackController();

}
