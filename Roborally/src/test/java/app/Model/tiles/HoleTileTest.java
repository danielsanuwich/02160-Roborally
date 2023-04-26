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
        int damage = 2;

        // Create a new HoleTile object with the position we created above
        HoleTile holeTile = new HoleTile(position, damage);

        // Test that the type, position and damage of the HoleTile object were set correctly
        assertEquals("Hole", holeTile.getType());
        assertEquals(position, holeTile.getPosition());
        assertEquals(damage, holeTile.getDamage());
    }

    @Test
    public void testRemoveRobot() {
        // Create a new Position object with coordinates (0, 0)
        Position position = new Position(0, 0);

        // Create a new HoleTile object with the position we created above
        HoleTile holeTile = new HoleTile(position,damage);

        // Create a new Robot object with the position and direction (0) we created
        // above
        Robot robot = new Robot(position, new Direction(0));

        // set Robot's health to 10
        robot.setHealth(10);

        // Check that the robot's new health is 10-2 = 8
        assertEquals(robot.getHealth(), 8);
    }

}
