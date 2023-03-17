package powpaw.controller.impl;

import javafx.scene.input.KeyEvent;
import powpaw.model.api.Player;
import powpaw.view.api.KeyObserver;

public class KeyObserverImpl implements KeyObserver {

    private final Player player;

    public KeyObserverImpl(final Player player) {
        this.player = player;
    }

    @Override
    public void keyPressed(KeyEvent event) {
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
                this.player.idle();
                break;
        }
    }
}
