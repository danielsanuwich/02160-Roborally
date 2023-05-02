package app.Model.board;

import app.Model.tiles.*;

public class MakeGameBoardLayout2 {
    public GameBoard gb(){
        GameBoard gb = new GameBoard(8,8); // x and y correct order?
            gb.setTile(new Position(0, 0),new HoleTile(new Position(0, 0)));
            gb.setTile(new Position(1,0),new HoleTile(new Position(1, 0)));
            gb.setTile(new Position(2,0),new HoleTile(new Position(2, 0)));
            gb.setTile(new Position(3,0),new HoleTile(new Position(3, 0)));
            gb.setTile(new Position(4,0),new HoleTile(new Position(4, 0)));
            gb.setTile(new Position(5,0),new HoleTile(new Position(5, 0)));
            gb.setTile(new Position(6,0),new HoleTile(new Position(6, 0)));
            gb.setTile(new Position(7,0),new HoleTile(new Position(7, 0)));
            
            gb.setTile(new Position(0,1),new HoleTile(new Position(0, 1)));
            gb.setTile(new Position(1,1),new FlagTile(new Position(1, 1)));
            gb.setTile(new Position(2,1),new StartTile(new Position(2, 1)));
            gb.setTile(new Position(3,1),new LaserTile(new Position(3, 1), new Direction(3), 1));
            gb.setTile(new Position(4,1),new Tile(new Position(4, 1)));
            gb.setTile(new Position(5,1),new Tile(new Position(5, 1)));
            gb.setTile(new Position(6,1),new Tile(new Position(6, 1)));
            gb.setTile(new Position(7,1),new HoleTile(new Position(7, 1)));
            
            gb.setTile(new Position(0,2),new HoleTile(new Position(0, 2)));
            gb.setTile(new Position(1,2),new Tile(new Position(1, 2)));
            gb.setTile(new Position(2,2),new Tile(new Position(2, 2)));
            gb.setTile(new Position(3,2),new Tile(new Position(3, 2)));
            gb.setTile(new Position(4,2),new Tile(new Position(4, 2)));
            gb.setTile(new Position(5,2),new ConveyorTile(new Position(5, 2), new Direction(0)));
            gb.setTile(new Position(6,2),new Tile(new Position(6, 2)));
            gb.setTile(new Position(7,2),new HoleTile(new Position(7, 2)));
            
            gb.setTile(new Position(0,3),new HoleTile(new Position(0, 3)));
            gb.setTile(new Position(1,3),new Tile(new Position(1, 3)));
            gb.setTile(new Position(2,3),new TurnTile(new Position(2, 3), -1));
            gb.setTile(new Position(3,3),new HoleTile(new Position(3, 3)));
            gb.setTile(new Position(4,3),new Tile(new Position(4, 3)));
            gb.setTile(new Position(5,3),new ConveyorTile(new Position(5, 3), new Direction(0)));
            gb.setTile(new Position(6,3),new Tile(new Position(6, 3)));
            gb.setTile(new Position(7,3),new HoleTile(new Position(7, 3)));
            
            gb.setTile(new Position(0,4),new HoleTile(new Position(0, 4)));
            gb.setTile(new Position(1,4),new Tile(new Position(1, 4)));
            gb.setTile(new Position(2,4),new Tile(new Position(2, 4)));
            gb.setTile(new Position(3,4),new Tile(new Position(3, 4)));
            gb.setTile(new Position(4,4),new TurnTile(new Position(4, 4), 1));
            gb.setTile(new Position(5,4),new Tile(new Position(5, 4)));
            gb.setTile(new Position(6,4),new LaserTile(new Position(6, 4), new Direction(4), 1));
            gb.setTile(new Position(7,4),new HoleTile(new Position(7, 4)));
            
            gb.setTile(new Position(0,5),new HoleTile(new Position(0, 5)));
            gb.setTile(new Position(1,5),new Tile(new Position(1, 5)));
            gb.setTile(new Position(2,5),new HoleTile(new Position(2, 5)));
            gb.setTile(new Position(3,5),new Tile(new Position(3, 5)));
            gb.setTile(new Position(4,5),new Tile(new Position(4, 5)));
            gb.setTile(new Position(5,5),new Tile(new Position(5, 5)));
            gb.setTile(new Position(6,5),new Tile(new Position(6, 5)));
            gb.setTile(new Position(7,5),new HoleTile(new Position(7, 5)));
            
            gb.setTile(new Position(0,6),new HoleTile(new Position(0, 6)));
            gb.setTile(new Position(1,6),new Tile(new Position(1, 6)));
            gb.setTile(new Position(2,6),new Tile(new Position(2, 6)));
            gb.setTile(new Position(3,6),new Tile(new Position(3, 6)));
            gb.setTile(new Position(4,6),new Tile(new Position(4, 6)));
            gb.setTile(new Position(5,6),new StartTile(new Position(5, 6)));
            gb.setTile(new Position(6,6),new Tile(new Position(6, 6)));
            gb.setTile(new Position(7,6),new HoleTile(new Position(7, 6)));
            
            gb.setTile(new Position(0,7),new HoleTile(new Position(0, 7)));
            gb.setTile(new Position(1,7),new HoleTile(new Position(1, 7)));
            gb.setTile(new Position(2,7),new HoleTile(new Position(2, 7)));
            gb.setTile(new Position(3,7),new HoleTile(new Position(3, 7)));
            gb.setTile(new Position(4,7),new HoleTile(new Position(4, 7)));
            gb.setTile(new Position(5,7),new HoleTile(new Position(5, 7)));
            gb.setTile(new Position(6,7),new HoleTile(new Position(6, 7)));
            gb.setTile(new Position(7,7),new HoleTile(new Position(7, 7)));

        return gb;
}
}
