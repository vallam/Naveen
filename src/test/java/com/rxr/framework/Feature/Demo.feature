
Feature: CucumberPOC

  #________________________________________________________________________________________________
@Wag_LoginScreen_Scenario
  Scenario: Selecting Enter login credentials
Given Logged in as Pharmacy User
Then should see dropdown labeled  Plan
When Select a valid value from the drop down
       | InputFileName     | SheetName      | RowId    |
       |  rxr_Input        | dropDown       | DropDown1 |
Then should see TextBox labeled  BIN
Then should see TextBox labeled  PCN
Then should see TextBox labeled  Plan ID
Then should see TextBox labeled  Plan Name
Then should see enabled button labeled  Search
When user enters six numaric character as valid BIN_Number
       | InputFileName     | SheetName      | RowId    |
       |  rxr_Input        | PlanSearch     | Row_one |
And click on Search button 
When click on back button
And user enter six numaric charecter as valid BIN_Number
       | InputFileName     | SheetName      | RowId    |
       |  rxr_Input        | PlanSearch     | Row_two |
And click on Search button
Then should see error       