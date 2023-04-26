package app.Model.tiles;

import app.Model.board.Direction;
import app.Model.board.Position;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ConveyorTileTest {

    // Test the constructor of ConveyorTile
    @Test
    public void testConstructor() {
        // Create a new Position object at (0, 0)
        Position position = new Position(0, 0);
        // Create a new Direction object with direction value 0
        Direction direction = new Direction(0);
        // Create a new ConveyorTile object with position, direction and type arguments
        ConveyorTile conveyorTile = new ConveyorTile(position, direction);

        // Test the attributes of the created ConveyorTile object
        assertEquals("Conveyor", conveyorTile.getType()); // Check if type is set to "Conveyor"
        assertEquals(position, conveyorTile.getPosition()); // Check if position is set correctly
        assertEquals(direction, conveyorTile.getConveyorDirection()); // Check if conveyorDirection is set correctly
    }

    // Test the moveRobot() method of ConveyorTile
    @Test
    public void testMoveRobot() {
        // Create a new Position object at (0, 0)
        Position position = new Position(0, 0);
        // Create a new Direction object with direction value 0
        Direction direction = new Direction(0);
        // Create a new ConveyorTile object with position, direction and type arguments
        ConveyorTile conveyorTile = new ConveyorTile(position, direction);

        // Create a new Robot object at the same position and direction as the
        // ConveyorTile
        Robot robot = new Robot(position, direction);
        // Move the Robot using the moveRobot() method of the ConveyorTile
        conveyorTile.moveRobot(robot);

        // The Robot should have moved one tile to the right, so we create a new
        // expectedPosition object with x=0 and y=1.
        Position expectedPosition = new Position(0, 1);
        // Test if the position of the Robot has been updated correctly
        assertEquals(expectedPosition, robot.getPosition());
    }
}
