package powpaw.controller.impl;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import powpaw.model.api.Player;
import powpaw.view.api.KeyObserver;

public class KeyObserverImpl implements KeyObserver {

    private final Player playerOne;
    private final Player playerTwo;

    private Set<KeyCode> p1PressedKeys = new HashSet<>();
    private Set<KeyCode> p2PressedKeys = new HashSet<>();

    public KeyObserverImpl(final List<Player> players) {
        this.playerOne = players.get(0);
        this.playerTwo = players.get(1);
    }

    @Override
    public void keyPressedPlayerOne(KeyEvent event) {
        p1PressedKeys.add(event.getCode());
        for (final var e : p1PressedKeys) {
            switch (e) {
                case W:
                    this.playerOne.jump();
                    break;
                case A:
                    this.playerOne.moveLeft();
                    break;
                case D:
                    this.playerOne.moveRight();
                    break;
                case H:
                    this.playerOne.dodge();
                    break;
                case G:
                    // this.playerOne.attack();
                    break;
                default:
                    break;
            }
        }
    }

    @Override
    public void keyReleasedPlayerOne(KeyEvent event) {
        if (p1PressedKeys.contains(event.getCode())) {
            p1PressedKeys.remove(event.getCode());
            playerOne.idle();
        }
    }

    @Override
    public void keyPressedPlayerTwo(KeyEvent event) {
        p2PressedKeys.add(event.getCode());
        for (final var e : p2PressedKeys) {
            switch (e) {
                case UP:
                    this.playerTwo.jump();
                    break;
                case LEFT:
                    this.playerTwo.moveLeft();
                    break;
                case RIGHT:
                    this.playerTwo.moveRight();
                    break;
                case L:
                    this.playerTwo.dodge();
                    break;
                case K:
                    // this.playerTwo.attack();
                    break;
                default:
                    break;
            }
        }
    }

    @Override
    public void keyReleasedPlayerTwo(KeyEvent event) {
        if (p2PressedKeys.contains(event.getCode())) {
            p2PressedKeys.remove(event.getCode());
            playerTwo.idle();
        }
    }
}
