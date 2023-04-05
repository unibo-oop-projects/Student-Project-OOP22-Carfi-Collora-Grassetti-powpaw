package powpaw.model.api;

import javafx.geometry.Point2D;

public interface Weapon {

    Hitbox getHitbox();

    Point2D getPosition();

    void update();

    void setAttack(double attack);

    void setSpeed(double speed);
    
}
