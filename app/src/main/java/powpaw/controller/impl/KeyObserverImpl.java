package powpaw.controller.impl;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import javafx.scene.input.KeyCode;
import powpaw.config.Parser;
import powpaw.controller.api.AttackController;
import powpaw.model.api.Player;
import powpaw.view.api.KeyObserver;

/**
 * Is an implementation of the {@code KeyObserver} interface, which provides
 * methods for handling key press and release events. This class is used to
 * observe the keyboard input and update the state of the associated
 * {@code Player} object accordingly.
 * 
 * @author Alessia Carfì
 */
public class KeyObserverImpl implements KeyObserver {

    private final Player player;

    private KeyCode keyJump;
    private KeyCode keyLeft;
    private KeyCode keyRight;
    private KeyCode keyAttack;
    private KeyCode keyDodge;
    private Set<KeyCode> keys = new HashSet<>();
    private AttackController attackController;

    /**
     * Constructs a new KeyObserverImpl.
     * 
     * @param player the Player to observe.
     * @param parser the Parser used to parse the keyboard input commands.
     * @param ac     the AttackController object used to check for hits during
     *               attacks.
     */
    public KeyObserverImpl(final Player player, final Parser parser, final AttackController ac) {
        this.player = player;
        Map<String, KeyCode> commands = parser.getCommands(player.getNumber());
        this.attackController = ac;

        this.keyJump = commands.get("jump");
        this.keyLeft = commands.get("left");
        this.keyRight = commands.get("right");
        this.keyAttack = commands.get("attack");
        this.keyDodge = commands.get("dodge");

        this.keys.add(keyJump);
        this.keys.add(keyLeft);
        this.keys.add(keyRight);
        this.keys.add(keyAttack);
        this.keys.add(keyDodge);
    }

    @Override
    public void keyPressed(final KeyCode event) {
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
        if (event == keyAttack) {
            this.player.setIsAttacking(true);
            this.attackController.checkHit(this.player);
        }
        if (event == keyDodge) {
            this.player.setIsDodging(true);
        }
    }

    @Override
    public void keyReleased(final KeyCode event) {

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
        if (event == keyAttack) {
            this.player.setIsAttacking(false);
        }
        if (event == keyDodge) {
            this.player.setIsDodging(false);
        }
    }
}
