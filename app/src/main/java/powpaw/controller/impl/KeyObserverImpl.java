package powpaw.controller.impl;

import java.util.HashSet;
import java.util.Set;
import javafx.scene.input.KeyEvent;
import powpaw.model.api.Player;
import powpaw.view.api.KeyObserver;

public class KeyObserverImpl implements KeyObserver {

    private final Player player;

    private Set<KeyEvent> pressedKeys = new HashSet<>();

    public KeyObserverImpl(final Player player) {
        this.player = player;
    }

    @Override
    public void keyPressed(KeyEvent event) {
        pressedKeys.add(event);
        commandsPressed();
    }

    @Override
    public void keyReleased(KeyEvent event) {
        pressedKeys.remove(event);
        commandsReleased();
    }

    private void commandsPressed() {
        for (var event : pressedKeys) {
            switch (event.getCode()) {
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

    private void commandsReleased() {
        player.idle();
    }
}
