Feature: Gmailreg

@Gmailreg         @Testrun
  Scenario: Validating Gmail login page
  Given user navigates to Gmail login page
  When user fills authentication details
  Then user should be able login