package app.Model.tiles;

import app.Model.board.Direction;
import app.Model.board.Position;

public class FlagTile extends Tile {

    // The direction of the conveyor belt

    // ConveyorTile constructor
    public FlagTile(Position position, Direction conveyorDirection) {
        super(position, conveyorDirection, "Flag");
    }

}