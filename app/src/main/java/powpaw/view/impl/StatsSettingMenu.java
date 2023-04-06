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
    private int attackPointP1;
    private int defencePointP1;
    private int speedPointP1;
    private int attackPointP2;
    private int defencePointP2;
    private int speedPointP2;
    // private Map<Integer, Map<String, Integer>> statsMapG = new HashMap<>();
    // private Map<String, Integer> statsMap = new HashMap<>();
    private Label att;
    private Label def;
    private Label spe;
    private Text attackTextP1;
    private Text defenceTextP1;
    private Text speedTextP1;
    private Text attackTextP2;
    private Text defenceTextP2;
    private Text speedTextP2;
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
        attackPointP1 = 5;
        defencePointP1 = 5;
        speedPointP1 = 5;
        attackPointP2 = 5;
        defencePointP2 = 5;
        speedPointP2 = 5;
        initButton();
        // initMap();
        setButtonDimension();
        attackTextP1 = new Text("" + attackPointP1);
        defenceTextP1 = new Text("" + defencePointP1);
        speedTextP1 = new Text("" + speedPointP1);
        attackTextP2 = new Text("" + attackPointP2);
        defenceTextP2 = new Text("" + defencePointP2);
        speedTextP2 = new Text("" + speedPointP2);
        new Text();
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
                        getChildren().remove(attackTextP1);
                        attackPointP1 = control.decreaseAtt(attackPointP1);
                        attackTextP1 = new Text("" + attackPointP1);
                        add(attackTextP1, 3, 0);
                    });
                    plusButtonsP2.get(i).getKey().setOnAction(e -> {
                        getChildren().remove(attackTextP2);
                        attackPointP2 = control.increaseAtt(attackPointP2);
                        attackTextP2 = new Text("" + attackPointP2);
                        add(attackTextP2, 7, 0);
                    });
                    minusButtonsP2.get(i).getKey().setOnAction(e -> {
                        getChildren().remove(attackTextP2);
                        attackPointP2 = control.decreaseAtt(attackPointP2);
                        attackTextP2 = new Text("" + attackPointP2);
                        add(attackTextP2, 7, 0);
                    });
                    break;
                case "DEFENCE":
                    plusButtonsP1.get(i).getKey().setOnAction(e -> {
                        getChildren().remove(defenceTextP1);
                        defencePointP1 = control.increaseDef(defencePointP1);
                        defenceTextP1 = new Text("" + defencePointP1);
                        add(defenceTextP1, 3, 1);
                    });
                    minusButtonsP1.get(i).getKey().setOnAction(e -> {
                        getChildren().remove(defenceTextP1);
                        defencePointP1 = control.decreaseDef(defencePointP1);
                        defenceTextP1 = new Text("" + defencePointP1);
                        add(defenceTextP1, 3, 1);
                    });
                    plusButtonsP2.get(i).getKey().setOnAction(e -> {
                        getChildren().remove(defenceTextP2);
                        defencePointP2 = control.increaseDef(defencePointP2);
                        defenceTextP2 = new Text("" + defencePointP2);
                        add(defenceTextP2, 7, 1);
                    });
                    minusButtonsP2.get(i).getKey().setOnAction(e -> {
                        getChildren().remove(defenceTextP2);
                        defencePointP2 = control.decreaseDef(defencePointP2);
                        defenceTextP2 = new Text("" + defencePointP2);
                        add(defenceTextP2, 7, 1);
                    });
                    break;
                case "SPEED":
                    plusButtonsP1.get(i).getKey().setOnAction(e -> {
                        getChildren().remove(speedTextP1);
                        speedPointP1 = control.increaseSpe(speedPointP1);
                        speedTextP1 = new Text("" + speedPointP1);
                        add(speedTextP1, 3, 2);
                    });
                    minusButtonsP1.get(i).getKey().setOnAction(e -> {
                        getChildren().remove(speedTextP1);
                        speedPointP1 = control.decreaseSpe(speedPointP1);
                        speedTextP1 = new Text("" + speedPointP1);
                        add(speedTextP1, 3, 2);
                    });
                    plusButtonsP2.get(i).getKey().setOnAction(e -> {
                        getChildren().remove(speedTextP2);
                        speedPointP2 = control.increaseSpe(speedPointP2);
                        speedTextP2 = new Text("" + speedPointP2);
                        add(speedTextP2, 7, 2);
                    });
                    minusButtonsP2.get(i).getKey().setOnAction(e -> {
                        getChildren().remove(speedTextP2);
                        speedPointP2 = control.decreaseAtt(speedPointP2);
                        speedTextP2 = new Text("" + speedPointP2);
                        add(speedTextP2, 7, 2);
                    });
                    break;
            }
        }
        finish.setOnAction(e -> {
            setAllStats();
            StatsHandler.buildStatsP1(statsP1);
            StatsHandler.buildStatsP2(statsP2);
            System.out.println("A " + StatsHandler.getStatsP1().getAttack() + " D "
                    + StatsHandler.getStatsP1().getDefence() + " S " + StatsHandler.getStatsP1().getSpeed());
            System.out.println("A " + StatsHandler.getStatsP2().getAttack() + " D "
                    + StatsHandler.getStatsP2().getDefence() + " S " + StatsHandler.getStatsP2().getSpeed());
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
        add(defenceTextP1, 3, 1);
        add(speedTextP1, 3, 2);
        add(attackTextP2, 7, 0);
        add(defenceTextP2, 7, 1);
        add(speedTextP2, 7, 2);
        add(exit, 0, 10);
        add(finish, 10, 10);
    }

    private void setAllStats() {
        statsP1.setAttack(attackPointP1);
        statsP1.setDefence(defencePointP1);
        statsP1.setSpeed(speedPointP1);
        statsP2.setAttack(attackPointP2);
        statsP2.setDefence(defencePointP2);
        statsP2.setSpeed(speedPointP2);
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