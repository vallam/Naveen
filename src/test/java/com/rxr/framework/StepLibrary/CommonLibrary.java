package com.rxr.framework.StepLibrary;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.apache.commons.configuration.Configuration;
import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.ConfigurationFactory;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.Point;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.rxr.framework.properties.ReadProperties;
import com.rxr.frameworkConstant.UserConfig;

import cucumber.api.DataTable;


public class CommonLibrary {
	//Manju
	public static WebDriver driver;
	public static ChromeDriver chromeDriver;
	private static final String Chrome = null;
	//changes
	//public static WebDriver webDriver = null;
	public static WebElement element = null;
	static WebDriverWait browserWithElementWait = null;
	static long t1 = 0;
	static long t2 = 0;
	static long timeTaken = 0;
	String actual = null;
	public static String expecte = null;
	public static String X = null;
	public static String Y = null;
	static Integer Ycoordinate = null;
	static Integer Xcoordinate = null;
	static Integer img_Width = null;
	static Integer img_Height = null;
	static String imgLocation;
	static String imgSize;
	public static Configuration config = null;
	static Properties prop;
	public CommonLibrary() throws ConfigurationException, IOException {
		ConfigurationFactory factory = new ConfigurationFactory("config/config.xml");
		config = factory.getConfiguration();
	}

	public static void initiateBrowser() throws ConfigurationException, IOException, InterruptedException {
		if (config.getString("breakPoint").equalsIgnoreCase("Desktop")) {
			/*if ("Yes".equalsIgnoreCase(config.getString("fireFox"))) {
				webDriver = new FirefoxDriver();
			} else if ("Yes".equalsIgnoreCase(config.getString("chrome"))) {
				if("Windows".equalsIgnoreCase(config.getString("operatingSystem"))) {
				} else {
					webDriver = new ChromeDriver();
				}
			} else if ("Yes".equalsIgnoreCase(config.getString("IE"))) {
			} else if ("Yes".equalsIgnoreCase(config.getString("safari"))) {
			} else {
				System.out.println("**********Given Browser Name is Wrong************");
			}
			webDriver.manage().window().maximize();
		} else if(config.getString("breakPoint").equalsIgnoreCase("Mobile")) {
			if ("iOS".equalsIgnoreCase(config.getString("operatingSystem"))) {
				initiateBrowser_iOS();
			} else if("android".equalsIgnoreCase(config.getString("operatingSystem"))) {
				initiateBrowser_Android();
			} else {
			}
		}
		
*/		
			//chromeDriver.get(config.getString("applicationURL"));
			
			/*DesiredCapabilities Capabulities = new DesiredCapabilities();
			Capabulities.setCapability("app", "C:/Softwares/ElectronApp/RxRenewalApp (4)/RxRenewalApp/RxRenewal-windows.exe");
			try {
				driver = new RemoteWebDriver (new URL("http://localhost:9999"), Capabulities);
			} catch (MalformedURLException e1){
				e1.printStackTrace();
			}*/
			//Manju
			
			System.out.println("Launching App");
			//Napels APP path
			File pmsAppPath = new File(
					"C:/Users/krishnem.WALGREENS/Desktop/Code-Merge/rx-renewal-UI-201606161230-win32-ia32/rx-renewal-UI-201606161230.exe");
			// NEw App Path
			/*File pmsAppPath = new File(
					"C:/Users/krishnem.WALGREENS/Desktop/New-Elec-App/RxRenewalApp (2)/RxRenewalApp/RxRenewal-windows.exe");*/
			
			
			
			System.out.println(" am logdin");
			//chromeDriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			DesiredCapabilities capabilities = new DesiredCapabilities();
			capabilities.setCapability("app", pmsAppPath.getAbsolutePath());
			capabilities.setCapability("debugConnectToRunningApp", true);
			//driver = new RemoteWebDriver(new URL("http://localhost:9999"), capabilities);
			//driver.switchTo();
			//Thread.sleep(1000);

			File chromeDriverPath = new File("C:/Users/krishnem.WALGREENS/Desktop/chromedriver_win32/chromedriver.exe");
			System.setProperty("webdriver.chrome.driver", chromeDriverPath.getAbsolutePath());

			ChromeOptions options = new ChromeOptions();
			options.setBinary(pmsAppPath.getAbsolutePath());
			//options.setExperimentalOption("debuggerAddress", "localhost:12345");

			DesiredCapabilities chromeCapabilities = DesiredCapabilities.chrome();
			chromeCapabilities.setCapability("app", pmsAppPath.getAbsolutePath());
			chromeCapabilities.setCapability("chrome.binary", pmsAppPath.getAbsolutePath());
			//chromeCapabilities.setCapability("debugConnectToRunningApp", "true");
			chromeCapabilities.setCapability(ChromeOptions.CAPABILITY, options);

			chromeDriver = new ChromeDriver(chromeCapabilities);
			Thread.sleep(6000);
			/*chromeDriver.findElement(By.id("select_value_label_0")).click();
			Thread.sleep(1000);
			chromeDriver.findElement(By.id("select_option_6")).click();
			chromeDriver.findElement(By.id("input_7")).sendKeys("111111");
			chromeDriver.findElement(By.xpath("//*[@id='toolbar']/form/div[2]/div/button")).click();
	*/
			
		/*chromeDriver.findElement(By.xpath("/html/body/tsfn-app/ng-outlet/tsfn-main/div/div/md-toolbar/button/md-icon")).click();
		Thread.sleep(2000);
		chromeDriver.findElement(By.xpath("/html/body/tsfn-app/ng-outlet/tsfn-main/div/md-sidenav/a[1]/div[2]")).click();
		Thread.sleep(2000);
		chromeDriver.findElement(By.xpath("/html/body/tsfn-app/ng-outlet/tsfn-main/div/div/md-toolbar/button/md-icon")).click();
		Thread.sleep(2000);
		chromeDriver.findElement(By.xpath("/html/body/tsfn-app/ng-outlet/tsfn-main/div/md-sidenav/a[2]")).click();	
		Thread.sleep(2000);
		WebElement element = chromeDriver.findElement(By.xpath("//*[@id='member-profile']/div/fieldset[1]/legend"));
		String strng = element.getText();
		System.out.println(strng);
		Assert.assertEquals("Employee Information", strng);*/
		}
	}
	

	public static void closeBrowser(){
		chromeDriver.quit();
	}

	public static void initiateBrowser_iOS() throws IOException, InterruptedException {
		try {
			System.out.println("initialising the Ios browser");
			DesiredCapabilities capabilities = new DesiredCapabilities();
			capabilities.setCapability(CapabilityType.BROWSER_NAME,"safari");
			capabilities.setCapability("app", "safari");
			capabilities.setCapability("platformName", "iOS");
			capabilities.setCapability("platformVersion", UserConfig.platform_Version);
			capabilities.setCapability("deviceName", "iPhone");
			capabilities.setCapability("device", "iPhone");
			capabilities.setCapability("-U", UserConfig.deviceUDID); 
			capabilities.setCapability("app", UserConfig.safarilauncherLocation); 
			capabilities.setCapability("noReset", true);
			capabilities.setCapability("autoAcceptAlerts", true);
			//chromeDriver=new RemoteWebDriver(new URL(UserConfig.appiumServerURL_iOS), capabilities);
			chromeDriver.manage().deleteAllCookies();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}


	/*
	 *  Methods for 
	 */

	public static void validateImagePosition(String objectProperty,String imgLocation, String imgName) {
		try {
			element = getElementByProperty(objectProperty, chromeDriver);
			Point point = element.getLocation();
			String[] imgsp=imgLocation.split("X");
			Xcoordinate = Integer.parseInt(imgsp[0]);
			Ycoordinate = Integer.parseInt(imgsp[1]);
			if (Xcoordinate.equals(point.x) && Ycoordinate.equals(point.y) ) {
				System.out.println("------------------------------------------------------------------------------");
				System.out.println(imgName+" Image Position :: X & Y coordinate value are Same");
			}else {
				System.out.println("------------------------------------------------------------------------------");
				System.out.println("Mismatch of "+imgName+" Image Position X & Y coordinate");
				System.out.println("Actual X and Y Coordinate of Image "+point.x +","+point.y);
				System.out.println("Expected X and Y Coordinate of Image "+Xcoordinate+","+Ycoordinate);
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
		}
	}


	/*
	 *  Methods for 
	 */

	public static void validateImageSize(String objectProperty,String imgSize, String imgName) {
		try {
			element = getElementByProperty(objectProperty, chromeDriver);
			Dimension dimensions= element.getSize();
			String[] imgsize=imgSize.split("X");
			img_Width = Integer.parseInt(imgsize[0]);
			img_Height = Integer.parseInt(imgsize[1]);
			if(img_Width.equals(dimensions.width) && img_Height.equals(dimensions.height)) {
				System.out.println(imgName+" Image Width & Height value are Same");
			}else {
				System.out.println("Mismatch of "+imgName+" Image Width & Height");
				System.out.println("Actual Width and Height of Image "+dimensions.width +","+dimensions.height);
				System.out.println("Expected Width and Height of Image "+img_Width+","+img_Height);
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
		}
	}


	/*
	 *  Methods for 
	 */

	public static void accessibilityValidation(String objectProperty,String Text, String imgName) {
		try {
			element = getElementByProperty(objectProperty, chromeDriver);
			String alt = element.getAttribute("alt");
			if(alt.equalsIgnoreCase(Text)) {
				System.out.println(imgName+" Image accessibility expected and actual name are Same");
			}else {
				System.out.println(imgName+" Image accessibility expected and actual name are not Same");
				System.out.println("Accessibility-Actual : "+alt);
				System.out.println("Accessibility-Expected : "+Text);
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
		}
	}


	/*
	 *  Methods for 
	 */

	public static void linkText_Validation(String objectProperty,String Text) {
		try {
			element = getElementByProperty(objectProperty, chromeDriver);
			String linkText = element.getText();
			if(linkText.equalsIgnoreCase(Text)) {
				System.out.println("Link Text expected and actual text are Same");
			}else {
				System.out.println("Link Text expected and actual text are not Same");
				System.out.println("Link Text - Actual : "+linkText);
				System.out.println("Link Text -Expected : "+Text);
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
		}
	}


	/*
	 *  Methods for 
	 */

	public static void performanceValidation(long t1,long t2, String perf_Expected) throws Exception, IOException, InterruptedException {
		try {
			timeTaken = (t2-t1)/1000;
			long expected = Long.parseLong(perf_Expected);
			if(timeTaken<=expected){
			} else {
				System.out.println(" Page Load Time is High while Navigating to ::"+chromeDriver.getTitle() );
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
		}
	}


	/*
	 *  Methods for 
	 */

	public static WebElement getElementByProperty(String objectProperty, WebDriver webDriver) {
		String propertyType = null;
		WebDriverWait browserWithElementWait = null;
		try{
			if (browserWithElementWait == null) {
				browserWithElementWait = new WebDriverWait(webDriver, config.getInt("elementWaitInSeconds"));
			}
			propertyType = StringUtils.substringAfter(objectProperty, "~");
			objectProperty = StringUtils.substringBefore(objectProperty, "~");
			if (propertyType.equalsIgnoreCase("CSS")) {
				element = browserWithElementWait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(objectProperty)));
				highlightElement(element, webDriver);
			} else if (propertyType.equalsIgnoreCase("XPATH")) {
				element = browserWithElementWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(objectProperty)));
				highlightElement(element, webDriver);
			} else if (propertyType.equalsIgnoreCase("ID")) {
				element = browserWithElementWait.until(ExpectedConditions.presenceOfElementLocated(By.id(objectProperty)));
				 highlightElement(element, webDriver);
			} else if (propertyType.equalsIgnoreCase("NAME")) {
				element = browserWithElementWait.until(ExpectedConditions.presenceOfElementLocated(By.name(objectProperty)));
				highlightElement(element, webDriver);
			} else if (propertyType.equalsIgnoreCase("LINKTEXT")) {
				element = browserWithElementWait.until(ExpectedConditions.presenceOfElementLocated(By.linkText(objectProperty)));
				highlightElement(element, webDriver);
			} else {
				element = browserWithElementWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(objectProperty)));
				//		highlightElement(webElement, browser);	//to avoid overlapping of elements commented the following line of code -Angeline-03AUG2015
			}
		}catch(Exception e){

		}

		return element;
	}


	/*
	 * Common Methods for Element Verification
	 */

	public static boolean isElementPresentVerification(String objectProperty) throws Exception {
		boolean isElementPresent = false;
		browserWithElementWait = new WebDriverWait(chromeDriver,30);
		try {
			element = getElementByProperty(objectProperty, chromeDriver);
			if (element != null) {
				isElementPresent = true;
				t2=System.currentTimeMillis();
			} else {
				throw new Exception("Object Couldn't be retrieved and verified");
			}
			Thread.sleep(1000);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return isElementPresent;
	}


	/*
	 *  Methods for 
	 */

	public static boolean clearAndEnterText(String objectProperty, String Text) {
		boolean isTextEnteredResult = false;
		try {
			System.out.println(objectProperty);
			System.out.println(Text);
			if ("-".equals(Text)) {
				// ignore this field
				isTextEnteredResult = true;
			} else {
				WebElement textBox = getElementByProperty(objectProperty, chromeDriver);
				//textBox.clear();
				Thread.sleep(6000);
				textBox.sendKeys(Text);
				isTextEnteredResult = true;
			}
		} catch (Exception e) {
			e.printStackTrace();;
		}
		return isTextEnteredResult;
	}




	/*
	 *  Methods for Highlight the Elements
	 */
	public static void highlightElement(WebElement element,WebDriver webDriver) {
		for (int i = 0; i < 1; i++) {
			JavascriptExecutor js = (JavascriptExecutor) webDriver;
			js.executeScript("arguments[0].setAttribute('style', arguments[1]);", element, "color: black; border: 3px solid black;");
		}
	}


	/*
	 *  Methods for 
	 */
	public static void browserNavigation_Back() {
		try {
			chromeDriver.navigate().back();
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/*
	 *  Methods for 
	 */
	public static void refresh_Page() {
		chromeDriver.navigate().refresh();
	}


	/*
	 *  Common Method for Click
	 */
	public static boolean isElementPresentVerifyClick(String objectProperty) {
		boolean isVerifiedAndClicked = false;
		browserWithElementWait = new WebDriverWait(chromeDriver,30);
		try {
			element = getElementByProperty(objectProperty, chromeDriver);
			if (element != null) {
				t1=System.currentTimeMillis();
				element.click();
				isVerifiedAndClicked = true;
			} else {
				throw new Exception("Object Couldn't be retrieved and clicked");
			}
		} catch (Exception e) {
			element = null;
		}
		return isVerifiedAndClicked;
	}



	/*
	 *  Methods for 
	 */

	public static void getscreenshot(String screenShotName) throws Exception 
	{
		File scrFile = ((TakesScreenshot)chromeDriver).getScreenshotAs(OutputType.FILE);
		//The below method will save the screen shot in d drive with name "screenshot.png"
		FileUtils.copyFile(scrFile, new File(UserConfig.projectLocation+"/FailureScreenShot/"+screenShotName+".png"));
	}


	/*
	 *  Methods for 
	 */

	public static void scrollTo(WebDriver driver, WebElement element) {
		((JavascriptExecutor) driver).executeScript(
				"arguments[0].scrollIntoView();", element);
	}


	/*
	 *  Methods for 
	 */

	public static Map<String, List<String>> getHorizontalData(DataTable dataTable) {
		Map<String, List<String>> dataMap = null;
		try {
			dataMap = new HashMap<String, List<String>>();
			List<String> headingRow = dataTable.raw().get(0);
			int dataTableRowsCount = dataTable.getGherkinRows().size() - 1;
			ArrayList<String> totalRowCount = new ArrayList<String>();
			totalRowCount.add(Integer.toString(dataTableRowsCount));
			dataMap.put("totalRowCount", totalRowCount);
			for (int i = 0; i < headingRow.size(); i++) {
				List<String> dataList = new ArrayList<String>();
				dataMap.put(headingRow.get(i), dataList);
				for (int j = 1; j <= dataTableRowsCount; j++) {
					List<String> dataRow = dataTable.raw().get(j);
					dataList.add(dataRow.get(i));
				}
			}
		} catch (Exception e) {

		}
		return dataMap;
	}


	/*
	 *  Methods for 
	 */

	public static Map<String, List<String>> getVerticalData(DataTable dataTable) {
		Map<String, List<String>> dataMap = null;
		try {
			int dataTableRowsCount = dataTable.getGherkinRows().size();
			dataMap = new HashMap<String, List<String>>();
			for (int k = 0; k < dataTableRowsCount; k++) {
				List<String> dataRow = dataTable.raw().get(k);
				String key = dataRow.get(0);
				dataRow.remove(0);
				dataMap.put(key, dataRow);
			}
		} catch (Exception e) {

		}
		return dataMap;
	}


	/*
	 *  Methods for 
	 */

	public static String getXLSTestData (String FileName,String SheetName, String RowId,String column) throws IOException {

		String col1 = null;
		DataFormatter df = new DataFormatter();
		FileInputStream file = new FileInputStream(new File(System.getProperty("user.dir") +"/InputData"+ File.separator +FileName+".xls"));
		System.out.println(file);
		HSSFWorkbook book = new HSSFWorkbook(file);
		HSSFSheet sheet = book.getSheet(SheetName);

		int rowCount = sheet.getLastRowNum()-sheet.getFirstRowNum();
		for (int rowIterator = 1; rowIterator<=rowCount;rowIterator++) {
			String row = sheet.getRow(rowIterator).getCell(0).getStringCellValue();
			if (row.equalsIgnoreCase(RowId)) {
				for (int colIterator = 1;colIterator<sheet.getRow(rowIterator).getLastCellNum();colIterator++) {
					String col = sheet.getRow(0).getCell(colIterator).getStringCellValue();
					if (col.equalsIgnoreCase(column)) {
						Cell cellvalue = sheet.getRow(rowIterator).getCell(colIterator);
						col1 = df.formatCellValue(cellvalue);
						break;
					}
				}
			}
		}
		return col1;
	}
}
//////////////////////////////////////////////////////////////


