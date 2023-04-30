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
import javafx.scene.control.SplitPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.transform.Rotate;
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

                GridPane gridPane = createHexagonalMap(gameBoard);
                hexagonBoardPane.getChildren().add(gridPane);
                gridPane.prefWidthProperty().bind(hexagonBoardPane.widthProperty());
                gridPane.prefHeightProperty().bind(hexagonBoardPane.heightProperty());
                gridPane.maxWidthProperty().bind(hexagonBoardPane.widthProperty());
                gridPane.maxHeightProperty().bind(hexagonBoardPane.heightProperty());

                SplitPane playerCardsPane = (SplitPane) loader.getNamespace().get("playerCardPane");
                
                primaryStage.setScene(scene);
                primaryStage.show();

        }

        private GridPane createHexagonalMap(GameBoard gameBoard) {
                GridPane gridPane = new GridPane();

                Tile[][] board = gameBoard.getTiles();
                int xDim = gameBoard.getXDim();
                int yDim = gameBoard.getYDim();


                double cellWidth = 100; // Adjust the size of the hexagonal cell's width
                double cellHeight = 86.6; // Adjust the size of the hexagonal cell's height

                // Debugger to see if it is being called correctly.
                System.out.println("Creating hexagonal map for board:");
                for (Tile[] row : board) {
                        for (Tile tile : row) {
                                System.out.print(tile.getPosition() + " ");
                        }
                        System.out.println();
                }

                for (int i = 0; i < xDim; i++) {
                        for (int j = 0; j < yDim; j++) {
                                Tile tile = board[i][j];

                                if (tile != null) { // Only create cells for tiles
                                        // Create a hexagonal cell for the tile
                                        HexagonalCell hexagonalCell = new HexagonalCell(cellWidth, cellHeight, tile);

                                        // Add the hexagonal cell to the grid pane
                                        gridPane.add(hexagonalCell, i, j);

                                        // Calculate the offset for the hexagonal layout
                                        double offsetY = (i % 2 == 0) ? (cellHeight / 2) : 0 ;
                                        
                                        // Set the cell's position in the grid
                                        hexagonalCell.setTranslateY(offsetY);
                                        if (i != 0){
                                                hexagonalCell.setTranslateX(-28.867513459481298 * i);
                                        }

                                        // // Add a label to display the tile type
                                        // Label label = new Label(tile.getType());
                                        // gridPane.add(label, i, j);
                                }
                        }
                }
                return gridPane;
        }

        public static void main(String[] args) {
                launch(args);
        }
}
