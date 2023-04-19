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
    private int direction; // stores direction of tile 
    private boolean isHole = false; // stores void/hole property of tile 

    // tile class constructor 
    public Tile(Position inputPosition; TileType type; Direction inputDirection = 0){
        position.x = inputPosition.x;
        position.y = inputPosition.y;
        this.TileType = type; 
        if(type == Hole){
            isHole = true;
        } 
        direction = inputDirection % 6; 
    }

    // Tile setters 

    // Tile getters 

}