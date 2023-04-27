package app.Model;

import app.Model.board.*;
import app.Model.tiles.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RobotTest {
    private Robot robot;
    private Position initPosition;
    private Direction initDirection;
    private int initHealth;
    private int initPlayer;
    private String initName;

    @BeforeEach
    void setUp() {
        initPosition = new Position(0, 0);
        initDirection = new Direction(0);
        initHealth = 10;
        initPlayer = 1;
        initName = "TestBot";

        robot = new Robot(initPosition, initDirection, initHealth, initPlayer, initName);
    }

    // Test setters and getters.
    @Test
    void testSettersAndGetters() {
        Position newPosition = new Position(1, 1);
        Direction newDirection = new Direction(3);
        int newHealth = 8;
        int newPlayer = 2;
        String newName = "NewTestBot";

        robot.setPlayer(newPlayer);
        robot.setHealth(newHealth);
        robot.setName(newName);
        robot.setPosition(newPosition);
        robot.setDirection(newDirection);

        assertEquals(newPlayer, robot.getPlayer());
        assertEquals(newHealth, robot.getHealth());
        assertEquals(newName, robot.getName());
        assertEquals(newPosition, robot.getPosition());
        assertEquals(newDirection, robot.getDirection());
    }

    // Test changeHealth method.
    @Test
    void testChangeHealth() {
        int diffHealth = -2;
        int expectedHealth = initHealth + diffHealth;

        robot.changeHealth(diffHealth);
        assertEquals(expectedHealth, robot.getHealth());
    }

    // Test respawn method.
    @Test
    void testRespawn() {
        StartTile startTile = new StartTile(new Position(2, 2), new Direction(0));
        Position expectedPosition = startTile.getPosition();

        robot.respawn(startTile);
        assertEquals(expectedPosition, robot.getPosition());
    }
}
