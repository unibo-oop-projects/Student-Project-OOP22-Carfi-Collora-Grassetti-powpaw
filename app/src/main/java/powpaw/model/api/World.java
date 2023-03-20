package powpaw.model.api;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import javafx.scene.shape.Rectangle;
import powpaw.view.api.KeyObservable;

public interface World {

    void addPlayer(Player player);

    ArrayList<Rectangle> getWeapons();

    List<Player> getPlayers();

    KeyObservable getKeyObservable();

    void update(Duration deltaTime);
}
