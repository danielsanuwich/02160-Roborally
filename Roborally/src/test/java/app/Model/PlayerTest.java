package app.Model;

import app.Model.cards.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import app.Model.board.*;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

public class PlayerTest {

    private Player player;
    private Robot robot;

    @BeforeEach
    public void setUp() {
        Position initPosition = new Position(0, 0);
        Direction initDirection = new Direction(0);
        int initHealth = 3;
        int initPlayer = 1;
        String initName = "TestRobot";
        robot = new Robot(initPosition, initDirection, initHealth, initPlayer, initName);
        player = new Player(robot);
    }

    @Test
    public void testPlaceCardFromHandToSlot() {
        // Test if a card from the hand is placed correctly into the first open
        // programming slot
        Card card = new ProgramCard(0, 1);
        player.setCardinHand(0, card);
        player.placeCardFromHandToSlot(0);
        assertEquals(card, player.getCardInProgrammingSlot(0));
    }

    @Test
    public void testClearProgrammingSlots() {
        // Test if programming slots are cleared and locked based on the robot's health
        Card card = new ProgramCard(0, 1);
        player.setCardinProgrammingSlot(0, card);
        player.getRobot().changeHealth(-1); // Updated this line to use changeHealth()
        player.clearProgrammingSlots();
        assertTrue(player.getProgrammingSlots()[0] == null
                || player.getProgrammingSlots()[0].getClass() == HealthCard.class);
    }

    @Test
    public void testSetCardInProgrammingSlot() {
        // Test if a card is correctly set in a specific programming slot
        Card card = new ProgramCard(0, 1);
        player.setCardinProgrammingSlot(0, card);
        assertEquals(card, player.getCardInProgrammingSlot(0));
    }

    @Test
    public void testGetCardInProgrammingSlot() {
        // Test if the correct card is retrieved from a specific programming slot
        Card card = new ProgramCard(0, 1);
        player.setCardinProgrammingSlot(0, card);
        assertEquals(card, player.getCardInProgrammingSlot(0));
    }

    @Test
    public void testSetCardInHand() {
        // Test if a card is correctly set in a specific hand slot
        Card card = new ProgramCard(0, 1);
        player.setCardinHand(0, card);
        assertEquals(card, player.getCardinHand(0));
    }

    @Test
    public void testGetCardInHand() {
        // Test if the correct card is retrieved from a specific hand slot
        Card card = new ProgramCard(0, 1);
        player.setCardinHand(0, card);
        assertEquals(card, player.getCardinHand(0));
    }

    @Test
    public void testDealCards() {
        // Test if the correct number of cards are dealt based on the robot's health
        player.dealCards();
        int nonNullCards = 0;
        for (int i = 0; i < 9; i++) {
            if (player.getCardinHand(i) != null) {
                nonNullCards++;
            }
        }
        assertEquals(robot.getHealth() - 1, nonNullCards);
    }

    @Test
    public void testFillEmptySlots() {
        // Test if empty programming slots are filled with cards from the player's hand
        player.clearProgrammingSlots();
        player.dealCards();
        player.fillEmptySlots();
        for (int i = 0; i < 5; i++) {
            assertNotNull(player.getCardInProgrammingSlot(i));
        }
    }
}
