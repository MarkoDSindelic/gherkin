Feature: Dropdown select
  Scenario: User can select options from dropdown menu
    Given user is on the dropdown page
    When user clicks the menu and selects
      | field         | options  |
      | menu_dropdown | Option 1 |
      | menu_dropdown | Option 2 |
    Then Correct option is selected
      | field         | options  |
      | menu_dropdown | Option 1 |
      | menu_dropdown | Option 2 |
