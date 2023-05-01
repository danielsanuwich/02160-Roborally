package app.Model.cards;

import java.util.Arrays;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Polygon;

public class CardCell extends Pane{
    public CardCell(double width, double height, Card card) {
        Polygon rectangle = new Polygon();
        Double[] points = calculateCardPoints(width, height);
        rectangle.getPoints().addAll(Arrays.asList(points));
        //hexagon.setFill(Color.TRANSPARENT);
        rectangle.setStroke(Paint.valueOf("#000000"));
        rectangle.setStrokeWidth(5);
        this.getChildren().add(rectangle);

        ImageView imageView = new ImageView();
        imageView.setFitWidth(width);
        imageView.setFitHeight(height);
        imageView.setPreserveRatio(true);
        imageView.setSmooth(true);
        imageView.setCache(true);
        Image image = getTileImage(card);
        imageView.setImage(image);

        this.getChildren().add(imageView);
    }

    private Image getTileImage(Card card) {
        String imageName = card.getImageName();
        String imagePath;
        System.out.println(imageName);
        imagePath = "/images/" + imageName + ".png"; // Changed from jpg to png
        System.out.println("Image path: " + imagePath); // Add this line to print the imagePath
        return new Image(getClass().getResourceAsStream(imagePath));
    }

    private Double[] calculateCardPoints(double width, double height) {
        Double[] points = new Double[8];
        points[0] = 0.0; // x-coordinate of top-left corner
        points[1] = 0.0; // y-coordinate of top-left corner
        points[2] = width; // x-coordinate of top-right corner
        points[3] = 0.0; // y-coordinate of top-right corner
        points[4] = width; // x-coordinate of bottom-right corner
        points[5] = height; // y-coordinate of bottom-right corner
        points[6] = 0.0; // x-coordinate of bottom-left corner
        points[7] = height; // y-coordinate of bottom-left corner
        return points;
    }

}
