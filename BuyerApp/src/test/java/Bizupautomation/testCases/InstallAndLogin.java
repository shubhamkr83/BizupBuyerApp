package Bizupautomation.testCases;

import org.testng.annotations.Test;

import Bizupautomation.testUtils.Base;
import buyer.pageObjects.Android.LoginObj;

public class InstallAndLogin extends Base {

	@Test
	public void LoginFlow() throws InterruptedException {
		LoginObj login = new LoginObj(driver);

		// App install and login
		login.Install();

	}
}
