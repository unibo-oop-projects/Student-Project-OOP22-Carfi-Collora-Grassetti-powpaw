package powpaw.model.api;

import javafx.geometry.Point2D;
import powpaw.model.impl.PlayerStats;

public interface Weapon {

    WeaponHitbox getHitbox();

    Point2D getPosition();

    void update();

    void setAttack(double attack);
    
    int getDurability();

    void decrementDurability();

    void resetDurability();

    int getId();

    boolean isPicked();

    void setPicked(boolean isPicked);

    void addAttack(PlayerStats ps);

    void setVisible(boolean b);

    boolean getIsVisible();

}
