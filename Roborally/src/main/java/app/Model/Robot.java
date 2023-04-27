package app.Model;

import app.Model.board.*;
import app.Model.tiles.*;

public class Robot {

	// robot attributes
	private int player;
	private int health;
	private String name;
	private Position position;
	private Direction direction;

	// robot constructor
	public Robot(Position initPosition, Direction initDirection, int initHealth, int initPlayer, String initName) {
		this.player = initPlayer;
		this.health = initHealth;
		this.name = initName;
		this.position = initPosition;
		this.direction = initDirection;
	}

	// robot setters
	public void setPlayer(int initPlayer) {
		this.player = initPlayer;
	}

	public void setHealth(int initHealth) {
		this.health = initHealth;
	}

	public void setName(String initName) {
		this.name = initName;
	}

	public void setPosition(Position initPosition) {
		this.position = initPosition;
	}

	public void setDirection(Direction initDirection) {
		this.direction = initDirection;
	}

	// robot getters
	public int getPlayer() {
		return this.player;
	}

	public int getHealth() {
		return this.health;
	}

	public String getName() {
		return this.name;
	}

	public Position getPosition() {
		return this.position;
	}

	public Direction getDirection() {
		return this.direction;
	}

	// modifiers
	public void changeHealth(int diffHealth) {
		this.health += diffHealth;
	}

	/**
	 * Respawn the robot at the given StartTile's position.
	 * 
	 * @param startTile The StartTile where the robot will respawn.
	 */
	public void respawn(StartTile startTile) {
		this.setPosition(startTile.getPosition());
	}

}
