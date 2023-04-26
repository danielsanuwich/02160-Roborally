package app.Model.tiles;

import app.Model.board.Direction;
import app.Model.board.Position;

public class HoleTile extends Tile {

    // HoleTile constructor
    public HoleTile(Position inputPosition, Direction inputDirection) {
        super(inputPosition, inputDirection, "Hole");
    }
}