package app.Model.tiles;

import app.Model.board.Direction;
import app.Model.board.Position;

public class TurnTile extends Tile {
    private final int turnAmount;

    public TurnTile(Position position, Direction direction, int turnAmount) {
        super(position, direction, "Turn");
        if ((turnAmount % 6) == 0) {
            this.turnAmount = turnAmount;
        } else {
            throw new IllegalArgumentException("Turn amount must be a multiple of 6.");
        }
    }

    public int getTurnAmount() {
        return turnAmount;
    }
}
