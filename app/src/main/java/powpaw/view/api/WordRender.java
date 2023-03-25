package powpaw.view.api;

import javafx.scene.Scene;
import powpaw.controller.impl.PlayerController;

public interface WordRender {

    PlayerController getPlayerController();

    MapRender getMapRender();

    Scene render();

    void setKeyCommands();
}
