package powpaw.view.api;

import javafx.scene.Scene;
import powpaw.controller.api.WeaponController;
import powpaw.controller.api.PlayerController;
import powpaw.controller.impl.PowerUpController;

public interface WorldRender {

    PlayerController getPlayerController();

    /**
     * Getter for the WeaponController
     * 
     * @returnAn instance of the WeaponController.
     */
    WeaponController getWeaponController();

    PowerUpController getPowerUpController();

    /**
     * Getter for the MapRender
     * 
     * @return An instance of the MapRender.
     */
    MapRender getMapRender();

    Scene render();

    void playersCommands();
}
