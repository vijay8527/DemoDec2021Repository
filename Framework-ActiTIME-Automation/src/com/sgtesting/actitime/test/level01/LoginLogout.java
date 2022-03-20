package com.sgtesting.actitime.test.level01;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginLogout extends Initialize
{
	
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
	public static void login()
	{
		try
		{
			oBrowser.findElement(By.id("username")).sendKeys("admin");
			oBrowser.findElement(By.name("pwd")).sendKeys("manager");
			oBrowser.findElement(By.xpath("//*[@id='loginButton']/div")).click();
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
	public static void logout()
	{
		try
		{
			oBrowser.findElement(By.linkText("Logout")).click();
			Thread.sleep(2000);
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}

}
