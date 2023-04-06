package powpaw.controller.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import javafx.geometry.Point2D;
import powpaw.controller.api.ScreenController;
import powpaw.model.api.Player;
import powpaw.model.api.PlayerObservable;
import powpaw.model.impl.PlayerImpl;
import powpaw.model.impl.PlayerObservableImpl;
import powpaw.view.impl.PlayerRender;

public class PlayerController {

    private final static Point2D POSITION_ONE = new Point2D(ScreenController.SIZE_HD_W / 3,
            ScreenController.SIZE_HD_H / 2.5);
    private final static Point2D POSITION_TWO = new Point2D(ScreenController.SIZE_HD_W / 1.5,
            ScreenController.SIZE_HD_H / 2.5);
    private final static List<Point2D> POSITIONS = List.of(POSITION_ONE, POSITION_TWO);

    private PlayerObservable playerObservable;
    private List<PlayerRender> playersRender = new ArrayList<>();
    private List<Player> players = new ArrayList<>();

    public PlayerController() {
        AtomicInteger index = new AtomicInteger();
        POSITIONS.forEach(point -> {
            Player player = new PlayerImpl(point, index.incrementAndGet());
            players.add(player);
            playersRender.add(new PlayerRender(player));
        });
        playerObservable = new PlayerObservableImpl(players);

    }

    public List<Player> getPlayerList() {
        return this.players;
    }

    public List<PlayerRender> getRender() {
        return this.playersRender;
    }

    public PlayerObservable getPlayerObservable() {
        return this.playerObservable;
    }
}
