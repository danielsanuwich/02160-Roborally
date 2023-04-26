package app.Model.cards;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ProgramCardTest {

    private ProgramCard card1, card2, card3, card4;

    @BeforeEach
    public void setUp() {
        card1 = new ProgramCard(-3, 0); // CCW3
        card2 = new ProgramCard(3, 0); // CW3
        card3 = new ProgramCard(0, 2); // Move2
        card4 = new ProgramCard(6, 0); // Uturn
    }

    @Test
    public void testGetTurnAmount() {
        assertEquals(-3, card1.getTurnAmount());
        assertEquals(3, card2.getTurnAmount());
        assertEquals(0, card3.getTurnAmount());
        assertEquals(6, card4.getTurnAmount());
    }

    @Test
    public void testGetMoveAmount() {
        assertEquals(0, card1.getMoveAmount());
        assertEquals(0, card2.getMoveAmount());
        assertEquals(2, card3.getMoveAmount());
        assertEquals(0, card4.getMoveAmount());
    }
}