package powpaw.model.api;

import java.time.Duration;

import javafx.geometry.Point2D;
import powpaw.model.impl.PlayerImpl.PlayerState;

public interface Player {

    Point2D getPosition();

    Point2D getDirection();

    void setDirection(Point2D direction);

    double getWidth();

    double getHeight();

    int getNumber();

    PlayerState getState();

    void setWidth(double width);

    void setHeight(double height);

    void setIsJumping(boolean b);

    void setIsMovingRight(boolean b);

    void setIsMovingLeft(boolean b);

    void idle();

    void attack();

    void dodge();

    double getAttackPower();

    double getCurrentHealth();

    Hitbox getHitbox();

    void update(Duration deltaTime);

}
