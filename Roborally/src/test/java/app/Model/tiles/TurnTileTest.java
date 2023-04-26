package app.Model.tiles;

import app.Model.board.Direction;
import app.Model.board.Position;
import org.junit.Test;
import static org.junit.Assert.*;

public class TurnTileTest {

    // Test that a TurnTile with a valid turnAmount can be created
    @Test
    public void testValidTurnAmount() {
        // create a new Position object to pass to the TurnTile constructor
        Position position = new Position(1, 1);

        // create a new Direction object to pass to the TurnTile constructor
        Direction direction = new Direction(0);

        // create a new TurnTile object with turnAmount 6
        TurnTile turnTile = new TurnTile(position, direction, 6);

        // test that the turnAmount is equal to 6
        assertEquals(6, turnTile.getTurnAmount());
    }

    // Test that a TurnTile with an invalid turnAmount throws an exception
    @Test(expected = IllegalArgumentException.class)
    public void testInvalidTurnAmount() {
        // create a new Position object to pass to the TurnTile constructor
        Position position = new Position(1, 1);

        // create a new Direction object to pass to the TurnTile constructor
        Direction direction = new Direction(0);

        // try to create a new TurnTile object with turnAmount 5 (not a multiple of 6)
        TurnTile turnTile = new TurnTile(position, direction, 5);
    }
}
