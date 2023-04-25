/*
 * Cards which modify the robots health
 */
public class HealthCard extends Card{
    
    // HealthCard attributes
    private int diffHealth;
    
    // HealthCard constructor
    public HealthCard(int diffHealth){
        this.diffHealth = diffHealth;
        // setting the card type based on the input
        if(this.diffHealh >= 0){
            super("Add" + toString(diffHealth) + "HP");
        }else{
            super("Deduct" + toString(diffHealth) + "HP");
        }
    }
    
    // HealthCard getters
    public int getDiffHealth(){
        return this.diffHealth;
    }
    
}
    