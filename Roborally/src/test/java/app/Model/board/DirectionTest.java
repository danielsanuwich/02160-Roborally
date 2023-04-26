package app.Model.board;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class DirectionTest {

    @Test
    public void testInitialDirection() {
        // create a new Direction object with initial direction 0
        Direction direction = new Direction(0);

        // test the initial direction value
        assertEquals(0, direction.getDirection());
    }

    @Test
    public void testPositiveDirection() {
        // create a new Direction object with initial direction 0
        Direction direction = new Direction(0);

        // test setting the direction value to a positive number
        direction.setDirection(3);
        assertEquals(3, direction.getDirection());
    }

    @Test
    public void testNegativeDirection() {
        // create a new Direction object with initial direction 0
        Direction direction = new Direction(0);

        // test setting the direction value to a negative number
        direction.setDirection(-2);
        assertEquals(4, direction.getDirection());
    }

    @Test
    public void testLargePositiveDirection() {
        // create a new Direction object with initial direction 0
        Direction direction = new Direction(0);

        // test setting the direction value to a large positive number
        direction.setDirection(13);
        assertEquals(1, direction.getDirection());
    }

    @Test
    public void testLargeNegativeDirection() {
        // create a new Direction object with initial direction 0
        Direction direction = new Direction(0);

        // test setting the direction value to a large negative number
        direction.setDirection(-17);
        assertEquals(5, direction.getDirection());
    }
}
