Feature: Checkboxes
  Scenario: User can click on checkboxes
    Given User is on the checkbox page
    When User clicks checkbox
    | 1 | 2 |
    Then Checkbox is checked
    | 1 |
    Then Checkbox is unchecked
    | 2 |

