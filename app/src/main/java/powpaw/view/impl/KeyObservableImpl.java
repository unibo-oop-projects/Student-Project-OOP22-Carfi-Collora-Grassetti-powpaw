package powpaw.view.impl;

import java.util.ArrayList;
import java.util.List;

import javafx.scene.input.KeyEvent;
import powpaw.view.api.KeyObservable;
import powpaw.view.api.KeyObserver;

public class KeyObservableImpl implements KeyObservable {

    private List<KeyObserver> observers = new ArrayList<>();

    @Override
    public void addObserver(KeyObserver observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(KeyObserver observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObserversPressed(KeyEvent event) {
        for (var observer : observers) {
            observer.keyPressed(event);
        }
    }

    @Override
    public void notifyObserversReleased(KeyEvent event) {
        for (var observer : observers) {
            observer.keyReleased(event);
        }
    }
}
