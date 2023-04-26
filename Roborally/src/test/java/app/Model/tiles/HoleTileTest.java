package app.Model.tiles;

import app.Model.Robot;
import app.Model.board.Direction;
import app.Model.board.Position;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class HoleTileTest {

    @Test
    public void testConstructor() {
        // Create a new Position object with coordinates (0, 0)
        Position position = new Position(0, 0);

        // Create a new HoleTile object with the position we created above
        HoleTile holeTile = new HoleTile(position);

        // Test that the type and position of the HoleTile object were set correctly
        assertEquals("Hole", holeTile.getType());
        assertEquals(position, holeTile.getPosition());
    }

    @Test
    public void testRemoveRobot() {
        // Create a new Position object with coordinates (0, 0)
        Position position = new Position(0, 0);

        // Create a new HoleTile object with the position we created above
        HoleTile holeTile = new HoleTile(position);

        // Create a new Robot object with the position and direction (0) we created
        // above
        Robot robot = new Robot(position, new Direction(0));

        // Remove the Robot object from the HoleTile
        holeTile.removeRobot(robot);

        // Test that the Robot's position is now null
        assertNull(robot.getPosition());
    }

}
