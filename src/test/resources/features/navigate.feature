Feature: Navigate

  @navigate
  Scenario: Open Login Page
    Given Navigate to Page Phone Book
    When Register new account link
    Then Registration form should appear
