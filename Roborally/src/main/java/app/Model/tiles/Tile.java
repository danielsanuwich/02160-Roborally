package app.Model.tiles;

import app.Model.board.Direction;
import app.Model.board.Position;

public class Tile {
    private final String type; // stores the type of tile
    private final Position position; // stores the position of the tile
    private final Direction direction; // stores direction of tile

    // tile class constructor
    public Tile(Position position, Direction direction, String type) {
        this.type = type;
        this.position = position;
        this.direction = direction;
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
