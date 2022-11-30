@Search
Feature: Test

  Scenario: Input invalid email
    When I go to forgot password page
    And I input "unexisted_email@gmail.com" into email field
    Then I can see error message displayed

  Scenario: Send forgot password successfully
    When I go to forgot password page
    And I input "existed_email@gmail.com" into email field
    And I click send button
    Then I can see request accepted message






