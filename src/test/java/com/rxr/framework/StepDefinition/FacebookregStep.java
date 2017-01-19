package com.rxr.framework.StepDefinition;

import com.rxr.framework.StepLibrary.Facebookreg;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class FacebookregStep {
	
	Facebookreg fb = new Facebookreg();
	
	@Given("^user navigates to facebook login page$")
	public void user_navigates_to_facebook_login_page() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	 fb.launch();   
	}

	@When("^user gives credential details$")
	public void user_gives_credential_details() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    fb.reg();
	}

	@Then("^user should suppose to able login$")
	public void user_should_suppose_to_able_login() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    fb.verify();
	}

}
