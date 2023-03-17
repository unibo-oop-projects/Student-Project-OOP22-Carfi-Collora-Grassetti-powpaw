package powpaw.model.api;

import java.time.Duration;
import java.util.List;

import powpaw.view.api.KeyObservable;

public interface World {

    void addPlayer(Player player);

    List<Player> getPlayers();

    KeyObservable getKeyObservable();

    void update(Duration deltaTime);
}
