@tag
Feature: As a player I want to pick my robots starting position

  @tag1
  Scenario: Successfully picked starting position for robot
    Given a robot with current position null
    And picked position is within the board
    When picking starting position
    Then game returns a response message that the startposition for robot has been placed

  Scenario: Picked starting position outside of board for robot
    Given a robot with current position null
    And picked position is outside the board
    When picking starting position
    Then game returns a response message that the startposition for robot has NOT been placed


  Scenario: Already picked starting position for robot
    Given a robot with current position on board
    And picked position is within the board
    When picking starting position
    Then game returns a error response message that the startposition for robot has already been placed    
    