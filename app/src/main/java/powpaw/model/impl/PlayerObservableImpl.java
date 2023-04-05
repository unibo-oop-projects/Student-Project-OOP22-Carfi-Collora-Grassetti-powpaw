package powpaw.model.impl;

import java.time.Duration;
import java.util.List;

import powpaw.config.Parser;
import powpaw.controller.impl.AttackControllerImpl;
import powpaw.controller.impl.KeyObserverImpl;
import powpaw.model.api.Player;
import powpaw.model.api.PlayerObservable;
import powpaw.view.api.KeyObservable;
import powpaw.view.impl.KeyObservableImpl;

public class PlayerObservableImpl implements PlayerObservable {

    private List<Player> playerList;
    private final KeyObservable observable = new KeyObservableImpl();
    private final Parser config;
    
    public PlayerObservableImpl(List<Player> playerList) {
        this.playerList = playerList;
        this.config = new Parser();
        this.playerList.forEach(player -> observable.addObserver(new KeyObserverImpl(player, this.config)));
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
        playerList.forEach(player -> {
            player.update(deltaTime);
        });
    }
}