Feature: Jira

@Jira         @Testrun
  Scenario: Validating Jira login page
  Given user navigates to Jira login page
  When user fills authentication details
  Then user should be able login