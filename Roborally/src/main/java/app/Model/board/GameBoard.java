package app.Model.board;

import app.Model.tiles.StartTile;
import app.Model.tiles.*;

public class GameBoard {

    private int xDim;
    private int yDim;
    private Tile[][] gameBoard;
    private int borderWidth = 1;

    public GameBoard(int xDim, int yDim) {
        this.xDim = xDim;
        this.yDim = yDim;
        this.gameBoard = new Tile[xDim][yDim];

        // Initialize the game board
        for (int i = 0; i < xDim; i++) {
            for (int j = 0; j < yDim; j++) {
                this.gameBoard[i][j] = new Tile();
                this.gameBoard[i][j].setPosition(new Position(i, j));
                this.gameBoard[i][j].setType(TileType.BASE_TILE);
                this.gameBoard[i][j].setDirection(0);
            }
        }

        // Specify other special tiles
        // ...

    }

    // gets the tile at a certain position
    public Tile getTile(Position pos) {
        return gameBoard[pos.getX()][pos.getY()];
    }

    // computes the distance between any two positions
    private float distance(Position pos1, Position pos2) {
        return (float) Math.sqrt(Math.pow((pos1.getX() - pos2.getX()), 2) + Math.pow((pos1.getY() - pos2.getY()), 2));
    }

    // returns the nearest start tile to any given position
    private Position nearestStartTile(Position initial) {
        float smallestDistance = Math.abs(xDim + yDim);
        Position closest = null; // nearest start tile's position

        // loop to iterate through all positions on the board
        for (int i = 0; i < xDim; i++) {
            for (int j = 0; j < yDim; j++) {
                if (distance(initial, gameBoard[i][j].getPosition()) < smallestDistance) {
                    // if this distance smaller than previous update new smallest distance
                    if (gameBoard[i][j] instanceof StartTile) {// if tiletype is startTile
                        smallestDistance = distance(initial, gameBoard[i][j].getPosition());
                        // update new closest start position
                        closest = gameBoard[i][j].getPosition();
                    }
                }
            }
        }
        return closest;
    }

}
