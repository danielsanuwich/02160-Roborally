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
        super();
        if ((turnAmount % 6) != 0) {
            if (turnAmount == 6) {
                throw new IllegalArgumentException("Invalid turnAmount value: 6");
            }
            this.turnAmount = turnAmount;
            if (Math.abs(this.turnAmount % 6) == 3) {
                super.setName("Uturn");
            } else if (this.turnAmount > 0) {
                super.setName("CW");
            } else if (this.turnAmount < 0) {
                super.setName("CCW");
            }
        } else {
            this.moveAmount = moveAmount;
            super.setName("Move" + Integer.toString(moveAmount));
        }
    }

    // programCard getters
    public int getTurnAmount() {
        return this.turnAmount;
    }

    public int getMoveAmount() {
        return this.moveAmount;
    }
}
