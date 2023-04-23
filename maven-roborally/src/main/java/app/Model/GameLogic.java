package app.Model;

import app.Model.board.Direction;
import app.Model.board.GameBoard;
import app.Model.board.Position;
import app.Model.cards.Card;
import app.Model.tiles.Tile;

public class GameLogic {
    
    // Instance variables
    private final Robot robot1;
    private final Robot robot2;
    private final GameBoard board;

    // GameLogic constructor
    public GameLogic() {
        // Initialize starting attributes for the robots
        Position initialPos1 = new Position(5, 5);
        Position initialPos2 = new Position(5, 4);
        Direction initialDirection1 = new Direction(0);
        Direction initialDirection2 = new Direction(0);
        int initialHealth = 10;

        // Create robots
        robot1 = new Robot(initialPos1, initialDirection1, initialHealth, 1, "Alice");
        robot2 = new Robot(initialPos2, initialDirection2, initialHealth, 2, "Bob");

        // Create game board
        board = new GameBoard(10, 10);
    }

    // Helper method to check if a position is even
    private boolean isEven(Position pos) {
        return pos.getX() % 2 == 0;
    }

    // Method to move a position in a given direction by a certain number of steps
    private Position move(Position pos1, Direction initDirection, int stepsToMove) {
        // Base case: no steps remaining
        if (stepsToMove == 0) {
            return pos1;
        } else {
            // Recursive case: update position based on direction and parity
            Position newPos = new Position(pos1.getX(), pos1.getY());
            if (isEven(newPos)) {
                // Update position based on direction if even
                switch (initDirection.getDirection() % 6) {
                    case 0:
                        newPos.setY(newPos.getY() - 1);
                        break;
                    case 1:
                        newPos.setX(newPos.getX() + 1);
                        break;
                    case 2:
                        newPos.setX(newPos.getX() + 1);
                        newPos.setY(newPos.getY() + 1);
                        break;
                    case 3:
                        newPos.setY(newPos.getY() + 1);
                        break;
                    case 4:
                        newPos.setX(newPos.getX() - 1);
                        newPos.setY(newPos.getY() + 1);
                        break;
                    case 5:
                        newPos.setX(newPos.getX() - 1);
                        break;
                }
            } else {
                // Update position based on direction if odd
                switch (initDirection.getDirection() % 6) {
                    case 0:
                        newPos.setY(newPos.getY() - 1);
                        break;
                    case 1:
                        newPos.setX(newPos.getX() + 1);
                        newPos.setY(newPos.getY() - 1);
                        break;
                    case 2:
                        newPos.setX(newPos.getX() + 1);
                        break;
                    case 3:
                        newPos.setY(newPos.getY() + 1);
                        break;
                    case 4:
                        newPos.setX(newPos.getX() - 1);
                        break;
                    case 5:
                        newPos.setX(newPos.getX() - 1);
                        newPos.setY(newPos.getY() - 1);
                        break;
                }
            }
            // Recursively call move() for the remaining steps
            return move(newPos, initDirection, stepsToMove - 1);
        }
    }

    // Method to check if a robot is at a certain position and return its ID
    private int robotsAtThisPosition(Position pos) {
        if (robot1.getPosition().equals(pos)) return 1;
        if (robot2.getPosition().equals(pos)) return 2;
        return 0;
    }

    // Method to move a robot in a given direction, taking into account bumping and pushing other robots
    private void moveRobots(Robot robot, Direction directionToMove) {
        Position nextPosition = move(robot.getPosition(), directionToMove, 1); // Find next position given current position and a direction

        int robotAtNextPosition = robotsAtThisPosition(nextPosition);
        if (robotAtNextPosition == 1) { // If robot 1 is in the way, move it out of the way
            moveRobots(robot1, directionToMove);
        } else if (robotAtNextPosition == 2) { // If robot 2 is in the way, move it out of the way
            moveRobots(robot2, directionToMove);
        }

        robot.setPosition(nextPosition); // Move the desired robot
    }

    // Method to update robot attributes based on the tile at its position
    private void updateFromTile(Robot robot, GameBoard gb) {
        Tile currentTile = gb.getTile(robot.getPosition());
        switch (currentTile.getType()) { // Check the tile type the robot is on
            case BASE_TILE:
                // Do nothing
                break;
            case HOLE:
                // Return robot to the closest start position or apply any other penalty
                robot.setHealth(robot.getHealth() - 3);
                break;
            case CONVEYOR_NORMAL:
                // Move robot by one in the direction of the conveyer
                moveRobots(robot, currentTile.getDirection());
                break;
            case GEAR_CLOCKWISE:
                // Rotate robot clockwise (right)
                Direction originalDirectionCW = robot.getDirection();
                Direction newDirectionCW = new Direction(originalDirectionCW.getDirection() + 1);
                robot.setDirection(newDirectionCW);
                break;
            case GEAR_COUNTERCLOCKWISE:
                // Rotate robot counterclockwise (left)
                Direction originalDirectionCCW = robot.getDirection();
                Direction newDirectionCCW = new Direction(originalDirectionCCW.getDirection() - 1);
                robot.setDirection(newDirectionCCW);
                break;
            case REPAIR_ONE:
                // Increase health by 1
                robot.setHealth(robot.getHealth() + 1);
                break;
            case REPAIR_TWO:
                // Increase health by 2
                robot.setHealth(robot.getHealth() + 2);
                break;
            case START:
                // Do nothing
                break;
        }
    }

    // Method to update the game state based on a played card and a robot
    public void updateFromCard(Card card, Robot robot, GameBoard gb) {
        switch (card.getAttribute()) {
            case MOVE_ONE:
                moveRobots(robot, robot.getDirection());
                updateFromTile(robot, gb);
                break;
            case MOVE_TWO:
                moveRobots(robot, robot.getDirection());
                updateFromTile(robot, gb);
                moveRobots(robot, robot.getDirection());
                updateFromTile(robot, gb);
                break;
            case MOVE_THREE:
                moveRobots(robot, robot.getDirection());
                updateFromTile(robot, gb);
                moveRobots(robot, robot.getDirection());
                updateFromTile(robot, gb);
                moveRobots(robot, robot.getDirection());
                updateFromTile(robot, gb);
                break;
            case BACK_UP:
                Direction newDirection = new Direction((robot.getDirection().getDirection() + 3));
                moveRobots(robot, newDirection);
                updateFromTile(robot, gb);
                break;
            case TURN_CLOCKWISE:
                robot.setDirection(new Direction((robot.getDirection().getDirection() + 1)));
                updateFromTile(robot, gb);
                break;
            case TURN_COUNTERCLOCKWISE:
                robot.setDirection(new Direction((robot.getDirection().getDirection() - 1)));
                updateFromTile(robot, gb);
                break;
            case U_TURN:
                robot.setDirection(new Direction((robot.getDirection().getDirection() + 3)));
                updateFromTile(robot, gb);
                break;
        }
    }
    
    /**
     * Main turn function that takes an array of cards for each robot and
     * updates the game state accordingly.
     * 
     * @paramcardsForRobot1 array of cards played by Robot 1
     * @paramcardsForRobot2 array of cards played by Robot 2
     */
    public void playTurn(Card[] cardsForRobot1, Card[] cardsForRobot2) {
        // Update game state for robot1 based on the cards played
        for (Card card : cardsForRobot1) {
            updateFromCard(card, robot1, board);
        }

        // Update game state for robot2 based on the cards played
        for (Card card : cardsForRobot2) {
            updateFromCard(card, robot2, board);
     
        }
    }
}

	
	// Main turn function: Select robot based on the cards played and pass the relevant information to updateFromCard
	// This method will be used in the controller to handle the game state updates
	// TODO: Implement the main turn function and integrate it with the controller



    //TODO main turn function - select robot based on cards player and pass relevant into updateFromCard
    //Method above will be used in controller -> Make controller
    
    
    
