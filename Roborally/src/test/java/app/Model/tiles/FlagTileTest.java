package app.Model.tiles;

import app.Model.board.Position;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class FlagTileTest {

    private FlagTile flagTile;

    @BeforeEach
    public void setUp() {
        flagTile = new FlagTile(new Position(2, 2));
    }

    @Test
    public void testFlagTileProperties() {
        assertEquals("Flag", flagTile.getType());
        assertEquals(new Position(2, 2), flagTile.getPosition());
        assertNull(flagTile.getDirection());
    }
}
