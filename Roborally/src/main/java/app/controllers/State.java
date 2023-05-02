package app.controllers;


public class State{

    // State Attributes
    private String name;

    // State Controller
    public State(String name){
        this.name = name;
    }

    // State Getters
    public String getStateName(){
        return this.name;
    }


    public void executeState(){}



}