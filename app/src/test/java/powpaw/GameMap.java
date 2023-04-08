package powpaw;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import powpaw.model.impl.CreateMap;
import powpaw.model.impl.BlockFactory;
import powpaw.model.impl.BlockImpl;

public class GameMap {

    @Test
    void checkTerrainTest() {
        CreateMap map = new CreateMap();
        ArrayList<BlockImpl> terrainTest = map.getTerrains();
        terrainTest.add(BlockFactory.createBlock(0, 0));
        assertEquals(terrainTest.size(), map.getTerrains().size());

    }

    @Test
    void chekBlockPositionTest() {
        BlockImpl blockOne = BlockFactory.createBlock(200, 200);
        blockOne.setX(400);
        BlockImpl blockTwo = BlockFactory.createBlock(250, 200);
        blockTwo.setX(400);
        assertEquals(blockOne.getPosition(), blockTwo.getPosition());
    }

}
