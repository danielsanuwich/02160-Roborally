package app.Model;

import app.Model.board.*;
import app.Model.tiles.*;
import app.Model.cards.*;

public class GameLogic {
    Position initialPos1;
    Position initialPos2;
    Direction initialDirection1;
    Direction initialDirection2;
    int initialHealth;

    Robot robot1;
    Robot robot2;

    GameBoard board;

    // gamelogic constructor
    public GameLogic() {

        // specify stating attributes for the robots
        this.initialPos1 = new Position(5, 5);
        this.initialPos2 = new Position(5, 4);
        this.initialDirection1 = new Direction(0);
        this.initialDirection2 = new Direction(0);
        this.initialHealth = 10;

        //

        // make robots
        this.robot1 = new Robot(initialPos1, initialDirection1, initialHealth, 1, "Alice");
        this.robot2 = new Robot(initialPos2, initialDirection2, initialHealth, 2, "Bob");

        // make gameboard
        this.board = new GameBoard(10, 10);

    }

    public GameLogic(Position initialPos1, Position initialPos2, Direction initialDirection1,
            Direction initialDirection2,
            int initialHealth, Robot robot1, Robot robot2, GameBoard board) {

        // specify stating attributes for the robots
        this.initialPos1 = initialPos1;
        this.initialPos2 = initialPos2;
        this.initialDirection1 = initialDirection1;
        this.initialDirection2 = initialDirection2;
        this.initialHealth = initialHealth;

        //

        // make robots
        this.robot1 = robot1;
        this.robot2 = robot2;

        // make gameboard
        this.board = board;

    }

    // is even helper method for the move method
    private boolean isEven(Position pos) {
        if (pos.getX() % 2 == 0)
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
                switch (initDirection.getDirection() % 6) {
                    case 0:
                        pos1.setPosition(pos1.getX() + 0, pos1.getY() - 1);
                        break;
                    case 1:
                        pos1.setPosition(pos1.getX() + 1, pos1.getY() - 0);
                        break;
                    case 2:
                        pos1.setPosition(pos1.getX() + 1, pos1.getY() + 1);
                        break;
                    case 3:
                        pos1.setPosition(pos1.getX() + 0, pos1.getY() + 1);
                        break;
                    case 4:
                        pos1.setPosition(pos1.getX() - 1, pos1.getY() + 1);
                        break;
                    case 5:
                        pos1.setPosition(pos1.getX() - 1, pos1.getY() + 0);
                        break;
                }
            } else { // position is odd
                switch (initDirection.getDirection() % 6) {
                    case 0:
                        pos1.setPosition(pos1.getX() + 0, pos1.getY() - 1);
                        break;
                    case 1:
                        pos1.setPosition(pos1.getX() + 1, pos1.getY() - 1);
                        break;
                    case 2:
                        pos1.setPosition(pos1.getX() + 1, pos1.getY() - 0);
                        break;
                    case 3:
                        pos1.setPosition(pos1.getX() + 0, pos1.getY() + 1);
                        break;
                    case 4:
                        pos1.setPosition(pos1.getX() - 1, pos1.getY() + 0);
                        break;
                    case 5:
                        pos1.setPosition(pos1.getX() - 1, pos1.getY() - 1);
                        break;
                }
            }
            return move(pos1, initDirection, stepsToMove - 1); // make recursive call
        }
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
    void moveRobots(Robot robot, Direction directionToMove) {
        Position nextPosition = move(robot.getPosition(), directionToMove, 1); // find next position given current
                                                                               // position and a direction
        if (robotsAtThisPosition(nextPosition) == 1) { // if robot 1 in the way, move it out of the way
            moveRobots(robot1, directionToMove);
        }

        if (robotsAtThisPosition(nextPosition) == 2) { // if robot 2 in the way, move it out of the way
            moveRobots(robot2, directionToMove);
        }

        robot.setPosition(nextPosition); // move desired robot

    }

    // update robots based on the tile type
    private void updateFromTile(Robot robot, GameBoard gb) {
        Tile currentTile = gb.getTile(robot.getPosition());
        if (currentTile instanceof ConveyorTile) {
            // move accordingly
            moveRobots(robot, currentTile.getDirection());

        } else if (currentTile instanceof TurnTile) {
            // turn accordingly
            TurnTile cTile = (TurnTile) currentTile;
            robot.setDirection(new Direction(robot.getDirection().getDirection() + cTile.getTurnAmount()));

        } else if (currentTile instanceof HoleTile) {
            // return to a start position and take damage
            robot.changeHealth(-((HoleTile) currentTile).getDamage());
            robot.setPosition(gb.nearestStartTile(robot.getPosition()));

        } else if (currentTile instanceof LaserTile) {
            // take damage
            LaserTile cTile = (LaserTile) currentTile;
            robot.changeHealth(-1 * cTile.getDamage());
        }
    }

    // specify what happens each turn
    public void ExcecuteTurn(Card card, Robot robot, GameBoard gb) {
        // check which type of card it is:

        // card is a program card
        if (card instanceof ProgramCard) {
            // turn robot
            ProgramCard currentCard = (ProgramCard) card;
            robot.setDirection(new Direction(robot.getDirection().getDirection() + currentCard.getTurnAmount()));

            // move robot (careful!)
            for (int i = 0; i < currentCard.getMoveAmount(); i++) {
                moveRobots(robot, robot.getDirection());
                updateFromTile(robot, gb);
            }

            // card is a health card
        } else if (card instanceof HealthCard) {
            HealthCard currentCard = (HealthCard) card;
            robot.changeHealth(currentCard.getDiffHealth());
        } else {
            System.out.println("Problem with Executing card types");
        }
    }

}