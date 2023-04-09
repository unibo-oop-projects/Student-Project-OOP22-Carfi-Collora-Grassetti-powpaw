package powpaw.model.impl;

import java.util.Random;

import javafx.scene.shape.Circle;
import powpaw.controller.api.ScreenController;
import powpaw.model.api.PlayerStats;
import powpaw.model.api.PowerUp;

/**
 * abstract PowerUp. This class create the base of the powerUp. POWNUMBER is a
 * static double which
 * indicate how much points a stats will get when increased by the powerUp
 * 
 * 
 * @author Simone Collorà
 */
public abstract class PowerUpImpl implements PowerUp {

    protected final static double POWNUMBER = 0.2;
    protected final static int powerUpDuration = 7;
    private final double radius = ScreenController.SIZE_HD_W / 40;
    private final Random rand = new Random();
    private Circle hurtbox;
    private boolean isVisible = true;

    public PowerUpImpl() {
        this.hurtbox = new Circle(rand.nextDouble(radius + 10, ScreenController.SIZE_HD_W - radius - 10),
                rand.nextDouble(radius, ScreenController.SIZE_HD_H / 3), radius);
    }

    @Override
    public Circle getHurtbox() {
        return this.hurtbox;
    }

    @Override
    public void setVisible(boolean b) {
        this.isVisible = b;
        this.hurtbox.setVisible(b);
    }

    @Override
    public boolean getIsVisible() {
        return this.isVisible;
    }

    @Override
    public abstract void statPowerUp(PlayerStats stats);
}
