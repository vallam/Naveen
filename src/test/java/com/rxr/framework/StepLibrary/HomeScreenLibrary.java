package com.rxr.framework.StepLibrary;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Random;

import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.PropertiesConfiguration;
import org.apache.http.impl.client.EntityEnclosingRequestWrapper;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.rxr.framework.properties.ReadProperties;
import com.rxr.frameworkConstant.HomeScreenUIConstants;

public class HomeScreenLibrary extends CommonLibrary {
	
	static Properties prop;
	
	public HomeScreenLibrary() throws ConfigurationException, IOException {
		super();
		/*ReadProperties propertyObj = new ReadProperties();
		prop = propertyObj.readProperties("loginPage", "textbox", false);
		*/
	}
public static Properties getProp(String context,String filename, Boolean match) throws IOException{
	ReadProperties propertyObj = new ReadProperties();
	prop = propertyObj.readProperties(context, filename, match);
return prop;
}
	/*
	 * Method 
	 */

	public static void search (Map<String, List<String>> dataMap) throws Exception{

		String search_keyword =getXLSTestData(dataMap.get("InputFileName").get(0), dataMap.get("SheetName").get(0), dataMap.get("RowId").get(0), "SearchValue");
		try{	
			if(config.getString("breakPoint").equalsIgnoreCase("Mobile")){
				if(isElementPresentVerification(HomeScreenUIConstants.hamburger_menu_ICN)){
					if(!isElementPresentVerifyClick(HomeScreenUIConstants.hamburger_menu_ICN)) {
						throw new Exception("Element Not able to click Explore Link");
					}
				}else {
					throw new Exception("Not able to verify element");
				}
				if(isElementPresentVerification(HomeScreenUIConstants.homeScreen_Search_TXT_mobile)){
					element = chromeDriver.findElement(By.xpath(HomeScreenUIConstants.homeScreen_Search_TXT_mobile));
					Thread.sleep(1000);
					element.sendKeys(search_keyword);
					Thread.sleep(1000);
					element.sendKeys(Keys.ENTER);
				}else {
					throw new Exception("Element Not Verified");
				}
			}else {

				if(isElementPresentVerification(HomeScreenUIConstants.homeScreen_Search_ICN)){
					if(!isElementPresentVerifyClick(HomeScreenUIConstants.homeScreen_Search_ICN)) {
						throw new Exception("Element Not able to click");
					}
				}else {
					throw new Exception("Element Not Verified");
				}
				if(isElementPresentVerification(HomeScreenUIConstants.homeScreen_Search_TXT)){
					//				if(!clearAndEnterText(HomeScreenUIConstants.userName_TXT,search_keyword)) {
					//					throw new Exception("User Not able to Enter search keyword in search TextField");
					//				}
					element = chromeDriver.findElement(By.xpath(HomeScreenUIConstants.homeScreen_Search_TXT));
					Thread.sleep(1000);
					element.sendKeys(search_keyword);
					Thread.sleep(1000);
					element.sendKeys(Keys.ENTER);
				}else {
					throw new Exception("Element Not Verified");
				}
			}
			Thread.sleep(5000);
		} catch (Exception e){
			e.printStackTrace();
		}
	}



	/*
	 * Method 
	 */

	
	public static void login (Map<String, List<String>> dataMap) throws Exception{
		getProp("loginPage","textbox",false);
		/*ReadProperties propertyObj = new ReadProperties();
		prop = propertyObj.readProperties("loginPage", "textbox", false);*/
		String usrName =getXLSTestData(dataMap.get("InputFileName").get(0), dataMap.get("SheetName").get(0), dataMap.get("RowId").get(0), "UserName");
		System.out.println(usrName);
		String passWord = getXLSTestData(dataMap.get("InputFileName").get(0), dataMap.get("SheetName").get(0), dataMap.get("RowId").get(0), "Password");
		try{	
			 {
				//if(isElementPresentVerification(HomeScreenUIConstants.userName_TXT)){
					//if(!clearAndEnterText(HomeScreenUIConstants.userName_TXT,usrName)) {
				 System.out.println(prop.getProperty("userName_TXT"));
				 if(!clearAndEnterText(prop.getProperty("userName_TXT"),usrName)) {
						throw new Exception("User Not able to Enter UserName in UserName TextField");
					}
				 
				}/*else {
					throw new Exception("Element Not Verified");
				}*/
				//if(isElementPresentVerification(HomeScreenUIConstants.password_TXT)){
					if(!clearAndEnterText(HomeScreenUIConstants.password_TXT,passWord)) {
						throw new Exception("User Not able to Enter Password in Password TextField");
					}
			//	}
		/*else {
					throw new Exception("Element Not Verified");
				}*/
				//if(isElementPresentVerification(HomeScreenUIConstants.login_BTN)){
					if(!isElementPresentVerifyClick(HomeScreenUIConstants.login_BTN)) {
						throw new Exception("Element Not sblr to click");
					}
		}
					
					finally {
					    /*if (out != null) { 
					        System.out.println("Closing PrintWriter");
					        out.close(); 
					    }*/ 
					} { 
					        System.out.println("PrintWriter not open");
					    } 
					} 
			//	}/*else {
			//		throw new Exception("Element Not Verified");
			//	}*/
			//	Thread.sleep(10000);
	//		}
	//	} /*catch (Exception e){
		//	e.printStackTrace();
	//	}*/
	//}

	//}

	/*
	 * Method 
	 */

	public static void navigateTo_ExploreProducts (String para) throws Exception{
		try{	
			if(config.getString("breakPoint").equalsIgnoreCase("Mobile")){
				if(isElementPresentVerification(HomeScreenUIConstants.hamburger_menu_ICN)){
					if(!isElementPresentVerifyClick(HomeScreenUIConstants.hamburger_menu_ICN)) {
						throw new Exception("Element Not able to click Explore Link");
					}
				}else {
					throw new Exception("Not able to verify element");
				}
			} else {
				if(isElementPresentVerification(HomeScreenUIConstants.explore_Products)){
					if(!isElementPresentVerifyClick(HomeScreenUIConstants.explore_Products)) {
						throw new Exception("Element Not able to click Explore Link");
					}
				}else {
					throw new Exception("Not able to verify element");
				}
				Thread.sleep(2000);
			}
			if(para.equalsIgnoreCase("Creditcards")){
				if(config.getString("breakPoint").equalsIgnoreCase("Mobile")){
					if(isElementPresentVerification(HomeScreenUIConstants.explore_Products_CreditCards_mobile)){
						if(!isElementPresentVerifyClick(HomeScreenUIConstants.explore_Products_CreditCards_mobile)) {
							throw new Exception("Element Not able to click Explore Link");
						}
					}else {
						throw new Exception("Not able to verify element");
					}
				} else {
					if(isElementPresentVerification(HomeScreenUIConstants.explore_Products_CreditCards)){
						if(!isElementPresentVerifyClick(HomeScreenUIConstants.explore_Products_CreditCards)) {
							throw new Exception("Element Not able to click Explore Link");
						}
					}else {
						throw new Exception("Element Not Verified");
					}
				}
			}
			if(para.equalsIgnoreCase("Checking")){
				if(config.getString("breakPoint").equalsIgnoreCase("Mobile")){
					if(isElementPresentVerification(HomeScreenUIConstants.hamburger_menu_ICN)){
						if(!isElementPresentVerifyClick(HomeScreenUIConstants.hamburger_menu_ICN)) {
							throw new Exception("Element Not able to click Explore Link");
						}
					}else {
						throw new Exception("Not able to verify element");
					}
					if(isElementPresentVerification(HomeScreenUIConstants.explore_Products_Checking_mobile)){
						if(!isElementPresentVerifyClick(HomeScreenUIConstants.explore_Products_Checking_mobile)) {
							throw new Exception("Element Not able to click Explore Link");
						}
					}else {
						throw new Exception("Not able to verify element");
					}
				} else {
					if(isElementPresentVerification(HomeScreenUIConstants.explore_Products_Checking)){
						if(!isElementPresentVerifyClick(HomeScreenUIConstants.explore_Products_Checking)) {
							throw new Exception("Element Not able to click Explore Link");
						}
					}else {
						throw new Exception("Element Not Verified");
					}
				}
			}
		} catch (Exception e){
			e.printStackTrace();
		}
	}



//////////////////////////////////////

/*public static void soapuirunner() throws MalformedURLException, InterruptedException {

	
	//driver.get("C:/Users/krishnem.WALGREENS/Desktop/SoapUI/SoapUI/SoapUI/manju.bat");
	// PMS App Path
	File pmsAppPath = new File(
			"C:/Users/krishnem.WALGREENS/Desktop/SoapUI/SoapUI/SoapUI/manju.bat");
		//	"C:/Softwares/Dev_app/PMS-Build-Feb-09/PMS-Build-Feb-09/PMS.WindowsApp.exe");
	

	// Launch the app using RemoteWebDriver (this code is still intact as
	// the Chrome Driver is not launching the app &
	// this can be used for native code automation)
	
	
	
	DesiredCapabilities capabilities = new DesiredCapabilities();
	capabilities.setCapability("app", pmsAppPath.getAbsolutePath());
	driver = new RemoteWebDriver(new URL("http://localhost:9999"), capabilities);
	driver.switchTo();
	Thread.sleep(1000);

	File chromeDriverPath = new File("C:/Users/krishnem.WALGREENS/Desktop/chromedriver_win32/chromedriver.exe");
	System.setProperty("webdriver.chrome.driver", chromeDriverPath.getAbsolutePath());

	ChromeOptions options = new ChromeOptions();
	options.setBinary(pmsAppPath.getAbsolutePath());
	options.setExperimentalOption("debuggerAddress", "localhost:12345");

	DesiredCapabilities chromeCapabilities = DesiredCapabilities.chrome();
	chromeCapabilities.setCapability("app", pmsAppPath.getAbsolutePath());
	chromeCapabilities.setCapability("chrome.binary", pmsAppPath.getAbsolutePath());
	chromeCapabilities.setCapability(ChromeOptions.CAPABILITY, options);

	chromeDriver = new ChromeDriver(chromeCapabilities);
	}*/
	public static void soapuirunner() {
	
	
	WebDriver driver = null;
	//RemoteWebdriver driver = null;
	DesiredCapabilities Capabulities = new DesiredCapabilities();
	Capabulities.setCapability("app", "C:/Users/krishnem.WALGREENS/Desktop/SoapUI/SoapUI/SoapUI/manju.bat");
	try {
		driver = new RemoteWebDriver (new URL("http://localhost:9999"), Capabulities);
	} catch (MalformedURLException e1){
		e1.printStackTrace();
	}
	}
	
	public String createAcc(Map<String, List<String>> dataMap) throws InterruptedException, FileNotFoundException, ConfigurationException {
		 try{
		     String val= System.getProperty("testDataRelPropPath");
		     String propfilepath = val.substring(val.indexOf(":")+1, val.length());
		   File tesDatapropFile  = new File (propfilepath);
		     propfilepath = tesDatapropFile.getAbsolutePath();
			 PropertiesConfiguration conf = new PropertiesConfiguration("/C:/Users/A040890/Desktop/src/RegistryApp_Selenium_UITest/seleniumSuite/com/registry/seleniumauto/config/testData.dev.properties");  
			 String usrName =getXLSTestData(dataMap.get("InputFileName").get(0), dataMap.get("SheetName").get(0), dataMap.get("RowId").get(0), "UserName");
				System.out.println(usrName);
				String passWord = getXLSTestData(dataMap.get("InputFileName").get(0), dataMap.get("SheetName").get(0), dataMap.get("RowId").get(0), "Password");
			 
			 
			 String uiPassword = (String)conf.getProperty("password");
	         String uiFirstname = (String)conf.getProperty("firstName");
	         String uiLastName = (String)conf.getProperty("lastName");

	         Random randomNo = new Random ();
			 int value = randomNo.nextInt(10000);
			 Integer newint = new Integer(value);
			 String mailID = uiFirstname+uiLastName+"-"+newint.toString()+"@target.com";  
			 conf.setProperty("email_ID", mailID);  
			 conf.save();
			 WebElement firstName=chromeDriver.findElement(By.id("firstName"));
		     firstName.sendKeys(uiFirstname);
		     WebElement lastName=driver.findElement(By.id("lastName"));
		     lastName.sendKeys(uiLastName);
	         WebElement email=driver.findElement(By.id("logonId"));
	         email.sendKeys(mailID);
	         WebElement pass=driver.findElement(By.id("logonPassword"));
	         pass.sendKeys(uiPassword);
	         WebElement confirmPass=driver.findElement(By.id("logonPasswordVerify"));
	         confirmPass.sendKeys(uiPassword);
	         WebElement create=driver.findElement(By.id("CreateAccount"));
	         create.click();
			 }catch (Exception e) {
				e.printStackTrace();
				//return Constants.KEYWORDS_FAIL;
			}
			// return Constants.KEYWORDS_PASS;
		return actual;
		 }

public static void Dashboard_click () throws Exception{
		
		if(config.getString("breakPoint").equalsIgnoreCase("Desktop")){
			//if(isElementPresentVerification(HomeScreenUIConstants.hamburger_menu_ICN)){
			Thread.sleep(2000);
			
				//if(!isElementPresentVerifyClick(prop.getProperty("dashboard"))) {
			if(!isElementPresentVerifyClick(HomeScreenUIConstants.dashboard_link)){
			
					throw new Exception("Element Not able to click Explore Link");
				}
			}else {
				throw new Exception("Not able to verify element");
			}
		} 
			
		}






