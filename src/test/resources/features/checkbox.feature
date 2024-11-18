Feature: Checkboxes
  Scenario: User can click on checkboxes
    Given User is on the checkbox page
    When User clicks checkbox
    | checkboxOne_checkbox |
    | checkboxTwo_checkbox |
    Then Checkbox is checked
    | checkboxOne |
    Then Checkbox is unchecked
    | checkboxTwo |


