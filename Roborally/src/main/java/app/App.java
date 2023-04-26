package app;

import java.util.SplittableRandom;

import app.controllers.MenuController;
import app.controllers.SceneController;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.ImagePattern;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Polygon;
import javafx.stage.Stage;


public class App extends Application {

	public static void main(String[] args) {
		launch(args);
	}
	
	@Override
	public void start(Stage primaryStage) {
        Image floor = new Image(floorURL);
        Image acid = new Image(acidURL);
        Image pit = new Image(pitURL);
        Image radiation = new Image(radURL);
        int height = 600;
        int width = 800;
        AnchorPane tileMap = new AnchorPane();
        Scene content = new Scene(tileMap, width, height);
        primaryStage.setScene(content);
        double size = 40,v=Math.sqrt(3)/2.0;
        for(double y=0;y<height;y+=size*Math.sqrt(3))
        {
            for(double x=-25,dy=y;x<width;x+=(3.0/2.0)*size)
            {
                Polygon tile = new Polygon();
                tile.getPoints().addAll(new Double[]{
                    x,dy,
                    x+size,dy,
                    x+size*(3.0/2.0),dy+size*v,
                    x+size,dy+size*Math.sqrt(3),
                    x,dy+size*Math.sqrt(3),
                    x-(size/2.0),dy+size*v
                });
                SplittableRandom random = new SplittableRandom();
                int probability = random.nextInt(10);
                // if (probability < 8){
                //     tile.setFill(new ImagePattern(floor, 0, 0, 1, 1, true));
                // }
                
                switch(probability){
                    case 0: 
                        tile.setFill(new ImagePattern(acid, 0, 0, 1, 1, true));
                        break;
                    case 1:
                        tile.setFill(new ImagePattern(pit, 0, 0, 1, 1, true));
                        break;
                    case 2:
                        tile.setFill(new ImagePattern(radiation, 0, 0, 1, 1, true));
                        break;
                    default:
                        tile.setFill(new ImagePattern(floor, 0, 0, 1, 1, true));
                        break;
                    
                }
                tile.setStrokeWidth(2);
                tile.setStroke(Paint.valueOf("#000000") );
                tileMap.getChildren().add(tile);
                dy = dy==y ? dy+size*v : y;
            }
        }
        primaryStage.show();
    }
}


