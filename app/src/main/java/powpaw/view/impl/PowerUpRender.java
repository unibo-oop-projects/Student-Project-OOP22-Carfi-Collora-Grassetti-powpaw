package powpaw.view.impl;

import java.util.ArrayList;


import javafx.scene.shape.Circle;
import powpaw.controller.impl.PowerUpController;

public class PowerUpRender {
    private ArrayList<Circle> powerUps;
    PowerUpController contr = new PowerUpController();

    public PowerUpRender(ArrayList<Circle> powerUps) {
        this.powerUps = powerUps;
    }

    public ArrayList<Circle> getPowerUp() {
        return this.powerUps;
    }
}
