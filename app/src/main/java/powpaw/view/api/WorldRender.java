package powpaw.view.api;

import javafx.scene.Scene;
import powpaw.controller.impl.PlayerController;
import powpaw.controller.impl.WeaponController;
import powpaw.view.impl.MapRender;

public interface WorldRender {

    PlayerController getPlayerController();

    WeaponController getWeaponController();

    MapRender getMapRender();

    Scene render();

    void playersCommands();
}
