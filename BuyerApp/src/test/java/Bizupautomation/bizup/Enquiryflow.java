package Bizupautomation.bizup;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import buyer.pageObjects.Android.EnquiryTab;
import buyer.pageObjects.Android.HomePage;
import buyer.pageObjects.Android.Login;
import buyer.pageObjects.Android.PlayStore;
import buyer.pageObjects.Android.Search;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;

public class Enquiryflow extends Base {

	@Test
	public void EnquiryFlow() throws InterruptedException {

		PlayStore playStore = new PlayStore(driver);
		Login login = new Login(driver);
		HomePage homePage = new HomePage(driver);
		Search search = new Search(driver);
		EnquiryTab enquiryTab = new EnquiryTab(driver);


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

		// Launch the app
		driver.activateApp("com.sot.bizup");
		Thread.sleep(5000);

		// ----------------------------------------------------------------------
		// --------------------- App login ----------------------
		// ----------------------------------------------------------------------

		// Answer the TrueCaller
		// login.TrueCaller();

		// Enter Number
		login.MobileNumber("1111100000");
		Thread.sleep(5000);

		// ---------------HomePage---------------
		// Answer the notification permission
		homePage.NotificationPermission();
		Thread.sleep(4000);

		// Click on the Coachmark
		homePage.CoachMark();

		// Selecting Product
		homePage.ProductSelect(3);
		homePage.ProductSelect(4);

		// Select Price
		homePage.PriceSelect();
		HomeWait();

		// Video Click
		homePage.HomeVideoPlay(1);
		// Thread.sleep(2000);

		// ------------------Video Page--------------------
		/*
		 // Answer activation question driver.findElement(AppiumBy.androidUIAutomator(
		 "new UiScrollable(new UiSelector()).scrollIntoView(text(\"आप किस के लिए कपड़े देख रहें हैं ?\"));"
		  )); driver.findElement(By.xpath(
		  "//android.widget.Button[@resource-id=\"com.sot.bizup:id/mtOption\" and @text=\"दुकान के लिए\"]"
		  )) .click();
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

		// ----------------------------------------------------------------------
		// ------------------ SearchEnquiryFlow --------------------
		// ----------------------------------------------------------------------

		// Click on the search icon
		search.SearchIconClick();

		// Type text on the search icon
		search.SearchInputType("jeans");
		driver.pressKey(new KeyEvent(AndroidKey.ENTER));

		String resultsSearch = driver.findElement(By.id("com.sot.bizup:id/mtTitle")).getText();
		Assert.assertEquals("Showing results for “jeans”", resultsSearch);

		// Video Tab
		search.VideoTabClick();

		// Play video
		search.PlayVideo();

		// Video Enquiry button click
		search.VideoLikeButton();

		shortSellerEnquiry();
		driver.pressKey(new KeyEvent(AndroidKey.BACK));
		driver.pressKey(new KeyEvent(AndroidKey.BACK));
		driver.pressKey(new KeyEvent(AndroidKey.BACK));

		// Sample Tab Change
		search.SampleTabClick();

		// Sample Enquiry
		search.SampleEnquiryClick();
		Thread.sleep(4000);

		// Back from Chat
		driver.pressKey(new KeyEvent(AndroidKey.BACK));
		Thread.sleep(2000);

		// Seller Tab Change
		search.SellerTabClick();

		// Select seller card
		search.SellerCardSelect();

		// ----------- Short Seller Enquiry ----------
		shortSellerEnquiry();

		// Terminate the app
		driver.terminateApp("com.sot.bizup");

		// Launch the app
		driver.activateApp("com.sot.bizup");

		// ----------------------------------------------------------------------
		// ------------------ Enquiry Tab Flow ------------------
		// ----------------------------------------------------------------------

		// Mere Seller Tab Click
		enquiryTab.MereSellerTabClick();
		Thread.sleep(2000);

		enquiryTab.CoachMark();
		Thread.sleep(2000);

		// Reply Now button click
		enquiryTab.ReplyNowClick();

		// Back from Chat
		Thread.sleep(4000);
		driver.pressKey(new KeyEvent(AndroidKey.BACK));

		// ----------------------------------------------------------------------
		// ------------------- Claimming Flow -------------------
		// ----------------------------------------------------------------------

		// KB button click
		enquiryTab.KBClick();

		// Upload invoice button click
		enquiryTab.UploadClick();

		// select the invoice
		enquiryTab.selectInvoice();

		// Click on the Claim button
		enquiryTab.ClaimButtonClick();

		// Click on the Ask now button
		enquiryTab.AskNowButtonClick();

		Thread.sleep(4000);
		driver.pressKey(new KeyEvent(AndroidKey.BACK));
		driver.pressKey(new KeyEvent(AndroidKey.BACK));

		// Order Feedback question
		enquiryTab.SelectFeedbackQue();
		driver.pressKey(new KeyEvent(AndroidKey.BACK));

		// ----------------------------------------------------------------------
		// ----------------- Claim Tab Flow --------------------
		// ----------------------------------------------------------------------

		// Click on Claim Tab
		enquiryTab.ClaimTabClick();

		// Click on the Ask now button
		enquiryTab.AskNowClick();

		// WhatsApp back
		Thread.sleep(5000);
		driver.pressKey(new KeyEvent(AndroidKey.BACK));
		driver.pressKey(new KeyEvent(AndroidKey.BACK));

		// Order Feedback question
		Thread.sleep(2000);
		enquiryTab.SelectFeedbackQue();
	}

}
