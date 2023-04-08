package powpaw.controller.api;

import java.util.List;
import java.util.Optional;

import powpaw.model.api.Player;

public interface AttackController {

    void setPlayers(List<Player> players);

    Optional<Player> checkDeath();

    void checkHit(Player player);

}