package com.rxr.framework.StepDefinition;
import java.io.IOException;

import org.apache.commons.configuration.ConfigurationException;

import com.rxr.framework.StepLibrary.CommonLibrary;
import com.rxr.framework.StepLibrary.PlanSearchLibrary;
import com.rxr.frameworkConstant.PlanSearchScreen;

import cucumber.api.DataTable;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;


public class PlanSearch extends CommonLibrary{
	
	public PlanSearch() throws ConfigurationException, IOException {
		super();
	}
@Given("^Logged in as Pharmacy User$")
public void logged_in_as_Pharmacy_User() throws IOException, InterruptedException, ConfigurationException{
	try{
		CommonLibrary.initiateBrowser();
	}catch(Exception e){
		e.printStackTrace();
	}
}


@And("^Select plan$")
public void Select_plan() throws Throwable
{
	Thread.sleep(2000);
	
}

@When("^navigates to dashboard page$")
public void navigates_to_dashboard_page() throws Throwable {
	// Write code here that turns the phrase above into concrete actions
	PlanSearchLibrary.dashboardEle_Click("Dashboard");
			
		    //throw new PendingException();
}

@Then("^should see dropdown labeled  Plan$")
public void should_see_dropdown_labeled_Plan() throws Throwable {
    // Write code here that turns the phrase above into concrete actions
	//CommonLibrary.isElementPresentVerification(PlanSearchScreen.dashboard_screen_dropdown_value1);
   
}

@Then("^should see TextBox labeled  BIN$")
public void should_see_TextBox_labeled_BIN() throws Throwable {
    // Write code here that turns the phrase above into concrete actions
	CommonLibrary.isElementPresentVerification(PlanSearchScreen.dashboard_screen_BIN_txtbox);
   
}

@Then("^should see TextBox labeled  PCN$")
public void should_see_TextBox_labeled_PCN() throws Throwable {
    // Write code here that turns the phrase above into concrete actions
	CommonLibrary.isElementPresentVerification(PlanSearchScreen.dashboard_screen_PCN_txtbox);
   
}

@Then("^should see TextBox labeled  Plan ID$")
public void should_see_TextBox_labeled_Plan_ID() throws Throwable {
    // Write code here that turns the phrase above into concrete actions
	CommonLibrary.isElementPresentVerification(PlanSearchScreen.dashboard_screen_PlanID_txtbox);
    
}

@Then("^should see TextBox labeled  Plan Name$")
public void should_see_TextBox_labeled_Plan_Name() throws Throwable {
    // Write code here that turns the phrase above into concrete actions
	CommonLibrary.isElementPresentVerification(PlanSearchScreen.dashboard_screen_PlanName_txtbox);
    
}

@Then("^should see enabled button labeled  Search$")
public void should_see_enabled_button_labeled_Search() throws Throwable {
	PlanSearchLibrary.is_Enabled(PlanSearchScreen.dashboard_screen_search_button);
}

@When("^Select a valid value from the drop down$")
public void select_a_valid_value_from_the_drop_down(DataTable arg1) throws Throwable {
	{
		PlanSearchLibrary.selectDropDownValue(arg1, PlanSearchScreen.dashboard_screen_dropdown_value1);
	}
}

@And("^user enter six numaric charecter as valid BIN_Number$")
public void user_enter_six_numaric_charecter_as_valid_BIN_Number(DataTable arg1) throws Throwable {
	PlanSearchLibrary.enter_BIN(arg1);
}

@When("^click on Search button$")
public void click_on_Search_button() throws Throwable {
    // Write code here that turns the phrase above into concrete actions
	PlanSearchLibrary.click_Search();
   
}

/*@Then("^validate search results$")
public void validate_search_results() throws Throwable {
    // Write code here that turns the phrase above into concrete actions
    throw new PendingException();
}*/

@When("^user goes back to dashboard page$")
public void user_goes_back_to_dashboard_page() throws Throwable {
    // Write code here that turns the phrase above into concrete actions
    throw new PendingException();
}

@When("^user enters six numaric character as valid BIN_Number$")
public void user_enters_six_numaric_character_as_valid_BIN_Number(DataTable arg1) throws Throwable {
	PlanSearchLibrary.enter_BIN(arg1);
    
}

@When("^user enters PCN numaric character as valid |PCN_Number|$")
public void user_enters_PCN_numaric_character_as_valid_PCN_Number(DataTable arg1) throws Throwable {
	PlanSearchLibrary.enter_PCN(arg1);
    throw new PendingException();
}

/*@When("^user click on Search button$")
public void user_click_on_Search_button() throws Throwable {
    // Write code here that turns the phrase above into concrete actions
	PlanSearchLibrary.click_Search();
    throw new PendingException();
}    
    */


@When("^user enters three chars for Plan Name as valid |Plan Name|$")
public void user_enters_three_chars_for_Plan_Name_as_valid_Plan_Name(DataTable arg1) throws Throwable {
	PlanSearchLibrary.enter_PlanName(arg1);
    throw new PendingException();
}

@When("^user enters four chars for Plan ID as valid |Plan ID|$")
public void user_enters_four_chars_for_Plan_ID_as_valid_Plan_ID(DataTable arg1) throws Throwable {
	PlanSearchLibrary.enter_PlanID(arg1);
    throw new PendingException();
}

@When("^User requests for a Plan Search on the Patient Profile screen$")
public void user_requests_for_a_Plan_Search_on_the_Patient_Profile_screen() throws Throwable {
	PlanSearchLibrary.dashboardEle_Click(PlanSearchScreen.Patient);
    throw new PendingException();
}

@Then("^Plan Search Page Opens$")
public void plan_Search_Page_Opens() throws Throwable {
    // Write code here that turns the phrase above into concrete actions
    throw new PendingException();
}

@Then("^BIN, PCN and Plan ID fields are visible$")
public void bin_PCN_and_Plan_ID_fields_are_visible() throws Throwable {
	CommonLibrary.isElementPresentVerification(PlanSearchScreen.dashboard_screen_BIN_txtbox);
	CommonLibrary.isElementPresentVerification(PlanSearchScreen.dashboard_screen_PCN_txtbox);
	CommonLibrary.isElementPresentVerification(PlanSearchScreen.dashboard_screen_PlanID_txtbox);
    throw new PendingException();
}

@Then("^“What plan are you adding\\?” label and Please select drop-down are visible$")
public void what_plan_are_you_adding_label_and_Please_select_drop_down_are_visible() throws Throwable {
	CommonLibrary.isElementPresentVerification(PlanSearchScreen.dashboard_screen_dropdown_value2);
    throw new PendingException();
}

@Then("^\"([^\"]*)\" drop down will contain the following selection options: Standard Coupon  Worker’s Comp$")
public void drop_down_will_contain_the_following_selection_options_Standard_Coupon_Worker_s_Comp(String arg1) throws Throwable {
    // Write code here that turns the phrase above into concrete actions
    throw new PendingException();
}

@Then("^Plan Name field hidden$")
public void plan_Name_field_hidden() throws Throwable {
    // Write code here that turns the phrase above into concrete actions
    throw new PendingException();
}

@Then("^Search, Cancel and Select buttons are visible and enabled$")
public void search_Cancel_and_Select_buttons_are_visible_and_enabled() throws Throwable {
	PlanSearchLibrary.is_Enabled(PlanSearchScreen.dashboard_screen_search_button);
	PlanSearchLibrary.is_Enabled(PlanSearchScreen.plan_search_screen_cancel_button);
	PlanSearchLibrary.is_Enabled(PlanSearchScreen.plan_search_screen_select_button);
    throw new PendingException();
}

@When("^User changes value from the Please select dropdown to a new non- default value$")
public void user_changes_value_from_the_Please_select_dropdown_to_a_new_non_default_value() throws Throwable {
    // Write code here that turns the phrase above into concrete actions
    throw new PendingException();
}

@Then("^System will display an error message$")
public void system_will_display_an_error_message() throws Throwable {
    // Write code here that turns the phrase above into concrete actions
    throw new PendingException();
}

@When("^User enters (\\d+) characters in the BIN Field$")
public void user_enters_characters_in_the_BIN_Field(int arg1, DataTable arg2) throws Throwable {
  
    throw new PendingException();
}

@When("^Clicks on Search button$")
public void clicks_on_Search_button() throws Throwable {
    // Write code here that turns the phrase above into concrete actions
	PlanSearchLibrary.click_Search();
    throw new PendingException();
}

@Then("^If applicable, System will remove previous search results and reset the Please Select drop down value to default$")
public void if_applicable_System_will_remove_previous_search_results_and_reset_the_Please_Select_drop_down_value_to_default() throws Throwable {
    // Write code here that turns the phrase above into concrete actions
    throw new PendingException();
}

@Then("^Perform Search$")
public void perform_Search() throws Throwable {
    // Write code here that turns the phrase above into concrete actions
	PlanSearchLibrary.click_Search();
    throw new PendingException();
}

@When("^click on back button$")
public void click_on_back_button() throws Exception {
    // Write code here that turns the phrase above into concrete actions
	Thread.sleep(2000);
	CommonLibrary.isElementPresentVerifyClick(PlanSearchScreen.plan_search_screen_back_button);
	System.out.println("clicked back button");
    //throw new PendingException();
}

@Then("^should see error$")
public void should_see_error() throws Throwable {
    // Write code here that turns the phrase above into concrete actions
   // throw new PendingException();
	Thread.sleep(1000);
	boolean val = CommonLibrary.isElementPresentVerification(PlanSearchScreen.error_Message);
	if (val==true)
		System.out.println("error found");
}

@When("^user enters (\\d+) characters in the BIN field$")
public void user_enters_characters_in_the_BIN_field(int arg1, DataTable arg2) throws Throwable {
    // Write code here that turns the phrase above into concrete actions
    // For automatic transformation, change DataTable to one of
    // List<YourType>, List<List<E>>, List<Map<K,V>> or Map<K,V>.
    // E,K,V must be a scalar (String, Integer, Date, enum etc)
    throw new PendingException();
}

@Then("^“Mandatory field required” error message will be displayed below the BIN field$")
public void mandatory_field_required_error_message_will_be_displayed_below_the_BIN_field() throws Throwable {
    // Write code here that turns the phrase above into concrete actions
    throw new PendingException();
}

@When("^User enters (\\d+) characters in the Plan ID field$")
public void user_enters_characters_in_the_Plan_ID_field(int arg1) throws Throwable {
    // Write code here that turns the phrase above into concrete actions
    throw new PendingException();
}

@Then("^System will remove previous search results and reset the Please select dropdown value to default, if applicable$")
public void system_will_remove_previous_search_results_and_reset_the_Please_select_dropdown_value_to_default_if_applicable() throws Throwable {
    // Write code here that turns the phrase above into concrete actions
    throw new PendingException();
}

@When("^User enters (\\d+) characters in the Plan Name field$")
public void user_enters_characters_in_the_Plan_Name_field(int arg1) throws Throwable {
    // Write code here that turns the phrase above into concrete actions
    throw new PendingException();
}

@When("^User enters valid BIN number and (\\d+) characters in the PCN field$")
public void user_enters_valid_BIN_number_and_characters_in_the_PCN_field(int arg1) throws Throwable {
    // Write code here that turns the phrase above into concrete actions
    throw new PendingException();
}

@When("^user opened the Plan Search screen from the Patient Profile and requests to close the Plan Search window$")
public void user_opened_the_Plan_Search_screen_from_the_Patient_Profile_and_requests_to_close_the_Plan_Search_window() throws Throwable {
    // Write code here that turns the phrase above into concrete actions
    throw new PendingException();
}

@When("^User Clicks on the Cancel or X button$")
public void user_Clicks_on_the_Cancel_or_X_button() throws Throwable {
    // Write code here that turns the phrase above into concrete actions
    throw new PendingException();
}

@Then("^system will close the Plan Search window and return user to the previous screen$")
public void system_will_close_the_Plan_Search_window_and_return_user_to_the_previous_screen() throws Throwable {
    // Write code here that turns the phrase above into concrete actions
    throw new PendingException();
}



}
