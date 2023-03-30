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


#include<iostream>
#include<string>
#include<Windows.h>

using namespace std;

int main()
{
	// Create a stage object
	Stage stage;
	stage.setTitle("Roborally");

	// Create a menu controller
	MenuController menuController;

	// Create a scene object
	Scene scene(menuController, 800, 600);

	// Create a scene controller
	SceneController sceneController;
	sceneController.setStage(stage);
	sceneController.setScene(scene);
	sceneController.showStage();

	return 0;
}