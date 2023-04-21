//Import position
//import tile

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
                gameBoard[i][j] = new Tile();
                gameBoard[i][j].setPosition(new Position(i, j));
                gameBoard[i][j].setType(TileType.BASE_TILE);
                gameBoard[i][j].setDirection(0);
            }
        }

        // Specify other special tiles
        // ...
    }

    public Tile getTile(Position pos) {
        return gameBoard[pos.getX()][pos.getY()];
    }
}
