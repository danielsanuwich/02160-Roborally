package app.Model.board;

import app.Model.tiles.Tile;
import app.Model.tiles.Tile.TileType;

public class GameBoard {

    private final int xDim;
    private final int yDim;
    private final Tile[][] gameBoard;

    public GameBoard(int xDim, int yDim) {
        this.xDim = xDim;
        this.yDim = yDim;
        this.gameBoard = new Tile[xDim][yDim];

        initBoard();
    }

    // Initializes the game board with tiles
    private void initBoard() {
        for (int i = 0; i < xDim; i++) {
            for (int j = 0; j < yDim; j++) {
                Position currentPosition = new Position(i, j);
                gameBoard[i][j] = new Tile(currentPosition, TileType.BASE_TILE);
            }
        }
        
        // Add holes around edges
        createHolesAroundEdges();
        
        // Add start points in each corner
        createStartPoints();
        
        // Add other special tiles here as needed
    }

    // Creates holes around the edges of the board
    private void createHolesAroundEdges() {
        for (int i = 0; i < xDim; i++) {
            for (int j = 0; j < yDim; j++) {
                Position currentPosition = new Position(i, j);
                if (i == 0 || i == xDim - 1 || j == 0 || j == yDim - 1) {
                    gameBoard[i][j] = new Tile(currentPosition, TileType.HOLE);
                }
            }
        }
    }

    // Creates start points in each corner of the board
    private void createStartPoints() {
        gameBoard[0][0] = new Tile(new Position(0, 0), TileType.START);
        gameBoard[xDim - 1][0] = new Tile(new Position(xDim - 1, 0), TileType.START);
        gameBoard[0][yDim - 1] = new Tile(new Position(0, yDim - 1), TileType.START);
        gameBoard[xDim - 1][yDim - 1] = new Tile(new Position(xDim - 1, yDim - 1), TileType.START);
    }

    // Returns the tile at a given position
    public Tile getTile(Position pos) {
        return gameBoard[pos.getX()][pos.getY()];
    }
    
    // Determines the nearest respawn position for a given initial position
    public Position getNearestRespawn(Position initialPosition) {
        Position respawnPosition;

        if (initialPosition.getX() <= xDim / 2 && initialPosition.getY() <= yDim / 2) {
            // Top left quadrant
            respawnPosition = new Position(1, 1);
        } else if (initialPosition.getX() <= xDim / 2 && initialPosition.getY() > yDim / 2) {
            // Top right quadrant
            respawnPosition = new Position(1, yDim - 2);
        } else if (initialPosition.getX() > xDim / 2 && initialPosition.getY() <= yDim / 2) {
            // Bottom left quadrant
            respawnPosition = new Position(xDim - 2, 1);
        } else {
            // Bottom right quadrant
            respawnPosition = new Position(xDim - 2, yDim - 2);
        }

        return respawnPosition;
    }
}
    

