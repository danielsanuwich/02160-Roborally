package app.Model;

import app.Model.board.*;
import app.Model.cards.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GameLogicTestAdv {
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
        initialPos1 = new Position(5, 2);
        initialPos2 = new Position(3, 1);
        initialDirection1 = new Direction(0);
        initialDirection2 = new Direction(0);
        initialHealth = 10;

        robot1 = new Robot(initialPos1, initialDirection1, initialHealth, 1, "Alice");
        robot2 = new Robot(initialPos2, initialDirection2, initialHealth, 2, "Bob");
        MakeGameBoardLayout1 mgbl = new MakeGameBoardLayout1();

        board = mgbl.makeBoard(); // x and y correct order?

        

        gameLogic = new GameLogic(initialPos1, initialPos2, initialDirection1, initialDirection2, initialHealth, robot1,
                robot2, board);
    }

    

    @Test
    void testConveyor() {
        Position Position1 = new Position(1,5);
        robot1.setPosition(Position1);
        Direction direction1 = new Direction(2);
        robot1.setDirection(direction1);
        ProgramCard card = new ProgramCard(0, 1);
        Direction expectedDirection = robot1.getDirection();
        Position expectedPosition = new Position(3, 6);
        int expectedHealth = 10;

        gameLogic.ExecuteTurn(card, robot1, board);

        assertEquals(expectedDirection, robot1.getDirection());
        assertEquals(expectedPosition, robot1.getPosition());
        assertEquals(expectedHealth, robot1.getHealth());
    }

    @Test
    void testHole() {
        Position Position1 = new Position(1,5);
        robot1.setPosition(Position1);
        Direction direction1 = new Direction(4);
        robot1.setDirection(direction1);
        ProgramCard card = new ProgramCard(0, 1);
        Direction expectedDirection = robot1.getDirection();
        Position expectedPosition = new Position(3, 4);
        int expectedHealth = 9;
        gameLogic.ExecuteTurn(card, robot1, board);

        assertEquals(expectedDirection, robot1.getDirection());
        assertEquals(expectedPosition, robot1.getPosition());
        assertEquals(expectedHealth, robot1.getHealth());
    }

    @Test
    void testLaser() {
        Position Position1 = new Position(6,4);
        robot1.setPosition(Position1);
        Direction direction1 = new Direction(4);
        robot1.setDirection(direction1);
        ProgramCard card = new ProgramCard(0, 1);
        Direction expectedDirection = robot1.getDirection();
        Position expectedPosition = new Position(5, 5);
        int expectedHealth = 9;

        gameLogic.ExecuteTurn(card, robot1, board);

        assertEquals(expectedDirection, robot1.getDirection());
        assertEquals(expectedPosition, robot1.getPosition());
        assertEquals(expectedHealth, robot1.getHealth());
    }

    @Test
    void testTurn() {
        Position Position1 = new Position(1,5);
        robot1.setPosition(Position1);
        Direction direction1 = new Direction(0);
        robot1.setDirection(direction1);
        ProgramCard card = new ProgramCard(0, 1);
        Direction expectedDirection = new Direction(1);
        Position expectedPosition = new Position(1, 4);
        int expectedHealth = 10;

        gameLogic.ExecuteTurn(card, robot1, board);

        assertEquals(1, robot1.getDirection().getDirection());
        assertEquals(expectedPosition, robot1.getPosition());
        assertEquals(expectedHealth, robot1.getHealth());

        Position Position2 = new Position(3,4);
        robot2.setPosition(Position2);
        Direction direction2 = new Direction(0);
        robot2.setDirection(direction2);
        ProgramCard card2 = new ProgramCard(0, 1);
        Direction expectedDirection2 = new Direction(5);
        Position expectedPosition2 = new Position(3, 3);
        int expectedHealth2 = 10;

        gameLogic.ExecuteTurn(card2, robot2, board);

        assertEquals(1, robot2.getDirection().getDirection());
        assertEquals(expectedPosition2, robot2.getPosition());
        assertEquals(expectedHealth2, robot2.getHealth());

    }

    @Test
    void testFlag() {
        Position Position1 = new Position(2,1);
        robot1.setPosition(Position1);
        Direction direction1 = new Direction(5);
        robot1.setDirection(direction1);
        ProgramCard card = new ProgramCard(0, 1);
        Direction expectedDirection = robot1.getDirection();
        Position expectedPosition = new Position(1, 1);
        int expectedHealth = 11;

        gameLogic.ExecuteTurn(card, robot1, board);

        assertEquals(expectedDirection, robot1.getDirection());
        assertEquals(expectedPosition, robot1.getPosition());
        assertEquals(expectedHealth, robot1.getHealth());
    }
}
