package app.Model.tiles;

import app.Model.Robot;
import app.Model.board.Direction;
import app.Model.board.Position;

public class ConveyorTile extends Tile {

    // The direction of the conveyor belt
    private final Direction conveyorDirection;

    // ConveyorTile constructor
    public ConveyorTile(Position position, Direction conveyorDirection) {
        super(position, "Conveyor");
        this.conveyorDirection = conveyorDirection;
    }

    // Move a robot on this conveyor tile
    public void moveRobot(Robot robot) {
        robot.move(conveyorDirection);
    }
}
