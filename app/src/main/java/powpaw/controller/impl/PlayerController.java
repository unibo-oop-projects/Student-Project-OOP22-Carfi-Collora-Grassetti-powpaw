package powpaw.controller.impl;

import javafx.geometry.Point2D;
import powpaw.controller.api.ScreenController;
import powpaw.model.api.Player;
import powpaw.model.api.World;
import powpaw.model.impl.PlayerImpl;
import powpaw.model.impl.WorldImpl;
import powpaw.view.impl.PlayerRender;

public class PlayerController {

    private World world = new WorldImpl();
    private PlayerRender playerRender;
    private Player player1;

    public PlayerController() {

        player1 = new PlayerImpl(
                new Point2D(ScreenController.SIZE_HD_W / 3, ScreenController.SIZE_HD_H / 2));
        world.addPlayer(player1);
        playerRender = new PlayerRender(player1);
    }

    // qui o nel model?
    public PlayerRender getRender() {
        return this.playerRender;
    }

    public World getWorld() {
        return this.world;
    }
}
