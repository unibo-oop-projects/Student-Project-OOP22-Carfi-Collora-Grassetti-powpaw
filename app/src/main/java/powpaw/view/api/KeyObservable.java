package powpaw.view.api;

import javafx.scene.input.KeyEvent;

public interface KeyObservable {

    void addObserver(KeyObserver observer);

    void removeObserver(KeyObserver observer);

    void notifyObserversPressed(KeyEvent event);

    void notifyObserversReleased(KeyEvent event);
}
