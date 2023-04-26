package app.Model.board;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;
import java.util.Arrays;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import app.Model.tiles.Tile;

public class HexagonalCell extends Pane {
    public HexagonalCell(double width, double height, Tile tile) {
        Polygon hexagon = new Polygon();
        Double[] points = calculateHexagonPoints(width, height);
        hexagon.getPoints().addAll(Arrays.asList(points));
        hexagon.setFill(Color.TRANSPARENT);
        hexagon.setStroke(Color.BLACK);
        hexagon.setStrokeWidth(1);
        this.getChildren().add(hexagon);

        ImageView imageView = new ImageView();
        imageView.setFitWidth(width);
        imageView.setFitHeight(height);
        imageView.setPreserveRatio(true);
        imageView.setSmooth(true);
        imageView.setCache(true);
        
        Image image = getTileImage(tile);
        imageView.setImage(image);

        this.getChildren().add(imageView);
    }

    private Image getTileImage(Tile tile) {
        String imageName = tile.getType();
        String imagePath = "images/" + imageName + ".png";
        return new Image(imagePath);
    }
    private Double[] calculateHexagonPoints(double width, double height) {
        double centerX = width / 2;
        double centerY = height / 2;

        double radius = Math.min(width, height) * 0.5;
        double angle = Math.PI / 6;
        Double[] points = new Double[12];

        for (int i = 0; i < 6; i++) {
            points[2 * i] = centerX + radius * Math.cos(angle);
            points[2 * i + 1] = centerY + radius * Math.sin(angle);
            angle += Math.PI / 3;
        }

        return points;
    }
}








