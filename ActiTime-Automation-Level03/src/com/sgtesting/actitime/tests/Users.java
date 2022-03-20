package com.sgtesting.actitime.tests;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Users{
	
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
	public static void createUser(WebDriver oBrowser)
	{
		try
		{
			oBrowser.findElement(By.xpath("//*[@id='topnav']/tbody/tr[1]/td[5]/a/div[2]")).click();
			Thread.sleep(3000);
			oBrowser.findElement(By.xpath("//div[text()='Add User']")).click();
			Thread.sleep(3000);
			oBrowser.findElement(By.name("firstName")).sendKeys("demo");
			oBrowser.findElement(By.name("lastName")).sendKeys("User1");
			oBrowser.findElement(By.name("email")).sendKeys("demo@gmail.com");
			oBrowser.findElement(By.name("username")).sendKeys("demoUser1");
			oBrowser.findElement(By.name("password")).sendKeys("Welcome123");
			oBrowser.findElement(By.name("passwordCopy")).sendKeys("Welcome123");
			oBrowser.findElement(By.className("buttonTitle")).click();
			Thread.sleep(5000);
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
	public static void modifyUser(WebDriver oBrowser)
	{
		try
		{
			oBrowser.findElement(By.xpath("//span[text()='User1, demo']")).click();
			Thread.sleep(3000);
			oBrowser.findElement(By.name("password")).sendKeys("India123");
			oBrowser.findElement(By.name("passwordCopy")).sendKeys("India123");
			oBrowser.findElement(By.xpath("//span[text()='Save Changes']")).click();
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
	public static void deleteUser(WebDriver oBrowser)
	{
		try
		{
			oBrowser.findElement(By.xpath("//span[text()='User1, demo']")).click();
			Thread.sleep(3000);
			oBrowser.findElement(By.id("userDataLightBox_deleteBtn")).click();
			Thread.sleep(2000);
			Alert oAlert=oBrowser.switchTo().alert();
			String content=oAlert.getText();
			System.out.println(content);
			oAlert.accept();
			Thread.sleep(2000);
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}
