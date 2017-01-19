package com.rxr.framework.StepLibrary;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import junit.framework.Assert;

public class Jira {
	

		private WebDriver driver;
		 private String baseUrl;
		
	public void launch(){
		System.setProperty("webdriver.firefox.marionette","C://Selenium//geckodriver-v0.9.0-win64//geckodriver.exe");
		driver = new FirefoxDriver();
		baseUrl = "https://id.atlassian.com/signup?application=jac&tenant=&continue=https%3A%2F%2Fjira.atlassian.com%2Fdefault.jsp"; 
		driver.manage().timeouts().implicitlyWait(30, TimeUnit. SECONDS);
		//driver.manage().window().maximize();
		System.out.println("This is Before method");
		driver.get(baseUrl);
	}
		public void login(){
			driver.findElement(By.id("username")).clear();
			driver.findElement(By.id("username")).sendKeys("vallamnaveen007@gmail.com");
			driver.findElement(By.id("next")).click();
			driver.findElement(By.id("password")).clear();
			driver.findElement(By.id("password")).sendKeys("Naveen@1");
			driver.findElement(By.id("login-submit")).click();
		}
		
	public void loginverify(){
		
		String title = driver.getTitle();
		Assert.assertTrue(title.matches("Inbox"));
	}
}
