package app.controllers;

import javafx.scene.Scene;
import javafx.stage.Stage;

public class SceneController {

	private Stage stage;
	private Scene scene;

	public void setStage(Stage stage) {
		this.stage = stage;
	}

	public void setScene(Scene scene) {
		this.scene = scene;
	}

	public void showStage() {
		stage.setScene(scene);
		stage.show();
	}
}
