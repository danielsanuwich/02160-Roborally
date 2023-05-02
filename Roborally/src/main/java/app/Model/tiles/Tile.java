package app.Model.tiles;

import app.Model.board.Direction;
import app.Model.board.Position;


public class Tile {

    // Tile Attributes 
    private String type = "Base"; // default type
    private Position position;
    private Direction direction = new Direction(0); // default direction

    // Tile Constructors
    public Tile(){}

    public Tile(Position position) {
        this.position = position;
    }
    public Tile(String type, Position position) {
        this.type = type;
        this.position = position;
    }
    public Tile(String type, Position position, Direction direction) {
        this.type = type;
        this.position = position;
        this.direction = direction;
    }
    public Tile(Position inputPosition,Direction inputDirection,String string){}



    // Tile Setters
    public void setPosition(Position position) {
        this.position = position;
    }
    public void setType(String type) {
        this.type = type;
    }
    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    // Tile Getters
    public Position getPosition() {
        return this.position;
    }
    public String getType() {
        return this.type;
    }
    public Direction getDirection() {
        return this.direction;
    }

    // debug info if needed 
    @Override
    public String toString() {
        return "Tile{" +
                "type='" + type + '\'' +
                ", position=" + position +
                ", direction=" + direction +
                '}';
    }

}


