package app.Model.board;

import java.util.Objects;

public final class Position {
    private final int x;
    private final int y;

    // position constructor
    public Position(int x, int y) {
        this.x = x;
        this.y = y;
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

    // private setPosition method
    private void setPosition(int x, int y) {
        // position should only be set through constructor
    }
}
