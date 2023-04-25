package roborally;


import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;

public class StepsDefinition {

	

	@Given("a robot with current position null")
	public void a_robot_with_current_position_null() {
        robot = new Robot();
        robot.setCurrentPosition(null);
    }		
		
		
	}
	@Given("picked position is within the board")
	public void picked_position_is_within_the_board() {
	gameBoard = new GameBoard(10); // Board size is 10
		
		
	}
	@When("picking starting position")
	public void picking_starting_position() {
		startingPositionPicker = new StartingPositionPicker(robot, gameBoard);
        startingPositionPicker.pickStartingPosition(new Position(5, 5)); // Pick a position on the board
		
		
	}
	@Then("game returns a response message that the startposition for robot has been placed")
	public void game_returns_a_response_message_that_the_startposition_for_robot_has_been_placed() {
	    // Write code here that turns the phrase above into concrete actions
//	    throw new io.cucumber.java.PendingException();
	}
	
}

