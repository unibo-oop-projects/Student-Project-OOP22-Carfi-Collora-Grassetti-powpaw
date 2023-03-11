package powpaw.view.api;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;

public class PauseMenu extends GridPane {
    private Button resume;
    private Button exitMenu;

    public PauseMenu() {
        setAlignment(Pos.CENTER);
        resume = new Button("RESUME");
        exitMenu = new Button("MENU");
        setVgap(15);
        setHgap(15);
        resume.prefWidthProperty().bind(widthProperty().divide(4));
        resume.prefHeightProperty().bind(heightProperty().divide(4));
        exitMenu.prefWidthProperty().bind(widthProperty().divide(4));
        exitMenu.prefHeightProperty().bind(heightProperty().divide(4));
        resume.setMaxSize(300, 70);
        exitMenu.setMaxSize(300, 70);
        add(resume, 0, 0);
        add(exitMenu, 0, 1);
        resume.setOnAction(e -> {
            try {
                resume.getScene().setRoot(new GameInterface());
            } catch (Exception e1) {
                e1.printStackTrace();
            }
        });
        exitMenu.setOnAction(e -> {
            try {
                exitMenu.getScene().setRoot(new StartMenu());
            } catch (Exception e1) {
                e1.printStackTrace();
            }
        });
    }
}
