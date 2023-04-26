package app.Model.cards;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class CardTest {

	@Test
	public void testGetType() {
		String type = "Action";
		Card card = new Card(type);
		assertEquals(type, card.getType());
	}
}
