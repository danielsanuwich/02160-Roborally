package app.Model.cards;

/*
 * Cards which modify the robots health
 */
public class HealthCard extends Card {

    // HealthCard attributes
    private int diffHealth;

    // HealthCard constructor
    public HealthCard(int diffHealth) {
        super();
    	this.diffHealth = diffHealth;
        if (diffHealth >= 0) {
            super.setName("Add" + Integer.toString(diffHealth) + "HP");
        } else {
            super.setName("Deduct" + Integer.toString(diffHealth) + "HP");
        }
        // setting the card type based on the input
    }

    // HealthCard getters
    public int getDiffHealth() {
        return this.diffHealth;
    }

}
