package powpaw.controller.impl;

import java.util.Optional;
import powpaw.controller.api.ScreenController;
import powpaw.model.api.Player;
import powpaw.model.impl.PlayerImpl.PlayerState;

public class AttackControllerImpl {

    // si riferisce in percentuale
    private static final double MAX_DAMAGE = 1; // * 100
    private Player playerOne;
    private Player playerTwo;

    public AttackControllerImpl(Player playerOne, Player playerTwo) {
        this.playerOne = playerOne;
        this.playerTwo = playerTwo;
    }

    // nel PlayerImpl
    public Optional<Player> checkHealtStatus() {
        if (playerOne.getCurrentHealth() >= MAX_DAMAGE) {
            return Optional.of(this.playerOne);
        } else if (playerOne.getCurrentHealth() >= MAX_DAMAGE) {
            return Optional.of(this.playerTwo);
        }
        return Optional.empty();
    }

    public Optional<Player> checkDeath() {
        if (ScreenController.isOutOfScreen(this.playerOne.getHitbox())) {
            if (checkHit().get() == this.playerOne) {
                return Optional.of(this.playerOne);
            }
        } else if (ScreenController.isOutOfScreen(this.playerTwo.getHitbox())) {
            if (checkHit().get() == this.playerOne) {
                return Optional.of(this.playerTwo);
            }
        }
        return Optional.empty();
    }

    private Optional<Player> checkHit() {
        if (this.playerOne.getHitbox().checkCollision(this.playerTwo.getHitbox().getShape())) {
            if (this.playerOne.getState().equals(PlayerState.ATTACK)) {
                this.playerOne.attack();
                return Optional.of(this.playerOne);
            } else if (this.playerTwo.getState().equals(PlayerState.ATTACK)) {
                this.playerTwo.attack();
                return Optional.of(this.playerTwo);
            }
        }
        return Optional.empty();
    }

    public Optional<Player> update() {
        return checkDeath();
    }

}
