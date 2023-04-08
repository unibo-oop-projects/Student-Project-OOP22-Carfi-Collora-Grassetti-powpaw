package powpaw.model.api;

import java.time.Duration;
import java.util.Optional;

import javafx.geometry.Point2D;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;
import powpaw.model.impl.PlayerStats;
import powpaw.model.impl.PlayerImpl.PlayerState;

/**
 * 
 * @author Giacomo Grassetti
 */
public interface Player {

    Optional<Weapon> getWeapon();

    void setWeapon(Optional<Weapon> weapon);

    Point2D getPosition();

    Point2D getDirection();

    void setDirection(Point2D direction);

    double getWidth();

    double getHeight();

    int getNumber();

    Shape getFeetBox();

    /**
     * Getter for the hitbox shape of an arm as a rectangle.
     * 
     * @return The shape of ArmHitbox
     */
    Rectangle getArmHitbox();

    void increaseArmHitbox();

    void reduceArmHitbox();

    /**
     * Getter of the current state of the player.
     * 
     * @return The current state of the player (PlayerState)
     */
    PlayerState getState();

    void serCurrentState(PlayerState state);

    PlayerState getDirectionState();

    PlayerStats getPlayerStats();

    DamageMeter getCurrentHealth();

    void setWidth(double width);

    void setHeight(double height);

    void setIsJumping(boolean b);

    void setIsMovingRight(boolean b);

    void setIsMovingLeft(boolean b);

    void setIsHit(boolean b);

    void idle();

    /**
     * Method that checks if the player is falling by verifying if their feet are in
     * contact with the
     * terrain.
     * 
     * @return True if the feet player don't intersect the terrain, false otherwise
     */
    boolean isFalling();

    void dodge();

    /**
     * Method that sets the direction knockback for a player hitted.
     * 
     * @param direction Point2D with the direction to apply the knockback
     */
    void setDirectionDeath(Point2D direction);

    Hitbox getHitbox();

    /**
     * Method that updates the player's state to HIT, sets the direction of the
     * attack, reduces the
     * player's health by the damage received, and increases the player's knockback.
     * 
     * @param direction The direction from which the attack is coming, represented
     *                  as a Point2D.
     * @param damage    The amount of damage the player receives from the attack.
     */
    void receiveAttack(Point2D direction, double damage);

    void update(Duration deltaTime);
}
