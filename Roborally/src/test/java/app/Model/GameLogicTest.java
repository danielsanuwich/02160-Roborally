package app.Model;

import app.Model.board.*;
import app.Model.tiles.*;
import app.Model.cards.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GameLogicTest {
    private GameLogic gameLogic;
    private Robot robot1;
    private Robot robot2;
    private Position initialPos1;
    private Position initialPos2;
    private Direction initialDirection1;
    private Direction initialDirection2;
    private int initialHealth;
    private GameBoard board;

    @BeforeEach
    void setUp() {
        initialPos1 = new Position(5, 5);
        initialPos2 = new Position(5, 4);
        initialDirection1 = new Direction(0);
        initialDirection2 = new Direction(0);
        initialHealth = 10;

        robot1 = new Robot(initialPos1, initialDirection1, initialHealth, 1, "Alice");
        robot2 = new Robot(initialPos2, initialDirection2, initialHealth, 2, "Bob");

        board = new GameBoard(10, 10);

        gameLogic = new GameLogic(initialPos1, initialPos2, initialDirection1, initialDirection2, initialHealth, robot1,
                robot2, board);
    }

    // Test moveRobots method.
    @Test
    public void testMoveRobots() {
        GameBoard board = new GameBoard(10, 10);
        Position initPos1 = new Position(5, 5);
        Position initPos2 = new Position(5, 4);
        Direction initDirection1 = new Direction(0);
        Direction initDirection2 = new Direction(0);
        int initHealth = 10;
        Robot robot1 = new Robot(initPos1, initDirection1, initHealth, 1, "Alice");
        Robot robot2 = new Robot(initPos2, initDirection2, initHealth, 2, "Bob");

        GameLogic gameLogic = new GameLogic(initPos1, initPos2, initDirection1, initDirection2, initHealth, robot1,
                robot2, board);

        // Set the direction for the ConveyorTile at position (5, 5)
        Position conveyorTilePos = new Position(5, 5);
        Tile conveyorTile = new ConveyorTile(conveyorTilePos, new Direction(0));
        Direction conveyorDirection = new Direction(1);
        conveyorTile.setDirection(conveyorDirection);
        board.setTile(conveyorTilePos, conveyorTile);

        // Move robot1, which should be affected by the ConveyorTile
        gameLogic.moveRobots(robot1, initDirection1);

        // The expected position of robot1 after moving and being affected by the
        // ConveyorTile
        Position expectedPosition = new Position(6, 5);

        assertEquals(expectedPosition, robot1.getPosition());
    }

    /**
     * Test ExcecuteTurn method with a ProgramCard.
     * This test checks if the ExcecuteTurn method correctly updates the Robot's
     * attributes based on the ProgramCard.
     */
    @Test
    void testExcecuteTurnProgramCard() {
        ProgramCard card = new ProgramCard(2, 1);
        Direction expectedDirection = new Direction(robot1.getDirection().getDirection() + card.getTurnAmount());
        Position expectedPosition = gameLogic.move(robot1.getPosition(), expectedDirection, 1);

        gameLogic.ExcecuteTurn(card, robot1, board);

        assertEquals(expectedDirection, robot1.getDirection());
        assertEquals(expectedPosition, robot1.getPosition());
    }

    /**
     * Test ExcecuteTurn method with a HealthCard.
     * This test checks if the ExcecuteTurn method correctly updates the Robot's
     * health based on the HealthCard.
     */
    @Test
    void testExcecuteTurnHealthCard() {
        HealthCard card = new HealthCard(2);
        int expectedHealth = robot1.getHealth() + card.getDiffHealth();

        gameLogic.ExcecuteTurn(card, robot1, board);

        assertEquals(expectedHealth, robot1.getHealth());
    }
}
