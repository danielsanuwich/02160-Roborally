package app.Model.tiles;

import app.Model.board.Direction;
import app.Model.board.Position;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TileTest {

    // Test the construction of a Tile object with default parameters
    @Test
    public void testTileConstructionWithDefaultParameters() {
        // Create a new Tile object with default parameters
        Tile tile = new Tile();

        // Assert that the type of the tile is "Base"
        assertEquals("Base", tile.getType());

        // Assert that the position of the tile is null
        assertEquals(null, tile.getPosition());

        // Assert that the direction of the tile is the default direction (0)
        assertEquals(new Direction(0), tile.getDirection());
    }

    // Test the construction of a Tile object with specified parameters
    @Test
    public void testTileConstructionWithSpecifiedParameters() {
        // Create a new Position object to use as the input position
        Position position = new Position(2, 3);

        // Create a new Direction object to use as the input direction
        Direction direction = new Direction(1);

        // Create a new Tile object using the input position and direction
        Tile tile = new Tile("Test", position, direction);

        // Assert that the type of the tile is "Test"
        assertEquals("Test", tile.getType());

        // Assert that the position of the tile is the same as the input position
        assertEquals(position, tile.getPosition());

        // Assert that the direction of the tile is the same as the input direction
        assertEquals(direction, tile.getDirection());
    }
}
