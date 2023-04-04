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
    private AttackControllerImpl attackController;
    private Set<KeyCode> pressedKeys = new HashSet<>();
    private boolean isJumping = false;

    private KeyCode keyJump;
    private KeyCode keyLeft;
    private KeyCode keyRight;
    private KeyCode keyAttack;

    public KeyObserverImpl(Player player, Parser parser) {
        this.player = player;
        Map<String, KeyCode> commands = parser.getCommands(player.getNumber());

        this.keyJump = commands.get("jump");
        this.keyLeft = commands.get("left");
        this.keyRight = commands.get("right");
        this.keyAttack = commands.get("attack");
    }

    @Override
    public void keyPressed(KeyEvent event) {
        pressedKeys.add(event.getCode());

        pressedKeys.forEach(key -> {
            if (key == this.keyJump) {
                if (!isJumping) {
                    this.player.jump();
                    isJumping = true;
                } else {
                    this.player.idle();
                }
            }
            if (key == this.keyLeft) {
                this.player.moveLeft();
            }
            if (key == this.keyRight) {
                this.player.moveRight();
            }
            if (key == this.keyAttack){
                
            }
        });
    }

    @Override
    public void keyReleased(KeyEvent event) {
        if (pressedKeys.contains(event.getCode())) {
            pressedKeys.remove(event.getCode());
            if (event.getCode().equals(keyJump)) {
                isJumping = false;
            }
            this.player.idle();
        }
    }

    public void setAttackController(AttackControllerImpl ac){
        this.attackController = ac;
    }

}
