public class StartingPositionPicker {
    private Robot robot;
    private GameBoard gameBoard;

    public StartingPositionPicker(Robot robot, GameBoard gameBoard) {
        this.robot = robot;
        this.gameBoard = gameBoard;
    }

    public void pickStartingPosition(Position position) {
        if (gameBoard.isPositionWithinBoard(position)) {
            robot.setCurrentPosition(position);
        }
    }
}
