package powpaw.model.api;

import javafx.geometry.Point2D;
import powpaw.model.impl.PlayerStats;

public interface Weapon {

    Hitbox getHitbox();

    Point2D getPosition();

    void update();

    void setAttack(double attack);

    void setSpeed(double speed);

    int getId();

    void addAttack(PlayerStats ps);

    void setVisible(boolean b);

    boolean getIsVisible();

}
