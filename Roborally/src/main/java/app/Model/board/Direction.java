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

    // Override the equals method to compare the contents of the objects rather than address in memory (.equals())
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Direction direction1 = (Direction) o;
        return direction == direction1.direction;
    }
}
