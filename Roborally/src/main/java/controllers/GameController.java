package controllers;

import app.Game;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import states.UpgradingPhase;

public class GameController extends VBox {

	private Button endTurnButton = new Button();
	private Button exitButton = new Button();
	
	private Game game;
	
	public GameController() {
		// VBox window setup
		this.setAlignment(Pos.CENTER);
		this.setSpacing(80);
		
		initializeButtons();
		addListeners();
		
		// Begin Upgrading Phase
		this.game = new Game(new UpgradingPhase());
	}
	
	private void initializeButtons() {
		endTurnButton.setText("End turn");
		exitButton.setText("Exit to menu");
		
		/*
		 * after set up of elements
		 * add to VBox(MenuController) and eventually the scene
		 */
		
		this.getChildren().add(endTurnButton);
		this.getChildren().add(exitButton);
	}
	
	private void addListeners() {
		endTurnButton.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				game.nextPhase();
			}
		});
		
		exitButton.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				Scene scene = new Scene(new MenuController(), 800, 600);
				
				Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
				
				window.setScene(scene);
				window.show();
			}
		});
	}
}
