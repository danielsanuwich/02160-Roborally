package app.Model;

import app.Model.board.Direction;
import app.Model.board.GameBoard;
import app.Model.board.Position;
import app.Model.cards.Card;
import app.Model.tiles.Tile;

public class GameLogic{
	

    // is even helper method for the move method 
    private boolean isEven(Position pos){
        if(pos.getX() % 2 == 0) return true;
        else return false;
    }

    // move method
    private Position move(Position pos1, Direction initDirection, int stepsToMove) {
        // base case 
        if(stepsToMove == 0) {
            return pos1;
        }
        else { // recursive case
            if(isEven(pos1)) { // position is even
                switch(initDirection.getDirection() % 6){
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
                switch(initDirection.getDirection() % 6){
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
            return move(pos1, initDirection, stepsToMove-1); // make recursive call
        }
    }

    
    private Robot robot1;
    private Robot robot2;
    
    // gamelogic constructor
    public GameLogic(){


        // specify stating attributes for the robots
        Position initialPos1 = new Position(5,5);
        Position initialPos2 = new Position(5,4);
        Direction initialDirection1 = new Direction(0);
        Direction initialDirection2 = new Direction(0);
        int initialHealth = 10;

        // make robots 
        robot1 = new Robot(initialPos1,initialDirection1,initialHealth,1,"Alice");
        robot2 = new Robot(initialPos2,initialDirection2,initialHealth,2,"Bob");

    }

    // function to specify if a robot is at a certain position
    private int robotsAtThisPosition(Position pos){
        if(robot1.getPosition() == pos) return 1;
        if(robot2.getPosition() == pos) return 2;
        else return 0;
    }

    // robot movement function to allow for bumping and pushing 
    private void moveRobots(Robot robot, Direction directionToMove){
        Position nextPosition = move(robot.getPosition(), directionToMove, 1); // find next position given current position and a direction

        if(robotsAtThisPosition(nextPosition) == 1){ // if robot 1 in the way, move it out of the way
            moveRobots(robot1, directionToMove);
        }

        if(robotsAtThisPosition(nextPosition) == 2){ // if robot 2 in the way, move it out of the way
            moveRobots(robot2, directionToMove);
        }
        
        robot.setPosition(nextPosition); // move desired robot

    }
    
    // make gameboard
    GameBoard board = new GameBoard(10,10);


    // update robot attributes based on tile position 
    private void updateFromTile(Robot robot, GameBoard gb){
        Tile currentTile = gb.getTile(robot.getPosition());
        switch(currentTile.getType()) { // check the tile type which the robot is on
            case BASE_TILE:
                // do nothing 
                break;
            case HOLE:
                // return robot to closest start position
            	//TODO what happens when you enter hole
            	
            	
            	robot.setHealth(robot.getHealth()-3);
                break;
            case CONVEYOR_NORMAL:
                // move robot by one in direction of the conveyer
                moveRobots(robot,currentTile.getDirection());
                break;
            case GEAR_CLOCKWISE:
                // rotate robot clockwise (right)
            	Direction originalDirectionCW = robot.getDirection();
            	Direction newDirectionCW = new Direction(originalDirectionCW.getDirection() + 1);
            	robot.setDirection(newDirectionCW);
                break;
            case GEAR_COUNTERCLOCKWISE:
                // rotate robot counterclockwise (left)
            	Direction originalDirectionCCW = robot.getDirection();
            	Direction newDirectionCCW = new Direction(originalDirectionCCW.getDirection() - 1);
            	robot.setDirection(newDirectionCCW);
                break;
            case REPAIR_ONE:
                // increase health by 1
                robot.setHealth(robot.getHealth()+1);
                break;
            case REPAIR_TWO:
                // increase health by 2
                robot.setHealth(robot.getHealth()+2);
                break;
            case START:
                // do nothing 
                break;
        }
        
    }


    // specify what happens each turn
    
    public void updateFromCard(Card card, Robot robot, GameBoard gb) {
    	
    	
    	switch(card.getAttribute()) {	
    		case "MOVE_ONE":
    			moveRobots(robot, robot.getDirection());
    			updateFromTile(robot, gb);
    			break;
    		case "MOVE_TWO":
    			moveRobots(robot, robot.getDirection());
    			updateFromTile(robot, gb);
    			moveRobots(robot, robot.getDirection());
    			updateFromTile(robot, gb);
    			
    			//
    			break;
    		case "MOVE_THREE":
    			moveRobots(robot, robot.getDirection());
    			updateFromTile(robot, gb);
    			moveRobots(robot, robot.getDirection());
    			updateFromTile(robot, gb);
    			moveRobots(robot, robot.getDirection());
    			updateFromTile(robot, gb);
    			//
    			break;
    		case "BACK_UP":
            	Direction newDirection = new Direction((robot.getDirection().getDirection()+3));
    			moveRobots(robot, newDirection);
    			updateFromTile(robot, gb);
    			//
    			break;
    		case "TURN_CLOCKWISE":
    			robot.setDirection(new Direction((robot.getDirection().getDirection()+1)));
    			updateFromTile(robot, gb);
    			//
    			break;
    		case "GEAR_COUNTERCLOCKWISE":
    			robot.setDirection(new Direction((robot.getDirection().getDirection()-1)));
    			updateFromTile(robot, gb);
    			//
    			break;
    		case "U_TURN":
    			robot.setDirection(new Direction((robot.getDirection().getDirection()+3)));
    			updateFromTile(robot, gb);
    			//
    			break;
    			
    			
    

    	}
    }

    //TODO main turn function - select robot based on cards player and pass relevant into updateFromCard
    //Method above will be used in controller -> Make controller

}