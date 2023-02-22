Feature: forgotPass

  @forgotValidLogin
  Scenario: Open Login Page
    Given Click on Forgot password
    When Click on Email field
    And Click on Send button
    Then Alert is displayed

  @forgotInvalidLogin
  Scenario: Open Login Page
    Given Click on Forgot password
    When Click on Email field
    And Click on Send button
    Then Alert is displayed
