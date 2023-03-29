package powpaw.view.impl;

import java.util.ArrayList;

import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;
import powpaw.controller.impl.PowerUpController;

public class PowerUpRender {
    private ArrayList<Circle> powerUps;

    public PowerUpRender(ArrayList<Circle> powerUps) {
        this.powerUps = powerUps;
    }

    public void update(Pane pane,PowerUpController contr) {
        pane.getChildren().remove(contr.getPowerUps());
        pane.getChildren().addAll(contr.getPowerUps());
    }

    public ArrayList<Circle> getPowerUp() {
        return this.powerUps;
    }
}
