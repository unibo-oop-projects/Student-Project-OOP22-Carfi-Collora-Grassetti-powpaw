package powpaw.view.api;

import javafx.scene.input.KeyCode;
import powpaw.controller.impl.AttackControllerImpl;

public interface KeyObserver {

    void keyPressed(KeyCode event);

    void keyReleased(KeyCode event);
}
