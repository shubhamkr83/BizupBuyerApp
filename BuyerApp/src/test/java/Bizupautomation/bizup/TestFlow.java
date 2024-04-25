package Bizupautomation.bizup;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.testng.annotations.Test;

import Bizupautomation.testUtils.Base;
import buyer.pageObjects.Android.SellerPage;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;

public class TestFlow extends Base {

	@Test
	public void Seller() throws InterruptedException {

		SellerPage sellerPage = new SellerPage(driver);

		// Coachmark
		//sellerPage.Coachmark();

		// ------Catalog Enquiry------

		// Go to Catalog Tab
		sellerPage.CatalogTabClick();

		// Selecting Catalog
		sellerPage.CatalogSelect();

		// Click on Baat Kare button
		sellerPage.BaatKareButton();

		// Check for PreEnquiryVideo
		By preEnquiryVideo = By.id("com.sot.bizup:id/mbButton");
		if (driver.findElements(preEnquiryVideo).size() > 0) {
			// If the PreEnquiryVideo exists, skip it
			Thread.sleep(8000);
			driver.findElement(preEnquiryVideo).click();
		}

		// Enter the text on the Chat box
		Thread.sleep(4000);
		sellerPage.LongChat1();

		driver.pressKey(new KeyEvent(AndroidKey.BACK));

		// ------Video Enquiry------
		// Search Video Tab Change
		sellerPage.VideoTabClick();

		// Click on the video
		sellerPage.VideoPlay();

		// Seller video baat kare button click
		sellerPage.VideoBaatKare();

		// Enter the text on the Chat box
		sellerPage.LongChat2();

		// WhatsApp Enable Click
		By secondElement = By.xpath("//android.widget.TextView[@text=\"ओनर से बात करे\"]");
		By firstElement = By.xpath("//android.widget.Button[@text=\"बात करे\"]");

		// driver.findElement(By.xpath("(//android.widget.Image[@text=\"Vector\"])[2]")).click();

		// Check if the first element exists
		if (driver.findElements(firstElement).size() > 0) {
			// If the first element exists, click it
			driver.findElement(firstElement).click();
		} else {
			// If the first element doesn't exist, check if the second element exists
			if (driver.findElements(secondElement).size() > 0) {
				// If the second element exists, click it
				driver.findElement(secondElement).click();
			} else {
				// If neither element exists, throw an exception or handle it in some other way
				throw new NoSuchElementException("Neither the first nor the second element was found.");
			}
		}

		// Check for PreEnquiryVideo
		if (driver.findElements(preEnquiryVideo).size() > 0) {
			// If the PreEnquiryVideo exists, skip it
			Thread.sleep(8000);
			driver.findElement(preEnquiryVideo).click();
		}

		// Back to Chat
		Thread.sleep(3000);
		driver.pressKey(new KeyEvent(AndroidKey.BACK));
		driver.pressKey(new KeyEvent(AndroidKey.BACK));

		// Answer feedback
		sellerPage.FeedbackAnswer();
	}

}
