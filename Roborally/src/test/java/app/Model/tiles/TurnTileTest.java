package app.Model.tiles;

import app.Model.board.Direction;
import app.Model.board.Position;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class TurnTileTest {

    private TurnTile turnTile;
    private Direction eastDirection;

    @BeforeEach
    public void setUp() {
        eastDirection = new Direction(2); // 2 represents EAST
        turnTile = new TurnTile(new Position(1, 1), eastDirection, 12);
    }

    // Test that the TurnTile properties (type, position, direction, and turnAmount)
    // are initialized correctly
    @Test
    public void testTurnTileProperties() {
        assertEquals("Turn", turnTile.getType());
        assertEquals(new Position(1, 1), turnTile.getPosition());
        assertEquals(eastDirection.getDirection(), turnTile.getDirection().getDirection());
        assertEquals(12, turnTile.getTurnAmount());
    }

    // Test that an IllegalArgumentException is thrown when the turnAmount is not a
    // multiple of 6
    @Test
    public void testInvalidTurnAmount() {
        assertThrows(IllegalArgumentException.class, () -> new TurnTile(new Position(1, 1), eastDirection, 7));
    }
}
