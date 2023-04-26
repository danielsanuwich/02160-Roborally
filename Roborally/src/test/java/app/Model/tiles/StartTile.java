package app.Model.tiles;

import app.Model.board.Direction;
import app.Model.board.Position;

public class StartTile extends Tile{

    // StartTile constructor
    public StartTile(Position inputPosition,Direction inputDirection){
        super(inputPosition, inputDirection, "Start");
    }
}