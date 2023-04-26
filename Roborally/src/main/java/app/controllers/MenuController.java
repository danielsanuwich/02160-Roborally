package app.controllers;

import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;

public class MenuController extends VBox {

	private Button startGameButton = new Button();
	private Button exitButton = new Button();

	public MenuController() {
		// VBox window setup
		this.setAlignment(Pos.CENTER);
		this.setSpacing(50);
		
		initializeButtons();
		addListeners();
	}
	
	private void initializeButtons() {
		startGameButton.setText("Start Game");
		exitButton.setText("Exit");

		/*
		 * after set up of elements
		 * add to VBox(MenuController in this case) and eventually the scene
		 */
		
		this.getChildren().add(startGameButton);
		this.getChildren().add(exitButton);
	}
	
	private void addListeners() {

		startGameButton.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
								
				Scene scene = new Scene(new GameController(), 800, 600);
				
				Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
				
				window.setScene(scene);
				window.show();
			}
		});

		// TODO: properly handle exit
		exitButton.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				System.out.println("Exit pressed");
			}
		});
	}
}
