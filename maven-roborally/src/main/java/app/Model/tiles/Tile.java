import app.Model.board.Position;
//import position
//import direction


public class Tile { 
    public enum TileType { // stores the type of tile 
        BASE_TILE,
        HOLE,
        CONVEYOR_NORMAL,
        CONVEYOR_EXPRESS,
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
    public Tile(Position inputPosition, TileType type, Direction inputDirection = null){
        this.position.setPosition(inputPosition.getX(), inputPosition.getY());
        this.tileType = type; 
        this.direction = inputDirection;
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
