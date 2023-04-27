package app.Model.tiles;

import app.Model.board.Direction;
import app.Model.board.Position;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HoleTileTest {

    @Test
    public void testHoleTile() {
        Position position = new Position(1, 1);
        Direction direction = new Direction(0);
        int holeDamage = 1;
        HoleTile holeTile = new HoleTile(position, direction, holeDamage);

        // Check if the type, position, direction, and damage are correct for the created HoleTile instance
        assertEquals("Hole", holeTile.getType());
        assertEquals(position, holeTile.getPosition());
        assertEquals(direction, holeTile.getDirection());
        assertEquals(holeDamage, holeTile.getDamage());
    }
}
