package powpaw.view.api;

import javafx.application.Platform;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import powpaw.controller.impl.GameStateHandler;
import powpaw.controller.api.PlayerController;
/**
 * GameOver view
 * 
 * @author Simone Collorà
 */
public class GameOver extends VBox {
    private final Button newGame;
    private final Button exit;
    private final Text gameOver;

    /**
     * GameOver create a VBox as with gridPane Text appeared a little decentralized
     * 
     * @param controller in order to get the player who won and set his color on the win text
     */
    public GameOver(PlayerController controller) {
        setAlignment(Pos.CENTER);
        int winnerNumber = controller.getPlayerObservable().getAttackController().checkDeath().get().getNumber();
        gameOver = new Text("P" + winnerNumber +" WIN");
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
        gameOver.setFill(winnerNumber == 1 ? Color.RED : Color.BLUE);
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
