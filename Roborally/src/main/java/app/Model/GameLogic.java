package app.Model;

import app.Model.board.*;
import app.Model.tiles.*;
import app.Model.cards.*;

public class GameLogic {

    // is even helper method for the move method
    private boolean isEven(Position pos) {
        if (pos.getPosition % 2 == 0)
            return true;
        else
            return false;
    }

    // move method
    private Position move(Position pos1, Direction initDirection, int stepsToMove) {
        // base case
        if (stepsToMove == 0) {
            return pos1;
        } else { // recursive case
            if (isEven(pos1)) { // position is even
                switch (initDirection.getDirection % 6) {
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
            } else { // position is odd
                switch (initDirection.getDirection % 6) {
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
            return move(pos1, initDirection, stepsToMove - 1); // make recursive call
        }
    }

    // gamelogic constructor
    public GameLogic() {

        // specify stating attributes for the robots
        Position initialPos1 = new Position(5, 5);
        Position initialPos2 = new Position(5, 4);
        Direction initialDirection1 = new Direction(0);
        Direction initialDirection2 = new Direction(0);
        int initialHealth = 10;

        //

        // make robots
        Robot robot1 = new Robot(initialPos1, initialDirection1, initialHealth, 1, "Alice");
        Robot robot2 = new Robot(initialPos2, initialDirection2, initialHealth, 2, "Bob");

        // make gameboard
        GameBoard board = new GameBoard(10, 10);

    }

    // function to specify if a robot is at a certain position
    private int robotsAtThisPosition(Position pos) {
        // '==' compares object references (memory locations), while '.equals()'
        // compares actual content of objects.
        // Use '.equals()' for accurate content comparison, as '==' checks if references
        // point to the same object.
        if (robot1.getPosition().equals(pos))
            return 1;
        if (robot2.getPosition().equals(pos))
            return 2;

        else
            return 0;
    }

    // robot movement function to allow for bumping and pushing
    private void moveRobots(Robot robot, Direction directionToMove){
        Position nextPosition = move(robot.getPosition, directionToMove, 1)  // find next position given current position and a direction

        if(robotsAtThisPosition(nextPosition) == 1){ // if robot 1 in the way, move it out of the way
            moveRobots(robot1, directionToMove);
        }

        if(robotsAtThisPosition(nextPosition) == 2){ // if robot 2 in the way, move it out of the way
            moveRobots(robot2, directionToMove);
        }
        
        robot.setPosition = nextPostition; // move desired robot

    }


        // update robots based on the tile type
    private void updateFromTile(Robot robot, GameBoard gb){
        Tile currentTile = gb.getTile(robot.getPosition);
        if(currentTile instanceof ConveyerTile){
            // move accordingly
            moveRobots(robot,currentTile.getDirection);

        }else if(currentTile instanceof TurnTile){
            // turn accordingly
            robot.setDirection = robot.getDirection.getDirection + currentTile.getTurnAmount

        }else if(currentTile instanceof HoleTile){
            // return to a start position
            robot.setPosition(gb.nearestStartTile(robot.getPosition));

        }else if(currentTile instanceof LaserTile){
            // take damage
            robot.changeHealth(-1 * currentTile.getDamage())
        }
    }

    // specify what happens each turn
    public void ExcecuteTurn(Card card, Robot robot, GameBoard gb) {
        // check which type of card it is:

        // card is a program card
        if (card instanceof ProgramCard) {
            // turn robot
            robot.setDirection(robot.getDirection.getDirection + card.turnAmount);

            // move robot (careful!)
            for (int i = 0; i < card.moveAmount; i++) {
                moveRobots(robot, robot.getDirection);
                updateFromTile(robot, gb);
            }

            // card is a health card
        } else if (card instanceof HealthCard) {
            robot.changeHealth(card.getDiffHealth());
        } else { System.java.printl("Problem with Executing card types");}

    }

}




