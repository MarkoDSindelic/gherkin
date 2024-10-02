Feature: Dropdown select
  Scenario: User can select options from dropdown menu
    Given user is on the dropdown page
    When user clicks the menu and selects "1"
    Then Option 1 is selected "1"

  Scenario:
    Given user is on the dropdown page
    When user clicks the menu and selects "2"
    Then Option 2 is selected "2"