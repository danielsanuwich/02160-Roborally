package app.Model.tiles;

import app.Model.board.Direction;
import app.Model.board.Position;

public class LaserTile extends Tile {
    // LaserTile attributes
    private final int laserDamage;

    // LaserTile constructor
    public LaserTile(Position inputPosition, Direction inputDirection, int laserDamage) {
        super(inputPosition, inputDirection, "Laser");
        this.laserDamage = Math.abs(laserDamage);
    }

    // LaserTile getters
    public int getDamage() {
        return this.laserDamage;
    }
}