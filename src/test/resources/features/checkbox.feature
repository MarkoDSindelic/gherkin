Feature: Checkboxes
  Scenario: User can click on checkboxes
    Given User is on the checkbox page
    When User clicks checkbox one 1
    And User clicks checkbox two 2
    Then Checkbox is checked 1
    And Checkbox is unchecked 2
    #could make a list if there were more than 2 checkboxes to test here

