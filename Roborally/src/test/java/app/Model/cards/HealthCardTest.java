package app.Model.cards;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class HealthCardTest {

    @Test
    void testConstructorPositiveDiffHealth() {
        HealthCard healthCard = new HealthCard(5);
        assertEquals("Add5HP", healthCard.getName(), "Card name should be Add5HP");
        assertEquals(5, healthCard.getDiffHealth(), "DiffHealth should be 5");
    }

    @Test
    void testConstructorNegativeDiffHealth() {
        HealthCard healthCard = new HealthCard(-3);
        assertEquals("Deduct-3HP", healthCard.getName(), "Card name should be Deduct-3HP");
        assertEquals(-3, healthCard.getDiffHealth(), "DiffHealth should be -3");
    }

    @Test
    void testGetDiffHealth() {
        HealthCard healthCard = new HealthCard(7);
        assertEquals(7, healthCard.getDiffHealth(), "DiffHealth should be 7");
    }
}
