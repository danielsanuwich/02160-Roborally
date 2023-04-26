package app.Model.tiles;

import app.Model.board.Position;
import app.Model.board.Direction;

public class Tile {
    private String type; // stores the type of tile
    private Position position; // stores the position of the tile
    private Direction direction; // stores direction of tile

    // tile class constructor
    public Tile(String type, Position position, Direction direction) {
        this.position = position;
        this.type = type;
        this.direction = direction;
    }

    public Tile(Position inputPosition, Direction inputDirection, String string) {
    }

    // Tile setters
    public void setPosition(Position position) {
        this.position = position;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setDirection(Direction direction) {
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
