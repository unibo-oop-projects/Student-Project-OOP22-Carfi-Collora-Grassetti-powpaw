package powpaw.view.api;

import javafx.geometry.Pos;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;

public class GameInterface extends StackPane {
    private double damageP1 = 0.0;
    private double damageP2 = 0.0;
    private Text damP1;
    private Text damP2;

    public GameInterface() {
        damP1 = new Text(0, 0, "P1: " + String.valueOf(damageP1));
        damP2 = new Text(0, 0, "P2: " + String.valueOf(damageP2));
        damP1.setStyle("-fx-font: 50 arial;");
        damP2.setStyle("-fx-font: 50 arial;");
        damP1.setFill(Color.RED);
        setPrefSize(400, 400);
        getChildren().addAll(damP1, damP2);
        setAlignment(damP1, Pos.TOP_LEFT);
        setAlignment(damP2, Pos.TOP_RIGHT);
    }
}
