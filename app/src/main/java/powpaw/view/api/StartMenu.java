package powpaw.view.api;



import javafx.application.Platform;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import powpaw.controller.impl.GameStateHandler;

/**
 * Start menu view
 * 
 * @author Simone Collorà
 */
public class StartMenu extends GridPane {
    private final Button start;
    private final Button exit;

    public StartMenu() {
        setAlignment(Pos.CENTER);
        start = new Button("START");
        exit = new Button("EXIT");
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
        start.setOnAction(e -> {
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
