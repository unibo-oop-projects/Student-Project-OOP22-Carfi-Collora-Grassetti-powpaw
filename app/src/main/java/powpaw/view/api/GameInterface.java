package powpaw.view.api;

import javafx.geometry.Pos;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import powpaw.model.impl.DamageMeterImpl;

public class GameInterface extends StackPane {
    DamageMeterImpl damage = new DamageMeterImpl();
    private String p1 = damage.toString();
    private String p2 = damage.toString();
    private Text damP1;
    private Text damP2;

    public GameInterface() {
        damP1 = new Text(0, 0, "P1: " + p1);
        damP2 = new Text(0, 0, "P2: " + p2);
        damP1.setStyle("-fx-font: 50 arial;");
        damP2.setStyle("-fx-font: 50 arial;");
        damP1.setFill(Color.RED);
        setPrefSize(400, 400);
        getChildren().addAll(damP1, damP2);
        setAlignment(damP1, Pos.TOP_LEFT);
        setAlignment(damP2, Pos.TOP_RIGHT);
    }
}
