#@JPMC_Demo
#@RxR_Framework
Feature: Payor search 


#Given step is used to set the context
#When step is the action/ interaction with the system
#Then step for representing the outcome
#And step for extending the previous step
#But step for more readability
#Data Tables
  #________________________________________________________________________________________________
  @Wag_LoginScreen_Scenario121
  Scenario:Selecting Enter login credentials
Given Logged in as a Pharmacy user
When user navigates to dashboard page
Then user will be able to see  dropdown labeled  Plan
Then  user will be able to see TextBox labeled  BIN
And  user will be able to see TextBox labeled  PCN
And  user will be able to see TextBox labeled  Plan ID
And  user will be able to see TextBox labeled  Plan Name
And  user will be able to see button labeled  Search
When user enters |123456|

#And user enters six numaric charecter as valid BIN_Number
       #| InputFileName     | SheetName      | RowId    |
       #|  RxR_PlanSearch   | BINPCN         | V_BIN_01 |
And user click on Search button 
Then validate search results

  @Wag_LoginScreen_Scenario121
  Scenario:Selecting Enter login credentials
Given Logged in as a Pharmacy user
When user navigates to dashboard page
Then user will be able to see  dropdown labeled  Plan
Then  user will be able to see TextBox labeled  BIN
And  user will be able to see TextBox labeled  PCN
And  user will be able to see TextBox labeled  Plan ID
And  user will be able to see TextBox labeled  Plan Name
And  user will be able to see button labeled  Search
When user enters |Bin| 
#allows only six charecters
|Bin |
|34567|
|123456|
|abcdef|
|@#$$%%%^^|


#And user enters six numaric charecter as valid BIN_Number
       #| InputFileName     | SheetName      | RowId    |
       #|  RxR_PlanSearch   | BINPCN         | V_BIN_01 |
And user click on Search button 
Then validate search results

@Function1
  Scenario: Wag(Search Verification)
When user goes back to dashboard page
And user enters six numaric charecter as valid BIN_Number
       | InputFileName     | SheetName      | RowId    |
       |  RxR_PlanSearch   | BINPCN         | V_BINPCN_01 |
And user enters PCN numaric charecter as valid |PCN_Number|
       | InputFileName     | SheetName      | RowId    |
       |  RxR_PlanSearch   | BINPCN         | V_PBINCN_01 |
And user click on Search button 
Then validate search results

@Function2
  Scenario: Wag
When user goes back to dashboard page
And user enters three chars for Plan Name as valid Plan Name
       | InputFileName     | SheetName      | RowId    |
       |  RxR_PlanSearch   | PlanName         | V_PLNNME_01 |
And user click on Search button 
Then validate search results

@Function3
  Scenario: Wag
When user goes back to dashboard page
And user enters four chars for Plan ID as valid Plan ID
       | InputFileName     | SheetName      | RowId    |
       |  RxR_PlanSearch   | PlanID       | V_PLNID_01 |
And user click on Search button 
Then validate search results