Feature: Login

  @validLogin
    Scenario: Open Login Page
    Given Navigate to Page Phone Book
    When Click on Login button
    And Click on Login button
    Then SignOut button is displayd

  @invalidLogin
  Scenario Outline: Invalid Login
    Given Navigate to Page Phone Book
    When Enter invalid data
    |email  |password  |
    |<email>|<password>|
    And Click on Login button
    Then Alert is displayed
    Examples:
      | email             | password |
      |  "asdas@asdas.aa" | "sdlvnsjk"|
      |  "dvd@vdafv.trt"  | "svsvsvsvs"|

