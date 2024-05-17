package Bizupautomation.bizup;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Bizupautomation.testUtils.Base;
import buyer.pageObjects.Android.HomePageObj;
import buyer.pageObjects.Android.LoginObj;

public class Install extends Base {
	
	@BeforeMethod(alwaysRun = true)
	public void preSetup() throws InterruptedException {
		RemoveApp(driver);
	}

	@Test
	public void LoginFlow() throws InterruptedException {
		LoginObj login = new LoginObj(driver);
		HomePageObj homePage = new HomePageObj(driver);

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
