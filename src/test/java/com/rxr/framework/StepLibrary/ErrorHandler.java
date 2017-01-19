package com.rxr.framework.StepLibrary;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class ErrorHandler {
	
	public static Properties properties = null;
	public static Logger logger = null;
	
	public ErrorHandler()
	{
		properties = new Properties();
		logger =Logger.getLogger("ErrorHandler");
		PropertyConfigurator.configure("Config/log4j.properties");
	}
	
	
	public static String handleException(Exception exceptionObj)
	{
		String errorValue = "";
		String errorMessage = "";
		try
	 {	
		errorMessage=covertExceptionToString(exceptionObj);
		properties.load(new FileInputStream(System.getProperty("user.dir")+"//Config//ErrorList.properties") );
		
		//iterate through the properties file
		for(String errorKey : properties.stringPropertyNames())
		{
			if(errorMessage.equals(errorKey))
			{
				errorValue = properties.getProperty(errorKey);
//				logger.error(errorValue);
				logger.error(errorValue, exceptionObj);
			}
			/*String errorValue = properties.getProperty(errorKey);
			System.out.println("Error Key: "+errorKey);
			System.out.println("Error values: "+errorValue);*/
		}
		
		return properties.getProperty(errorValue);
		
	 }
		catch(IOException objException)
		{
			System.out.println("File not found");
		}
		return errorValue;
	}
	
	
	public static String covertExceptionToString(Exception objExcpetion)
	{
		String strMessage = objExcpetion.toString();
		int firstOccurence = strMessage.indexOf(':');
		
		String subString = strMessage.substring(0, firstOccurence);
		return subString;
	}
	
	public static void main(String[] args) {
	 try
	 {
		ErrorHandler e = new ErrorHandler();
		WebDriver driver = new FirefoxDriver();
		logger.info("Browser Opened");

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		logger.info("Implicit wait given");

		driver.get("https://www.google.co.in/");
		logger.info("Url opened");

		driver.findElement(By.name("q1")).sendKeys("Selenium");
		logger.info("keyword type");  

		driver.quit();
		logger.info("driver is closed");
	 }
	 	catch(Exception e)
	 {
	 		handleException(e);
	 }
	}

}
