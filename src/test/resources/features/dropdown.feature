Feature: Dropdown select
  Scenario: User can select options from dropdown menu
    Given user is on the dropdown page
    When user clicks the menu and selects
      | dropdown_dropdown |
      | Option 1 |
      | Option 2 |
    Then Correct option is selected
      | dropdown_dropdown |
      | Option 1 |
      | Option 2 |
