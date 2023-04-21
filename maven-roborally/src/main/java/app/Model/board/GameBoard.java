package app.Model.board;

import app.Model.tiles.Tile;
import app.Model.tiles.Tile.TileType;

public class GameBoard {

    private int xDim;
    private int yDim;
    private Tile[][] gameBoard;

    public GameBoard(int xDim, int yDim) {
        this.xDim = xDim;
        this.yDim = yDim;
        this.gameBoard = new Tile[xDim][yDim];

        // Initialize the game board
        for (int i = 0; i < xDim; i++) {
            for (int j = 0; j < yDim; j++) {
                Position currentPosition = new Position(i, j);
                gameBoard[i][j] = new Tile(currentPosition, TileType.BASE_TILE);
            }
        }

        // Specify other special tiles
        // ...
    }

    public Tile getTile(Position pos) {
        return gameBoard[pos.getX()][pos.getY()];
    }
}
