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
        Direction defaultDirection = new Direction(0);
        for (int i = 0; i < xDim; i++) {
            for (int j = 0; j < yDim; j++) {
                this.gameBoard[i][j] = new Tile();
                this.gameBoard[i][j].setPosition(new Position(i, j));
                this.gameBoard[i][j].setType("Base");
                this.gameBoard[i][j].setDirection(defaultDirection);
            }
        }
    }

    // gets the tile at a certain position
    public Tile getTile(Position pos) {
        return gameBoard[pos.getX()][pos.getY()];
    }

    // sets the tile at a certain position
    public void setTile(Position pos, Tile tile) {
        gameBoard[pos.getX()][pos.getY()] = tile;
    }

    // computes the distance between any two positions
    private float distance(Position pos1, Position pos2) {
        return (float) Math.hypot(pos1.getX() - pos2.getX(), pos1.getY() - pos2.getY());
    }

    // returns the nearest start tile to any given position
    public Position nearestStartTile(Position initial) {
        float smallestDistance = Float.MAX_VALUE;
        Position closest = new Position(0, 0); // nearest start tile's position

        // loop to iterate through all positions on the board
        for (int i = 0; i < xDim; i++) {
            for (int j = 0; j < yDim; j++) {
                if (gameBoard[i][j] instanceof StartTile) {
                    float dist = distance(initial, gameBoard[i][j].getPosition());
                    if (dist < smallestDistance) {
                        smallestDistance = dist;
                        closest = gameBoard[i][j].getPosition();
                    }
                }
            }
        }
        return closest;
    }

}