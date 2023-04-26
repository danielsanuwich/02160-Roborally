package app.Model.board;

public class Direction {
    private int direction;

    // direction constructor
    public Direction(int direction) {
        if (direction < 0) {
            this.direction = 6 + (direction % 6);
        } else {
            this.direction = direction % 6;
        }
    }

    // direction setter
    public void setDirection(int direction) {
        if (direction < 0) {
            this.direction = 6 + (direction % 6);
        } else {
            this.direction = (direction % 6);
        }
    }

    // direction getter
    public int getDirection() {
        return this.direction;
    }
}
