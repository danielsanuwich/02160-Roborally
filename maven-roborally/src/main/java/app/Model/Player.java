package app.Model;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import app.Model.cards.Card;

public class Player {

    // An array to hold the cards in the player's hand
    private final Card[] cardHand = new Card[9]; 
    // An array to hold the cards in the player's programming slots
    private final Card[] programmingSlots = new Card[5]; 
    // An array to keep track of which programming slots are locked
    private final boolean[] programmingSlotsLocked = new boolean[5]; 
    // The player's robot
    private final Robot robot; 
    // Condition to win
    public boolean wonOrLost = false;
    // A list to hold the deck of cards
    private final List<Card> deck;

    public Player(Robot robot) {
        this.robot = robot;
        deck = deckOfCards();
    }

    public List<Card> deckOfCards() {
        // Create and shuffle a new deck of cards
        List<Card> cards = new ArrayList<>();
        for (int i = 0; i < 18; i++) {
            if (i < 6) {
                cards.add(Card.BACK_UP);
                cards.add(Card.MOVE_THREE);
                cards.add(Card.U_TURN);
            }
            if (i < 12) {
                cards.add(Card.MOVE_TWO);
            }
            cards.add(Card.MOVE_ONE);
            cards.add(Card.ROTATE_LEFT);
            cards.add(Card.ROTATE_RIGHT);
        }
        Collections.shuffle(cards);
        return cards;
    }

    public void placeCardFromHandToSlot(int handSlot) {
        // Move a card from the player's hand to an open programming slot
        placeCardInFirstOpenSlot(handSlot, cardHand, programmingSlots);
    }

    public void undoProgrammingSlotPlacement(int programmingSlot) {
        // Move a card from a locked programming slot back to the player's hand
        if (!programmingSlotsLocked[programmingSlot]) {
            placeCardInFirstOpenSlot(programmingSlot, programmingSlots, cardHand);
        }
    }

    private void placeCardInFirstOpenSlot(int cardSlotInOriginArray, Card[] originArray, Card[] destinationArray) {
        // Helper method to move a card from one array to another
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

    public void clearProgrammingSlots() {
        // Clear all programming slots and lock the necessary slots based on the robot's HP
        Arrays.fill(programmingSlotsLocked, false);

        int hp = robot.getState().getHp();
        for (int i = 5; i >= hp && i >= 1; i--) {
            programmingSlotsLocked[i - 1] = true;
        }
        for (int i = 0; i < programmingSlots.length; i++) {
            if (!programmingSlotsLocked[i]) {
                programmingSlots[i] = null;
            }
        }
    }

    public void setCardinProgrammingSlot(int programmingSlot, Card programCard) {
        // Set a card in a specific programming slot 
        programmingSlots[programmingSlot] = programCard;
    }

    public Card getCardInProgrammingSlot(int slot) {
        return programmingSlots[slot];
    }

    public void setCardinHand(int handSlot, Card programCard) {
        cardHand[handSlot] = programCard;
    }

    public Card getCardinHand(int handSlot) {
        return cardHand[handSlot];
    }

    public Card[] getProgrammingSlots() {
        return programmingSlots;
    }

    public void dealCards() {
        Arrays.fill(cardHand, null);
        Collections.shuffle(deck);
        for (int i = 0; i < robot.getState().getHp() - 1; i++) {
            cardHand[i] = deck.get(i);
        }
    }

    public Robot getRobot() {
        return robot;
    }

    public void fillEmptySlots() {
        for (Card card : programmingSlots) {
            if (card == null) {
                int randomPick = (int) (Math.random() * 9);
                while (true) {
                    if (getCardinHand(randomPick) != null) {
                        placeCardFromHandToSlot(randomPick);
                        break;
                    }
                    randomPick = (randomPick + 1) % 9;
                }
            }
        }
    }
}