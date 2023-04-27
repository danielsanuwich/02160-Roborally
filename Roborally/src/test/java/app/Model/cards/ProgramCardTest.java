package app.Model.cards;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ProgramCardTest {

    private ProgramCard card1, card2, card3, card4;

    @BeforeEach
    public void setUp() {
        card1 = new ProgramCard(-3, 0); // Uturn
        card2 = new ProgramCard(3, 0); // CW
        card3 = new ProgramCard(0, 2); // Move2
        card4 = new ProgramCard(6, 0); // Blank card
    }

    @Test
    public void testGetName() {
        assertEquals("Uturn", card1.getName());
        assertEquals("Uturn", card2.getName());
        assertEquals("Move2", card3.getName());
        assertEquals("", card4.getName());
    }

    @Test
    public void testGetMoveAmount() {
        assertEquals(0, card1.getMoveAmount());
        assertEquals(0, card2.getMoveAmount());
        assertEquals(2, card3.getMoveAmount());
        assertEquals(0, card4.getMoveAmount());
    }

    @Test
    public void testGetTurnAmount() {
        assertEquals(-3, card1.getTurnAmount());
        assertEquals(3, card2.getTurnAmount());
        assertEquals(0, card3.getTurnAmount());
        assertEquals(0, card4.getTurnAmount());
    }
}
