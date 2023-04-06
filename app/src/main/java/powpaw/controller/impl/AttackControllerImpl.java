package powpaw.controller.impl;

import java.util.List;
import java.util.Optional;

import javafx.geometry.Point2D;
import powpaw.controller.api.ScreenController;
import powpaw.model.api.Player;

public class AttackControllerImpl {

    private Player playerOne;
    private Player playerTwo;

    public void setPlayers(List<Player> players) {
        this.playerOne = players.get(0);
        this.playerTwo = players.get(1);
    }

    public Optional<Player> checkDeath() {
        if (ScreenController.isOutOfScreen(playerOne.getHitbox())) {
            return Optional.of(playerOne);
        }
        if (ScreenController.isOutOfScreen(this.playerTwo.getHitbox())) {
            return Optional.of(playerTwo);
        }
        return Optional.empty();
    }

    public void checkHit(Player player) {
        if (this.playerOne.getHitbox().checkCollision(this.playerTwo.getHitbox().getHitboxLeft())
                && player.getNumber() == 1) {
            System.out.println(player.getNumber() + "left");
            this.playerTwo.receiveAttack(new Point2D(1, 0), StatsHandler.getStatsP1().getAttack()-StatsHandler.getStatsP2().getDefence());
        } else if (this.playerOne.getHitbox().checkCollision(this.playerTwo.getHitbox().getHitboxRight())
                && player.getNumber() == 1) {
            System.out.println(player.getNumber() + "right");
            this.playerTwo.receiveAttack(new Point2D(-1, 0), StatsHandler.getStatsP1().getAttack()-StatsHandler.getStatsP2().getDefence());
        } else if (this.playerTwo.getHitbox().checkCollision(this.playerOne.getHitbox().getHitboxLeft())
                && player.getNumber() == 2) {
            System.out.println(player.getNumber() + "left");
            this.playerOne.receiveAttack(new Point2D(1, 0), StatsHandler.getStatsP2().getAttack()-StatsHandler.getStatsP1().getDefence());
        } else if (this.playerTwo.getHitbox().checkCollision(this.playerOne.getHitbox().getHitboxRight())
                && player.getNumber() == 2) {
            System.out.println(player.getNumber() + "right");
            this.playerOne.receiveAttack(new Point2D(-1, 0), StatsHandler.getStatsP2().getAttack()-StatsHandler.getStatsP1().getDefence());
        }
    }

}
