@end_to_end_test_room_creation, @e2e
Feature: US_01 Medunna Room Creation

  Background: Sign In Medunna
    Given user goes to the url "https://www.medunna.com"
    When user clicks on user icon
    And user clicks on Sign in option in an open window
    And user enters valid username and password
      | username      | password |
      | TugbaOzkilinc | 8822tuba |
    And user clicks on Remember me checkbox
    And user clicks on Sign in submit button

  Scenario Outline: TC_01 Create Room
    And user clicks on Items&Titles icon
    And user clicks on Room option in an open window
    And user clicks on Create a new Room button
    And user enters a valid room number value for Room Number input
    And user selects DAYCARE option from Room Type dropdown
    And user clicks on Status check box
    And user enters a valid price value "<price>" for price input
    And user enters a valid description value "<description>" for description input
    And user clicks on Save button
    Then user should see A new Room is created with identifier message "<message>"
    And user closes the application
  Examples:
    | price | description         | message                               |
    | 200   | What a lovely view! | A new Room is created with identifier |


