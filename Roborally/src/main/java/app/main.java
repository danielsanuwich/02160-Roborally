package app;

import app.Model.board.Direction;

public class main {

    public static void main(String[] args) {
        // create a new direction object with initial direction 0
        Direction dir = new Direction(0);

        // test the initial direction value
        assert dir.getDirection() == 0;

        // test setting the direction value to a positive number
        dir.setDirection(3);
        assert dir.getDirection() == 3;

        // test setting the direction value to a negative number
        dir.setDirection(-2);
        assert dir.getDirection() == 4;

        // test setting the direction value to a large positive number
        dir.setDirection(13);
        assert dir.getDirection() == 1;

        // test setting the direction value to a large negative number
        dir.setDirection(-17);
        assert dir.getDirection() == 5;

        // print a message indicating that all tests passed
        System.out.println("All tests passed!");
    }

}
