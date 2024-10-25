Feature: Checkboxes
  Scenario: User can click on checkboxes
    Given User is on the checkbox page
    When User clicks checkbox
    | checkbox |
    | 1 |
    | 2 |
    Then Checkbox is checked
    | checkbox |
    | 1 |
    Then Checkbox is unchecked
    | checkbox |
    | 2 |

