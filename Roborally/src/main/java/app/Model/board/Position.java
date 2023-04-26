package app.Model.board;

import java.util.Objects;

public final class Position {
    private int x;
    private int y;

    // position constructor
    public Position(int xi, int yi) {
        x = xi;
        y = yi;
    }

    // position setter
    public void setPosition(int xi, int yi) {
        this.x = xi;
        this.y = yi;
    }

    // position getters
    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }

    // overridden equals method
    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Position)) {
            return false;
        }
        Position other = (Position) obj;
        return this.x == other.x && this.y == other.y;
    }

    // overridden toString method
    @Override
    public String toString() {
        return "(" + x + ", " + y + ")";
    }

    
}
