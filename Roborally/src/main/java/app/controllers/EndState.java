package app.controllers;

// End -> Menu

public class EndState extends State{

    // EndState Attributes 
    private String nextStateName;
    
    
    // EndState Constructor
    
    public EndState(String nextStateName){
        this.nextStateName = nextStateName;
    }
    
    
    // EndState Setters 
    public void setNextStateName(String nextStateName){
        this.nextStateName = nextStateName;
    }
    
    
    // EndState Getters 

    public String getNextStateName(){
        return this.nextStateName;
    }
    
}