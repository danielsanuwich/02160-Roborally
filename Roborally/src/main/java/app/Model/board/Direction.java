class Direction{
    private int direction;

    // direction constructor
    public void Direction(int initDirection){
        direction = (initDirection % 6);
    }

    // direction setter
    public void setDirection(int initDirection){
        this.direction = (initDirection % 6);
    }

    // direction getter
    public int getDirection(){
        return this.direction;
    }
    

}