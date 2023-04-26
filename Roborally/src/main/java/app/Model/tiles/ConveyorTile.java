package app.Model.tiles;

import app.Model.board.Direction;
import app.Model.board.Position;

public class ConveyorTile extends Tile {

    // The direction of the conveyor belt

    // ConveyorTile constructor
    public ConveyorTile(Position position, Direction conveyorDirection) {
        super(position, conveyorDirection, "Conveyor");
    }

}