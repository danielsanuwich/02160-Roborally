package app.Model.tiles;

import app.Model.Robot;
import app.Model.board.Direction;
import app.Model.board.Position;

public class HoleTile extends Tile {

    // HoleTile Attribute 
    private int holeDamage = 0;


    // HoleTile constructor
    public HoleTile(Position position, Direction direction, int holeDamage) {
        super(position, direction, "Hole");
        this.holeDamage = holeDamage;
    }

    // Remove a robot from this hole tile
    public void removeRobot(Robot robot) {
        robot.setPosition(null);
    }

    // HoleTile getters
    public int getDamage() {
        return this.holeDamage;
    }
}
