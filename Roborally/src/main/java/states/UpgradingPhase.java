package states;

import app.Game;

public class UpgradingPhase implements GamePhase{

	public UpgradingPhase() {
		//testMethod();
	}
	
	public void next(Game game) {
		game.setPhase(new ProgrammingPhase());
	}

	public void previous(Game game) {
		System.out.println("Game is in root state");
	}

	public void printStatus() {
		System.out.println("Upgrading phase");
	}

	public void testMethod() {
		System.out.println("Constructor invoked");
	}
}
