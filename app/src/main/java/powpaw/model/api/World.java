package powpaw.model.api;

import java.util.ArrayList;

import javafx.scene.Node;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class World {
    
    private int levelWith;
    private Rectangle background;
    private Node block;

    private ArrayList<Node> terrains = new ArrayList<>(); 

    public World(){
        this.background = new Rectangle(1280, 720);
        this.levelWith = Level.Level1[0].length() * 60;
        createWorld();
    }

    private void createWorld(){
        for(int i=0; i < Level.Level1.length; i++){
            //System.out.println("i: " + i);
            String row  = Level.Level1[i];
            for(int j=0; j < row.length(); j++){
                switch (row.charAt(j)) {
                    case '0' :
                        break;
                    case '1':
                        Node block = Entity.createBlock(j*60, i*60, 60, 60, Color.RED);
                        terrains.add(block);
                        break;
                }
            }
        }
        
    }

    public ArrayList<Node> getTerrains() {
        return terrains;
    }
    



}
