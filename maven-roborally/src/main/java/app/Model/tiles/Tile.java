package app.Model.tiles;

import app.Model.board.Position;
import app.Model.board.Direction;

public class Tile { 
    public enum TileType { // stores the type of tile 
        BASE_TILE,
        HOLE,
        CONVEYOR_NORMAL,
        GEAR_CLOCKWISE,
        GEAR_COUNTERCLOCKWISE,
        REPAIR_ONE,
        REPAIR_TWO,
        START;
    }
    
    private Position position; // stores the position of the tile 
    private Direction direction; // stores direction of tile 
    private TileType tileType; // stores the type of the tile

    // tile class constructor 
    public Tile(Position inputPosition, TileType type, Direction inputDirection){
        this.position = new Position(inputPosition.getX(), inputPosition.getY());
        this.tileType = type; 
        this.direction = inputDirection;
    }

    // Overloaded constructor with default inputDirection value as null
    public Tile(Position inputPosition, TileType type) {
        this(inputPosition, type, null);
    }

    // Tile setters 
    public void setPosition(Position initPosition){
        this.position = initPosition;
    }    
    public void setType(TileType initType){
        this.tileType = initType;
    }    
    public void setDirection(Direction initDirection){
        this.direction = initDirection;
    }

    // Tile getters 
    public Position getPosition(){
        return this.position;
    }
    public TileType getType(){
        return this.tileType;
    }
    public Direction getDirection(){
        return this.direction;
    }    
}
