package powpaw.controller.impl;

import java.util.ArrayList;

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
    private ArrayList<Circle> powerUps;
    private PowerUpRender powerUpRender;
    private PowerUp pow = new PowerUpImpl();

    public PowerUpController() {
        powerUps = createPowerUp();
    }

    private ArrayList<Circle> createPowerUp() {
        powerUps = new ArrayList<>();
        powerUps.add(PowerUpFactory.createPowerUp(ScreenController.SIZE_HD_W/2 ,
        ScreenController.SIZE_HD_H/2));
        Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(10), event ->{
            if(powerUps.size()<4){
                powerUps.add(PowerUpFactory.createPowerUp(ScreenController.SIZE_HD_W/2, ScreenController.SIZE_HD_H/2));
            }
        }));
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.play();
        return powerUps;
    }

    public ArrayList<Circle> getPowerUps() {
        return this.powerUps;
    }
    public PowerUpRender getRender(){
        return this.powerUpRender;
    }

    public void pickPowerUp(Player player) {
        for (Circle powerUp : powerUps) {
            if (powerUp.getBoundsInParent().intersects(player.getHitbox().getShape().getBoundsInParent())) { 
                powerUp.setCenterY(10000);
                pow.attackUp();
            }
        }
    }

}
