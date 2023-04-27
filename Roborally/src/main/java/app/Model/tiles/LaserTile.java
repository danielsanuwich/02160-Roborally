package app.Model.tiles;

import app.Model.board.Direction;
import app.Model.board.Position;

public class LaserTile extends Tile {
    // LaserTile attributes
    private int laserDamage;

    // LaserTile constructor
    public LaserTile(Position inputPosition, Direction inputDirection, int laserDamage) {
        super("Laser", inputPosition, inputDirection);
        this.laserDamage = Math.abs(laserDamage);
    }

    // LaserTile getters
    public int getDamage() {
        return this.laserDamage;
    }
}