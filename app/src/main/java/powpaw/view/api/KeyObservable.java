package powpaw.view.api;

import javafx.scene.input.KeyEvent;

public interface KeyObservable {

    void addObserver(KeyObserver observer);

    void removeObserver(KeyObserver observer);

    void notifyObservers(KeyEvent event);
}
