// MenuState -> PlayerTurnState

public class MenuState extends State{

    // MenuState Attributes 
    private String nextStateName;
    
    
    // MenuState Constructor
    
    public MenuState(String nextStateName){
        this.nextStateName = nextStateName;
    }
    
    
    // MenuState Setters 
    public void setNextStateName(String nextStateName){
        this.nextStateName = nextStateName;
    }
    
    
    // MenuState Getters 

    public String getNextStateName(){
        return this.nextStateName;
    }
    
}