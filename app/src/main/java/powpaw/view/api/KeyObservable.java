package powpaw.view.api;

import javafx.scene.input.KeyCode;

public interface KeyObservable {

    void addObserver(KeyObserver observer);

    void removeObserver(KeyObserver observer);

    void notifyObserversPressed(KeyCode event);

    void notifyObserversReleased(KeyCode event);
}
