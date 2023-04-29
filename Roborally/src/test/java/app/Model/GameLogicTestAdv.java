package app.Model;

import app.Model.board.*;
import app.Model.cards.*;
import app.Model.tiles.*;
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
        initialPos2 = new Position(5, 4);
        initialDirection1 = new Direction(0);
        initialDirection2 = new Direction(0);
        initialHealth = 10;

        robot1 = new Robot(initialPos1, initialDirection1, initialHealth, 1, "Alice");
        robot2 = new Robot(initialPos2, initialDirection2, initialHealth, 2, "Bob");

        board = new GameBoard(8,11); // x and y correct order?

        Tile[][] tileArray = {{ new HoleTile(new Position(0, 0), new Direction(0), 1),
                     new HoleTile(new Position(1, 0), new Direction(0), 0),
                     new HoleTile(new Position(2, 0), new Direction(0), 0),
                     new HoleTile(new Position(3, 0), new Direction(0), 0),
                     new HoleTile(new Position(4, 0), new Direction(0), 0),
                     new HoleTile(new Position(5, 0), new Direction(0), 0),
                     new HoleTile(new Position(6, 0), new Direction(0), 0),
                     new HoleTile(new Position(7, 0), new Direction(0), 0),
                     new HoleTile(new Position(8, 0), new Direction(0), 0),
                     new HoleTile(new Position(9, 0), new Direction(0), 0),
                     new HoleTile(new Position(10, 0), new Direction(0), 1) },
         { new HoleTile(new Position(0, 1), new Direction(0), 1),
                     new Tile("F", new Position(1, 1), new Direction(0)),
                     new Tile("Base", new Position(2, 1), new Direction(0)),
                     new Tile("Base", new Position(3, 1), new Direction(0)),
                     new TurnTile(new Position(4, 1), new Direction(0), 3),
                     new Tile("Base", new Position(5, 1), new Direction(0)),
                     new ConveyorTile(new Position(6, 1), new Direction(2)),
                     new Tile("Base", new Position(7, 1), new Direction(0)),
                     new Tile("Base", new Position(8, 1), new Direction(0)),
                     new FlagTile(new Position(9, 1)),
                     new HoleTile(new Position(10, 1), new Direction(0), 1) },
         { new HoleTile(new Position(0, 2), new Direction(0), 1),
                     new LaserTile(new Position(1, 2), new Direction(0), 1),
                     new ConveyorTile(new Position(2, 2), new Direction(4)),
                     new ConveyorTile(new Position(3, 2), new Direction(4)),
                     new ConveyorTile(new Position(4, 2), new Direction(5)),
                     new Tile("Base", new Position(5, 2), new Direction(0)),
                     new StartTile(new Position(6, 2), new Direction(0)),
                     new ConveyorTile(new Position(7, 2), new Direction(2)),
                     new ConveyorTile(new Position(8, 2), new Direction(3)),
                     new LaserTile(new Position(9, 2), new Direction(0), 1),
                     new HoleTile(new Position(10, 2), new Direction(0), 1) },
         { new HoleTile(new Position(0, 3), new Direction(0), 1),
                     new LaserTile(new Position(1, 3), new Direction(0), 1),
                     new Tile("Base", new Position(2, 3), new Direction(0)),
                     new TurnTile(new Position(3, 3), new Direction(0), 1),
                     new HoleTile(new Position(4, 3), new Direction(0), 0),
                     new ConveyorTile(new Position(5, 3), new Direction(5)),
                     new ConveyorTile(new Position(6, 3), new Direction(5)),
                     new Tile("Base", new Position(7, 3), new Direction(0)),
                     new ConveyorTile(new Position(8, 3), new Direction(3)),
                     new LaserTile(new Position(9, 3), new Direction(0), 1),
                     new HoleTile(new Position(10, 3), new Direction(0), 1) },
         { new HoleTile(new Position(0, 4), new Direction(0), 1),
                     new TurnTile(new Position(1, 4), new Direction(0), 1),
                     new Tile("Base", new Position(2, 4), new Direction(0)),
                     new StartTile(new Position(3, 4), new Direction(0)),
                     new HoleTile(new Position(4, 4), new Direction(0), 1),
                     new HoleTile(new Position(5, 4), new Direction(0), 1),
                     new Tile("Base", new Position(6, 4), new Direction(0)),
                     new ConveyorTile(new Position(7, 4), new Direction(5)),
                     new LaserTile(new Position(8, 4), new Direction(2), 1),
                     new FlagTile(new Position(9, 4)),
                     new HoleTile(new Position(10, 4), new Direction(0), 1) },
         { new HoleTile(new Position(0, 5), new Direction(0), 1),
                     new Tile("Base", new Position(1, 5), new Direction(0)),
                     new ConveyorTile(new Position(2, 5), new Direction(2)),
                     new Tile("Base", new Position(3, 5), new Direction(0)),
                     new LaserTile(new Position(4, 5), new Direction(1), 1),
                     new LaserTile(new Position(5, 5), new Direction(1), 1),
                     new TurnTile(new Position(6, 5), new Direction(0), -1),
                     new StartTile(new Position(7, 5), new Direction(0)),
                     new TurnTile(new Position(8, 5), new Direction(0), 1),
                     new LaserTile(new Position(9, 5), new Direction(2), 1),
                     new HoleTile(new Position(10, 5), new Direction(0), 1) },
         { new HoleTile(new Position(0, 6), new Direction(0), 1),
                     new ConveyorTile(new Position(1, 6), new Direction(1)),
                     new FlagTile(new Position(2, 6)),
                     new ConveyorTile(new Position(3, 6), new Direction(2)),
                     new ConveyorTile(new Position(4, 6), new Direction(1)),
                     new ConveyorTile(new Position(5, 6), new Direction(1)),
                     new Tile("Base", new Position(6, 6), new Direction(0)),
                     new HoleTile(new Position(7, 6), new Direction(0), 1),
                     new Tile("Base", new Position(8, 6), new Direction(0)),
                     new Tile("Base", new Position(9, 6), new Direction(0)),
                     new HoleTile(new Position(10, 6), new Direction(0), 1) },
         { new HoleTile(new Position(0, 7), new Direction(0), 1),
                     new HoleTile(new Position(1, 7), new Direction(0), 0),
                     new HoleTile(new Position(2, 7), new Direction(0), 0),
                     new HoleTile(new Position(3, 7), new Direction(0), 0),
                     new HoleTile(new Position(4, 7), new Direction(0), 0),
                     new HoleTile(new Position(5, 7), new Direction(0), 0),
                     new HoleTile(new Position(6, 7), new Direction(0), 0),
                     new HoleTile(new Position(7, 7), new Direction(0), 0),
                     new HoleTile(new Position(8, 7), new Direction(0), 0),
                     new HoleTile(new Position(9, 7), new Direction(0), 1),
                     new HoleTile(new Position(10, 7), new Direction(0), 1) },
     };
     
     board.setBoard(tileArray);

        gameLogic = new GameLogic(initialPos1, initialPos2, initialDirection1, initialDirection2, initialHealth, robot1,
                robot2, board);
    }

    

    @Test
    void testConveyor() {
        ProgramCard card = new ProgramCard(0, 1);
        Direction expectedDirection = robot1.getDirection();
        Position expectedPosition = new Position(5, 1);

        gameLogic.ExecuteTurn(card, robot1, board);

        assertEquals(expectedDirection, robot1.getDirection());
        assertEquals(expectedPosition, robot1.getPosition());
    }
}
