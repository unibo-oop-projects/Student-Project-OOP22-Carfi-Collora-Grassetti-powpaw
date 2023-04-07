package powpaw.view.api;

import javafx.application.Platform;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import powpaw.controller.impl.GameStateHandler;
import powpaw.controller.impl.PlayerController;

public class GameOver extends VBox {
    private final Button newGame;
    private final Button exit;
    private final Text gameOver;

    public GameOver(PlayerController controller) {
        setAlignment(Pos.CENTER);
        gameOver = new Text("P" + controller.getPlayerObservable().getAttackController().checkDeath().get().getNumber() +" WIN");
        newGame = new Button("NEW GAME");
        exit = new Button("EXIT");
        setSpacing(15);
        newGame.prefWidthProperty().bind(widthProperty().divide(4));
        newGame.prefHeightProperty().bind(heightProperty().divide(4));
        exit.prefWidthProperty().bind(widthProperty().divide(4));
        exit.prefHeightProperty().bind(heightProperty().divide(4));
        newGame.setMaxSize(300, 70);
        exit.setMaxSize(300, 70);
        gameOver.setStyle("-fx-font: 70 arial;");
        gameOver.setFill(Color.RED);
        gameOver.setTextAlignment(TextAlignment.CENTER);
        getChildren().addAll(gameOver,newGame,exit);
        newGame.setOnAction(e -> {
            try {
                GameStateHandler.getGameStateView().showCharacterCreation();
            } catch (Exception e1) {
                e1.printStackTrace();
            }
        });
        exit.setOnAction(e -> {
            Platform.exit();
        });
    }
}
