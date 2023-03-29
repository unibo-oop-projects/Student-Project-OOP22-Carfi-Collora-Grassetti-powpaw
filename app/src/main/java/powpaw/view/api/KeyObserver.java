package powpaw.view.api;

import javafx.scene.input.KeyEvent;

public interface KeyObserver {

    void keyPressedPlayerOne(KeyEvent event);

    void keyReleasedPlayerOne(KeyEvent event);

    void keyPressedPlayerTwo(KeyEvent event);

    void keyReleasedPlayerTwo(KeyEvent event);
}
