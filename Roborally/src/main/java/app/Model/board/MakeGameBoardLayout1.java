package app.Model.board;
import app.Model.tiles.*;

public class MakeGameBoardLayout1{

    public GameBoard makeBoard(){
        GameBoard gb = new GameBoard(11,8); // x and y correct order?
            gb.setTile(new Position(0, 0),new HoleTile(new Position(0, 0), new Direction(0), 1));
            gb.setTile(new Position(1,0),new HoleTile(new Position(1, 0), new Direction(0), 1));
            gb.setTile(new Position(2,0),new HoleTile(new Position(2, 0), new Direction(0), 1));
            gb.setTile(new Position(3,0),new HoleTile(new Position(3, 0), new Direction(0), 1));
            gb.setTile(new Position(4,0),new HoleTile(new Position(4, 0), new Direction(0), 1));
            gb.setTile(new Position(5,0),new HoleTile(new Position(5, 0), new Direction(0), 1));
            gb.setTile(new Position(6,0),new HoleTile(new Position(6, 0), new Direction(0), 1));
            gb.setTile(new Position(7,0),new HoleTile(new Position(7, 0), new Direction(0), 1));
            gb.setTile(new Position(8,0),new HoleTile(new Position(8, 0), new Direction(0), 1));
            gb.setTile(new Position(9,0),new HoleTile(new Position(9, 0), new Direction(0), 1));
            gb.setTile(new Position(10,0),new HoleTile(new Position(10, 0), new Direction(0), 1));
            gb.setTile(new Position(0,1),new HoleTile(new Position(0, 1), new Direction(0), 1));
            gb.setTile(new Position(1,1),new Tile("F", new Position(1, 1), new Direction(0)));
            gb.setTile(new Position(2,1),new Tile("Base", new Position(2, 1), new Direction(0)));
            gb.setTile(new Position(3,1),new Tile("Base", new Position(3, 1), new Direction(0)));
            gb.setTile(new Position(4,1),new TurnTile(new Position(4, 1), new Direction(0), 3));
            gb.setTile(new Position(5,1),new Tile("Base", new Position(5, 1), new Direction(0)));
            gb.setTile(new Position(6,1),new ConveyorTile(new Position(6, 1), new Direction(2)));
            gb.setTile(new Position(7,1),new Tile("Base", new Position(7, 1), new Direction(0)));
            gb.setTile(new Position(8,1),new Tile("Base", new Position(8, 1), new Direction(0)));
            gb.setTile(new Position(9,1),new FlagTile(new Position(9, 1)));
            gb.setTile(new Position(10,1),new HoleTile(new Position(10, 1), new Direction(0), 1));
            gb.setTile(new Position(0,2),new HoleTile(new Position(0, 2), new Direction(0), 1));
            gb.setTile(new Position(1,2),new LaserTile(new Position(1, 2), new Direction(0), 1));
            gb.setTile(new Position(2,2),new ConveyorTile(new Position(2, 2), new Direction(4)));
            gb.setTile(new Position(3,2),new ConveyorTile(new Position(3, 2), new Direction(4)));
            gb.setTile(new Position(4,2),new ConveyorTile(new Position(4, 2), new Direction(5)));
            gb.setTile(new Position(5,2),new Tile("Base", new Position(5, 2), new Direction(0)));
            gb.setTile(new Position(6,2),new StartTile(new Position(6, 2), new Direction(0)));
            gb.setTile(new Position(7,2),new ConveyorTile(new Position(7, 2), new Direction(2)));
            gb.setTile(new Position(8,2),new ConveyorTile(new Position(8, 2), new Direction(3)));
            gb.setTile(new Position(9,2),new LaserTile(new Position(9, 2), new Direction(0), 1));
            gb.setTile(new Position(10,2),new HoleTile(new Position(10, 2), new Direction(0), 1));
            gb.setTile(new Position(0,3),new HoleTile(new Position(0, 3), new Direction(0), 1));
            gb.setTile(new Position(1,3),new LaserTile(new Position(1, 3), new Direction(0), 1));
            gb.setTile(new Position(2,3),new Tile("Base", new Position(2, 3), new Direction(0)));
            gb.setTile(new Position(3,3),new TurnTile(new Position(3, 3), new Direction(0), 1));
            gb.setTile(new Position(4,3),new HoleTile(new Position(4, 3), new Direction(0), 0));
            gb.setTile(new Position(5,3),new ConveyorTile(new Position(5, 3), new Direction(5)));
            gb.setTile(new Position(6,3),new ConveyorTile(new Position(6, 3), new Direction(5)));
            gb.setTile(new Position(7,3),new Tile("Base", new Position(7, 3), new Direction(0)));
            gb.setTile(new Position(8,3),new ConveyorTile(new Position(8, 3), new Direction(3)));
            gb.setTile(new Position(9,3),new LaserTile(new Position(9, 3), new Direction(0), 1));
            gb.setTile(new Position(10,3),new HoleTile(new Position(10, 3), new Direction(0), 1));
            gb.setTile(new Position(0,4),new HoleTile(new Position(0, 4), new Direction(0), 1));
            gb.setTile(new Position(1,4),new TurnTile(new Position(1, 4), new Direction(0), 1));
            gb.setTile(new Position(2,4),new Tile("Base", new Position(2, 4), new Direction(0)));
            gb.setTile(new Position(3,4),new StartTile(new Position(3, 4), new Direction(0)));
            gb.setTile(new Position(4,4),new HoleTile(new Position(4, 4), new Direction(0), 1));
            gb.setTile(new Position(5,4),new HoleTile(new Position(5, 4), new Direction(0), 1));
            gb.setTile(new Position(6,4),new Tile("Base", new Position(6, 4), new Direction(0)));
            gb.setTile(new Position(7,4),new ConveyorTile(new Position(7, 4), new Direction(5)));
            gb.setTile(new Position(8,4),new LaserTile(new Position(8, 4), new Direction(2), 1));
            gb.setTile(new Position(9,4),new FlagTile(new Position(9, 4)));
            gb.setTile(new Position(10,4),new HoleTile(new Position(10, 4), new Direction(0), 1));
            gb.setTile(new Position(0,5),new HoleTile(new Position(0, 5), new Direction(0), 1));
            gb.setTile(new Position(1,5),new Tile("Base", new Position(1, 5), new Direction(0)));
            gb.setTile(new Position(2,5),new ConveyorTile(new Position(2, 5), new Direction(2)));
            gb.setTile(new Position(3,5),new Tile("Base", new Position(3, 5), new Direction(0)));
            gb.setTile(new Position(4,5),new LaserTile(new Position(4, 5), new Direction(1), 1));
            gb.setTile(new Position(5,5),new LaserTile(new Position(5, 5), new Direction(1), 1));
            gb.setTile(new Position(6,5),new TurnTile(new Position(6, 5), new Direction(0), -1));
            gb.setTile(new Position(7,5),new StartTile(new Position(7, 5), new Direction(0)));
            gb.setTile(new Position(8,5),new TurnTile(new Position(8, 5), new Direction(0), 1));
            gb.setTile(new Position(9,5),new LaserTile(new Position(9, 5), new Direction(2), 1));
            gb.setTile(new Position(10,5),new HoleTile(new Position(10, 5), new Direction(0), 1));
            gb.setTile(new Position(0,6),new HoleTile(new Position(0, 6), new Direction(0), 1));
            gb.setTile(new Position(1,6),new ConveyorTile(new Position(1, 6), new Direction(1)));
            gb.setTile(new Position(2,6),new FlagTile(new Position(2, 6)));
            gb.setTile(new Position(3,6),new ConveyorTile(new Position(3, 6), new Direction(2)));
            gb.setTile(new Position(4,6),new ConveyorTile(new Position(4, 6), new Direction(1)));
            gb.setTile(new Position(5,6),new ConveyorTile(new Position(5, 6), new Direction(1)));
            gb.setTile(new Position(6,6),new Tile("Base", new Position(6, 6), new Direction(0)));
            gb.setTile(new Position(7,6),new HoleTile(new Position(7, 6), new Direction(0), 1));
            gb.setTile(new Position(8,6),new Tile("Base", new Position(8, 6), new Direction(0)));
            gb.setTile(new Position(9,6),new Tile("Base", new Position(9, 6), new Direction(0)));
            gb.setTile(new Position(10,6),new HoleTile(new Position(10, 6), new Direction(0), 1));
            gb.setTile(new Position(0,7),new HoleTile(new Position(0, 7), new Direction(0), 1));
            gb.setTile(new Position(1,7),new HoleTile(new Position(1, 7), new Direction(0), 1));
            gb.setTile(new Position(2,7),new HoleTile(new Position(2, 7), new Direction(0), 1));
            gb.setTile(new Position(3,7),new HoleTile(new Position(3, 7), new Direction(0), 1));
            gb.setTile(new Position(4,7),new HoleTile(new Position(4, 7), new Direction(0), 1));
            gb.setTile(new Position(5,7),new HoleTile(new Position(5, 7), new Direction(0), 1));
            gb.setTile(new Position(6,7),new HoleTile(new Position(6, 7), new Direction(0), 1));
            gb.setTile(new Position(7,7),new HoleTile(new Position(7, 7), new Direction(0), 1));
            gb.setTile(new Position(8,7),new HoleTile(new Position(8, 7), new Direction(0), 1));
            gb.setTile(new Position(9,7),new HoleTile(new Position(9, 7), new Direction(0), 1));
            gb.setTile(new Position(10,7),new HoleTile(new Position(10, 7), new Direction(0), 1));

        return gb;
    }

    
}