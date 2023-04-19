public class GameLogic{

    // is even helper method for the move method 
private boolean isEven(Position pos){
    if(pos.getPosition % 2 == 0) return true;
    else return false;
}

    // move method
private Position move(Position pos1; Direction initDirection; int stepsToMove) {
    // base case 
    if(stepsToMove == 0) {
        return pos1;
    }
    else { // recursive case
        if(isEven(pos1)) { // position is even
            switch(initDirection.getDirection % 6){
                case 0:
                    pos1.setX(pos1.getX() + 0);
                    pos1.setY(pos1.getY() - 1);
                break;
                case 1:
                    pos1.setX(pos1.getX() + 1);
                    pos1.setY(pos1.getY() + 0);
                break;
                case 2:
                    pos1.setX(pos1.getX() + 1);
                    pos1.setY(pos1.getY() + 1);
                break;
                case 3:
                    pos1.setX(pos1.getX() + 0);
                    pos1.setY(pos1.getY() + 1);
                break;
                case 4:
                    pos1.setX(pos1.getX() - 1);
                    pos1.setY(pos1.getY() + 1);
                break;
                case 5:
                    pos1.setX(pos1.getX() - 1);
                    pos1.setY(pos1.getY() + 0);
                break;
            }
        }
        else { // position is odd
            switch(this.direction % 6){
                case 0:
                    pos1.setX(pos1.getX() + 0);
                    pos1.setY(pos1.getY() - 1);
                break;
                case 1:
                    pos1.setX(pos1.getX() + 1);
                    pos1.setY(pos1.getY() - 1);
                break;
                case 2:
                    pos1.setX(pos1.getX() + 1);
                    pos1.setY(pos1.getY() + 0);
                break;
                case 3:
                    pos1.setX(pos1.getX() + 0);
                    pos1.setY(pos1.getY() + 1);
                break;
                case 4:
                    pos1.setX(pos1.getX() - 1);
                    pos1.setY(pos1.getY() + 0);
                break;
                case 5:
                    pos1.setX(pos1.getX() - 1);
                    pos1.setY(pos1.getY() - 1);
                break;
            }
        }
    }


public GameLogic(){


// specify starting positions
Position initialPos1;
Position initialP
// 

    // make robots 
    Robot robot1 = new Robot();
    Robot robot2 = new Robot();



    // make gameboard

}

    // specify what happens each turn


    // make function to specify how to update robot attributes based on tile type at its location 
    
    private boolean robotsAtThisPosition(){

    }


    // robot movement function to allow for bumping and pushing 
    int moveRobots(Robot robot1; Direction directionToMove){
        
    }



// update robot attributes based on tile position 
    switch(/* TileType with same position as robot*/) {
        case (BASE_TILE):
            
            break;
        case (HOLE):
            
            break;
        case (CONVEYOR_NORMAL):
            
            break;
        case (CONVEYOR_EXPRESS):
            
            break;
        case (GEAR_CLOCKWISE):
            
            break;
        case (GEAR_COUNTERCLOCKWISE):
            
            break;
        case (REPAIR_ONE):
            
            break;
        case (REPAIR_TWO):
            
            break;
        case (START):
            
            break;
      }
      






}