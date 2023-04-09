package powpaw.controller.api;

import powpaw.view.impl.PowerUpRender;

public interface PowerUpController {

    /**
     * Power
     * @return
     */
    PowerUpRender getRender();

    /**
     * pickPowerUp check if a player pick the PowerUp and increase a determinated stat of the player
     * who pick the PowerUp, When someone pick the power up after the stat is increased isCollected became true
     * in order to block the powerUp to be picked more than one time and became invisble. After 10 seconds
     * isCollected return false and another powerUp is created.
     * 
     * @param playerController
     */
    void pickPowerUp(PlayerController playerController);

}