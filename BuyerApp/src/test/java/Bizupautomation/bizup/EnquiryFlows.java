package Bizupautomation.bizup;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Bizupautomation.testUtils.Base;
import buyer.pageObjects.Android.EnquiryTab;
import buyer.pageObjects.Android.HomePage;
import buyer.pageObjects.Android.Search;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;

public class EnquiryFlows extends Base {

	@BeforeMethod(alwaysRun=true)
	public void preSetup() throws InterruptedException {
		// Launch the app
		driver.activateApp("com.sot.bizup");
		Thread.sleep(3000);
	}

	// ----------------------------------------------------------------------
	// ------------------ EnquiryVideoFlow --------------------
	// ----------------------------------------------------------------------
	@Test(groups=("Smoke"))
	public void EnquiryVideoFlow() throws InterruptedException {
		HomePage homePage = new HomePage(driver);

		// ---------------HomePage---------------
		// Selecting Product
		homePage.ProductSelect(3);
		homePage.ProductSelect(4);

		// Select Price
		homePage.PriceSelect();
		HomeWait();

		// Video Click
		homePage.HomeVideoPlay(1);
		Thread.sleep(2000);

		// ------------------Video Page--------------------
		/*
		 * // Answer activation question driver.findElement(AppiumBy.androidUIAutomator(
		 * "new UiScrollable(new UiSelector()).scrollIntoView(text(\"आप किस के लिए कपड़े देख रहें हैं ?\"));"
		 * )); driver.findElement(By.xpath(
		 * "//android.widget.Button[@resource-id=\"com.sot.bizup:id/mtOption\" and @text=\"दुकान के लिए\"]"
		 * )) .click();
		 */

		// Go to seller page
		driver.findElement(By.id("com.sot.bizup:id/mbGood")).click();

		//------ Seller Enquiry -------
		homePage.DetailedEnquiry();
		
		

		// Terminate the app
		driver.terminateApp("com.sot.bizup");

	}

	// ----------------------------------------------------------------------
	// ------------------ SearchEnquiryFlow --------------------
	// ----------------------------------------------------------------------
	@Test(groups=("Smoke"))
	public void SearchEnquiryFlow() throws InterruptedException {

		Search search = new Search(driver);

		// Click on the search icon
		search.SearchIconClick();

		// Type text on the search icon
		search.SearchInputType("jacket");
		driver.pressKey(new KeyEvent(AndroidKey.ENTER));

		// Check the Result
		String resultsSearch = driver.findElement(By.id("com.sot.bizup:id/mtTitle")).getText();
		Assert.assertEquals("Showing results for “jacket”", resultsSearch);

		// Video Tab
		search.SearchVideoTab();

		// Play video
		search.PlayVideo();

		// Video Enquiry button click
		search.VideoLikeButton();

		// Short Seller Enquiry
		search.shortSellerEnquiry();
		driver.pressKey(new KeyEvent(AndroidKey.BACK));
		driver.pressKey(new KeyEvent(AndroidKey.BACK));
		driver.pressKey(new KeyEvent(AndroidKey.BACK));

		// Sample Tab Change
		search.SearchSampleTab();

		// Sample Enquiry
		search.SearchSampleEnquiry();
		Thread.sleep(4000);

		// Back from Chat
		driver.pressKey(new KeyEvent(AndroidKey.BACK));
		Thread.sleep(2000);

		// Seller Tab Change
		search.SearchSellerTab();

		// Select seller card
		search.SellerCardSelect();

		// Short Seller Enquiry
		search.shortSellerEnquiry();

		// Terminate the app
		driver.terminateApp("com.sot.bizup");

	}

	// ----------------------------------------------------------------------
	// ------------------ Enquiry Tab Flow ------------------
	// ----------------------------------------------------------------------
	@Test(groups=("Smoke"))
	public void EnquiryTabFlow() throws InterruptedException {

		EnquiryTab enquiryTab = new EnquiryTab(driver);

		enquiryTab.MereSellerTabClick();
		Thread.sleep(1000);

		By coachMark = By.id("com.sot.bizup:id/ivDealsCoachmark");

		// Check for coachMark
		if (driver.findElements(coachMark).size() > 0) {
			// If the coachMark exists, click it
			driver.findElement(coachMark).click();
			// click Reply Now button
			enquiryTab.ReplyNowClick();
		} else {
			// If the coachMark element doesn't exist then click Reply Now button
			enquiryTab.ReplyNowClick();
		}

		// Check for PreEnquiryVideo
		By preEnquiryVideo = By.id("com.sot.bizup:id/mbButton");
		if (driver.findElements(preEnquiryVideo).size() > 0) {
			// If the PreEnquiryVideo exists, skip it
			Thread.sleep(8000);
			driver.findElement(preEnquiryVideo).click();
			// Back from chat
			Thread.sleep(1500);
			driver.pressKey(new KeyEvent(AndroidKey.BACK));
		} else {
			// If the PreEnquiryVideo doesn't exist then Back from chat
			// Back from chat
			Thread.sleep(1500);
			driver.pressKey(new KeyEvent(AndroidKey.BACK));
		}

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

		// Order Feedback question
		enquiryTab.SelectFeedbackQue();

		// ----------------------------------------------------------------------
		// ----------------- Claim Tab Flow --------------------
		// ----------------------------------------------------------------------

		// Click on Claim Tab
		enquiryTab.ClaimTabClick();

		// Click on the Ask now button
		enquiryTab.AskNowClick();

		if (driver.findElements(preEnquiryVideo).size() > 0) {
			// If the first element exists, click it
			Thread.sleep(8000);
			driver.findElement(preEnquiryVideo).click();
			// WhatsApp back
			Thread.sleep(1000);
			driver.pressKey(new KeyEvent(AndroidKey.BACK));
			driver.pressKey(new KeyEvent(AndroidKey.BACK));
		} else {
			// WhatsApp back
			Thread.sleep(1000);
			driver.pressKey(new KeyEvent(AndroidKey.BACK));
			driver.pressKey(new KeyEvent(AndroidKey.BACK));
		}

		// Order Feedback question
		enquiryTab.SelectFeedbackQue();

		// Terminate the app
		driver.terminateApp("com.sot.bizup");

	}

}
