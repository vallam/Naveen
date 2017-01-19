Feature: CucumberDemo

@Wag_Demo_Scenario
  Scenario: Wag demo user
   # Given Pharmacy user launch the App
    Then Pharmacy user Login with login credentials
      | InputFileName | SheetName | RowId    |
      | rxr_Input     | LoginData | User3    |
    #Then User search with patient name