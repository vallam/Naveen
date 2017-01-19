Feature: Presciber

@RxR_create_prescriber
  Scenario: Search and create prescriber
    Given Pharmacy user launch the App
    Then verify dropdown exist
    Then select dropdown
    And verify Phonenumber text field exist
    And verify NPI or DIA or stateLicence field exist
    And Verify FirstName textfield exist
    And verify LastName textfield exist
    And verify search button exist
    Then Enetr FirstName and last name 
    And click on search button
    And verify LastName First Name
    And verify Type
    And verify  State licence
    And verify Phone number 
    And verify state
    And verify  Address
    And verify Cancelbutton
    And verify AddNewButton
    Then Click on AddNew button
    
    
    
    