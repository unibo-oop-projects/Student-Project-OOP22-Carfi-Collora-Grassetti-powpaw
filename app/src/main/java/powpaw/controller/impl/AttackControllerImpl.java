package powpaw.controller.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import powpaw.controller.api.ScreenController;
import powpaw.model.api.Player;
import powpaw.model.impl.PlayerImpl.PlayerState;

public class AttackControllerImpl {

    // si riferisce in percentuale
    private static final double MAX_PERC = 1; // * 100
    private Player playerOne;
    private Player playerTwo;

    public AttackControllerImpl(List<Player> players) {
        this.playerOne = players.get(0);
        this.playerTwo = players.get(1);
    }

    public Optional<Player> checkDeath() {
        if(ScreenController.isOutOfScreen(this.playerOne.getHitbox())){
            return Optional.of(playerOne);
        } if (ScreenController.isOutOfScreen(this.playerOne.getHitbox())){
            return Optional.of(playerOne);
        }
        return Optional.empty();
    }

    //return hit player
    public Optional<Player> checkHit() {
        if (this.playerOne.getArmHitbox().intersects(this.playerTwo.getHitbox().getShape().getBoundsInParent())){
            return Optional.of(this.playerTwo);
        } if (this.playerTwo.getArmHitbox().intersects(this.playerOne.getHitbox().getShape().getBoundsInParent())){
            return Optional.of(this.playerOne);
        }
        return Optional.empty();
    }



    /* public boolean update() {
        return checkDeath();
    } */

}
