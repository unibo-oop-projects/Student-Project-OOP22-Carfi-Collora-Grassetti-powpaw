package powpaw.model.api;

import java.util.Random;

import javafx.scene.shape.Circle;
import powpaw.controller.api.ScreenController;
import powpaw.model.impl.PlayerStats;

/**
 * abstract PowerUp. This class create the base of the powerUp. POWNUMBER is a static double which
 * indicate how much points a stats will get when increased by the powerUp
 * 
 * 
 * @author Simone Collorà
 */
public abstract class PowerUp {

    protected final static double POWNUMBER = 0.2;
    private final double radius = ScreenController.SIZE_HD_W / 40;
    private final Random rand = new Random();
    private Circle hurtbox;
    private boolean isVisible = true;

    public PowerUp() {
        this.hurtbox = new Circle(rand.nextDouble(radius + 2.5, ScreenController.SIZE_HD_W - radius - 2.5),
                rand.nextDouble(radius, ScreenController.SIZE_HD_H / 3), radius);
    }

    public Circle getHurtbox() {
        return this.hurtbox;
    }

    public void setVisible(boolean b) {
        this.isVisible = b;
        this.hurtbox.setVisible(b);
    }

    public boolean getIsVisible() {
        return this.isVisible;
    }

    public abstract void statPowerUp(PlayerStats stats);
}
