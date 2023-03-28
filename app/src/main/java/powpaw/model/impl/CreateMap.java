package powpaw.model.impl;

import java.util.ArrayList;
import powpaw.model.api.Level;

public class CreateMap {

    private ArrayList<BlockImpl> terrains = new ArrayList<>();

    public CreateMap() {
        createTerrains();
    }

    private void createTerrains() {
        for (int y = 0; y < Level.Level2.length; y++) {
            String row = Level.Level2[y];
            for (int x = 0; x < row.length(); x++) {
                switch (row.charAt(x)) {
                    case '0':
                        break;
                    case '1':
                        BlockImpl block = Entity.createBlock(x, y);
                        terrains.add(block);
                        break;
                }
            }
        }

    }

    public ArrayList<BlockImpl> getTerrains() {
        return terrains;
    }

}
