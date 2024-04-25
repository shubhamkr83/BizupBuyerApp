package Bizupautomation.bizup;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import Bizupautomation.testUtils.Base;
import buyer.pageObjects.Android.HomePage;
import buyer.pageObjects.Android.Login;
import buyer.pageObjects.Android.PlayStore;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;

public class PlayStoreInstall extends Base {

	@Test
	public void InstallFlow() throws InterruptedException {
		PlayStore playStore = new PlayStore(driver);

		// ----------------------------------------------------------------------
		// ------------- Install from Playstore --------------
		// ----------------------------------------------------------------------

		// Launch the PlayStore App
		driver.activateApp("com.android.vending");

		// Click on the search icon
		playStore.SearchIcon();

		// Click on the search inupt
		playStore.SearchInput();

		// Text search
		playStore.SearchApp("Bizup");
		driver.pressKey(new KeyEvent(AndroidKey.ENTER));

		// Click on the Bizup icon
		playStore.AppIcon();

		// Click install button
		playStore.Install();

		// Waiting to installation
		Thread.sleep(45000);
		playStore.LaunchApp();

		// Launch the app
		driver.activateApp("com.sot.bizup");
		Thread.sleep(4000);
	}

	// ----------------------------------------------------------------------
	// --------------------- App login ----------------------
	// ----------------------------------------------------------------------
	@Test
	public void LoginFlow() throws InterruptedException {
		Login login = new Login(driver);
		HomePage homePage = new HomePage(driver);

		// Answer the TrueCaller
		By trueCaller = By.id("com.truecaller:id/tv_continueWithDifferentNumber");
		if (driver.findElements(trueCaller).size() > 0) {
			// If the PreEnquiryVideo exists, skip it
			driver.findElement(trueCaller).click();
		}

		// Enter Number
		login.MobileNumber("111110000");
		Thread.sleep(4000);

		// Answer the notification permission
		homePage.NotificationPermission();

		// Terminate the app
		driver.terminateApp("com.sot.bizup");

	}
}
