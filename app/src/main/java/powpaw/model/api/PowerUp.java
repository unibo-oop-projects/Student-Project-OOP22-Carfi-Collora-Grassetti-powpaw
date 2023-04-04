package powpaw.model.api;

import javafx.scene.shape.Circle;
import powpaw.model.impl.PlayerStats;

public abstract class PowerUp {

    private final static double RADIUS = 20.0;
    private Circle hurtbox = new Circle();
    
    public Circle createPowerUp(double x, double y){
        hurtbox.setRadius(RADIUS);
        hurtbox.setCenterX(x);
        hurtbox.setCenterY(y);
        return this.hurtbox;
    }

    public abstract void statPowerUp(PlayerStats stats);
}
