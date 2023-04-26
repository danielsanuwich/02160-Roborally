package app.Model.cards;

import org.junit.Test;
import static org.junit.Assert.*;

public class ProgramCardTest {
    
    @Test
    public void testConstructorWithTurnAmount() {
        ProgramCard card = new ProgramCard(3, 0);
        assertEquals("Uturn", card.getType());
        assertEquals(3, card.getTurnAmount());
        assertEquals(0, card.getMoveAmount());
        
        card = new ProgramCard(-4, 0);
        assertEquals("CW4", card.getType());
        assertEquals(-4, card.getTurnAmount());
        assertEquals(0, card.getMoveAmount());
        
        card = new ProgramCard(8, 0);
        assertEquals("CCW2", card.getType());
        assertEquals(8, card.getTurnAmount());
        assertEquals(0, card.getMoveAmount());
    }
    
    @Test
    public void testConstructorWithMoveAmount() {
        ProgramCard card = new ProgramCard(0, 1);
        assertEquals("Move1", card.getType());
        assertEquals(0, card.getTurnAmount());
        assertEquals(1, card.getMoveAmount());
        
        card = new ProgramCard(0, -2);
        assertEquals("Move2", card.getType());
        assertEquals(0, card.getTurnAmount());
        assertEquals(-2, card.getMoveAmount());
    }
}
