package powpaw.view.api;

import javafx.scene.input.KeyCode;

public interface KeyObserver {

    void keyPressed(KeyCode event);

    void keyReleased(KeyCode event);
}
