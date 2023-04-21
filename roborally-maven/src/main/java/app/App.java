package app;

import controllers.MenuController;
import controllers.SceneController;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class App extends Application {

	public static void main(String[] args) {
		launch(args);
	}
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		primaryStage.setTitle("Roborally");

		MenuController menuController = new MenuController();
		
		Scene scene = new Scene(menuController, 800, 600);
		
		SceneController sceneController = new SceneController();
		
		sceneController.setStage(primaryStage);
		sceneController.setScene(scene);
		sceneController.showStage();
	}
}


