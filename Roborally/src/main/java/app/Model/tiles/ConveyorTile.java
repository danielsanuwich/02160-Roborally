package app.Model.tiles;

import app.Model.board.*;

public class ConveyorTile extends Tile{

    // ConveyorTile constructor
    public ConveyorTile(Position inputPosition,Direction inputDirection){
        super(inputPosition, inputDirection, "Conveyor");
    }
}