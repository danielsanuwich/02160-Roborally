package app.Model.cards;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ProgramCardTest {

    private ProgramCard card1, card2, card3;

    @BeforeEach
    public void setUp() {
        card1 = new ProgramCard(-3, 0); // Uturn
        card2 = new ProgramCard(3, 0); // CW
        card3 = new ProgramCard(0, 2); // Move2
    }

    @Test
    public void testGetName() {
        assertEquals("Uturn", card1.getName());
        assertEquals("Uturn", card2.getName());
        assertEquals("Move2", card3.getName());
    }

    @Test
    public void testGetMoveAmount() {
        assertEquals(0, card1.getMoveAmount());
        assertEquals(0, card2.getMoveAmount());
        assertEquals(2, card3.getMoveAmount());
    }

    @Test
    public void testInvalidTurnAmount() {
        assertThrows(IllegalArgumentException.class, () -> {
            new ProgramCard(6, 0);
        });
    }
}
