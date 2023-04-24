import app.Model.board.Position;
//import position
//import direction


public class Tile { 
    private String tileType; // stores the type of tile 
    private Position position; // stores the position of the tile 
    private Direction direction; // stores direction of tile 
    private TileType tileType; // stores the type of the tile

    // tile class constructor 
    public Tile(Position inputPosition, String type, Direction inputDirection = null){
        this.position.setPosition(inputPosition.getX(), inputPosition.getY());
        this.tileType = type; 
        this.direction = inputDirection;
    }

    // Tile setters 
    public void setPosition(Position initPosition){
        this.position = initPosition;
    }    
    public void setType(String initType){
        this.tileType = initType;
    }    
    public void setDirection(Direction initDirection){
        this.direction = initDirection;
    }

    // Tile getters 
    public Position getPosition(){
        return this.position;
    }
    public String getType(){
        return this.tileType;
    }
    public Direction getDirection(){
        return this.direction;
    }    
}
