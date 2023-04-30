package app.Model.tiles;

import app.Model.board.Direction;
import app.Model.board.Position;

public class HoleTile extends Tile {

    // HoleTile Attribute
    private int holeDamage = 1;

    // HoleTile constructors
    public HoleTile(Position position) {
        super("Hole", position);
    }

    public HoleTile(Position position, int holeDamage) {
        super("Hole", position);
        this.holeDamage = holeDamage;
    }

    // HoleTile getters
    public int getDamage() {
        return this.holeDamage;
    }
}
