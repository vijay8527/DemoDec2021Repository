package com.sgtesting.actitime.test.level01;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Initialize 
{
	public static WebDriver oBrowser=null;
	/**
	 * Testcase ID:
	 * Testcase Name:
	 * Created By:
	 * Reviewed By:
	 * Reviewed Date:
	 * Return Value
	 * Parameters:
	 * Purpose:
	 * Description:
	 */
	public static void launchBrowser()
	{
		try
		{
			String strPath=System.getProperty("user.dir");
			System.setProperty("webdriver.chrome.driver", strPath+"\\Library\\drivers\\chromedriver.exe");
			oBrowser=new ChromeDriver();
			oBrowser.manage().window().maximize();
		}catch(Exception e)
		{
			e.printStackTrace();;
		}
	}
	
	/**
	 * Testcase ID:
	 * Testcase Name:
	 * Created By:
	 * Reviewed By:
	 * Reviewed Date:
	 * Return Value
	 * Parameters:
	 * Purpose:
	 * Description:
	 */
	public static void navigate()
	{
		try
		{
			oBrowser.get("http://localhost/login.do");
			Thread.sleep(4000);
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	/**
	 * Testcase ID:
	 * Testcase Name:
	 * Created By:
	 * Reviewed By:
	 * Reviewed Date:
	 * Return Value
	 * Parameters:
	 * Purpose:
	 * Description:
	 */
	public static void closeApplication()
	{
		try
		{
			oBrowser.quit();
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}

}
