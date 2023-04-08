package powpaw.controller.impl;

import java.util.List;
import java.util.Optional;

import powpaw.common.DirectionVector;
import powpaw.controller.api.AttackController;
import powpaw.controller.api.ScreenController;
import powpaw.model.api.Player;
import powpaw.model.impl.PlayerImpl.PlayerState;

public class AttackControllerImpl implements AttackController {

    private Player playerOne;
    private Player playerTwo;

    @Override
    public void setPlayers(List<Player> players) {
        this.playerOne = players.get(0);
        this.playerTwo = players.get(1);
    }

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

    @Override
    public void checkHit(Player player) {
        if (this.playerOne.getHitbox().checkCollision(this.playerTwo.getHitbox().getShape())
                && player.getNumber() == 1) {
            this.playerOne.serCurrentState(PlayerState.ATTACK);
            if (this.playerOne.getWeapon().isPresent()) {
                System.out.println("Durability 2:" + this.playerOne.getWeapon().get().getDurability());
                this.playerOne.getWeapon().get().decrementDurability();
            }
            if (this.playerOne.getDirectionState().equals(PlayerState.WALK_LEFT)) {
                this.playerTwo.receiveAttack(DirectionVector.LEFT.getPoint(), StatsHandler.getStatsP1().getAttack());
            } else {
                this.playerTwo.receiveAttack(DirectionVector.RIGHT.getPoint(), StatsHandler.getStatsP1().getAttack());
            }
        }
        if (this.playerTwo.getHitbox().checkCollision(this.playerOne.getHitbox().getShape())
                && player.getNumber() == 2) {
            this.playerTwo.serCurrentState(PlayerState.ATTACK);
            if (this.playerTwo.getWeapon().isPresent()) {
                this.playerTwo.getWeapon().get().decrementDurability();
                System.out.println("Durability 2:" + this.playerTwo.getWeapon().get().getDurability());
            }
            if (this.playerTwo.getDirectionState().equals(PlayerState.WALK_LEFT)) {
                this.playerOne.receiveAttack(DirectionVector.LEFT.getPoint(), StatsHandler.getStatsP2().getAttack());
            } else {
                this.playerOne.receiveAttack(DirectionVector.RIGHT.getPoint(), StatsHandler.getStatsP2().getAttack());
            }

        }
    }

}
