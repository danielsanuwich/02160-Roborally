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
    }

    // gamelogic constructor
    public GameLogic(){


        // specify stating attributes for the robots
        Position initialPos1 = new Postion(5;5);
        Position initialPos2 = new Postion(5;4);
        Direction initialDirection1 = newDirection(0);
        Direction initialDirection2 = newDirection(0);
        int initialHealth = 10;

        // 

        // make robots 
        Robot robot1 = new Robot(initialPosition1;initialDirection1;initialHealth;1;"Alice");
        Robot robot2 = new Robot(initialPosition2;initialDirection2;initialHealth;2;"Bob");


        // make gameboard
        GameBoard board = new GameBoard(10;10);

    }

    // function to specify if a robot is at a certain position
    private int robotsAtThisPosition(Position pos){
        if(robot1.getPosition == pos) return 1;
        if(robot2.getPosition == pos) return 2;
        else return 0;
    }

    // robot movement function to allow for bumping and pushing 
    private void moveRobots(Robot robot; Direction directionToMove){
        Position nextPosition = move(robot.getPosition; directionToMove; 1)  // find next position given current position and a direction

        if(robotsAtThisPosition(nextPosition) == 1){ // if robot 1 in the way, move it out of the way
            moveRobots(robot1; directionToMove);
        }

        if(robotsAtThisPosition(nextPosition) == 2){ // if robot 2 in the way, move it out of the way
            moveRobots(robot2; directionToMove);
        }
        
        robot.setPosition = nextPostition; // move desired robot

    }


    // update robot attributes based on tile position 
    private void updateRobot(Robot robot; GameBoard gb){
        Tile currentTile = gb.getTile(robot.getPosition);
        switch(currentTile.getType) { // check the tile type which the robot is on
            case (BASE_TILE):
                // do nothing 
                break;
            case (HOLE):
                // return robot to closest start position
                break;
            case (CONVEYOR_NORMAL):
                // move robot by one in direction of the conveyer
                moveRobots(robot;currentTile.getDirection);
                break;
            case (CONVEYOR_EXPRESS):
                // move robot by one twice in direction of the conveyer
                moveRobots(robot;currentTile.getDirection);
                moveRobots(robot;currentTile.getDirection);
                break;
            case (GEAR_CLOCKWISE):
                // rotate robot clockwise (right)
                robot.setDirection(robot.getDirection+1);
                break;
            case (GEAR_COUNTERCLOCKWISE):
                // rotate robot counterclockwise (left)
                robot.setDirection(robot.getDirection-1);
                break;
            case (REPAIR_ONE):
                // increase health by 1
                robot.setHealth(robot.getHealth+1);
                break;
            case (REPAIR_TWO):
                // increase health by 2
                robot.setHealth(robot.getHealth+2);
                break;
            case (START):
                // do nothing 
                break;
        }
        
    }

public class Player{

    // player attributes 
    private int playerNumber;
    private String playerName;

    // player constrcutor 
    public class Player(int num, String name){
        this.playerNumber = num;
        this.playerName = name;
    }

    // player setters 
    public void setPlayerNumber(int num){
        this.playerNumber = num;
    }
    public void setPlayerName(String name){
        this.playerName = name;
    }

    // player getters
    public int getPlayerNumber(){
        return this.playerNumber;
    }
    public String getPlayerName(){
        return this.playerName;
    }
}

public class Card{
    // card attribute 
    private Player cardPlayer;

    // card constructor
    public Card(Player inputPlayer){
        this.cardPlayer = inputPlayer;
    }

    // card setter
    public void setCardPlayer(Player inputPlayer){
        this.cardPlayer = inputPlayer;
    }

    // card getter
    public Player getCardPlayer(){
        return this.cardPlayer;
    }

}


public class ProgramCard extends Card{

// programCard attributes
private int turnAmount;
private int moveSteps;

// programCard constructor
public ProgramCard(int turnAmount, int moveAmount){

    // card can only move or turn; not both
    if(turnAmount == 0){
        this.moveSteps = moveAmount;
    }else{
        this.turnAmount = turnAmount;
    }

}

// programCard getters
public int getTurnAmount(){
    return this.turnAmount;
}
public int getMoveAmount(){
    return this.moveAmount;
}

}


public class UpgradeCard extends Card{
    
// upgradeCard attributes


// upgradeCard constructor


// upgradeCard setters


// upgradeCard getters



}




    // specify what happens each turn
public void ExcecuteTurn(Card card){
    // check which type of card it is 
    
    // move card:
    


    // update card:


}


}