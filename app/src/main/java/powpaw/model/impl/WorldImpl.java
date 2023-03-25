package powpaw.model.impl;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import powpaw.controller.impl.KeyObserverImpl;
import powpaw.model.api.Player;
import powpaw.model.api.World;
import powpaw.view.api.KeyObservable;
import powpaw.view.impl.KeyObservableImpl;

public class WorldImpl implements World {

    private final List<Player> playerList = new ArrayList<>();
    private final KeyObservable observable = new KeyObservableImpl();

    public WorldImpl() {
        playerList.forEach(player -> observable.addObserver(new KeyObserverImpl(player)));
    }

    @Override
    public void addPlayer(Player player) {
        this.playerList.add(player);
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
        playerList.forEach(player -> player.update(deltaTime));
    }
}