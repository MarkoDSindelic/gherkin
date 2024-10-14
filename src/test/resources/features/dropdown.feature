Feature: Dropdown select
  Scenario: User can select options from dropdown menu
    Given user is on the dropdown page
    When user clicks the menu and selects "Option 1"
    Then Option 1 is selected "Option 1"

  Scenario:
    Given user is on the dropdown page
    When user clicks the menu and selects "Option 2"
    Then Option 2 is selected "Option 2"