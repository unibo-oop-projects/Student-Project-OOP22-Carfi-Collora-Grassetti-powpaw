package powpaw.model.impl;

import java.time.Duration;
import java.util.List;

import powpaw.config.Parser;
import powpaw.controller.api.AttackController;
import powpaw.controller.impl.AttackControllerImpl;
import powpaw.controller.impl.GameStateHandler;
import powpaw.controller.impl.KeyObserverImpl;
import powpaw.model.api.Player;
import powpaw.model.api.PlayerObservable;
import powpaw.view.api.KeyObservable;
import powpaw.view.impl.KeyObservableImpl;

public class PlayerObservableImpl implements PlayerObservable {
    private boolean gameOver = false;
    private List<Player> playerList;
    private final KeyObservable observable = new KeyObservableImpl();
    private final Parser config;
    private AttackController attackController = new AttackControllerImpl();
    
    public PlayerObservableImpl(List<Player> playerList) {
        this.playerList = playerList;
        this.config = new Parser();
        this.attackController.setPlayers(playerList);
        this.playerList.forEach(player -> observable.addObserver(new KeyObserverImpl(player, this.config, this.attackController)));
    }

    @Override
    public List<Player> getPlayers() {
        return this.playerList;
    }

    @Override
    public KeyObservable getKeyObservable() {
        return this.observable;
    }

    @Override
    public void update(Duration deltaTime) {
        if(!gameOver){
            if (attackController.checkDeath().isPresent()){
                gameOver = true;
                GameStateHandler.getGameStateView().showGameOver();
            }
            playerList.forEach(player -> player.update(deltaTime));
        }
    }

    public AttackController getAttackController(){
        return this.attackController;
    }
}