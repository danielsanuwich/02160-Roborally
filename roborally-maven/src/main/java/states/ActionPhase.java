package states;

import app.Game;

public class ActionPhase implements GamePhase{

	public void next(Game game) {
		game.setPhase(new UpgradingPhase());
	}

	public void previous(Game game) {
		game.setPhase(new ProgrammingPhase());
	}

	public void printStatus() {
		System.out.println("Action phase");
	}

}
