package app.Model;

import app.Model.board.*;
import app.Model.tiles.*;
import app.Model.cards.*;

import java.util.LinkedList;
import java.util.HashSet;

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
    Position move(Position pos1, Direction initDirection, int stepsToMove) {
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
        // Use '.equals()' for accurate content comparison, as '==' checks if references
        // point to the same object.
        if (robot1.getPosition().equals(pos))
            return 1;
        if (robot2.getPosition().equals(pos))
            return 2;

        else
            return 0;
    }

    // Moves the given robot in the specified direction. If the robot encounters
    // another robot in its path, it will push that robot along in the same
    // direction.
    public void moveRobots(Robot robot, Direction directionToMove) {
        HashSet<Robot> processedRobots = new HashSet<>();
        LinkedList<Robot> robotsToProcess = new LinkedList<>();
        robotsToProcess.add(robot);

        while (!robotsToProcess.isEmpty()) {
            Robot currentRobot = robotsToProcess.poll();
            processedRobots.add(currentRobot);

            Position newPos = move(currentRobot.getPosition(), directionToMove, 1);
            int robotIdAtNewPos = robotsAtThisPosition(newPos);
            Robot robotAtNewPos = null;

            if (robotIdAtNewPos == 1) {
                robotAtNewPos = robot1;
            } else if (robotIdAtNewPos == 2) {
                robotAtNewPos = robot2;
            }

            if (robotAtNewPos != null && !processedRobots.contains(robotAtNewPos)) {
                robotsToProcess.add(robotAtNewPos);
            }

            currentRobot.setPosition(newPos);
        }
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
    public void ExecuteTurn(Card card, Robot robot, GameBoard gb) {
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
