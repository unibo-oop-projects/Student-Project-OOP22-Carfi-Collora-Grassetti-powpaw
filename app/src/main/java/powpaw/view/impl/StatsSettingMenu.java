package powpaw.view.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.util.Pair;
import powpaw.controller.impl.StatsControllerImpl;
import powpaw.model.api.StatsBuilder;
import powpaw.model.impl.PlayerStats;
import powpaw.model.impl.StatsBuilderImpl;
import powpaw.view.api.ButtonAction;
import powpaw.view.api.GameInterface;
import powpaw.view.api.StartMenu;

public class StatsSettingMenu extends GridPane {

    private static final int numStatistics = 3;
    private static final List<String> statList = new ArrayList<>(
            Arrays.asList(new String[] { "ATTACK", "DEFENCE", "SPEED" }));
    private Button finish;
    private Button exit;
    private final List<Pair<Button, String>> plusButtonsP1;
    private final List<Pair<Button, String>> minusButtonsP1;
    private final List<Pair<Button, String>> plusButtonsP2;
    private final List<Pair<Button, String>> minusButtonsP2;
    private int attackPointP1;
    private int defencePointP1;
    private int speedPointP1;
    private int attackPointP2;
    private int defencePointP2;
    private int speedPointP2;
    private Map<Integer, Map<String, Integer>> statsMapG = new HashMap<>();
    private Map<String, Integer> statsMap = new HashMap<>();
    private Label att;
    private Label def;
    private Label spe;
    private Text attackTextP1;
    private StatsBuilder statsP1 = new StatsBuilderImpl();

    private StatsControllerImpl control = new StatsControllerImpl();

    public StatsSettingMenu() {
        plusButtonsP1 = new ArrayList<>();
        minusButtonsP1 = new ArrayList<>();
        plusButtonsP2 = new ArrayList<>();
        minusButtonsP2 = new ArrayList<>();
        initButton();
        initMap();
        setButtonDimension();
        att = new Label("Attack: ");
        def = new Label("Defence: ");
        spe = new Label("Speed: ");
        attackPointP1 = 0;
        defencePointP1 = 0;
        speedPointP1 = 0;
        attackPointP2 = 0;
        defencePointP2 = 0;
        speedPointP2 = 0;
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
                        getChildren().remove(attackTextP1);
                        attackPointP1 = control.increaseAtt(attackPointP1);
                        attackTextP1 = new Text("" + attackPointP1);
                        add(attackTextP1, 3, 0);
                    });
                    minusButtonsP1.get(i).getKey().setOnAction(e -> {
                        attackPointP1 = control.decreaseAtt(attackPointP1);
                        System.out.println(attackPointP1);
                    });
                    plusButtonsP2.get(i).getKey().setOnAction(e -> {
                        attackPointP2 = control.increaseAtt(attackPointP1);
                    });
                    minusButtonsP2.get(i).getKey().setOnAction(e -> {
                        attackPointP1 = control.increaseAtt(attackPointP1);
                    });
                    break;
                case "DEFENCE":

                    plusButtonsP1.get(i).getKey().setOnAction(e -> {
                        defencePointP1 = control.increaseDef(defencePointP1);
                    });
                    minusButtonsP1.get(i).getKey().setOnAction(e -> {
                        defencePointP1 = control.decreaseDef(defencePointP1);
                    });
                    plusButtonsP2.get(i).getKey().setOnAction(e -> {
                        defencePointP2 = control.increaseDef(defencePointP1);
                    });
                    minusButtonsP2.get(i).getKey().setOnAction(e -> {
                        defencePointP1 = control.increaseDef(defencePointP1);
                    });
                    break;
                case "SPEED":
                    plusButtonsP1.get(i).getKey().setOnAction(e -> {

                    });
                    minusButtonsP1.get(i).getKey().setOnAction(e -> {

                    });
                    break;
            }
        }
        finish.setOnAction(e -> {
            statsP1.setAttack(attackPointP1);
            statsP1.setDefence(defencePointP1);
            statsP1.setSpeed(speedPointP1);
            finish.getScene().setRoot(new GameInterface());
        });
    }

    private void initButton() {
        for (int i = 0; i < numStatistics; i++) {
            plusButtonsP1.add(new Pair<Button, String>(new Button("+"), statList.get(i)));
            plusButtonsP2.add(new Pair<Button, String>(new Button("+"), statList.get(i)));
            minusButtonsP1.add(new Pair<Button, String>(new Button("-"), statList.get(i)));
            minusButtonsP2.add(new Pair<Button, String>(new Button("-"), statList.get(i)));
        }
        exit = new Button("MENU");
        finish = new Button("Finish");
    }

    private void setButtonDimension() {
        for (int i = 0; i < numStatistics; i++) {
            plusButtonsP1.get(i).getKey().prefWidthProperty().bind(widthProperty().divide(5));
            plusButtonsP1.get(i).getKey().prefHeightProperty().bind(heightProperty().divide(5));
            plusButtonsP1.get(i).getKey().setMaxSize(50, 50);
            plusButtonsP2.get(i).getKey().prefWidthProperty().bind(widthProperty().divide(5));
            plusButtonsP2.get(i).getKey().prefHeightProperty().bind(heightProperty().divide(5));
            plusButtonsP2.get(i).getKey().setMaxSize(50, 50);
            minusButtonsP1.get(i).getKey().prefWidthProperty().bind(widthProperty().divide(5));
            minusButtonsP1.get(i).getKey().prefHeightProperty().bind(heightProperty().divide(5));
            minusButtonsP1.get(i).getKey().setMaxSize(50, 50);
            minusButtonsP2.get(i).getKey().prefWidthProperty().bind(widthProperty().divide(5));
            minusButtonsP2.get(i).getKey().prefHeightProperty().bind(heightProperty().divide(5));
            minusButtonsP2.get(i).getKey().setMaxSize(50, 50);
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
            add(minusButtonsP2.get(i).getKey(), 5, i);
            add(plusButtonsP2.get(i).getKey(), 6, i);
        }
        add(attackTextP1, 3, 0);
        add(new Text("" + defencePointP1), 3, 1);
        add(new Text("" + speedPointP1), 3, 2);
        add(new Text("" + attackPointP2), 7, 0);
        add(new Text("" + defencePointP2), 7, 1);
        add(new Text("" + speedPointP2), 7, 2);
        add(exit, 10, 10);
        add(finish, 0, 10);
    }

    private void initMap() {
        for (int i = 0; i < 2; i++) {
            for (var v : statList) {
                statsMap.put(v, 0);
            }
            statsMapG.put(i, statsMap);
        }
    }

    private void updateText(Text text) {
        getChildren().remove(text);
        for (var v : statsMapG.entrySet()) {
            for (var d: v.getValue().entrySet()) {
                switch (d.getKey()) {
                    case "ATTACK":
                        if(v.getKey()==0){
                            text= new Text(""+d.getValue());
                            add(text, 3, 0);
                        }else{
                            text= new Text(""+d.getValue());
                            add(text, 7, 0);
                        }
                        case "DEFENCE":
                        if(v.getKey()==0){
                            text= new Text(""+d.getValue());
                            add(text, 3, 1);
                        }else{
                            text= new Text(""+d.getValue());
                            add(text, 7, 1);
                        }
                        case "SPEED":
                        if(v.getKey()==0){
                            text= new Text(""+d.getValue());
                            add(text, 3, 2);
                        }else{
                            text= new Text(""+d.getValue());
                            add(text, 7, 2);
                        }
                }
            }
        }
    }
}