Feature: Dropdown select
  Scenario: User can select options from dropdown menu
    Given user is on the dropdown page
    When user clicks the menu and selects
      | field    | options  |
      | dropdown | Option 1 |
      | dropdown | Option 2 |
    Then Correct option is selected
      | field    | options  |
      | dropdown | Option 1 |
      | dropdown | Option 2 |
