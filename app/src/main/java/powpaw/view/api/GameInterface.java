package powpaw.view.api;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;

public class GameInterface extends StackPane {
    private int damageP1 = 0;
    private int damageP2 = 0;
    private Text damP1;
    private Text damP2;
    private Button pause;

    public GameInterface() {
        damP1 = new Text(0, 0, "P1: " + String.valueOf(damageP1));
        damP2 = new Text(0, 0, "P2: " + String.valueOf(damageP2));
        pause = new Button("X");
        pause.prefWidthProperty().bind(widthProperty().divide(4));
        pause.prefHeightProperty().bind(heightProperty().divide(4));
        pause.setMaxSize(100, 70);
        damP1.setStyle("-fx-font: 50 arial;");
        damP2.setStyle("-fx-font: 50 arial;");
        damP1.setFill(Color.RED);
        setPrefSize(400, 400);
        getChildren().add(damP1);
        getChildren().add(damP2);
        getChildren().add(pause);
        setAlignment(damP1, Pos.TOP_LEFT);
        setAlignment(damP2, Pos.TOP_RIGHT);
        setAlignment(pause, Pos.TOP_CENTER);
        pause.setOnAction(e ->{
            pause.getScene().setRoot(new PauseMenu());
        });
    }
}
