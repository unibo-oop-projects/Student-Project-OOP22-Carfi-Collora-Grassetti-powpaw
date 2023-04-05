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

    PlayerState getState();

    PlayerStats getPlayerStats();

    void setWidth(double width);

    void setHeight(double height);

    void setIsJumping(boolean b);

    void setIsMovingRight(boolean b);

    void setIsMovingLeft(boolean b);

    void idle();

    void dodge();

    Hitbox getHitbox();

    void update(Duration deltaTime);

}
