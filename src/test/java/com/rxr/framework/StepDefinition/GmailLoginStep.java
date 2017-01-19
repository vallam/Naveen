package com.rxr.framework.StepDefinition;

import com.rxr.framework.StepLibrary.GmailLogin;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class GmailLoginStep {
	GmailLogin login = new GmailLogin();
	@Given("^user navigates to Gmail login page$")
	public void user_navigates_to_Gmail_login_page() throws Throwable {
	  login.launch();  
	    
	}

	@When("^user fills authentication details$")
	public void user_fills_authentication_details() throws Throwable {
	    login.login();
		// Write code here that turns the phrase above into concrete actions
	    
	}

	@Then("^user should be able login$")
	public void user_should_be_able_login() throws Throwable {
	    login.loginverify();
		// Write code here that turns the phrase above into concrete actions
	   
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
