package com.rxr.framework.StepDefinition;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import com.rxr.framework.StepLibrary.CommonLibrary;
import com.rxr.framework.StepLibrary.HomeScreenLibrary;
import com.rxr.framework.properties.ReadProperties;

import cucumber.api.DataTable;
import cucumber.api.PendingException;
import cucumber.api.java.en.Then;
import cucumber.api.DataTable;

	public class LoginScreen   {
		
		Properties prop;
		
		public LoginScreen() throws IOException{
			ReadProperties propertyObj = new ReadProperties();
			prop = propertyObj.readProperties("loginPage", "textbox", false);
		}
		
		@Then("^User eneter login credentials$")
		public void user_eneter_login_credentials(DataTable arg2) throws Throwable {
			Map<String, List<String>> dataMap = null;
			dataMap = CommonLibrary.getHorizontalData(arg2);
			Thread.sleep(3000);
			System.out.println("Before entering text");
			HomeScreenLibrary.login(dataMap);
		    throw new PendingException();
		}

		@Then("^User search with patient name$")
		public void user_search_with_patient_name() throws Throwable {
//			ReadProperties propertyObj = new ReadProperties();
//			propertyObj.readProperties("login", "login", false);
			HomeScreenLibrary.soapuirunner();
			//HomeScreenLibrary.Dashboard_click();
			
			//System.out.println("Property Value:"+prop.getProperty("userName"));
		}
	}
