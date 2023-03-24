package states;

import app.Game;

public class ProgrammingPhase implements GamePhase{

	@Override
	public void next(Game game) {
		game.setPhase(new ActionPhase());
	}

	@Override
	public void previous(Game game) {
		game.setPhase(new UpgradingPhase());
	}

	@Override
	public void printStatus() {
		System.out.println("Programming phase");
	}
}
