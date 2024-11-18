Feature: Forgot Password
  Scenario: I can retrieve my password if I forget it
    Given I am on the forgot password page
    When I enter my email in the
         |email_input         |
         |some_email@test.com |
    And I click
        | retrievePassword_button  |
        |                          |
    Then I get my password
