package powpaw.view.api;

import javafx.scene.input.KeyEvent;
import powpaw.controller.impl.AttackControllerImpl;

public interface KeyObserver {

    void keyPressed(KeyEvent event);

    void keyReleased(KeyEvent event);

}
