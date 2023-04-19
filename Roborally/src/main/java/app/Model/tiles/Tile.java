public class Tile{ 

    private enum TileType { // stores the type of tile 
        BASE_TILE,
        HOLE,
        CONVEYOR_NORMAL,
        CONVEYOR_EXPRESS,
        GEAR_CLOCKWISE,
        GEAR_COUNTERCLOCKWISE,
        REPAIR_ONE,
        REPAIR_TWO,
        START;


    private Position position; // stores the position of the tile 
    private Direction direction; // stores direction of tile 

    // tile class constructor 
    public Tile(Position inputPosition; TileType type; Direction inputDirection = 0){
        this.position.setPosition(inputPosition.getX, inputPosition.getY);
        this.TileType = type; 
    }

    // Tile setters 
    public void setPosition(Position initPosition){
        this.position = initPosition;
    }    
    public void setType(X initType){
        this.TileType = initType;
    }    
    public void setDirection(X initDirection){
        this.direction = initDirection;
    }

    // Tile getters 
    public Position getPosition(){
        return this.position;
    }
    public TileType getType(){
        return this.TileType;
    }
    public Direction getDirection(){
        return this.direction;
    }    
}