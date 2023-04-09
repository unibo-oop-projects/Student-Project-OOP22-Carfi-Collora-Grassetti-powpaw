package powpaw.view.impl;

import java.util.ArrayList;
import java.util.List;

import javafx.scene.input.KeyCode;
import powpaw.view.api.KeyObservable;
import powpaw.view.api.KeyObserver;

/**
 * The {@code KeyObservableImpl} class is an implementation of the
 * {@code KeyObservable} interface. It provides a mechanism for registering
 * KeyObserver objects and notifying them when keys are pressed or released.
 * 
 * @author Alessia Carfì
 */
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
    public void notifyObserversPressed(KeyCode event) {
        observers.forEach(obs -> obs.keyPressed(event));
    }

    @Override
    public void notifyObserversReleased(KeyCode event) {
        observers.forEach(obs -> obs.keyReleased(event));
    }
}
