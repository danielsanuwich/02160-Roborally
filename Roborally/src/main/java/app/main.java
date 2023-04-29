package app;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.net.URL;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        URL resource = getClass().getResource("/sample.fxml");
        if (resource == null) {
            System.out.println("Cannot find FXML file");
            System.exit(1);
        }
        Parent root = FXMLLoader.load(resource);
        primaryStage.setTitle("RoboRally");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
