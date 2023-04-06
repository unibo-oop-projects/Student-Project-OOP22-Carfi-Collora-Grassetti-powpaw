package powpaw.model.api;

import java.time.Duration;
import javafx.geometry.Point2D;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;
import powpaw.model.impl.PlayerStats;
import powpaw.model.impl.PlayerImpl.PlayerState;

public interface Player {

    Point2D getPosition();

    Point2D getDirection();

    void setDirection(Point2D direction);

    double getWidth();

    double getHeight();

    int getNumber();

    Shape getFeetBox();

    Rectangle getArmHitbox();

    void increaseArmHitbox();

    void reduceArmHitbox();

    PlayerState getState();

    PlayerStats getPlayerStats();

    DamageMeter getCurrentHealth();

    void setWidth(double width);

    void setHeight(double height);

    void setIsJumping(boolean b);

    void setIsMovingRight(boolean b);

    void setIsMovingLeft(boolean b);

    void setIsHit(boolean b);

    void idle();

    void dodge();

    void setDirectionDeath(Point2D direction);

    Hitbox getHitbox();

    void receiveAttack(Point2D direction, double damage);

    void update(Duration deltaTime);

}
