package app.controllers;


// PlayerExecuteState -> PlayerTurnState (continue)
// PlayerExecuteState -> EndState (win condition)

public class PlayerExecuteState extends State{

    // PlayerExecuteState Attributes 
    private String nextStateName;
    
    
    // PlayerExecuteState Constructor
    
    public PlayerExecuteState(String nextStateName){
        this.nextStateName = nextStateName;
    }
    
    
    // PlayerExecuteState Setters 
    public void setNextStateName(String nextStateName){
        this.nextStateName = nextStateName;
    }
    
    
    // PlayerExecuteState Getters 

    public String getNextStateName(){
        return this.nextStateName;
    }
    
}