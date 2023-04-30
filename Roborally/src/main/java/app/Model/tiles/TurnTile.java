package app.Model.tiles;

import app.Model.board.Direction;
import app.Model.board.Position;

/**
 * TurnTile class represents a tile that rotates a robot by a specified turn
 * amount.
 */
public class TurnTile extends Tile {
    private int turnAmount;

    // TurnTile Constructors
    public TurnTile(Position position, int turnAmount) {
        super("Turn", position);
        if ((turnAmount % 6) != 0) {
            this.turnAmount = turnAmount;
        } else {
            throw new IllegalArgumentException("Turn amount must NOT be a multiple of 6.");
        }
    }
    
    public TurnTile(Position position, Direction direction, int turnAmount) {
        super("Turn", position, direction);
        if ((turnAmount % 6) != 0) {
            this.turnAmount = turnAmount;
        } else {
            throw new IllegalArgumentException("Turn amount must NOT be a multiple of 6.");
        }
    }

    public int getTurnAmount() {
        return turnAmount;
    }
}


