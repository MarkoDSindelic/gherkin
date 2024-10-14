Feature: Checkboxes
  Scenario: User can click on checkboxes
    Given User is on the checkbox page
    When User clicks checkbox one "1"
    And User clicks checkbox two "2"
    Then Checkbox one is checked "1"
    And Checkbox two is unchecked "2"
