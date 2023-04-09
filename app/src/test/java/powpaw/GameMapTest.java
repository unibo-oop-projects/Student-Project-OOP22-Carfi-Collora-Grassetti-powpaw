package powpaw;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;

import powpaw.model.impl.CreateMap;
import powpaw.model.impl.BlockFactory;
import powpaw.model.impl.BlockImpl;

class GameMapTest {

    @Test
    void checkTerrainTest() {
        final CreateMap map = new CreateMap();
        final List<BlockImpl> terrainTest = map.getTerrains();
        terrainTest.add(BlockFactory.createBlock(0, 0));
        assertEquals(terrainTest.size(), map.getTerrains().size());

    }

    @Test
    void checkBlockPositionTest() {
        final BlockImpl blockOne = BlockFactory.createBlock(200, 200);
        blockOne.setX(400);
        final BlockImpl blockTwo = BlockFactory.createBlock(250, 200);
        blockTwo.setX(400);
        assertEquals(blockOne.getPosition(), blockTwo.getPosition());
    }

}
