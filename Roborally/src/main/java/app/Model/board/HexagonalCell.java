package app.Model.board;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Polygon;
import javafx.scene.text.Font;

import java.util.Arrays;

import javax.sound.sampled.AudioFileFormat.Type;

import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import app.Model.tiles.Tile;
import app.Model.tiles.TurnTile;

public class HexagonalCell extends Pane {
    public HexagonalCell(double width, double height, Tile tile) {
        Polygon hexagon = new Polygon();
        Double[] points = calculateHexagonPoints(width, height);
        hexagon.getPoints().addAll(Arrays.asList(points));
        // hexagon.setFill(Color.TRANSPARENT);
        hexagon.setStroke(Paint.valueOf("#FFFFFF"));
        hexagon.setStrokeWidth(5);
        this.getChildren().add(hexagon);

        ImageView imageView = new ImageView();
        imageView.setFitWidth(width);
        imageView.setFitHeight(height);
        imageView.setPreserveRatio(true);
        imageView.setSmooth(true);
        imageView.setCache(true);
        imageView.setRotate(60 * tile.getDirection().getDirection());
        Image image = getTileImage(tile);
        imageView.setImage(image);

        this.getChildren().add(imageView);

        // Print out the tile's position
        System.out.println("Tile position: " + tile.getPosition());

        // Add a label to display the position of the tile
        // Label positionLabel = new Label(tile.getPosition().toString());
        // positionLabel.setAlignment(Pos.CENTER);
        // positionLabel.setPrefSize(width, height);
        // positionLabel.setTextFill(Paint.valueOf("FFFFFF"));
        // positionLabel.setFont(new Font(8));
        // this.getChildren().add(positionLabel);
    }

    private Image getTileImage(Tile tile) {
        String imageName = tile.getType();
        String imagePath;

        if (tile instanceof TurnTile) {
            TurnTile turntile = (TurnTile) tile;
            if (turntile.getTurnAmount() > 0) {
                imagePath = "/images/" + "TurnTile_CW" + ".png";
            } else {
                imagePath = "/images/" + "TurnTile_CCW" + ".png";
            }
        } else {
            imagePath = "/images/" + imageName + "Tile" + ".png"; // Changed from jpg to png
        }
        System.out.println("Image path: " + imagePath); // Add this line to print the imagePath
        return new Image(getClass().getResourceAsStream(imagePath));
    }

    private Double[] calculateHexagonPoints(double width, double height) {
        double centerX = width / 2;
        double centerY = height / 2;

        double radius = Math.min(width, height) * 0.5 * 0.95;
        double angle = 0; // Start at 0 for a flat top hexagon
        Double[] points = new Double[12];

        for (int i = 0; i < 6; i++) {
            points[2 * i] = centerX + radius * Math.cos(angle);
            points[2 * i + 1] = centerY + radius * Math.sin(angle);
            angle += Math.PI / 3; // Increment by PI/3 (60 degrees) for a hexagon
        }

        return points;
    }
}
