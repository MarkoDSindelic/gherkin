Feature: User can login
  Scenario: Validate user can login
    Given User is on the login page
    When User enters valid username "tomsmith"
    And User enters valid password "SuperSecretPassword!"
    And User clicks login button
    Then User is logged in
