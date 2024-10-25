Feature: Login
  Scenario: User can login with valid credentials
    Given User is on the login page
    When User logs in with valid credentials
      | username      | password              |
      | tomsmith      |  SuperSecretPassword! |
    Then User is logged in

  Scenario: User cannot login with invalid credentials
    Given User is on the login page
    When User tries to login with invalid credentials
      | username            | password            |
      | bad username        | bad password        |
    Then User is not logged in
    When User tries to login with invalid credentials
      | username            | password            |
      | wrongUsername123    | SuperWrongPassword! |
    Then User is not logged in
    When User tries to login with invalid credentials
      | username            | password            |
      | some other username | incorrect Password15|
    Then User is not logged in


