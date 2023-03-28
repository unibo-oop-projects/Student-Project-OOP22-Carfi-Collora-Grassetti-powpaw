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
    private PlayerRender playerRender;
    private Player playerOne;
    private Player playerTwo;

    public PlayerController() {

        playerOne = new PlayerImpl(
                new Point2D(ScreenController.SIZE_HD_W / 3, ScreenController.SIZE_HD_H / 2));
        playerTwo = new PlayerImpl(
                new Point2D(ScreenController.SIZE_HD_W / 1.5, ScreenController.SIZE_HD_H / 2));
        playerObservable = new PlayerObservableImpl(new ArrayList<>(List.of(playerOne, playerTwo)));
        playerRender = new PlayerRender(playerOne, playerTwo);
    }

    // qui o nel model?
    public PlayerRender getRender() {
        return this.playerRender;
    }

    public PlayerObservable getPlayerObservable() {
        return this.playerObservable;
    }
}
