package states;

import app.Game;

public class ProgrammingPhase implements GamePhase{

	public void next(Game game) {
		game.setPhase(new ActionPhase());
	}

	public void previous(Game game) {
		game.setPhase(new UpgradingPhase());
	}

	public void printStatus() {
		System.out.println("Programming phase");
	}
}
