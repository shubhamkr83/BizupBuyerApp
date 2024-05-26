package Bizupautomation.testCases;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Bizupautomation.testUtils.Base;
import buyer.pageObjects.Android.HomeObj;
import buyer.pageObjects.Android.LoginObj;

public class InstallAndLogin extends Base {
	
	@BeforeMethod(alwaysRun = true)
	public void preSetup() throws InterruptedException {
		RemoveApp(driver);
	}

	@Test
	public void LoginFlow() throws InterruptedException {
		LoginObj login = new LoginObj(driver);
		HomeObj homePage = new HomeObj(driver);

		// App install
		Install(driver);
		Launch(driver);
		
		// Enter Number
		login.MobileNumber("1111100000");

		// Answer the notification permission
		homePage.NotificationPermission();

		// Terminate the app
		Terminate(driver);

	}
}
