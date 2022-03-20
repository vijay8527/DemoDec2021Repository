package com.sgtesting.actitime.driverscript;

import com.sgtesting.actitime.test.level01.HomePage;
import com.sgtesting.actitime.test.level01.Initialize;
import com.sgtesting.actitime.test.level01.LoginLogout;
import com.sgtesting.actitime.test.level01.Users;

public class DriverScript {

	public static void main(String[] args) {

		try
		{
			//Create User Scenario
			Initialize.launchBrowser();
			Initialize.navigate();
			LoginLogout.login();
			HomePage.minimizeFlyOutWindow();
			Users.createUser();
			Users.deleteUser();
			LoginLogout.logout();
			Initialize.closeApplication();

			//Modify User Scenario
			Initialize.launchBrowser();
			Initialize.navigate();
			LoginLogout.login();
			HomePage.minimizeFlyOutWindow();
			Users.createUser();
			Users.modifyUser();
			Users.deleteUser();
			LoginLogout.logout();
			Initialize.closeApplication();
		}catch(Exception e)
		{
			e.printStackTrace();
		}

	}

}
