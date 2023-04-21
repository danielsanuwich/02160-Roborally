package app.Model.cards;

public class Card {
    // The attribute that defines the card's behavior
    private final String attribute;

    // Public static final instances of the Card class, representing different card types
    // These instances can be used as a factory to create cards with predefined attributes
    public static final Card MOVE_ONE = new Card("MOVE ONE");
    public static final Card MOVE_TWO = new Card("MOVE TWO");
    public static final Card MOVE_THREE = new Card("MOVE THREE");
    public static final Card BACK_UP = new Card("BACK UP");
    public static final Card GEAR_CLOCKWISE = new Card("GEAR_CLOCKWISE");
    public static final Card GEAR_COUNTERCLOCKWISE = new Card("GEAR COUNTERCLOCKWISE");
    public static final Card U_TURN = new Card("U TURN");

    // Private constructor to restrict instantiation from outside the class
    // Ensures that only the defined card types can be created
    private Card(String attribute) {
        this.attribute = attribute;
    }

    // Getter method to access the card's attribute
    public String getAttribute() {
        return attribute;
    }

    // Method to execute the action associated with the card's attribute
    public void executeCard() {
        // Perform the action associated with the card's attribute
    }
}
