package powpaw.controller.api;

import java.util.List;

import powpaw.model.api.Player;
import powpaw.model.api.PlayerObservable;
import powpaw.view.api.PlayerRender;

public interface PlayerController {

    List<PlayerRender> getRender();

    PlayerObservable getPlayerObservable();

    List<Player> getPlayers();

}