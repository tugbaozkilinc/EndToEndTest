@end_to_end_test_room_assertion, @e2e
Feature: US_01 Medunna Room Creation

  Scenario: TC_02 Assert Room
    Given user sends get request for room data
    And user gets the room data and assert the response which he gets with get request