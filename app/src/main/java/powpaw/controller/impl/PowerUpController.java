package powpaw.controller.impl;

import java.util.ArrayList;

import javafx.scene.shape.Circle;
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
        powerUps.add(PowerUpFactory.createPowerUp(15 * ScreenController.SIZE_HD_W / 30,
                1 * ScreenController.SIZE_HD_H / 10));
        powerUps.add(
                PowerUpFactory.createPowerUp(10 * ScreenController.SIZE_HD_W / 30, 1 * ScreenController.SIZE_HD_H / 10));
        powerUps.add(
                PowerUpFactory.createPowerUp(5 * ScreenController.SIZE_HD_W / 30, 1 * ScreenController.SIZE_HD_H / 10));
        powerUps.add(PowerUpFactory.createPowerUp(1 * ScreenController.SIZE_HD_W / 30,
                1 * ScreenController.SIZE_HD_H / 10));
        powerUps.add(PowerUpFactory.createPowerUp(25 * ScreenController.SIZE_HD_W / 30,
                1 * ScreenController.SIZE_HD_H / 10));
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
            if (powerUp.getBoundsInParent().intersects(player.getHitbox().getHitbox().getBoundsInParent())) { 
                powerUp.setCenterY(10000);
                pow.attackUp();
            }
        }
    }

}
