package app.Model.tiles;

import app.Model.board.Direction;
import app.Model.board.Position;

public class StartTile extends Tile {
    // No additional attributes or methods are necessary

    // StartTile constructor
    public StartTile(Position position, Direction direction) {
        super("Start", position, direction);
    }
}
