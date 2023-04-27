package app.Model.tiles;

// Import necessary classes and methods
import app.Model.board.Direction;
import app.Model.board.Position;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class StartTileTest {

    // Test the construction of a StartTile object
    @Test
    public void testStartTileConstruction() {
        // Create a new Position object to use as the input position
        Position position = new Position(2, 3);

        // Create a new Direction object to use as the input direction
        Direction direction = new Direction(1);

        // Create a new StartTile object using the input position and direction
        StartTile startTile = new StartTile(position, direction);

        // Assert that the type of the startTile is "Start"
        assertEquals("Start", startTile.getType());

        // Assert that the position of the startTile is the same as the input position
        assertEquals(position, startTile.getPosition());

        // Assert that the direction of the startTile is the same as the input direction
        assertEquals(direction, startTile.getDirection());
    }
}
