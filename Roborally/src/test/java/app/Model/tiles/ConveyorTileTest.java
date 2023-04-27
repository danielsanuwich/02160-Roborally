package app.Model.tiles;

import app.Model.board.Direction;
import app.Model.board.Position;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ConveyorTileTest {

    private ConveyorTile conveyorTile;
    private Direction northDirection;

    @BeforeEach
    public void setUp() {
        northDirection = new Direction(0); // 0 represents NORTH
        conveyorTile = new ConveyorTile(new Position(1, 1), northDirection);
    }

    @Test
    public void testConveyorTileProperties() {
        assertEquals("Conveyor", conveyorTile.getType());
        assertEquals(new Position(1, 1), conveyorTile.getPosition());
        assertEquals(northDirection.getDirection(), conveyorTile.getDirection().getDirection());
    }
}
