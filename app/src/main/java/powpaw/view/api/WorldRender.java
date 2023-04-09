package powpaw.view.api;

import javafx.scene.Scene;
import powpaw.controller.api.WeaponController;
import powpaw.controller.api.DamageMeterController;
import powpaw.controller.api.PlayerController;
import powpaw.controller.api.PowerUpController;

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

    /**
     * Getter for the WeaponController
     * 
     * @return an instance of the WeaponController.
     */
    WeaponController getWeaponController();

     /**
     * Getter for the PowerUpController
     * 
     * @return an instance of the PowerUpController
     * @author Simone Collorà
     */
    PowerUpController getPowerUpController();

     /**
     * Getter for the DamageMeterController
     * 
     * @return an instance of the DamageMeterController
     * @author Simone Collorà
     */
    DamageMeterController getDamageMeterController();

    /**
     * Getter for the MapRender
     * 
     * @return An instance of the MapRender.
     */
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
