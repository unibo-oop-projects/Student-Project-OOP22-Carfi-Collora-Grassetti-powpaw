package powpaw.controller.impl;

import java.util.HashSet;
import java.util.Set;

import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import powpaw.model.api.Player;
import powpaw.view.api.KeyObserver;

public class KeyObserverImpl implements KeyObserver {

    private final Player player;

    private Set<KeyCode> pressedKeys = new HashSet<>();

    public KeyObserverImpl(final Player player) {
        this.player = player;
    }

    @Override
    public void keyPressed(KeyEvent event) {
        pressedKeys.add(event.getCode());
        for (final var e : pressedKeys) {
            switch (e) {
                case W:
                    this.player.jump();
                    break;
                case A:
                    this.player.moveLeft();
                    break;
                case D:
                    this.player.moveRight();
                    break;
                case H:
                    this.player.dodge();
                    break;
                case G:
                    this.player.attack();
                    break;
                default:
                    break;
            }
        }
    }

    @Override
    public void keyReleased(KeyEvent event) {
        pressedKeys.remove(event.getCode());
        player.idle();
    }
}
