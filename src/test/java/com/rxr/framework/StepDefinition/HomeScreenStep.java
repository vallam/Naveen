package com.rxr.framework.StepDefinition;

import java.util.List;
import java.util.Map;

import com.rxr.framework.StepLibrary.CommonLibrary;
import com.rxr.framework.StepLibrary.HomeScreenLibrary;

import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class HomeScreenStep {

		
	@Then("^Customer Login into the chase dot com$")
	public void Customer_Login_into_the_chase_dot_com(DataTable arg2) throws Exception {
		System.out.println("Before enetering text");
		Map<String, List<String>> dataMap = null;
		dataMap = CommonLibrary.getHorizontalData(arg2);
		System.out.println("After enetering text");
		HomeScreenLibrary.login(dataMap);
	}
	
	/*@Given("^Pharmacy user launch the App$")
	public void pharmacy_user_launch_the_App(DataTable arg2) throws Exception  {
		System.out.println("Before enetering text");
		Map<String, List<String>> dataMap = null;
		dataMap = CommonLibrary.getHorizontalData(arg2);
		System.out.println("After enetering text");
		HomeScreenLibrary.login(dataMap);
	}*/
	    // Write code here that turns the phrase above into concrete actions
	    //throw new PendingException();
	

	@Then("^Pharmacy user Login with login credentials$")
	public void pharmacy_user_Login_with_login_credentials(DataTable arg2) throws Throwable {
		System.out.println("Before enetering text");
		Map<String, List<String>> dataMap = null;
		dataMap = CommonLibrary.getHorizontalData(arg2);
		System.out.println("After enetering text");
		HomeScreenLibrary.login(dataMap);
	    // Write code here that turns the phrase above into concrete actions
	    // For automatic transformation, change DataTable to one of
	    // List<YourType>, List<List<E>>, List<Map<K,V>> or Map<K,V>.
	    // E,K,V must be a scalar (String, Integer, Date, enum etc)
	   // throw new PendingException();
	}
	
	/*@Then("^Customer search data in chase dot com$")
	public void Customer_search_data_in_chase_dot_com(DataTable arg2) throws Exception {
		Map<String, List<String>> dataMap = null;
		dataMap = CommonLibrary.getHorizontalData(arg2);
		HomeScreenLibrary.search(dataMap);
	}*/
	
	/*@Then("^Customer navigate to \"(.*)\" products objects$")
	public void Customer_navigate_to_explore_Product_Page(String para) throws Exception {
		HomeScreenLibrary.navigateTo_ExploreProducts(para);
	}
	
}*/
	
}
