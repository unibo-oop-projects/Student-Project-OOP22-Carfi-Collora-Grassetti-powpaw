package powpaw.view.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.util.Pair;
import powpaw.controller.impl.GameStateHandler;
import powpaw.controller.impl.StatsControllerImpl;
import powpaw.controller.impl.StatsHandler;
import powpaw.model.api.StatsBuilder;
import powpaw.model.impl.StatsBuilderImpl;
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
    private int attackPointsP1;
    private int defencePointsP1;
    private int speedPointsP1;
    private int attackPointsP2;
    private int defencePointsP2;
    private int speedPointsP2;
    // private Map<Integer, Map<String, Integer>> statsMapG = new HashMap<>();
    // private Map<String, Integer> statsMap = new HashMap<>();
    private Label att;
    private Label def;
    private Label spe;
    private Label p1 = new Label("Player 1: ");
    private Label p2 = new Label("Player 2: ");
    private Text attackTextP1;
    private Text defenceTextP1;
    private Text speedTextP1;
    private Text attackTextP2;
    private Text defenceTextP2;
    private Text speedTextP2;
    private int totalP1 = 15;
    private int totalP2 = 15;
    private Text pointLeftP1 = new Text("Pont left:" + totalP1);
    private Text pointLeftP2 = new Text("Pont left:" + totalP2);
    private StatsBuilder statsP1 = new StatsBuilderImpl();
    private StatsBuilder statsP2 = new StatsBuilderImpl();
    private StatsControllerImpl control = new StatsControllerImpl();

    public StatsSettingMenu() {
        att = new Label("Attack: ");
        def = new Label("Defence: ");
        spe = new Label("Speed: ");
        plusButtonsP1 = new ArrayList<>();
        minusButtonsP1 = new ArrayList<>();
        plusButtonsP2 = new ArrayList<>();
        minusButtonsP2 = new ArrayList<>();
        attackPointsP1 = 5;
        defencePointsP1 = 5;
        speedPointsP1 = 5;
        attackPointsP2 = 5;
        defencePointsP2 = 5;
        speedPointsP2 = 5;
        initButton();
        // initMap();
        setButtonDimension();
        attackTextP1 = new Text("" + attackPointsP1);
        defenceTextP1 = new Text("" + defencePointsP1);
        speedTextP1 = new Text("" + speedPointsP1);
        attackTextP2 = new Text("" + attackPointsP2);
        defenceTextP2 = new Text("" + defencePointsP2);
        speedTextP2 = new Text("" + speedPointsP2);
        setAlignment(Pos.CENTER);
        setVgap(15);
        setHgap(15);
        addPosition();
        exit.setOnAction(e -> {
            exit.getScene().setRoot(new StartMenu());
        });
        add(p1, 1, 0);
        add(p2, 5, 0);
        for (int i = 0; i < statList.size(); i++) {
            totalP1 = (attackPointsP1 + defencePointsP1 + speedPointsP1) - StatsHandler.getLimit();
            totalP2 = (attackPointsP2 + defencePointsP2 + speedPointsP2) - StatsHandler.getLimit();
            pointLeftP1 = new Text("Pont left:" + totalP1);
            pointLeftP2 = new Text("Pont left:" + totalP2);

            switch (statList.get(i)) {
                case "ATTACK":
                    plusButtonsP1.get(i).getKey().setOnAction(e -> {
                        attackPointsP1 = updateStatPlus(attackPointsP1, attackTextP1);
                    });
                    minusButtonsP1.get(i).getKey().setOnAction(e -> {
                        attackPointsP1 = updateStatMinus(attackPointsP1, attackTextP1);
                    });
                    plusButtonsP2.get(i).getKey().setOnAction(e -> {
                        attackPointsP2 = updateStatPlus(attackPointsP2, attackTextP2);
                    });
                    minusButtonsP2.get(i).getKey().setOnAction(e -> {
                        attackPointsP2 = updateStatPlus(attackPointsP2, attackTextP2);
                    });
                    break;
                case "DEFENCE":
                    plusButtonsP1.get(i).getKey().setOnAction(e -> {
                        defencePointsP1 = updateStatPlus(defencePointsP1, defenceTextP1);
                    });
                    minusButtonsP1.get(i).getKey().setOnAction(e -> {
                        defencePointsP1 = updateStatMinus(defencePointsP1, defenceTextP1);
                    });
                    plusButtonsP2.get(i).getKey().setOnAction(e -> {
                        defencePointsP2 = updateStatPlus(defencePointsP2, defenceTextP2);
                    });
                    minusButtonsP2.get(i).getKey().setOnAction(e -> {
                        defencePointsP2 = updateStatMinus(defencePointsP2, defenceTextP2);
                    });
                    break;
                case "SPEED":
                    plusButtonsP1.get(i).getKey().setOnAction(e -> {
                        speedPointsP1 = updateStatPlus(speedPointsP1, speedTextP1);
                    });
                    minusButtonsP1.get(i).getKey().setOnAction(e -> {
                        speedPointsP1 = updateStatMinus(speedPointsP1, speedTextP1);
                    });
                    plusButtonsP2.get(i).getKey().setOnAction(e -> {
                        speedPointsP2 = updateStatPlus(speedPointsP2, speedTextP2);
                    });
                    minusButtonsP2.get(i).getKey().setOnAction(e -> {
                        speedPointsP2 = updateStatMinus(speedPointsP2, speedTextP2);
                    });
                    break;
            }
        }
        finish.setOnAction(e -> {
            setAllStats();
            StatsHandler.buildStatsP1(statsP1);
            StatsHandler.buildStatsP2(statsP2);
            GameStateHandler.getGameStateView().showGame();
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
        finish.prefWidthProperty().bind(widthProperty().divide(5));
        finish.prefHeightProperty().bind(heightProperty().divide(5));
        finish.setMaxSize(50, 50);
    }

    private void addPosition() {
        add(att, 0, 1);
        add(def, 0, 2);
        add(spe, 0, 3);
        for (int i = 0; i < numStatistics; i++) {
            add(minusButtonsP1.get(i).getKey(), 1, i + 1);
            add(plusButtonsP1.get(i).getKey(), 2, i + 1);
            add(minusButtonsP2.get(i).getKey(), 5, i + 1);
            add(plusButtonsP2.get(i).getKey(), 6, i + 1);
        }
        add(attackTextP1, 3, 1);
        add(defenceTextP1, 3, 2);
        add(speedTextP1, 3, 3);
        add(attackTextP2, 7, 1);
        add(defenceTextP2, 7, 2);
        add(speedTextP2, 7, 3);
        // add(totP1,4,9);
        add(exit, 0, 10);
        add(finish, 10, 10);
    }

    private void setAllStats() {
        statsP1.setAttack(attackPointsP1);
        statsP1.setDefence(defencePointsP1);
        statsP1.setSpeed(speedPointsP1);
        statsP2.setAttack(attackPointsP2);
        statsP2.setDefence(defencePointsP2);
        statsP2.setSpeed(speedPointsP2);
    }

    private int updateStatPlus(int points, Text text) {
        points = control.increase(points);
        text.setText("" + points);
        return points;
    }

    private int updateStatMinus(int points, Text text) {
        points = control.decrease(points);
        text.setText("" + points);
        return points;
    }

    // private void initMap() {
    // for (int i = 0; i < 2; i++) {
    // for (var v : statList) {
    // statsMap.put(v, 0);
    // }
    // statsMapG.put(i, statsMap);
    // }
    // }

    // private void buttonIncr(Text t, int val, Pair<String, Button> p) {
    // getChildren().remove(t);
    // if (p.getKey() == "ATTACK") {
    // attackPointP1 = control.increaseAtt(attackPointP1);
    // attackTextP1 = new Text("" + attackPointP1);
    // add(attackTextP1, 3, 0);
    // }
    // }
    /*
     * private void updateText(Text text) {
     * for (var v : statsMapG.entrySet()) {
     * for (var d: v.getValue().entrySet()) {
     * switch (d.getKey()) {
     * case "ATTACK":
     * if(v.getKey()==0){
     * getChildren().remove(text);
     * text= new Text(""+d.getValue());
     * add(text, 3, 0);
     * }else{
     * getChildren().remove(text);
     * text= new Text(""+d.getValue());
     * add(text, 7, 0);
     * }
     * case "DEFENCE":
     * if(v.getKey()==0){
     * getChildren().remove(text);
     * text= new Text(""+d.getValue());
     * add(text, 3, 1);
     * }else{
     * getChildren().remove(text);
     * text= new Text(""+d.getValue());
     * add(text, 7, 1);
     * }
     * case "SPEED":
     * if(v.getKey()==0){
     * text= new Text(""+d.getValue());
     * add(text, 3, 2);
     * }else{
     * text= new Text(""+d.getValue());
     * add(text, 7, 2);
     * }
     * }
     * }
     * }
     * }
     */
}