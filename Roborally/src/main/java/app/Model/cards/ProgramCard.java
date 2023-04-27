package app.Model.cards;

public class ProgramCard extends Card {

    private int turnAmount = 0;
    private int moveAmount = 0;

    public ProgramCard(int turnAmount, int moveAmount) {
        super();
        if (turnAmount == 6) {
            // Blank card with no value
            super.setName("");
            this.turnAmount = 0;
            this.moveAmount = 0;
        } else {
            if ((turnAmount % 6) != 0) {
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
    }

    public int getTurnAmount() {
        return this.turnAmount;
    }

    public int getMoveAmount() {
        return this.moveAmount;
    }
}
