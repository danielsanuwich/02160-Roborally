package app;

import app.Model.board.Direction;

public class Main {

    public static void main(String[] args) {
        // create a new Direction object with initial direction 0
        Direction direction = new Direction(0);

        try {
            // test the initial direction value
            assert direction.getDirection() == 0;

            // test setting the direction value to a positive number
            direction.setDirection(3);
            assert direction.getDirection() == 3;

            // test setting the direction value to a negative number
            direction.setDirection(-2);
            assert direction.getDirection() == 4;

            // test setting the direction value to a large positive number
            direction.setDirection(13);
            assert direction.getDirection() == 1;

            // test setting the direction value to a large negative number
            direction.setDirection(-17);
            assert direction.getDirection() == 5;

            // print a message indicating that all tests passed
            System.out.println("All tests passed!");
        } catch (AssertionError e) {
            // print a message indicating that the test did not pass
            System.out.println("Test not passed: " + e.getMessage());
        }
    }
}
