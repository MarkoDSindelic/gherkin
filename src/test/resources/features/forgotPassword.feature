Feature: Forgot Password
  Scenario: I can retrieve my password if I forget it
    Given I am on the forgot password page
    When I enter my email
         | email_field        |
         |some_email@test.com |
    And I click retrieve password button
        | retrieve_password_button |
        |                          |
    Then I get my password
