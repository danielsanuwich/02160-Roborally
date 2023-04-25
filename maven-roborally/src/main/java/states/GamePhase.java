package states;

import app.Game;

public interface GamePhase {

	void next(Game game);
	void previous(Game game);
	void printStatus();
}
