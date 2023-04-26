package app.Model.cards;

/*
 * Cards which modify the robots health
 */
public class HealthCard extends Card {

    // HealthCard attributes
    private final int diffHealth;

    // HealthCard constructor
    public HealthCard(int diffHealth) {
        super(diffHealth >= 0 ? "Add " + diffHealth + " HP" : "Deduct " + Math.abs(diffHealth) + " HP");
        this.diffHealth = diffHealth;
    }

    // HealthCard getters
    public int getDiffHealth() {
        return this.diffHealth;
    }

}
