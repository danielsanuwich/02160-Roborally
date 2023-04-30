package app;

import app.Model.board.Direction;
import app.Model.board.HexagonalCell;
import app.Model.board.Position;
import app.Model.tiles.*;
import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class RoborallyUI extends Application {
        private static final Tile[][] BOARD = {
                        { new HoleTile(new Position(0, 0), new Direction(0), 1),
                                        new HoleTile(new Position(1, 0), new Direction(0), 0),
                                        new HoleTile(new Position(2, 0), new Direction(0), 0),
                                        new HoleTile(new Position(3, 0), new Direction(0), 0),
                                        new HoleTile(new Position(4, 0), new Direction(0), 0),
                                        new HoleTile(new Position(5, 0), new Direction(0), 0),
                                        new HoleTile(new Position(6, 0), new Direction(0), 0),
                                        new HoleTile(new Position(7, 0), new Direction(0), 0),
                                        new HoleTile(new Position(8, 0), new Direction(0), 0),
                                        new HoleTile(new Position(9, 0), new Direction(0), 0),
                                        new HoleTile(new Position(10, 0), new Direction(0), 1) },
                        { new HoleTile(new Position(0, 1), new Direction(0), 1),
                                        new Tile("F", new Position(1, 1), new Direction(0)),
                                        new Tile("Base", new Position(2, 1), new Direction(0)),
                                        new Tile("Base", new Position(3, 1), new Direction(0)),
                                        new TurnTile(new Position(4, 1), new Direction(0), 3),
                                        new Tile("Base", new Position(5, 1), new Direction(0)),
                                        new ConveyorTile(new Position(6, 1), new Direction(2)),
                                        new Tile("Base", new Position(7, 1), new Direction(0)),
                                        new Tile("Base", new Position(8, 1), new Direction(0)),
                                        new FlagTile(new Position(9, 1)),
                                        new HoleTile(new Position(10, 1), new Direction(0), 1) },
                        { new HoleTile(new Position(0, 2), new Direction(0), 1),
                                        new LaserTile(new Position(1, 2), new Direction(0), 1),
                                        new ConveyorTile(new Position(2, 2), new Direction(4)),
                                        new ConveyorTile(new Position(3, 2), new Direction(4)),
                                        new ConveyorTile(new Position(4, 2), new Direction(5)),
                                        new Tile("Base", new Position(5, 2), new Direction(0)),
                                        new StartTile(new Position(6, 2), new Direction(0)),
                                        new ConveyorTile(new Position(7, 2), new Direction(2)),
                                        new ConveyorTile(new Position(8, 2), new Direction(3)),
                                        new LaserTile(new Position(9, 2), new Direction(0), 1),
                                        new HoleTile(new Position(10, 2), new Direction(0), 1) },
                        { new HoleTile(new Position(0, 3), new Direction(0), 1),
                                        new LaserTile(new Position(1, 3), new Direction(0), 1),
                                        new Tile("Base", new Position(2, 3), new Direction(0)),
                                        new TurnTile(new Position(3, 3), new Direction(0), 1),
                                        new HoleTile(new Position(4, 3), new Direction(0), 0),
                                        new ConveyorTile(new Position(5, 3), new Direction(5)),
                                        new ConveyorTile(new Position(6, 3), new Direction(5)),
                                        new Tile("Base", new Position(7, 3), new Direction(0)),
                                        new ConveyorTile(new Position(8, 3), new Direction(3)),
                                        new LaserTile(new Position(9, 3), new Direction(0), 1),
                                        new HoleTile(new Position(10, 3), new Direction(0), 1) },
                        { new HoleTile(new Position(0, 4), new Direction(0), 1),
                                        new TurnTile(new Position(1, 4), new Direction(0), 1),
                                        new Tile("Base", new Position(2, 4), new Direction(0)),
                                        new StartTile(new Position(3, 4), new Direction(0)),
                                        new HoleTile(new Position(4, 4), new Direction(0), 1),
                                        new HoleTile(new Position(5, 4), new Direction(0), 1),
                                        new Tile("Base", new Position(6, 4), new Direction(0)),
                                        new ConveyorTile(new Position(7, 4), new Direction(5)),
                                        new LaserTile(new Position(8, 4), new Direction(2), 1),
                                        new FlagTile(new Position(9, 4)),
                                        new HoleTile(new Position(10, 4), new Direction(0), 1) },
                        { new HoleTile(new Position(0, 5), new Direction(0), 1),
                                        new Tile("Base", new Position(1, 5), new Direction(0)),
                                        new ConveyorTile(new Position(2, 5), new Direction(2)),
                                        new Tile("Base", new Position(3, 5), new Direction(0)),
                                        new LaserTile(new Position(4, 5), new Direction(1), 1),
                                        new LaserTile(new Position(5, 5), new Direction(1), 1),
                                        new TurnTile(new Position(6, 5), new Direction(0), -1),
                                        new StartTile(new Position(7, 5), new Direction(0)),
                                        new TurnTile(new Position(8, 5), new Direction(0), 1),
                                        new LaserTile(new Position(9, 5), new Direction(2), 1),
                                        new HoleTile(new Position(10, 5), new Direction(0), 1) },
                        { new HoleTile(new Position(0, 6), new Direction(0), 1),
                                        new ConveyorTile(new Position(1, 6), new Direction(1)),
                                        new FlagTile(new Position(2, 6)),
                                        new ConveyorTile(new Position(3, 6), new Direction(2)),
                                        new ConveyorTile(new Position(4, 6), new Direction(1)),
                                        new ConveyorTile(new Position(5, 6), new Direction(1)),
                                        new Tile("Base", new Position(6, 6), new Direction(0)),
                                        new HoleTile(new Position(7, 6), new Direction(0), 1),
                                        new Tile("Base", new Position(8, 6), new Direction(0)),
                                        new Tile("Base", new Position(9, 6), new Direction(0)),
                                        new HoleTile(new Position(10, 6), new Direction(0), 1) },
                        { new HoleTile(new Position(0, 7), new Direction(0), 1),
                                        new HoleTile(new Position(1, 7), new Direction(0), 0),
                                        new HoleTile(new Position(2, 7), new Direction(0), 0),
                                        new HoleTile(new Position(3, 7), new Direction(0), 0),
                                        new HoleTile(new Position(4, 7), new Direction(0), 0),
                                        new HoleTile(new Position(5, 7), new Direction(0), 0),
                                        new HoleTile(new Position(6, 7), new Direction(0), 0),
                                        new HoleTile(new Position(7, 7), new Direction(0), 0),
                                        new HoleTile(new Position(8, 7), new Direction(0), 0),
                                        new HoleTile(new Position(9, 7), new Direction(0), 1),
                                        new HoleTile(new Position(10, 7), new Direction(0), 1) },
        };

        @Override
        public void start(Stage primaryStage) throws Exception {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/app/view/MainFrameViewer.fxml"));
                Parent root = loader.load();
                Scene scene = new Scene(root);

                Pane hexagonBoardPane = (Pane) loader.getNamespace().get("hexagonBoardPane");
                GridPane gridPane = createHexagonalMap(BOARD);
                hexagonBoardPane.getChildren().add(gridPane);

                primaryStage.setScene(scene);
                primaryStage.show();

        }

        private GridPane createHexagonalMap(Tile[][] board) {
                GridPane gridPane = new GridPane();

                double cellWidth = 60; // Adjust the size of the hexagonal cell's width
                double cellHeight = 60; // Adjust the size of the hexagonal cell's height

                // Debugger to see if it is being called correctly.
                System.out.println("Creating hexagonal map for board:");
                for (Tile[] row : board) {
                        for (Tile tile : row) {
                                System.out.print(tile.getPosition() + " ");
                        }
                        System.out.println();
                }

                for (int row = 0; row < board.length; row++) {
                        for (int col = 0; col < board[row].length; col++) {
                                Tile tile = board[row][col];

                                if (tile != null) { // Only create cells for tiles
                                        // Create a hexagonal cell for the tile
                                        HexagonalCell hexagonalCell = new HexagonalCell(cellWidth, cellHeight, tile);

                                        // Add the hexagonal cell to the grid pane
                                        gridPane.add(hexagonalCell, col, row);

                                        // Calculate the offset for the hexagonal layout
                                        double offsetX = (row % 2 == 0) ? 0 : cellWidth / 2;

                                        // Set the cell's position in the grid
                                        hexagonalCell.setTranslateX(offsetX);

                                        // Add a label to display the tile type
                                        Label label = new Label(tile.getType());
                                        gridPane.add(label, col, row);
                                }
                        }
                }

                return gridPane;
        }

        public static void main(String[] args) {
                launch(args);
        }
}
