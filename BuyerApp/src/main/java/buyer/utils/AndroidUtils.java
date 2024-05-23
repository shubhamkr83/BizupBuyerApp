package buyer.utils;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;

public class AndroidUtils {

	AndroidDriver driver;

	// Assign driver to AndroidUtils
	public AndroidUtils(AndroidDriver driver) {
		this.driver = driver;
	}

	// Back Method
	public void Back() {
		driver.pressKey(new KeyEvent(AndroidKey.BACK));
	}

	// Enter Method
	public void Enter() {
		driver.pressKey(new KeyEvent(AndroidKey.ENTER));
	}

	// Click method for ID
	public void ClickId(String element) {
		driver.findElement(By.id(element)).click();
	}

	// Click method for xpath
	public void ClickXp(String element) {
		driver.findElement(By.xpath(element)).click();
	}

	// Restart App Method
	public void RestartApp() throws InterruptedException {
		driver.terminateApp("com.sot.bizup.debug");
		driver.activateApp("com.sot.bizup.debug");
		Thread.sleep(3000);
	}

	// Send Method
	public void Send() {
		ClickXp("//android.widget.Button[@text=\"\"]");
	}

	// Send message in the chat
	public void SendKey(String message) throws InterruptedException {
		driver.findElement(By.xpath("//android.widget.EditText")).sendKeys(message);
		Send();
		Thread.sleep(4000);
	}

	// Wait for element
	public void Wait(WebElement element, String text) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.attributeContains(((element)), "text", text));
	}

	// Getting seller name from video page
	public String VpSellerName() {
		String sellerName = driver.findElement(By.id("com.sot.bizup.debug:id/mtSellerNameD")).getText();
		System.out.println("Seller name is :- " + sellerName);
		return sellerName;
	}

	// Home to Video page navigation
	public void HomeFeed() throws InterruptedException {
		ClickXp("(//android.widget.ImageView[@resource-id=\"com.sot.bizup.debug:id/ivThumbnail\"])[1]");
		Thread.sleep(2000);
		System.out.println("Land to the video feed ✔");
	}

	// Getting seller name from seller page
	public String SpSellerName() {
		String sellerName = driver.findElement(By.id("com.sot.bizup.debug:id/mtSellerName")).getText();
		System.out.println("Seller name is :- " + sellerName);
		return sellerName;
	}

	// Home to seller page navigation
	public String HomeSeller() throws InterruptedException {
		ClickXp("(//android.widget.ImageView[@resource-id=\"com.sot.bizup.debug:id/ivThumbnail\"])[1]");
		Thread.sleep(2000);
		ClickId("com.sot.bizup.debug:id/mbGood");
		String Sseller = SpSellerName();
		return Sseller;
	}

	// Scroll without element
	public void Scroll() {
		boolean canScrollMore;
		do {
			canScrollMore = (Boolean) ((JavascriptExecutor) driver).executeScript("mobile: scrollGesture", ImmutableMap
					.of("left", 100, "top", 100, "width", 200, "height", 200, "direction", "down", "percent", 3.0));
		} while (canScrollMore);
	}

	// Scroll to find Element
	public void ScrollEle(String ele) {

		driver.findElement(AppiumBy
				.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"" + ele + "\"));"));
	}

	// Toast Message Method
	public String Toast() {

		String message = "";
		By toast = By.xpath("//android.widget.Toast");

		boolean istoast = driver.findElements(toast).size() > 0;

		if (istoast) {
			message = driver.findElement(toast).getAttribute("name");
			System.out.println("Toast Message Appers ✔");
			System.out.println(message);
		} else {
			System.out.println("Toast Message not Appers ❌");
			Assert.fail("Condition failed, marking test as failed");
		}

		return message;
	}

	// Chat Methods
	public void ShortChat1() throws InterruptedException {
		SendKey("Hello");

	}

	public void ShortChat2() throws InterruptedException {
		SendKey("Shirt chahiye");
		Send();
	}

	public void LongChat1() throws InterruptedException {
		SendKey("Hi");

		SendKey("Pant chahiye");

		SendKey("aur dekhao");
	}

	public void LongChat2() throws InterruptedException {
		SendKey("COD milega??");

		SendKey("Delivery charge kitna lagega??");

		SendKey("Delivery kab tak hogi??");
	}

	// Enquiry Methods
	public void DetailedEnquiry() throws InterruptedException {
		try {

			// CoachMark Check
			CoachMarkCheck("com.sot.bizup.debug:id/ivDealsCoachmarkText");
			ClickId("com.sot.bizup.debug:id/mtSellerCatalog");

			// Selecting Catalog
			ClickXp("(//android.widget.Button[@resource-id=\"com.sot.bizup.debug:id/mbShortlist\"])[1]");

			// Click on Baat Kare button
			ClickId("com.sot.bizup.debug:id/mbPlaceOrder");
			Thread.sleep(3000);

			// Check for PreEnquiryVideo
			PreEnquiryVideoCheck();

			// Enter the text on the Chat box
			LongChat1();
			driver.hideKeyboard();
			Back();

			// ------Video Enquiry------
			// Video Tab Change
			ClickId("com.sot.bizup.debug:id/mtSellerVideos");
			ClickId("com.sot.bizup.debug:id/mtSellerVideos");

			// Click on the video
			ClickXp("(//android.widget.ImageView[@resource-id=\"com.sot.bizup.debug:id/ivThumbnail\"])[1]");

			// Seller video baat kare button click
			ClickId("com.sot.bizup.debug:id/mbChat");

			// Check for PreEnquiryVideo
			PreEnquiryVideoCheck();

			// Enter the text on the Chat box
			LongChat2();

			// WhatsApp Enable Click
			By secondElement = By.xpath("//android.widget.TextView[@text=\"ओनर से बात करे\"]");
			By firstElement = By.xpath("//android.widget.Button[@text=\"बात करे\"]");

			// Check if the first element exists
			if (driver.findElements(firstElement).size() > 0) {
				// If the first element exists, click it
				driver.findElement(firstElement).click();
			} else {
				// If the first element doesn't exist, check if the second element exists
				driver.findElement(secondElement).click();
			}

			// Check for PreEnquiryVideo
			PreEnquiryVideoCheck();

			// Back to Chat
			Thread.sleep(3000);
			Back();
			Back();

			// Answer feedback
			ClickId("com.sot.bizup.debug:id/mbPositive");
			Thread.sleep(2000);
			ClickId("com.sot.bizup.debug:id/mbMessage");
			Thread.sleep(2000);

		} catch (Exception e) {

			System.out.println("Detail Enquiry error " + e + " ❌");
		}
	}

	public void shortSellerEnquiry() throws InterruptedException {
		try {

			// Click on Baat Kare button
			ClickId("com.sot.bizup.debug:id/mbDealKare");
			Thread.sleep(3000);

			// Check for PreEnquiryVideo
			PreEnquiryVideoCheck();

			// Enter the text on the Chat box
			ShortChat1();

			// Back from Chat
			Back();

			// Video Tab Change
			ClickId("com.sot.bizup.debug:id/mtSellerVideos");
			ClickId("com.sot.bizup.debug:id/mtSellerVideos");

			// Play video
			ClickXp("(//android.widget.ImageView[@resource-id=\"com.sot.bizup.debug:id/ivThumbnail\"])[1]");

			// Seller video baat kare button click
			ClickId("com.sot.bizup.debug:id/mbChat");

			// Check for PreEnquiryVideo
			PreEnquiryVideoCheck();

			// Enter the text on the Chat box
			ShortChat2();

			// Back from Chat
			Back();

		} catch (Exception e) {
			System.out.println("Short Seller Enquiry error" + e + " ❌");
		}

	}

	public void shortestEnquiry() throws InterruptedException {

		// Click on Baat Kare button
		ClickId("com.sot.bizup.debug:id/mbDealKare");
		Thread.sleep(1000);

		// Check for PreEnquiryVideo
		PreEnquiryVideoCheck();

		// Enter the text on the Chat box
		ShortChat1();

	}

	// CoachMark Check
	public void CoachMarkCheck(String CoachEle) {
		By coachMark = By.id(CoachEle);

		if (driver.findElements(coachMark).size() > 0) {
			// If the coachMark exists, click it
			driver.findElement(coachMark).click();
			System.out.println("CoachMark Displayed ✔");
		}
	}

	// PreEnquiryVideo Check
	public void PreEnquiryVideoCheck() throws InterruptedException {

		By preEnquiryVideo = By.id("com.sot.bizup.debug:id/mbButton");

		if (driver.findElements(preEnquiryVideo).size() > 0) {
			// If the PreEnquiryVideo exists, skip it
			Thread.sleep(8000);
			driver.findElement(preEnquiryVideo).click();
			System.out.println("Pre-Enquiry Video Displayed ✔");
		}

	}

}
