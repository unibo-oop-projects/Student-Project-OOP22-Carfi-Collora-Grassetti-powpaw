package powpaw.view.impl;

import java.util.ArrayList;

import javafx.scene.shape.Rectangle;

public class WeaponRender {

    private ArrayList<Rectangle> weapons;
    private final TransitionFactory transition = new TransitionFactory();
    private ArrayList<Rectangle> terrains;

    public WeaponRender(ArrayList<Rectangle> weapons){
        this.weapons = weapons;
    }

    public void setTerrains(ArrayList<Rectangle> terrains){
        this.terrains = terrains;
    }
    
    public ArrayList<Rectangle> getWeapons(){
        return this.weapons;
    }

    public void update() {
        for (Rectangle weapon : weapons) {
            transition.doVerticalTransition(weapon, weapon.getY(), this.terrains);
        }
    }
}
