package app.Model.tiles;

import app.Model.board.*;

public class TurnTile extends Tile {

    // Turntile attributes
    private int turnAmount;

    // TurnTile constructor
    public TurnTile(Position inputPosition, Direction inputDirection, int turnAmount) {
        super(inputPosition, inputDirection, "Turn");
        if ((turnAmount % 6) != 0) {
            this.turnAmount = turnAmount;
        }

    }

    // Turntile getter
    public getTurnAmount() {
        return turnAmount;
    }
}