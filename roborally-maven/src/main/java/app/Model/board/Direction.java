public class Direction{
    private int direction;

    // direction constructor
    public Direction(int initDirection){
        if (initDirection < 0) {
            direction = 6 + (initDirection % 6);
        } else {
            direction = initDirection % 6;
        }
    }

    // direction setter
    public void setDirection(int initDirection){
        if (initDirection < 0) {
            direction = 6 + (initDirection % 6);
        } else {
            direction = initDirection % 6;
        }
    }

    // direction getter
    public int getDirection(){
        return this.direction;
    }
}
