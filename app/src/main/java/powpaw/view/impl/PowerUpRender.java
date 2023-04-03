package powpaw.view.impl;

import java.util.Random;

import javafx.scene.shape.Circle;

public class PowerUpRender {
    private Circle powerUps;
    Random rand = new Random();

    public PowerUpRender(Circle powerUps) {
        this.powerUps = powerUps;
    }

    public Circle getPowerUp() {
        return this.powerUps;
    }
    public void render(){
        powerUps.setCenterX(powerUps.getCenterX());
        powerUps.setCenterY(powerUps.getCenterY());
    }
}
