package powpaw.controller.impl;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import javafx.scene.input.KeyCode;
import powpaw.config.Parser;
import powpaw.model.api.Player;
import powpaw.view.api.KeyObserver;

public class KeyObserverImpl implements KeyObserver {

    private final Player player;

    private KeyCode keyJump;
    private KeyCode keyLeft;
    private KeyCode keyRight;
    private Set<KeyCode> keys = new HashSet<>();

    public KeyObserverImpl(Player player, Parser parser) {
        this.player = player;
        Map<String, KeyCode> commands = parser.getCommands(player.getNumber());

        this.keyJump = commands.get("jump");
        this.keyLeft = commands.get("left");
        this.keyRight = commands.get("right");

        this.keys.add(keyJump);
        this.keys.add(keyLeft);
        this.keys.add(keyRight);
    }

    @Override
    public void keyPressed(KeyCode event) {
        if (!keys.contains(event)) {
            return;
        }

        if (event == keyJump) {
            if (!this.player.isFalling()) {
                this.player.setIsJumping(true);
            }
        }
        if (event == keyRight) {
            this.player.setIsMovingRight(true);
        }
        if (event == keyLeft) {
            this.player.setIsMovingLeft(true);
        }
    }

    @Override
    public void keyReleased(KeyCode event) {

        if (!keys.contains(event)) {
            return;
        }

        if (event == keyJump) {
            this.player.setIsJumping(false);
        }
        if (event == keyRight) {
            this.player.setIsMovingRight(false);
        }
        if (event == keyLeft) {
            this.player.setIsMovingLeft(false);
        }

    }

}
