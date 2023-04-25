package app;
import java.io.IOException;
import java.util.SplittableRandom;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.paint.Paint;
import javafx.stage.Stage;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Polygon;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;

public class UI extends Application{
    private static final String floorURL = "C:\\Users\\Tim\\Documents\\Java\\Roborally\\02160-Roborally\\Roborally\\src\\main\\java\\pictures\\tiles\\floor.png";
    private static final String acidURL = "C:\\Users\\Tim\\Documents\\Java\\Roborally\\02160-Roborally\\Roborally\\src\\main\\java\\pictures\\tiles\\acid.png";
    private static final String pitURL = "C:\\Users\\Tim\\Documents\\Java\\Roborally\\02160-Roborally\\Roborally\\src\\main\\java\\pictures\\tiles\\pit.png";
    private static final String radURL = "C:\\Users\\Tim\\Documents\\Java\\Roborally\\02160-Roborally\\Roborally\\src\\main\\java\\pictures\\tiles\\radiation.png";
    private static final String conveyorURL = "C:\\Users\\Tim\\Documents\\Java\\Roborally\\02160-Roborally\\Roborally\\src\\main\\java\\pictures\\tiles\\Conveyers-straight-1.png";
    public void start(Stage primaryStage) {
        Image floor = new Image(floorURL);
        Image acid = new Image(acidURL);
        Image pit = new Image(pitURL);
        Image conveyor = new Image(conveyorURL);
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
                        tile.setFill(new ImagePattern(conveyor, 0, 0, 1, 1, true));
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
    public static void main(String[] args)
    {
        launch(args);
    }

    // @Override
    // public void start(Stage primaryStage) throws Exception {
    //     primaryStage.setTitle("First GUI window!");
    //     primaryStage.show();
    // }
}
