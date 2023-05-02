package app.controllers;


// PlayerTurnState -> PlayerExecuteState


public class PlayerTurnState extends State{

    // PlayerTurnState Attributes 
    private String nextStateName;
    
    
    // PlayerTurnState Constructor
    
    public PlayerTurnState(String name, String nextStateName){
        super(name);
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