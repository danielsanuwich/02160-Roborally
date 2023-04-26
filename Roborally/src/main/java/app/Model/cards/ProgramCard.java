package app.Model.cards;

/*
 * Program card 
 */
public class ProgramCard extends Card {

    // programCard attributes
    private int turnAmount = 0;
    private int moveAmount = 0;

    // programCard constructor
    public ProgramCard(int turnAmount, int moveAmount) {
        super(determineCardType(turnAmount, moveAmount)); // Call to superclass constructor
        this.turnAmount = turnAmount;
        this.moveAmount = moveAmount;
    }

    private static String determineCardType(int turnAmount, int moveAmount) {
        if ((turnAmount % 6) != 0) { // setting the card type of a program card dependent on the inputs
            if ((turnAmount % 6) == 3) {
                return "Uturn";
            } else if (turnAmount < 0) {
                return "CCW" + Integer.toString(turnAmount);
            } else if (turnAmount > 0) {
                return "CW" + Integer.toString(Math.abs(turnAmount));
            }
        }
        return "Move" + Integer.toString(moveAmount);
    }

    // programCard getters
    public int getTurnAmount() {
        return this.turnAmount;
    }

    public int getMoveAmount() {
        return this.moveAmount;
    }

}
