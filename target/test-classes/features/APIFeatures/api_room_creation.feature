@api_test
Feature: Room Creation

  Scenario: TC01_Post_Room
    Given user sends post request for room data
    Then user gets the room data and assert the data