package powpaw.view.impl;

import javafx.scene.shape.Circle;

public class PowerUpRender {
    private Circle powerUps;

    public PowerUpRender(Circle powerUps) {
        this.powerUps = powerUps;
    }

    public Circle getPowerUp() {
        return this.powerUps;
    }

    public void render() {
        powerUps.setCenterX(powerUps.getCenterX());
        powerUps.setCenterY(powerUps.getCenterY());
    }
}
