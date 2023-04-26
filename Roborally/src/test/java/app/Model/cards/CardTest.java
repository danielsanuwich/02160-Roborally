package app.Model.cards;

public class CardTest {
	// card attributes
	private String type;

	// card constructor
	public CardTest(String type) {
		this.type = type;
	}

	// card setType
	public void setType(String newType) {
		this.type = newType;
	}

	// card getters
	public String getType() {
		return this.type;
	}

}