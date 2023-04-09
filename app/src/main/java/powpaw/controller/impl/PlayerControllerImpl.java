package powpaw.controller.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import javafx.geometry.Point2D;
import powpaw.controller.api.PlayerController;
import powpaw.controller.api.ScreenController;
import powpaw.model.api.Player;
import powpaw.controller.api.PlayerObservable;
import powpaw.model.impl.PlayerImpl;
import powpaw.view.api.PlayerRender;
import powpaw.view.impl.PlayerRenderImpl;

/**
 * The {@code PlayerControllerImpl} class implements the
 * {@code PlayerController} interface and
 * manages the players in the game.
 * 
 * @author Alessia Carfì
 */
public final class PlayerControllerImpl implements PlayerController {

    private static final Point2D POSITION_ONE = new Point2D(ScreenController.SIZE_HD_W / 3,
            ScreenController.SIZE_HD_H / 2.5);
    private static final Point2D POSITION_TWO = new Point2D(ScreenController.SIZE_HD_W / 1.5,
            ScreenController.SIZE_HD_H / 2.5);
    private static final List<Point2D> POSITIONS = List.of(POSITION_ONE, POSITION_TWO);

    private PlayerObservable playerObservable;
    private List<PlayerRender> playersRender = new ArrayList<>();
    private List<Player> players = new ArrayList<>();

    /**
     * Constructs a new {@code PlayerControllerImpl} object, initializes the players
     * and their respective PlayerRender objects, and initializes the
     * PlayerObservable object with the list of players.
     */
    public PlayerControllerImpl() {
        AtomicInteger index = new AtomicInteger();
        POSITIONS.forEach(point -> {
            Player player = new PlayerImpl(point, index.incrementAndGet());
            players.add(player);
            playersRender.add(new PlayerRenderImpl(player));
        });
        playerObservable = new PlayerObservableImpl(players);

    }

    @Override
    public List<PlayerRender> getRender() {
        return this.playersRender;
    }

    @Override
    public PlayerObservable getPlayerObservable() {
        return this.playerObservable;
    }

    @Override
    public List<Player> getPlayers() {
        return this.players;
    }
}
