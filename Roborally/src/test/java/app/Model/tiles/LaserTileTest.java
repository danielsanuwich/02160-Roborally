package app.Model.tiles;

import app.Model.board.Direction;
import app.Model.board.Position;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class LaserTileTest {
    @Test
    public void testConstructor() {
        // create a new position and direction
        Position position = new Position(0, 0);
        Direction direction = new Direction(0);

        // set the laser damage
        int laserDamage = 3;

        // create a new LaserTile object
        LaserTile laserTile = new LaserTile(position, direction, laserDamage);

        // check that the type, position, direction and laser damage are set correctly
        assertEquals("Laser", laserTile.getType());
        assertEquals(position, laserTile.getPosition());
        assertEquals(direction, laserTile.getDirection());
        assertEquals(laserDamage, laserTile.getDamage());
    }

    // This unit test tests the getDamage() method of LaserTile
    @Test
    public void testGetDamage() {
        // create a new position and direction
        Position position = new Position(0, 0);
        Direction direction = new Direction(0);

        int laserDamage = 3;

        // create a new LaserTile object
        LaserTile laserTile = new LaserTile(position, direction, laserDamage);

        // check that the getDamage() method returns the correct value
        assertEquals(laserDamage, laserTile.getDamage());
    }
}
