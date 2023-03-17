package powpaw.model.api;

import java.util.ArrayList;
import javafx.scene.shape.Rectangle;

public class CreateMap {

    private ArrayList<Rectangle> terrains = new ArrayList<>();

    public CreateMap() {
        createWorld();
    }

    private void createWorld() {
        for (int y = 0; y < Level.Level2.length; y++) {
            String row = Level.Level2[y];
            for (int x = 0; x < row.length(); x++) {
                switch (row.charAt(x)) {
                    case '0':
                        break;
                    case '1':
                        Rectangle block = Entity.createBlock(x, y, 1, 1);
                        terrains.add(block);
                        break;
                }
            }
        }

    }

    public ArrayList<Rectangle> getTerrains() {
        return terrains;
    }

}
