package app.controllers;


// PlayerTurnState -> PlayerExecuteState


public class PlayerTurnState extends State{

    // PlayerTurnState Attributes 
    private String nextStateName;
    
    
    // PlayerTurnState Constructor
    
    public PlayerTurnState(String nextStateName){
        this.nextStateName = nextStateName;
    }
    
    
    // PlayerTurnState Setters 
    public void setNextStateName(String nextStateName){
        this.nextStateName = nextStateName;
    }
    
    
    // PlayerTurnState Getters 

    public String getNextStateName(){
        return this.nextStateName;
    }
    
}