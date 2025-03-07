package app.Model.tiles;

import app.Model.Robot;
import app.Model.board.Direction;
import app.Model.board.Position;

public class HoleTile extends Tile {

    // HoleTile constructor
    public HoleTile(Position position) {
        super(position, "Hole");
    }

    // Remove a robot from this hole tile
    public void removeRobot(Robot robot) {
        robot.setPosition(null);
    }
}
