package powpaw.view.api;

import javafx.application.Platform;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import powpaw.controller.api.StatsController;
import powpaw.controller.impl.StatsControllerImpl;
import powpaw.model.impl.StatsImpl;

public class StatsSettingMenu extends GridPane {
    private final Button plusAtt;
    private final Button plusDef;
    private final Button plusSpe;
    private final Button plusDex;
    private final Button minAtt;
    private final Button minDef;
    private final Button minSpe;
    private final Button minDex;
    private final Button finish;

    private StatsImpl stats = new StatsImpl();
    private StatsController control = new StatsControllerImpl();

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
        finish = new Button("Finish");
        setAlignment(Pos.CENTER);
        setVgap(15);
        setHgap(15);
        plusAtt.prefWidthProperty().bind(widthProperty().divide(5));
        plusAtt.prefHeightProperty().bind(heightProperty().divide(5));
        exit.prefWidthProperty().bind(widthProperty().divide(5));
        exit.prefHeightProperty().bind(heightProperty().divide(5));
        plusAtt.setMaxSize(50, 50);
        exit.setMaxSize(50, 50);
        add(plusAtt, 0, 0);
        add(minAtt, 0, 1);
        add(exit, 10, 10);
        add(finish,0,10);
        add(plusDef,5,5);
        exit.setOnAction(e -> {
            exit.getScene().setRoot(new StartMenu());
        });
        plusAtt.setOnAction(e -> {
            System.out.println(stats.getAttack());
            stats = new StatsImpl.StatsBuilder().attack(control.increaseAtt(stats.getAttack()))
            .defence(stats.getDefence()).speed(stats.getSpeed())
            .build();
            System.out.println(stats.getAttack());
        });
        minAtt.setOnAction(e -> {
            System.out.println(stats.getAttack());
            stats = new StatsImpl.StatsBuilder().attack(control.decreaseAtt(stats.getAttack()))
                    .defence(stats.getDefence()).speed(stats.getSpeed())
                    .build();
            System.out.println(stats.getAttack());
        });
        plusDef.setOnAction(e -> {
            System.out.println(stats.getDefence());
            stats = new StatsImpl.StatsBuilder().attack(stats.getAttack())
            .defence(control.increaseDef(stats.getDefence())).speed(stats.getSpeed())
            .build();
            System.out.println(stats.getDefence());
        });
        finish.setOnAction(e ->{
            System.out.println("A: "+ stats.getAttack() +" D:"+ stats.getDefence() + " S:"+ stats.getSpeed());
        });
    }
}
