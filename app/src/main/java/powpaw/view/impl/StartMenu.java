package powpaw.view.impl;

import javafx.application.Platform;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.ImagePattern;
import powpaw.controller.impl.StaticGameState;

/**
 * Start menu view.
 * 
 * @author Simone Collorà
 */
public class StartMenu extends GridPane {

    /**
     * Start menu costructor.
     */
    public StartMenu() {
        setAlignment(Pos.CENTER);
        setBackground(Background.fill(new ImagePattern(new Image("/background_menu.png"))));
        final Button start = new Button("START");
        final Button exit = new Button("EXIT");
        setVgap(15);
        setHgap(15);
        start.prefWidthProperty().bind(widthProperty().divide(4));
        start.prefHeightProperty().bind(heightProperty().divide(4));
        exit.prefWidthProperty().bind(widthProperty().divide(4));
        exit.prefHeightProperty().bind(heightProperty().divide(4));
        start.setMaxSize(300, 70);
        exit.setMaxSize(300, 70);
        add(start, 0, 0);
        add(exit, 0, 1);
        start.setOnAction(e -> StaticGameState.getGameStateView().showCharacterCreation());
        exit.setOnAction(e -> {
            Platform.exit();
        });
    }
}
