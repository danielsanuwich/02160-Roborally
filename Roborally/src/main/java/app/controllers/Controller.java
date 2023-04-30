package app.controllers;



public class Controller{
    Debug db("Controller");

    // Controller Attributes 
    private int numberOfStates = 6;
    private State[numberOfStates] stateList;

    MenuState menu = new MenuState("menu","turn1a");
    PlayerTurnState turn1a = new PlayerTurnState("turn1a","turn1b", 1);
    PlayerTurnState turn1b = new PlayerExecuteState("turn1b","turn2a","end",1);
    PlayerTurnState turn2a = new PlayerTurnState("turn2a","turn2b",2);
    PlayerTurnState turn2b = new PlayerExecuteState("turn2b","turn1a","end",2);
    EndState end = new EndState("end","menu");


    // assign game states to the gamelist
    stateList[0] = menu;
    stateList[1] = turn1a;
    stateList[2] = turn1b;
    stateList[3] = turn2a;
    stateList[4] = turn2b;
    stateList[5] = end;



    // function to set the desired state to be on
    // returns number of states that are on (should always be one)
    private int setStates(String stateName){
        int statesOn = 0;
        for(int i = 0; i < numberOfStates; i++){
            if(stateList[i].getName == stateName){
                stateList[i].setOn();
                statesOn += 1;
            } else {
                stateList[i].setOff();
            }
        }
        return statesOn;
    }

    // returns first state in the statelist to be on 
    private State getOnState(){
        for(int i = 0; i < numberOfStates; i++){
            if(stateList[i].getOn == true){
                return OnState;
            }
        }
        
        return null;
    }

    // main loop

    while(true){
        getOnState().excecuteState();
        this.db.print("executing state: "+getOnStateName());
        int result = setStates(getOnState().nextStateName());
        if(result != 1){
            this.db.print("Error: " + result.toString() + " states on instead of just 1")
            break;
        }
    }



    // Controller Constructor
    public Controller(){
        
    }





}