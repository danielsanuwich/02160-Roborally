package app.Model.board;


public class Position{
    private int x;
    private int y;
    
    // position constructor
    public Position(int xi, int yi){
        x = xi; 
        y = yi;
    }

    // position setter
    public void setPosition(int xi, int yi){
        this.x = xi;
        this.y = yi;
    }
 
    // position setter
    public void setX (int xi){
        this.x = xi;
    }
  
    // position setter
    public void setY (int yi){
        this.y = yi;
    }
    
    // position getters
    public int getX(){
        return this.x;
    }
    public int getY(){
        return this.y;
    }


}
