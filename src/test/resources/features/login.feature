Feature: Login
@Valid
  Scenario: User can login with valid credentials
    Given User is on the login page
    When User enters username "tomsmith"
    And User enters password "SuperSecretPassword!"
    And User clicks login button
    Then User is logged in
@Invalid
  Scenario: User cannot login with invalid credentials
    Given User is on the login page
    When User enters username "someUsername"
    And User enters password "SomeRandomPassword!"
    And User clicks login button
    Then User is not logged in

