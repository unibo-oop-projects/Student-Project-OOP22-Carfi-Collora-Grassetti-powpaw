package powpaw.view.impl;

import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import powpaw.model.api.PowerUp;
import powpaw.view.api.PowerUpRender;

/**
 * PowerUpRender implementation
 * 
 * @author Simone Collorà
 */
public class PowerUpRenderImpl implements PowerUpRender {
    private Circle sprite = new Circle();
    private PowerUp powerup;
    private int type;

    @Override
    public void setPowerUp(PowerUp powerup, int type) {
        this.type = type;
        this.powerup = powerup;
    }

    @Override
    public Circle getSprite() {
        return this.sprite;
    }

    @Override
    public void render() {
        this.sprite.setCenterX(this.powerup.getHurtbox().getCenterX());
        this.sprite.setCenterY(this.powerup.getHurtbox().getCenterY());
        this.sprite.setRadius(this.powerup.getHurtbox().getRadius());
        this.sprite.setFill(type == 0 ? Color.RED : Color.BLUE);
        this.sprite.setVisible(this.powerup.getIsVisible());
    }
}
