package app;

import states.GamePhase;

public class Game{

	// reference for current phase
	private GamePhase phase;
	
	public Game(GamePhase initialPhase) {
		this.phase = initialPhase;
		
		// prototype console log helper
		printStatus();
	}
	
	public void setPhase(GamePhase phase) {
		this.phase = phase;
	}
	
	public GamePhase getPhase(GamePhase phase) {
		return this.phase;
	}
	
	public void nextPhase() {
		phase.next(this);
		
		// prototype console log helper
		printStatus();
	}

	public void previousPhase() {
		phase.previous(this);		
	}

	public void printStatus() {
		phase.printStatus();
	}
}

