Feature: Checkboxes
  Scenario: User can click on checkboxes
    Given User is on the checkbox page
    When User clicks checkbox 1
    And User clicks checkbox 2
    Then Checkbox 1 is checked
    And Checkbox 2 is unchecked
