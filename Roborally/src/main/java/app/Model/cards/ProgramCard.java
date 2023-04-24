/*
 * Program card 
 */
public class ProgramCard extends Card{
    
    // programCard attributes
    private int turnAmount = 0;
    private int moveAmount = 0;
    
    // programCard constructor
    public ProgramCard(int turnAmount, int moveAmount){
        if((turnAmount % 6) != 0){ // setting the card type of a program card dependent on the inputs 
            this.turnAmount = turnAmount;
            if((this.turnAmount % 6) == 3){
                super("Uturn");
            }else if(this.turnAmount > 0){
                super("CCW" + toString(turnAmount));
            }else if(this.turnAmount < 0){
                super("CW" + toString(abs(turnAmount)));
            }
        }else{
            this.moveAmount = moveAmount;
            super("Move"+ toString(moveAmount));
        }
        
    }

    // programCard getters
    public int getTurnAmount(){
        return this.turnAmount;
    }

    public int getMoveAmount(){
        return this.moveAmount;
    }
    
}