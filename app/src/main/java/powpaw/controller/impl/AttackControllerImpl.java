package powpaw.controller.impl;

import java.util.List;
import java.util.Optional;

import powpaw.common.DirectionVector;
import powpaw.controller.api.AttackController;
import powpaw.controller.api.ScreenController;
import powpaw.model.api.Player;
import powpaw.model.impl.PlayerImpl.PlayerState;

/**
 * Class AttackController that controll if a player hit another player and their
 * respective deaths
 * 
 * @author Giacomo Grassetti
 */
public class AttackControllerImpl implements AttackController {

    private Player playerOne;
    private Player playerTwo;

    /**
     * Player setters for the class
     * 
     * @param players A list of Player objects that contains players.
     */
    @Override
    public void setPlayers(List<Player> players) {
        this.playerOne = players.get(0);
        this.playerTwo = players.get(1);
    }

    /**
     * Method that checks if either player has gone out of
     * the screen and returns an Optional containing the player who is still on
     * the screen (player alive). If both players are still on the screen, it
     * returns an empty
     * Optional.
     * 
     * @return Optional<Player> if a player is out of screen, Optional.empty()
     *         otherwise
     */
    @Override
    public Optional<Player> checkDeath() {
        if (ScreenController.isOutOfScreen(playerOne.getHitbox())) {
            return Optional.of(playerTwo);
        }
        if (ScreenController.isOutOfScreen(this.playerTwo.getHitbox())) {
            return Optional.of(playerOne);
        }
        return Optional.empty();
    }

    /**
     * Method that checks if a player has hit the other player. It takes in a player
     * object as a parameter and
     * checks if that player's hitbox collides with the other player's hitbox. If a
     * hit is detected, it sets the attacking player's state to `PlayerState.ATTACK`
     * and
     * decrements the durability of their weapon (if they have one). It then calls
     * the receiveAttack method on the other player, passing in the direction of the
     * attack and the
     * attacking player's attack stat.
     * 
     * @param player the other player
     */
    @Override
    public void checkHit(Player player) {

        if (this.playerTwo.getState() != PlayerState.DODGE
                && this.playerOne.getHitbox().checkCollision(this.playerTwo.getHitbox().getShape())
                && player.getNumber() == 1) {
            if (this.playerOne.getWeapon().isPresent()) {
                this.playerOne.getWeapon().get().decrementDurability();
            }
            if (this.playerOne.getDirectionState().equals(PlayerState.WALK_LEFT)) {
                this.playerTwo.receiveAttack(DirectionVector.LEFT.getPoint(), StaticStats.getStatsP1().getAttack());
            } else {
                this.playerTwo.receiveAttack(DirectionVector.RIGHT.getPoint(), StaticStats.getStatsP1().getAttack());
            }
        }
        if (this.playerOne.getState() != PlayerState.DODGE
                && this.playerTwo.getHitbox().checkCollision(this.playerOne.getHitbox().getShape())
                && player.getNumber() == 2) {
            if (this.playerTwo.getWeapon().isPresent()) {
                this.playerTwo.getWeapon().get().decrementDurability();
            }
            if (this.playerTwo.getDirectionState().equals(PlayerState.WALK_LEFT)) {
                this.playerOne.receiveAttack(DirectionVector.LEFT.getPoint(), StaticStats.getStatsP2().getAttack());
            } else {
                this.playerOne.receiveAttack(DirectionVector.RIGHT.getPoint(), StaticStats.getStatsP2().getAttack());
            }

        }
    }

}
