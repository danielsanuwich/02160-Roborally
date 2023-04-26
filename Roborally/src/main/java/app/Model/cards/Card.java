package app.Model.cards;

public class Card {
	// card attribute
	private String name;
	
	public Card() {
		
	}
	// card constructor
	public Card(String name) {
		this.name = name;
	}
	
	// card setType 
	public void setName(String newName){
		this.name = newName;
	}


	// card getters
	public String getName(){
		return this.name;
	}
}
