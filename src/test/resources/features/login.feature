Feature: Login
  Scenario: User can login with valid credentials
    Given User is on the login page
    When User enters username "tomsmith"
    And User enters password "SuperSecretPassword!"
    And User clicks login button
    Then User is logged in

  Scenario: User cannot login with invalid credentials
    Given User is on the login page
    When User enters username "some username"
    And User enters password "some wrong password"
    And User clicks login button
    Then User is not logged in

  Scenario: User tries different invalid credentials
    Given User is on the login page
    When User tries to login with invalid credentials
      | username            | password            |
      | bad username        | bad password        |
      | wrongUsername123    | SuperWrongPassword! |
      | some other username | incorrect Password15|
    Then User is not logged in


