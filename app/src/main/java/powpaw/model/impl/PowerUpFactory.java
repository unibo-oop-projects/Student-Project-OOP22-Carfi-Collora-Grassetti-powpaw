package powpaw.model.impl;

import java.util.Random;

import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class PowerUpFactory {
    public static Circle createPowerUp(int x, int y){
        Circle powerUp = new Circle();
        powerUp.setCenterX(40);
        powerUp.setCenterY(40);
        powerUp.setLayoutX(x);
        powerUp.setLayoutY(y);
        powerUp.setRadius(20);
        setPowerUp(powerUp);
        return powerUp; 
    }
    public static void setPowerUp(Circle powerUp){
        Random rand = new Random();
        switch(rand.nextInt(2)){
            case 0:
                powerUp.setFill(Color.LIGHTPINK);
                break;
            case 1:
                powerUp.setFill(Color.BLUE);
                break;
        }
    }
}
