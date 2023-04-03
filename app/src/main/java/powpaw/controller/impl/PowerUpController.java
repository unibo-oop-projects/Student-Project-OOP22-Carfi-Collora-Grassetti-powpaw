package powpaw.controller.impl;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.shape.Circle;
import javafx.util.Duration;
import powpaw.controller.api.ScreenController;
import powpaw.model.api.Player;
import powpaw.model.api.PowerUp;
import powpaw.model.impl.PowerUpFactory;
import powpaw.model.impl.PowerUpImpl;
import powpaw.view.impl.PowerUpRender;

public class PowerUpController {
    private Circle powerUps;
    private PowerUpRender powerUpRender;
    private PowerUp pow = new PowerUpImpl();

    public PowerUpController() {
        powerUps = createPowerUp();
        powerUpRender = new PowerUpRender(this.powerUps);
    }

     public Circle createPowerUp() {
        powerUps = PowerUpFactory.createPowerUp(ScreenController.SIZE_HD_W / 2, ScreenController.SIZE_HD_H / 2);
        Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(5), event -> {
            powerUps= PowerUpFactory.createPowerUp(ScreenController.SIZE_HD_W / 2, ScreenController.SIZE_HD_H / 2);
        }));
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.play();
        return powerUps;
    }

    public Circle getPowerUps() {
        return this.powerUps;
    }

    public PowerUpRender getRender() {
        return this.powerUpRender;
    }

    public void pickPowerUp(Player player) {

        if (powerUps.getBoundsInParent().intersects(player.getHitbox().getShape().getBoundsInParent())) {
            powerUps.setCenterY(300);
            pow.attackUp();
        }
    }
}
