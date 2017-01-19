package com.rxr.framework.StepLibrary;

import org.openqa.selenium.WebElement;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.apache.commons.configuration.ConfigurationException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import com.rxr.framework.StepLibrary.CommonLibrary;
import com.rxr.frameworkConstant.PlanSearchScreen;

import cucumber.api.DataTable;

public class PlanSearchLibrary extends CommonLibrary {
	
	public PlanSearchLibrary() throws ConfigurationException, IOException {
		super();
	}
	
	public static void dashboardEle_Click(String val)
	{
		try
		{
		Thread.sleep(4000);
		//Properties prop = HomeScreenLibrary.getProp("dashboardscreen", "linktext", true);		
		boolean link = CommonLibrary.isElementPresentVerifyClick(val);
		if(link==true)
		{
			System.out.println("clicked dashboard");
		}
		else
			System.out.println("dashboard not found");
		}
		catch (Exception e){
			e.printStackTrace();
		}
		//chromeDriver.findElementByLinkText("Dashboard").click();
	}

public static void selectDropDownValue(DataTable arg1, String propval) throws Exception
{
	Map<String, List<String>> dataMap = null;
	int i;
	try
	{
		String drp_vals[] = {"Select search option","Prescriber","Drug","Patient","Plan"};
	dataMap = CommonLibrary.getHorizontalData(arg1);
	System.out.println(dataMap.get("RowId").get(0));
    String drp_dwn_value = CommonLibrary.getXLSTestData(dataMap.get("InputFileName").get(0), dataMap.get("SheetName").get(0), dataMap.get("RowId").get(0),"First_Set");
    System.out.println("value of drp dowm is" +drp_dwn_value);
	WebElement ele = CommonLibrary.getElementByProperty(propval, chromeDriver);
	Thread.sleep(1000);
	ele.click();	
	
	Thread.sleep(2000);
	/*List<WebElement> allelemts = chromeDriver.findElements(By.xpath("//md-content[@class='_md']/md-option"));
	for(WebElement elem: allelemts){
		System.out.println(elem.getText());
		if(drp_dwn_value.equalsIgnoreCase(elem.getText()))
		{
			elem.click();
		}	

	  }*/
	  
	for(i=0;i<drp_vals.length;i++)
	{
		System.out.println(drp_vals[i]);
		if (drp_dwn_value.equalsIgnoreCase(drp_vals[i]))
			Thread.sleep(2000);
			CommonLibrary.isElementPresentVerifyClick(PlanSearchScreen.plan_click);
	}
	/*Select drop_down = new Select(ele);
	Thread.sleep(2000);
	List<WebElement> weblist = drop_down.getOptions();
	for(i=0;i<weblist.size();i++)
	{
		if(drp_dwn_value.equalsIgnoreCase(weblist.get(i).getText()));
		weblist.get(i).click();
		
	}
	if(i==weblist.size())
	{
		throw new Exception("value provided in excel is not in any of the options in drop down");
	}*/
	}
	catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	//drop_down.selectByVisibleText(drp_dwn_value);
	
/*List <WebElement> weblist = objSel.getOptions();
//Taking the count of items
int liCount = weblist.size();
String value;
for (int rowIterator=1;rowIterator<=liCount;rowIterator++)
    {
		value = CommonLibrary.getXLSTestData(FileName, SheetName, RowId, column);
		if(value.equals(weblist.get(rowIterator)))
		{
			weblist.get(rowIterator).click();
		}
    }*/
	
	
		
	}
	
	
public static void enter_BIN(DataTable arg1) throws Exception
{
	//Properties prop = HomeScreenLibrary.getProp("dashboardscreen", "textbox", true);
	String val1 = PlanSearchScreen.dashboard_screen_BIN_txtbox;
	PlanSearchLibrary.enter_Text(arg1, "BIN_Num", val1, chromeDriver);
}

public static void enter_BIN(int no, DataTable arg1) throws Exception
{
	//Properties prop = HomeScreenLibrary.getProp("dashboardscreen", "textbox", true);
	String val1 = PlanSearchScreen.dashboard_screen_BIN_txtbox;
	PlanSearchLibrary.enter_Text(arg1, "BIN_Num", val1, chromeDriver);
}

public static void enter_PCN(DataTable arg1) throws Exception
{
	//Properties prop = HomeScreenLibrary.getProp("dashboardscreen", "textbox", true);
	String val1 = PlanSearchScreen.dashboard_screen_PCN_txtbox;
	PlanSearchLibrary.enter_Text(arg1, "PCN_Num", val1, chromeDriver);
}

public static void enter_PCN(int no, DataTable arg1) throws Exception
{
	//Properties prop = HomeScreenLibrary.getProp("dashboardscreen", "textbox", true);
	String val1 = PlanSearchScreen.dashboard_screen_PCN_txtbox;
	PlanSearchLibrary.enter_Text(arg1, "PCN_Num", val1, chromeDriver);
}

public static void enter_PlanName(DataTable arg1) throws Exception
{
	//Properties prop = HomeScreenLibrary.getProp("dashboardscreen", "textbox", true);
	String val1 = PlanSearchScreen.dashboard_screen_PlanName_txtbox;
	PlanSearchLibrary.enter_Text(arg1, "Plan_Name", val1, chromeDriver);
}

public static void is_Enabled(String val) throws Exception
{
	//Properties prop = HomeScreenLibrary.getProp("dashboardscreen", "button", true);
	try {
		WebElement ele = CommonLibrary.getElementByProperty(val,chromeDriver);
		
		ele.isEnabled();
	} catch (Exception e) {
		e.printStackTrace();
	}
	
}

public static void enter_PlanID(DataTable arg1) throws Exception
{
//Properties prop = HomeScreenLibrary.getProp("dashboardscreen", "textbox", true);
String val1 = PlanSearchScreen.dashboard_screen_PlanID_txtbox;
PlanSearchLibrary.enter_Text(arg1, "Plan_ID", val1,chromeDriver);
}

public static void click_Search() throws Exception
{
	try
	{
	CommonLibrary.isElementPresentVerifyClick(PlanSearchScreen.dashboard_screen_search_button);
	}
	catch(Exception e)
	{
		//String alertMessage = chromeDriver.switchTo().alert().getText();
        //System.out.println(alertMessage);
		e.printStackTrace();
	}
	
}

public static void enter_Text(DataTable arg1, String colval, String propval, WebDriver driver) throws Exception
	{
		try
		{
			Map<String, List<String>> dataMap = null;
			dataMap = CommonLibrary.getHorizontalData(arg1);
			String val = getXLSTestData(dataMap.get("InputFileName").get(0), dataMap.get("SheetName").get(0), dataMap.get("RowId").get(0), colval);
			System.out.println(val);
			// WebElement ele = chromeDriver.findElementById(propval);
			if(!clearAndEnterText(propval,val)) {
				throw new Exception("User Not able to Enter" +val+ "in TextField");
			}
				/*if(colval=="BIN_Num" && val.length()<6)
				{
					String alertMessage = driver.switchTo().alert().getText();
			        System.out.println(alertMessage);
				}*/
				if(colval=="PCN_Num" && driver.findElement(By.id("input_8")).getText().length()==0)
						{
					String alertMessage = driver.switchTo().alert().getText();
			        System.out.println(alertMessage);
						}
				if(colval=="PlanID" && val.length()<4)
				{
					String alertMessage = driver.switchTo().alert().getText();
			        System.out.println(alertMessage);
				}
				if(colval=="PlanName" && val.length()<3)
				{
					String alertMessage = driver.switchTo().alert().getText();
			        System.out.println(alertMessage);
				}

		}
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
	}

	}
}
