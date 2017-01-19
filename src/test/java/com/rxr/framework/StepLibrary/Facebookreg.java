package com.rxr.framework.StepLibrary;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import cucumber.api.java.Before;
import junit.framework.Assert;

public class Facebookreg {
	private WebDriver driver;
	 private String baseUrl;
	 By firstname = By.id("u_0_1");
	    By lastname = By.id("u_0_3");
	    By mobilenumber = By.id("u_0_5");
	    By Reentermobile = By.id("u_0_8");
	    By newpassword = By.id("u_0_a");
@BeforeTest	
public void launch(){
	System.setProperty("webdriver.firefox.marionette","C://Selenium//geckodriver-v0.9.0-win64//geckodriver.exe");
	driver = new FirefoxDriver();
	baseUrl = "https://www.facebook.com/"; 
	driver.manage().timeouts().implicitlyWait(30, TimeUnit. SECONDS);
	//driver.manage().window().maximize();
	System.out.println("This is Before method");
	driver.get(baseUrl);
}
@Test
public void reg() {
	  driver.get(baseUrl);
	  
	  driver.findElement(firstname).clear();
	  driver.findElement(firstname).sendKeys("Naveen");
	  driver.findElement(lastname).clear();
	  driver.findElement(lastname).sendKeys("vallam");
	  driver.findElement(mobilenumber).clear();
	  driver.findElement(mobilenumber).sendKeys("9876543210");
	  driver.findElement(Reentermobile).clear();
	  driver.findElement(Reentermobile).sendKeys("9876543210");
	  driver.findElement(newpassword).clear();
	  driver.findElement(newpassword).sendKeys("Reddy@1");
	  Select month = new Select(driver.findElement(By.id("month")));
	  month.selectByVisibleText("May");
	  Select day = new Select(driver.findElement(By.id("day")));
	  day.selectByIndex(4);
	  Select year = new Select(driver.findElement(By.id("year")));
	  year.selectByVisibleText("1990");
	  driver.findElement(By.id("u_0_i")).click();
	  System.out.println("This is Test Method");
		}
@AfterTest
public void verify(){
	String text = driver.findElement(By.xpath(".//*[@id='content']/div/div/div/div/div[2]/h2")).getText();
	  Assert.assertEquals("Sign Up", text);
	  driver.quit();
}
}
