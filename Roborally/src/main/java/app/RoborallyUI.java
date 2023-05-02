package app;

import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.ResourceBundle;

import app.Model.Robot;
import app.Model.board.Direction;
import app.Model.board.GameBoard;
import app.Model.board.HexagonalCell;
import app.Model.board.MakeGameBoardLayout1;
import app.Model.board.MakeGameBoardLayout2;
import app.Model.board.MakeGameBoardLayout3;
import app.Model.board.Position;
import app.Model.cards.Card;
import app.Model.cards.CardCell;
import app.Model.cards.HealthCard;
import app.Model.cards.ProgramCard;
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
import javafx.geometry.Insets;

public class RoborallyUI extends Application{
        Card[] cards = {new HealthCard(1), new HealthCard(2), new HealthCard(3), new ProgramCard(1,0), new ProgramCard(-1,0), new ProgramCard(0, 1), new ProgramCard(0, 2), new ProgramCard(0,3), new HealthCard(1)};

        @Override
        public void start(Stage primaryStage) throws Exception {
                // Create a MakeGameBoardLayout1 object and generate the board
                MakeGameBoardLayout3 boardMaker = new MakeGameBoardLayout3();
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

                Pane cardPane = (Pane) loader.getNamespace().get("cardDeckGrid");
                GridPane cardGridPane = createCardDeck(cards);
                cardPane.getChildren().add(cardGridPane);
                SplitPane playerCardsPane = (SplitPane) loader.getNamespace().get("playerCardPane");
                
                primaryStage.setScene(scene);
                primaryStage.show();

        }

        private GridPane createCardDeck(Card[] cards) {
                GridPane gridPane = new GridPane();
                gridPane.setPadding(new Insets(10));
                gridPane.setHgap(10);
                gridPane.setVgap(10);
            
                // Create 5 empty card slots in the first row
                for (int i = 0; i < 5; i++) {
                    Pane emptyCardSlot = new Pane();
                    emptyCardSlot.setMinSize(20, 60);
                    emptyCardSlot.setStyle("-fx-border-color: #000000; -fx-border-width: 2");
                    gridPane.add(emptyCardSlot, i, 0);
                }
            
                // Shuffle the cards array
                Collections.shuffle(Arrays.asList(cards));
            
                // Create the card cells for the 9 randomly generated cards in the second row
                for (int i = 0; i < 9; i++) {
                    CardCell cardCell = new CardCell(50, 75, cards[i]);
                    gridPane.add(cardCell, i, 1);
            
                    // Add click event listener
                    cardCell.setOnMouseClicked(e -> {
                        ObservableList<Node> cardSlots = gridPane.getChildren();
                        for (Node slot : cardSlots) {
                            // Check if the slot is in the first row and is empty
                            if (GridPane.getRowIndex(slot) == 0 && slot instanceof Pane && ((Pane) slot).getChildren().isEmpty()) {
                                // Add the clicked card to the empty slot
                                ImageView cardImage = new ImageView(((ImageView) cardCell.getChildren().get(1)).getImage());
                                cardImage.setFitWidth(50);
                                cardImage.setFitHeight(75);
                                ((Pane) slot).getChildren().add(cardImage);
            
                                // Remove the card from the second row
                                cardCell.getChildren().clear();
                                cardCell.setStyle("-fx-background-color: transparent");
                                break;
                            }
                        }
                    });
                }
            
                return gridPane;
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

                double cellWidth = 50; // Adjust the size of the hexagonal cell's width
                double cellHeight = 43.3; // Adjust the size of the hexagonal cell's height

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
                                                hexagonalCell.setTranslateX(-28.867513459481298 * i / 2);
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
