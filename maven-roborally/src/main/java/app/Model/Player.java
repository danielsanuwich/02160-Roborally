package app.Model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import app.Model.cards.Card;
import app.Model.cards.CardAttribute;

public class Player {

    private final Card[] cardHand = new Card[9];
    private final Card[] programmingSlots = new Card[5];
    private final boolean[] programmingSlotsLocked = new boolean[5];
    private final Robot robot;
    private boolean wonOrLost = false;
    private final List<Card> deck;

    // Player constructor
    public Player(Robot robot) {
        this.robot = robot;
        deck = deckOfCards();
    }
    // Creates and shuffles a new deck of cards
    private List<Card> deckOfCards() {
        List<Card> cards = new ArrayList<>();
        for (int i = 0; i < 18; i++) {
            // Use the CardAttribute enum to create the Card objects
            if (i < 6) {
                cards.add(new Card(CardAttribute.BACK_UP));
                cards.add(new Card(CardAttribute.MOVE_THREE));
                cards.add(new Card(CardAttribute.U_TURN));
            }
            if (i < 12) {
                cards.add(new Card(CardAttribute.MOVE_TWO));
            }
            cards.add(new Card(CardAttribute.MOVE_ONE));
            cards.add(new Card(CardAttribute.TURN_CLOCKWISE));
            cards.add(new Card(CardAttribute.TURN_COUNTERCLOCKWISE));
        }
        Collections.shuffle(cards);
        return cards;
    }


    // Moves a card from the player's hand to an open programming slot
    public void placeCardFromHandToSlot(int handSlot) {
        placeCardInFirstOpenSlot(handSlot, cardHand, programmingSlots);
    }

    // Helper method to move a card from one array to another
    private void placeCardInFirstOpenSlot(int cardSlotInOriginArray, Card[] originArray, Card[] destinationArray) {
        if (originArray[cardSlotInOriginArray] != null) {
            for (int i = 0; i < destinationArray.length; i++) {
                if (destinationArray[i] == null) {
                    destinationArray[i] = originArray[cardSlotInOriginArray];
                    originArray[cardSlotInOriginArray] = null;
                    return;
                }
            }
        }
    }

    // Clears all programming slots and locks the necessary slots based on the robot's HP
    public void clearProgrammingSlots() {
        Arrays.fill(programmingSlotsLocked, false);

        int hp = robot.getHealth();
        for (int i = 5; i >= hp && i >= 1; i--) {
            programmingSlotsLocked[i - 1] = true;
        }
        for (int i = 0; i < programmingSlots.length; i++) {
            if (!programmingSlotsLocked[i]) {
                programmingSlots[i] = null;
            }
        }
    }

    // Sets a card in a specific programming slot
    public void setCardinProgrammingSlot(int programmingSlot, Card programCard) {
        programmingSlots[programmingSlot] = programCard;
    }

    // Returns the card in the specified programming slot
    public Card getCardInProgrammingSlot(int slot) {
        return programmingSlots[slot];
    }

    // Sets a card in a specific hand slot
    public void setCardinHand(int handSlot, Card programCard) {
        cardHand[handSlot] = programCard;
    }

    // Returns the card in the specified hand slot
    public Card getCardinHand(int handSlot) {
        return cardHand[handSlot];
    }

    public Card[] getProgrammingSlots() {
        return programmingSlots.clone();
    }

    public void dealCards() {
        Arrays.fill(cardHand, null);
        Collections.shuffle(deck);
        for (int i = 0; i < robot.getHealth() - 1; i++) {
            cardHand[i] = deck.get(i);
        }
    }

    public Robot getRobot() {
        return robot;
    }

    // Fills the empty slots in programmingSlots array with random cards from the player's hand
    public void fillEmptySlots() {
        for (Card card : programmingSlots) {
            if (card == null) {
                int randomPick = (int) (Math.random() * 9);
                while (true) {
                    if (getCardinHand(randomPick) != null) {
                        // Place the card from the hand to the programming slot
                        placeCardFromHandToSlot(randomPick);
                        break;
                    } else {
                        // Generate a new random index to pick a card from the hand
                        randomPick = (int) (Math.random() * 9);
                    }
                }
            }
        }
    }

    // Sets the wonOrLost value for the player
    public void setWonOrLost(boolean wonOrLost) {
        this.wonOrLost = wonOrLost;
    }

    // Returns true if the player has won or lost the game, false otherwise
    public boolean hasWonOrLost() {
        return wonOrLost;
    }

}
