package app.Model.cards;

public class Card {
	// card attribute
	private String type;

	// card constructor
	public Card(String type) {
		this.type = type;
	}

	// card getter
	public void setType(String type) {
		this.type = type;
	}

	// card getter
	public String getType() {
		return this.type;
	}
}
