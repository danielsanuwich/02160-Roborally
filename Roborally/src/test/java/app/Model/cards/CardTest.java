package app.Model.cards;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CardTest {

	@Test
	void testConstructor() {
		Card card = new Card("Ace");
		assertEquals("Ace", card.getName(), "Card name should be Ace");
	}

	@Test
	void testEmptyConstructor() {
		Card card = new Card();
		assertNull(card.getName(), "Card name should be null");
	}

	@Test
	void testSetName() {
		Card card = new Card();
		card.setName("King");
		assertEquals("King", card.getName(), "Card name should be King");
	}

	@Test
	void testGetName() {
		Card card = new Card("Queen");
		assertEquals("Queen", card.getName(), "Card name should be Queen");
	}
}
