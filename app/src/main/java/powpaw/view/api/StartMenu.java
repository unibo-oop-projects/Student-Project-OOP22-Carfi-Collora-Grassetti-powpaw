package powpaw.view.api;

import javafx.application.Platform;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;

public class StartMenu extends GridPane{
    private Button start;
    private Button exit;

    public StartMenu(GridPane root){
        root.setAlignment(Pos.CENTER);
        start = new Button("START");
        exit = new Button("EXIT");
        setVgap(15);
        setHgap(15);
        start.prefWidthProperty().bind(root.widthProperty().divide(4));
        start.prefHeightProperty().bind(root.heightProperty().divide(4));
        exit.prefWidthProperty().bind(root.widthProperty().divide(4));
        exit.prefHeightProperty().bind(root.heightProperty().divide(4));
        start.setMaxSize(300, 70);
        exit.setMaxSize(300, 70);
        add(start,0,0);
        add(exit,0,1);
        start.setOnAction(e->{
           /* App app = new App();
            start.getScene().setRoot(app.getGridPane());*/
        });
        exit.setOnAction(e->{
            Platform.exit();
        });
    }
}
