package states;

import app.Game;

public class ActionPhase implements GamePhase{

	@Override
	public void next(Game game) {
		game.setPhase(new UpgradingPhase());
	}

	@Override
	public void previous(Game game) {
		game.setPhase(new ProgrammingPhase());
	}

	@Override
	public void printStatus() {
		System.out.println("Action phase");
	}

}
