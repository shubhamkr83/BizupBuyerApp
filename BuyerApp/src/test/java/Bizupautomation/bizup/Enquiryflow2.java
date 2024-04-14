package Bizupautomation.bizup;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import buyer.pageObjects.Android.HomePage;
import buyer.pageObjects.Android.SellerPage;

public class Enquiryflow2 extends Base {

	@Test
	public void Enquiryflow() throws InterruptedException {

		//PlayStore playStore = new PlayStore(driver);
		HomePage homePage = new HomePage(driver);
		//SellerPage sellerPage = new SellerPage(driver);

		// ----------------------------------------------------------------------
		// ------------- Install from Playstore --------------
		// ----------------------------------------------------------------------
/*
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

		// Launch the app
		driver.activateApp("com.sot.bizup");
		Thread.sleep(5000);

		// ---------------------------------------------------------------------- //
		// --------------------- App login ---------------------- //
		// ----------------------------------------------------------------------//

		// Answer the TrueCaller //
		driver.findElement(By.id("com.truecaller:id/tv_continueWithDifferentNumber")).click();

		// Enter Number
		driver.findElement(By.id("com.sot.bizup:id/etMobileNo")).sendKeys("1111199999");
		Thread.sleep(5000);

		// ---------------HomePage---------------
		// Answer the notification permission
		homePage.NotificationPermission();
		Thread.sleep(4000);

		// Click on the Coachmark
		homePage.CoachMark();

		// Selecting Product
		homePage.ProductSelect();
		// HomeWait();

		// Select Price
		homePage.PriceSelect();
		HomeWait();
*/
		driver.activateApp("com.sot.bizup");
		Thread.sleep(5000);
		// Video Click
		homePage.HomeVideoPlay();
		// Thread.sleep(2000);

		// ------------------Video Page--------------------
		/*
		// Answer activation question
		driver.findElement(AppiumBy.androidUIAutomator(
				"new UiScrollable(new UiSelector()).scrollIntoView(text(\"आप किस के लिए कपड़े देख रहें हैं ?\"));"));
		driver.findElement(By.xpath(
				"//android.widget.Button[@resource-id=\"com.sot.bizup:id/mtOption\" and @text=\"दुकान के लिए\"]"))
				.click();
		// Thread.sleep(2000);
*/
		// Go to seller page
		driver.findElement(By.id("com.sot.bizup:id/mbGood")).click();

		// Seller
		SellerEnquiry();

		// Terminate the app
		driver.terminateApp("com.sot.bizup");

		// Launch the app
		driver.activateApp("com.sot.bizup");
		Thread.sleep(5000);

	}

}
