package powpaw.model.impl;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import javafx.scene.shape.Rectangle;
import powpaw.controller.api.ScreenController;
import powpaw.controller.impl.KeyObserverImpl;
import powpaw.model.api.Player;
import powpaw.model.api.World;
import powpaw.view.api.KeyObservable;
import powpaw.view.impl.KeyObservableImpl;
import powpaw.view.impl.TransitionFactory;
import powpaw.view.impl.WorldRender;

public class WorldImpl implements World {

    private final List<Player> playerList = new ArrayList<>();
    private final KeyObservable observable = new KeyObservableImpl();

    private ArrayList<Rectangle> weapons;
    //private Rectangle weapons;

    public WorldImpl() {
        playerList.forEach(player -> observable.addObserver(new KeyObserverImpl(player)));
    
        //PROVA!!
        weapons = new ArrayList<>();
        weapons.add(Entity.createWeapon(15 * ScreenController.SIZE_HD_W/30, 1 * ScreenController.SIZE_HD_H/10 , ScreenController.SIZE_HD_W/30, ScreenController.SIZE_HD_H/10));
        
        weapons.add(Entity.createWeapon(1 * ScreenController.SIZE_HD_W/30, 1 * ScreenController.SIZE_HD_H/10, ScreenController.SIZE_HD_W/30, ScreenController.SIZE_HD_H/10));
        weapons.add(Entity.createWeapon(5 * ScreenController.SIZE_HD_W/30, 1 * ScreenController.SIZE_HD_H/10, ScreenController.SIZE_HD_W/30, ScreenController.SIZE_HD_H/10));
        weapons.add(Entity.createWeapon(10 * ScreenController.SIZE_HD_W/30, 1 * ScreenController.SIZE_HD_H/10, ScreenController.SIZE_HD_W/30, ScreenController.SIZE_HD_H/10));
        weapons.add(Entity.createWeapon(25* ScreenController.SIZE_HD_W/30, 1 * ScreenController.SIZE_HD_H/10, ScreenController.SIZE_HD_W/30, ScreenController.SIZE_HD_H/10));*/
    }
    
    @Override
    public ArrayList<Rectangle> getWeapons(){
        return this.weapons;
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