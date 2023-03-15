package powpaw.view.api;

import javafx.application.Platform;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;

public class StatsSettingMenu extends GridPane {
    private final Button plusAtt;
    private final Button plusDef;
    private final Button plusSpe;
    private final Button plusDex;
    private final Button minAtt;
    private final Button minDef;
    private final Button minSpe;
    private final Button minDex;
    
    private final Button exit;

    public StatsSettingMenu() {
        plusAtt = new Button("+");
        plusDef = new Button("+");
        plusSpe = new Button("+");
        plusDex = new Button("+");
        minAtt = new Button("-");
        minDef = new Button("-");
        minSpe = new Button("-");
        minDex = new Button("-");
        exit = new Button("MENU");
        setVgap(15);
        setHgap(15);
        plusAtt.prefWidthProperty().bind(widthProperty().divide(5));
        plusAtt.prefHeightProperty().bind(heightProperty().divide(5));
        exit.prefWidthProperty().bind(widthProperty().divide(5));
        exit.prefHeightProperty().bind(heightProperty().divide(5));
        plusAtt.setMaxSize(50, 50);
        exit.setMaxSize(50, 50);
        add(plusAtt, 0, 0);
        plusAtt.setScaleX(BASELINE_OFFSET_SAME_AS_HEIGHT);
        add(minAtt, 0, 1);
        add(exit, 10, 10);
        exit.setOnAction(e -> {
            exit.getScene().setRoot(new StartMenu());
        });
    }
}
