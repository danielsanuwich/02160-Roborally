package app.Model.cards;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class HealthCardTest {

    @Test
    public void testConstructorPositive() {
        int diffHealth = 2;
        HealthCard card = new HealthCard(diffHealth);
        assertEquals("Add 2 HP", card.getType());
        assertEquals(diffHealth, card.getDiffHealth());
    }

    @Test
    public void testConstructorNegative() {
        int diffHealth = -3;
        HealthCard card = new HealthCard(diffHealth);
        assertEquals("Deduct 3 HP", card.getType());
        assertEquals(diffHealth, card.getDiffHealth());
    }

}
