package app.Model.tiles;

import app.Model.board.Direction;
import app.Model.board.Position;

public class Tile {
    private final String type; // stores the type of tile
    private final Position position; // stores the position of the tile
    private final Direction direction; // stores direction of tile

    // tile class constructor
    public Tile(Position position2, Direction direction2, String string) {
        this.type = position2;
        this.position = direction2;
        this.direction = string;
    }

    // Tile getters
    public Position getPosition() {
        return this.position;
    }

    public String getType() {
        return this.type;
    }

    public Direction getDirection() {
        return this.direction;
    }
}
