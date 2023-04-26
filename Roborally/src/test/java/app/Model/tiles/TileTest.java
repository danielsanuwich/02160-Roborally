// Import necessary classes and packages
package app.Model.tiles;

import app.Model.board.Direction;
import app.Model.board.Position;

import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

public class TurnTileTest {

    @Test
    public void testValidTurnAmount() {
        // Test that a valid turn amount is set correctly
        int turnAmount = 12;
        TurnTile tile = new TurnTile(new Position(1, 1), Direction.NORTH, turnAmount);
        assertEquals(turnAmount, tile.getTurnAmount());
    }

    @Test
    public void testInvalidTurnAmount() {
        // Test that an invalid turn amount throws an IllegalArgumentException
        int invalidTurnAmount = 7;
        assertThrows(IllegalArgumentException.class, () -> {
            new TurnTile(new Position(2, 2), Direction.WEST, invalidTurnAmount);
        });
    }

}
