package powpaw.controller.impl;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import powpaw.config.Parser;
import powpaw.model.api.Player;
import powpaw.view.api.KeyObserver;

public class KeyObserverImpl implements KeyObserver {

    private final Player player;
    private Set<KeyCode> pressedKeys = new HashSet<>();

    private KeyCode keyJump;
    private KeyCode keyLeft;
    private KeyCode keyRight;

    public KeyObserverImpl(Player player, Parser parser) {
        this.player = player;
        Map<String, KeyCode> commands = parser.getCommands(player.getNumber());

        this.keyJump = commands.get("jump");
        this.keyLeft = commands.get("left");
        this.keyRight = commands.get("right");
    }

    @Override
    public void keyPressed(KeyEvent event) {
        pressedKeys.add(event.getCode());

        pressedKeys.forEach(key -> {
            if (key == this.keyJump) {
                this.player.jump();
            }
            if (key == this.keyLeft) {
                this.player.moveLeft();
            }
            if (key == this.keyRight) {
                this.player.moveRight();
            }
        });
    }

    @Override
    public void keyReleased(KeyEvent event) {
        if (pressedKeys.contains(event.getCode())) {
            pressedKeys.remove(event.getCode());
            this.player.idle();
        }
    }

}
