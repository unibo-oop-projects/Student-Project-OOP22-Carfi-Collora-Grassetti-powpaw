package powpaw.view.api;

import javafx.scene.Scene;
import powpaw.controller.api.WeaponController;
import powpaw.controller.api.PlayerController;
import powpaw.controller.impl.DamageMeterController;
import powpaw.controller.impl.PowerUpController;
import powpaw.view.impl.MapRender;

/**
 * Interface that provides the ability to render the game world.
 * 
 * @author Alessia Carfì
 */
public interface WorldRender {

    /**
     * Gets the player controller instance.
     * 
     * @return the player controller
     */
    PlayerController getPlayerController();

    WeaponController getWeaponController();

    PowerUpController getPowerUpController();

    DamageMeterController getDamageMeterController();

    MapRender getMapRender();

    /**
     * Renders the game world.
     * 
     * @return the scene containing the rendered game world
     */
    Scene render();

    /**
     * Registers player commands for key presses and releases.
     */
    void playersCommands();
}
