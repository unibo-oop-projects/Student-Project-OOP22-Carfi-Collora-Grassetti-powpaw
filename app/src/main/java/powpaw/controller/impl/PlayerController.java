package powpaw.controller.impl;

import java.util.ArrayList;
import java.util.List;

import javafx.geometry.Point2D;
import powpaw.controller.api.ScreenController;
import powpaw.model.api.Player;
import powpaw.model.api.PlayerObservable;
import powpaw.model.impl.PlayerImpl;
import powpaw.model.impl.PlayerObservableImpl;
import powpaw.view.impl.PlayerRender;

public class PlayerController {

    private PlayerObservable playerObservable;
    private List<PlayerRender> playersRender = new ArrayList<>();
    private List<Player> players = new ArrayList<>();

    public PlayerController() {

        players.add(
                new PlayerImpl(
                        new Point2D(ScreenController.SIZE_HD_W / 3, ScreenController.SIZE_HD_H / 2)));
        players.add(new PlayerImpl(
                new Point2D(ScreenController.SIZE_HD_W / 1.5, ScreenController.SIZE_HD_H / 2)));
        playerObservable = new PlayerObservableImpl(players);

        for (int i = 0; i < 2; i++) {
            playersRender.add(new PlayerRender(players.get(i), i + 1));
        }
    }

    public List<PlayerRender> getRender() {
        return this.playersRender;
    }

    public PlayerObservable getPlayerObservable() {
        return this.playerObservable;
    }
}
