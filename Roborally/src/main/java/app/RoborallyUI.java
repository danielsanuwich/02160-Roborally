package app;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import app.Model.Robot;
import app.Model.board.Direction;
import app.Model.board.GameBoard;
import app.Model.board.HexagonalCell;
import app.Model.board.MakeGameBoardLayout1;
import app.Model.board.Position;
import app.Model.tiles.*;
import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.SplitPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.transform.Rotate;
import javafx.stage.Stage;
import javafx.fxml.FXML;

public class RoborallyUI extends Application implements Initializable{
        @FXML
        private GridPane cardDeckGrid;
        
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
                List<Robot> robots = createRobotOnStartTile(gameBoard);
                GridPane gridPane = createHexagonalMap(gameBoard, robots);
                hexagonBoardPane.getChildren().add(gridPane);
                gridPane.prefWidthProperty().bind(hexagonBoardPane.widthProperty());
                gridPane.prefHeightProperty().bind(hexagonBoardPane.heightProperty());
                gridPane.maxWidthProperty().bind(hexagonBoardPane.widthProperty());
                gridPane.maxHeightProperty().bind(hexagonBoardPane.heightProperty());

                SplitPane playerCardsPane = (SplitPane) loader.getNamespace().get("playerCardPane");
                
                primaryStage.setScene(scene);
                primaryStage.show();

        }

        private void addCardImagesToGrid() {
                String[] cardImages = {
                    "/images/HealthCard1.png",
                    "/images/HealthCard2.png",
                    "/images/ProgramCardCCW1.png",
                    "/images/ProgramCardCW1.png",
                    "/images/ProgramCardMove1.png",
                    "/images/ProgramCardMove2.png",
                    "/images/ProgramCardMove3.png",
                };
            
                for (int i = 0; i < cardImages.length; i++) {
                    Image image = new Image(getClass().getResourceAsStream(cardImages[i]));
                    ImageView imageView = new ImageView(image);
                    imageView.setFitWidth(50); // Adjust the width of the card image
                    imageView.setFitHeight(80); // Adjust the height of the card image
            
                    cardDeckGrid.add(imageView, i, 0); // Place the card image in the GridPane
                }
            }
        private List<Robot> createRobotOnStartTile(GameBoard gameBoard) {
                Tile[][] board = gameBoard.getTiles();
                int xDim = gameBoard.getXDim();
                int yDim = gameBoard.getYDim();
                List<Robot> robots = new ArrayList<>();

                for (int i = 0; i < xDim; i++) {
                        for (int j = 0; j < yDim; j++) {
                        Tile tile = board[i][j];
                        if (tile instanceof StartTile) {
                                Robot robot = new Robot(tile.getPosition(), tile.getDirection(), 5, robots.size() + 1, "Robot" + (robots.size() + 1));
                                robots.add(robot);
                        }
                        }
                }

                if (robots.isEmpty()) {
                        throw new IllegalStateException("No StartTile found on the game board.");
                }

                return robots;
            }
            
        private GridPane createHexagonalMap(GameBoard gameBoard, List <Robot> robots) {
                GridPane gridPane = new GridPane();

                Tile[][] board = gameBoard.getTiles();
                int xDim = gameBoard.getXDim();
                int yDim = gameBoard.getYDim();
                int player = 2;

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
                                        
                                        for (Robot robot : robots) {
                                                if (tile.getPosition().equals(robot.getPosition())) {
                                                        String imagePath = "/images/Mech" + player + ".png";
                                                        ImageView robotView = new ImageView(new Image(getClass().getResourceAsStream(imagePath)));
                                                        robotView.setFitWidth(cellWidth * 0.8);
                                                        robotView.setFitHeight(cellHeight * 0.8);
                                                        hexagonalCell.getChildren().add(robotView);
                                                        player+=1;
                                                        System.out.println("WHAT" + imagePath);
                                                }
                                        }
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

        @Override
        public void initialize(URL location, ResourceBundle resources) {
                addCardImagesToGrid();
        }
}
