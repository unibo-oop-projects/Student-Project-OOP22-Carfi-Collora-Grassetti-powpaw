package powpaw.view.api;

import javafx.scene.Scene;
import powpaw.controller.api.PlayerController;
import powpaw.controller.impl.PowerUpController;
import powpaw.controller.impl.WeaponController;
import powpaw.view.impl.MapRender;

public interface WorldRender {

    PlayerController getPlayerController();

    WeaponController getWeaponController();

    PowerUpController getPowerUpController();

    MapRender getMapRender();

    Scene render();

    void playersCommands();
}
