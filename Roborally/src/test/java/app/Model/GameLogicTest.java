package app.Model;

import app.Model.board.*;
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
    // Test moveRobots method.
    @Test
    public void testMoveRobots() {
        GameBoard board = new GameBoard(10, 10);
        Position initPos1 = new Position(5, 5);
        Position initPos2 = new Position(5, 4);
        Direction initDirection1 = new Direction(1);
        Direction initDirection2 = new Direction(0);
        int initHealth = 10;
        Robot robot1 = new Robot(initPos1, initDirection1, initHealth, 1, "Alice");
        Robot robot2 = new Robot(initPos2, initDirection2, initHealth, 2, "Bob");

        GameLogic gameLogic = new GameLogic(initPos1, initPos2, initDirection1, initDirection2, initHealth, robot1,
                robot2, board);

        // Move robot1
        int stepsToMove1 = 2;
        gameLogic.moveRobots(robot1, initDirection1, stepsToMove1);

        // The expected position of robot1 after moving
        Position expectedPosition1 = gameLogic.move(initPos1, initDirection1, stepsToMove1);

        assertEquals(expectedPosition1, robot1.getPosition());

        // Move robot2
        int stepsToMove2 = 3;
        gameLogic.moveRobots(robot2, initDirection2, stepsToMove2);

        // The expected position of robot2 after moving
        Position expectedPosition2 = gameLogic.move(initPos2, initDirection2, stepsToMove2);

        assertEquals(expectedPosition2, robot2.getPosition());
    }

    // Test ExcecuteTurn method with a ProgramCard.
    @Test
    void testExcecuteTurnProgramCard() {
        ProgramCard card = new ProgramCard(2, 1);
        Direction expectedDirection = new Direction(robot1.getDirection().getDirection() + card.getTurnAmount());
        Position expectedPosition = gameLogic.move(robot1.getPosition(), expectedDirection, 1);

        gameLogic.ExcecuteTurn(card, robot1, board);

        assertEquals(expectedDirection, robot1.getDirection());
        assertEquals(expectedPosition, robot1.getPosition());
    }

    // Test ExcecuteTurn method with a HealthCard.
    @Test
    void testExcecuteTurnHealthCard() {
        HealthCard card = new HealthCard(2);
        int expectedHealth = robot1.getHealth() + card.getDiffHealth();

        gameLogic.ExcecuteTurn(card, robot1, board);

        assertEquals(expectedHealth, robot1.getHealth());
    }
}
