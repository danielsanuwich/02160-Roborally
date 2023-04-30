package app;

import app.Model.board.Direction;
import app.Model.board.GameBoard;
import app.Model.board.HexagonalCell;
import app.Model.board.MakeGameBoardLayout1;
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

        @Override
        public void start(Stage primaryStage) throws Exception {
                // Create a MakeGameBoardLayout1 object and generate the board
                MakeGameBoardLayout1 boardMaker = new MakeGameBoardLayout1();
                GameBoard gameBoard = boardMaker.gb();
                Tile[][] board = gameBoard.getTiles(); // Assuming you have a getTiles() method in GameBoard class

                FXMLLoader loader = new FXMLLoader(getClass().getResource("/app/view/MainFrameViewer.fxml"));
                Parent root = loader.load();
                Scene scene = new Scene(root);

                Pane topPane = (Pane) loader.getNamespace().get("topPane");
                Pane hexagonBoardPane = (Pane) loader.getNamespace().get("hexagonalGridPlaceholder");
                GridPane gridPane = createHexagonalMap(board);
                hexagonBoardPane.getChildren().add(gridPane);

                gridPane.prefWidthProperty().bind(hexagonBoardPane.widthProperty());
                gridPane.prefHeightProperty().bind(hexagonBoardPane.heightProperty());
                gridPane.maxWidthProperty().bind(hexagonBoardPane.widthProperty());
                gridPane.maxHeightProperty().bind(hexagonBoardPane.heightProperty());

                primaryStage.setScene(scene);
                primaryStage.show();

        }

        private GridPane createHexagonalMap(GameBoard gameBoard) {
                GridPane gridPane = new GridPane();

                MakeGameBoardLayout1 layout = new MakeGameBoardLayout1();
                GameBoard gameBoard = layout.gb();

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
                                        double offsetY = (col % 2 == 0) ? 0 : cellHeight / 2;

                                        // Set the cell's position in the grid
                                        hexagonalCell.setTranslateY(offsetY);

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
