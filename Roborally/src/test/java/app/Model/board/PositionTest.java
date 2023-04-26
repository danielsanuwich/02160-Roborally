package app.Model.board;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class PositionTest {

    @Test
    public void testGetX() {
        Position pos = new Position(2, 3);
        assertEquals(2, pos.getX());
    }

    @Test
    public void testGetY() {
        Position pos = new Position(2, 3);
        assertEquals(3, pos.getY());
    }

    @Test
    public void testEquals() {
        Position pos1 = new Position(2, 3);
        Position pos2 = new Position(2, 3);
        Position pos3 = new Position(4, 5);

        assertTrue(pos1.equals(pos2));
        assertFalse(pos1.equals(pos3));
    }

    @Test
    public void testToString() {
        Position pos = new Position(2, 3);
        assertEquals("(2, 3)", pos.toString());
    }
}
