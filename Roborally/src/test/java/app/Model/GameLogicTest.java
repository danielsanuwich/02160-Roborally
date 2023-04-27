package app.Model;

import app.Model.board.Direction;
import app.Model.board.GameBoard;
import app.Model.board.Position;
import app.Model.cards.Card;
import app.Model.cards.HealthCard;
import app.Model.cards.ProgramCard;
import app.Model.tiles.ConveyorTile;
import app.Model.tiles.HoleTile;
import app.Model.tiles.LaserTile;
import app.Model.tiles.Tile;
import app.Model.tiles.TurnTile;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GameLogicTest {

    private GameLogic gameLogic;
    private Position initialPos1;
    private Position initialPos2;
    private Direction initialDirection1;
    private Direction initialDirection2;
    private int initialHealth;
    private Robot robot1;
    private Robot robot2;
    private GameBoard board;

    @BeforeEach
    public void setUp() {
        initialPos1 = new Position(5, 5);
        initialPos2 = new Position(5, 4);
        initialDirection1 = new Direction(0);
        initialDirection2 = new Direction(0);
        initialHealth = 10;

        robot1 = new Robot(initialPos1, initialDirection1, initialHealth, 1, "Alice");
        robot2 = new Robot(initialPos2, initialDirection2, initialHealth, 2, "Bob");

        board = new GameBoard(10, 10);

        gameLogic = new GameLogic(initialPos1, initialPos2, initialDirection1, initialDirection2,
                initialHealth, robot1, robot2, board);
    }

    @Test
    public void testMoveRobots() {
        // robot1 is blocking the way of robot2, so robot2 should be pushed
        gameLogic.moveRobots(robot2, new Direction(2));
        assertEquals(new Position(6, 4), robot2.getPosition());

        // robot1 is blocking the way of robot2, and is itself being pushed by another robot
        gameLogic.moveRobots(robot2, new Direction(2));
        assertEquals(new Position(7, 4), robot2.getPosition());

        // robot1 and robot2 are both in the way, and both need to be pushed
        gameLogic.moveRobots(robot2, new Direction(2));
        assertEquals(new Position(8, 3), robot2.getPosition());
    }

@Test
    public void testUpdateFromTile() {
        // test ConveyorTile
        Tile tile1 = new ConveyorTile(new Position(5, 4), new Direction(2));
        board.addTile(tile1);
        gameLogic.updateFromTile(robot2, board);
        assertEquals(new Position(6, 4), robot2.getPosition());

        // test TurnTile
        Tile tile2 = new TurnTile(new Position(6, 4), new Direction(2), 2);
        board.addTile(tile2);
        gameLogic.updateFromTile(robot2, board);
        assertEquals(new Direction(4).getDirection(), robot2.getDirection().getDirection());

        // test HoleTile
        Tile tile3 = new HoleTile(new Position(6, 3), 2);
        board.addTile(tile3);
        gameLogic.updateFromTile(robot2, board);
        assertEquals(initialHealth - 2, robot2.getHealth());
        assertEquals(new Position(5, 5), robot2.getPosition());

        // test LaserTile
        Tile tile4 = new LaserTile(new Position(5, 4), new Direction(2), 3);
        board.addTile(tile4);
        gameLogic.updateFromTile(robot2, board);
        assertEquals(initialHealth - 3
    
    
    
    }

}