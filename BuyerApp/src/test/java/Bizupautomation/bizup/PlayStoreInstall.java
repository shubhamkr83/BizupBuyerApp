package Bizupautomation.bizup;

import org.testng.annotations.Test;

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
		Thread.sleep(40000);

		// Launch the app
		driver.activateApp("com.sot.bizup");
		Thread.sleep(3000);
	}

	// ----------------------------------------------------------------------
	// --------------------- App login ----------------------
	// ----------------------------------------------------------------------
	@Test
	public void LoginFlow() throws InterruptedException {
		Login login = new Login(driver);
		HomePage homePage = new HomePage(driver);

		// Answer the TrueCaller
		// login.TrueCaller();

		// Enter Number
		login.MobileNumber("1111100000");
		Thread.sleep(5000);

		// Answer the notification permission
		homePage.NotificationPermission();

		// Terminate the app
		driver.terminateApp("com.sot.bizup");

	}
}
