package app.Model.cards;

public class Card {
    private int playerNum = 0;
    // 0 means no player, 1 means player 1, 2 means player 2

    // The attribute that defines the card's behavior
    private final CardAttribute attribute;

    // Public static final instances of the Card class, representing different card types
    // These instances can be used as a factory to create cards with predefined attributes
    public static final Card MOVE_ONE = new Card(CardAttribute.MOVE_ONE);
    public static final Card MOVE_TWO = new Card(CardAttribute.MOVE_TWO);
    public static final Card MOVE_THREE = new Card(CardAttribute.MOVE_THREE);
    public static final Card BACK_UP = new Card(CardAttribute.BACK_UP);
    public static final Card TURN_CLOCKWISE = new Card(CardAttribute.TURN_CLOCKWISE);
    public static final Card TURN_COUNTERCLOCKWISE = new Card(CardAttribute.TURN_COUNTERCLOCKWISE);
    public static final Card U_TURN = new Card(CardAttribute.U_TURN);

    // Private constructor to restrict instantiation from outside the class
    // Ensures that only the defined card types can be created
    public Card(CardAttribute attribute) {
        this.attribute = attribute;
    }

    // card setters
    public void setPlayerNum(int playerNum) {
        this.playerNum = playerNum;
    }

    // card getters
    public CardAttribute getAttribute() {
        return attribute;
    }

    public int getPlayerNum() {
        return this.playerNum;
    }

    // Method to execute the action associated with the card's attribute
    public void executeCard() {
        // Perform the action associated with the card's attribute
    }
}
