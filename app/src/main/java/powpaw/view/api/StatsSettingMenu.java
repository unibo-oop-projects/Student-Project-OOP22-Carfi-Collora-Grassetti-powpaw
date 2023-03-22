package powpaw.view.api;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.util.Pair;
import powpaw.controller.api.StatsController;
import powpaw.controller.impl.StatsControllerImpl;
import powpaw.model.impl.StatsImpl;

public class StatsSettingMenu extends GridPane {

    private static final int numStatistics = 3;
    private static final List<String> statList = new ArrayList<>(Arrays.asList(new String[] { "ATTACK", "DEFENCE", "SPEED" }));
    private Button finish;
    private Button exit;
    private final List<Pair<Button, String>> plusButtonsP1;
    private final List<Pair<Button, String>> minusButtonsP1;
    private static final Text att = new Text(0, 0, "Attack:");
    private static final Text def = new Text(0, 0, "Defence:");
    private static final Text spe = new Text(0, 0, "Speed:");
    private Text myAttackTextP1;
    private Text myDefenceTextP1;
    private Text mySpeedTextP1;

    private StatsImpl statsP1 = new StatsImpl();
    private StatsImpl statsP2 = new StatsImpl();
    private StatsController control = new StatsControllerImpl();

    public StatsSettingMenu() {
        plusButtonsP1 = new ArrayList<>();
        minusButtonsP1 = new ArrayList<>();
        initButton();
        setButtonDimension();
        myAttackTextP1 = new Text(0, 0, "" + statsP1.getAttack());
        myDefenceTextP1 = new Text(0, 0, "" + statsP1.getDefence());
        mySpeedTextP1 = new Text(0, 0, "" + statsP1.getSpeed());
        setAlignment(Pos.CENTER);
        setVgap(15);
        setHgap(15);
        addButtonPosition();
        exit.setOnAction(e -> {
            exit.getScene().setRoot(new StartMenu());
        });
        for (int i = 0; i < statList.size(); i++) {
            switch (statList.get(i)) {
                case "ATTACK":
                    plusButtonsP1.get(i).getKey().setOnAction(e -> {
                        statsP1 = new StatsImpl.StatsBuilder().attack(control.increaseAtt(statsP1.getAttack()))
                                .defence(statsP1.getDefence()).speed(statsP1.getSpeed())
                                .build();
                        getChildren().remove(myAttackTextP1);
                        myAttackTextP1 = new Text("" + statsP1.getAttack());
                        add(myAttackTextP1, 3, 0);
                        System.out.println(statsP1.getAttack());
                    });
                    minusButtonsP1.get(i).getKey().setOnAction(e -> {
                        statsP1 = new StatsImpl.StatsBuilder().attack(control.decreaseAtt(statsP1.getAttack()))
                                .defence(statsP1.getDefence()).speed(statsP1.getSpeed())
                                .build();
                        getChildren().remove(myAttackTextP1);
                        myAttackTextP1 = new Text("" + statsP1.getAttack());
                        add(myAttackTextP1, 3, 0);
                        System.out.println(statsP1.getAttack());
                    });
                    break;
                case "DEFENCE":
                    plusButtonsP1.get(i).getKey().setOnAction(e -> {
                        statsP1 = new StatsImpl.StatsBuilder().attack(statsP1.getAttack())
                                .defence(control.increaseDef(statsP1.getDefence())).speed(statsP1.getSpeed())
                                .build();
                        getChildren().remove(myDefenceTextP1);
                        myDefenceTextP1 = new Text("" + statsP1.getDefence());
                        add(myDefenceTextP1, 3, 1);
                        System.out.println(statsP1.getDefence());

                    });
                    minusButtonsP1.get(i).getKey().setOnAction(e -> {
                        statsP1 = new StatsImpl.StatsBuilder().attack(statsP1.getAttack())
                                .defence(control.decreaseDef(statsP1.getDefence())).speed(statsP1.getSpeed())
                                .build();
                        getChildren().remove(myDefenceTextP1);
                        myDefenceTextP1 = new Text("" + statsP1.getDefence());
                        add(myDefenceTextP1, 3, 1);
                        System.out.println(statsP1.getDefence());

                    });
                    break;
                case "SPEED":
                    plusButtonsP1.get(i).getKey().setOnAction(e -> {
                        statsP1 = new StatsImpl.StatsBuilder().attack(statsP1.getAttack())
                                .defence(statsP1.getDefence()).speed(control.increaseSpe(statsP1.getSpeed()))
                                .build();
                        getChildren().remove(mySpeedTextP1);
                        mySpeedTextP1 = new Text("" + statsP1.getSpeed());
                        add(mySpeedTextP1, 3, 2);
                        System.out.println(statsP1.getSpeed());
                    });
                    minusButtonsP1.get(i).getKey().setOnAction(e -> {
                        statsP1 = new StatsImpl.StatsBuilder().attack(statsP1.getAttack())
                                .defence(statsP1.getDefence()).speed(control.decreaseSpe(statsP1.getSpeed()))
                                .build();
                        getChildren().remove(mySpeedTextP1);
                        mySpeedTextP1 = new Text("" + statsP1.getSpeed());
                        add(mySpeedTextP1, 3, 2);
                        System.out.println(statsP1.getSpeed());
                    });
                    break;
            }
        }
        finish.setOnAction(e -> {
            System.out.println("A: " + statsP1.getAttack() + " D:" + statsP1.getDefence() + " S:" + statsP1.getSpeed());
            finish.getScene().setRoot(new GameInterface());
        });
    }

    private void initButton() {
        for (int i = 0; i < numStatistics; i++) {
            plusButtonsP1.add(new Pair<Button, String>(new Button("+"), statList.get(i)));
            minusButtonsP1.add(new Pair<Button, String>(new Button("-"), statList.get(i)));
        }
        exit = new Button("MENU");
        finish = new Button("Finish");
    }

    private void setButtonDimension() {
        for (int i = 0; i < numStatistics; i++) {
            plusButtonsP1.get(i).getKey().prefWidthProperty().bind(widthProperty().divide(5));
            plusButtonsP1.get(i).getKey().prefHeightProperty().bind(heightProperty().divide(5));
            plusButtonsP1.get(i).getKey().setMaxSize(50, 50);
            minusButtonsP1.get(i).getKey().prefWidthProperty().bind(widthProperty().divide(5));
            minusButtonsP1.get(i).getKey().prefHeightProperty().bind(heightProperty().divide(5));
            minusButtonsP1.get(i).getKey().setMaxSize(50, 50);
        }
        exit.prefWidthProperty().bind(widthProperty().divide(5));
        exit.prefHeightProperty().bind(heightProperty().divide(5));
        exit.setMaxSize(50, 50);
    }

    private void addButtonPosition() {
        add(att, 0, 0);
        add(def, 0, 1);
        add(spe, 0, 2);
        for (int i = 0; i < numStatistics; i++) {
            add(minusButtonsP1.get(i).getKey(), 1, i);
            add(plusButtonsP1.get(i).getKey(), 2, i);
        }
        add(myAttackTextP1, 3, 0);
        add(myDefenceTextP1, 3, 1);
        add(mySpeedTextP1, 3, 2);
        add(exit, 10, 10);
        add(finish, 0, 10);
    }

}
