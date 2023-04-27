package app.Model.tiles;

import app.Model.board.Direction;
import app.Model.board.Position;

public class ConveyorTile extends Tile {

    public ConveyorTile(Position position, Direction conveyorDirection) {
        super("Conveyor", position, conveyorDirection);
    }
}
