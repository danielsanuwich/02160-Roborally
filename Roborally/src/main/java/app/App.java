package app;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import app.Model.board.Direction;
import app.Model.board.HexagonalCell;
import app.Model.board.Position;
import app.Model.tiles.*;

public class App extends Application {
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
					new Tile("Base", new Position(8, 1), new Direction(0)), new FlagTile(new Position(9, 1)),
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
					new LaserTile(new Position(8, 4), new Direction(2), 1), new FlagTile(new Position(9, 4)),
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
					new ConveyorTile(new Position(1, 6), new Direction(1)), new FlagTile(new Position(2, 6)),
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

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {

		// Set up the main layout container
		BorderPane root = new BorderPane();

		// Create the hexagonal map and the card layout
		GridPane hexagonalMap = createHexagonalMap(BOARD);
		// TODO
		// GridPane cardLayout = createCardLayout();

		// Add hexagonal map and card layout to the main layout container
		root.setTop(hexagonalMap);
		// root.setBottom(cardLayout);

		// Set up the scene and stage
		Scene scene = new Scene(root, 800, 600);
		primaryStage.setTitle("Hexagonal Game UI");
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	private GridPane createHexagonalMap(Tile[][] board) {
		int numRows = board.length;
		int numCols = board[0].length;

		GridPane hexagonalMap = new GridPane();
		hexagonalMap.setHgap(0);
		hexagonalMap.setVgap(0);

		double hexWidth = 60;
		double hexHeight = 60;

		for (int row = 0; row < numRows; row++) {
			for (int col = 0; col < numCols; col++) {
				Tile tile = board[row][col];
				HexagonalCell hexagonalCell = new HexagonalCell(hexWidth, hexHeight, tile);

				hexagonalMap.add(hexagonalCell, col, row);

				double offsetX = (col % 2 == 0) ? hexHeight / 2 : 0;
				hexagonalCell.setLayoutX(col * (hexWidth * 0.75));
				hexagonalCell.setLayoutY(row * (hexHeight * 0.5) + offsetX);
			}
		}

		return hexagonalMap;
	}

	// TODO:
	// private GridPane createCardLayout() {
	// GridPane cardLayout = new GridPane();

	// // Create 5 empty programming card slots
	// for (int i = 0; i < 5; i++) {
	// // Add your card UI element to the grid
	// // e.g., cardLayout.add(new Card(), columnIndex, rowIndex);
	// // Replace 'Card' with your card UI element class
	// cardLayout.add(new Card(), i, 0);
	// }

	// // Create 7 empty command card slots
	// for (int i = 0; i < 7; i++) {
	// // Add your card UI element to the grid
	// // e.g., cardLayout.add(new Card(), columnIndex, rowIndex);
	// // Replace 'Card' with your card UI element class
	// cardLayout.add(new Card(), i, 1);
	// }

	// return cardLayout;
	// }

}
