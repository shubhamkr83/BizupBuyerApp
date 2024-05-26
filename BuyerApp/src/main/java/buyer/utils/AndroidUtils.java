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
		By ChatCheck = By.xpath("//android.widget.Button[@text=\"\"]");
		By WhatsAppCheck = By.id("com.whatsapp:id/send");

		if (driver.findElements(ChatCheck).size() > 0) {
			ChatCheck();
			SendKey("Hello");
		} else if (driver.findElements(WhatsAppCheck).size() > 0) {
			WhatsAppCheck();
		}
	}

	public void ShortChat2() throws InterruptedException {
		By ChatCheck = By.xpath("//android.widget.Button[@text=\"\"]");
		By WhatsAppCheck = By.id("com.whatsapp:id/send");

		if (driver.findElements(ChatCheck).size() > 0) {
			ChatCheck();
			SendKey("Shirt chahiye");
			Send();
		} else if (driver.findElements(WhatsAppCheck).size() > 0) {
			WhatsAppCheck();
		}
	}

	public void LongChat1() throws InterruptedException {
		By ChatCheck = By.xpath("//android.widget.Button[@text=\"\"]");
		By WhatsAppCheck = By.id("com.whatsapp:id/send");

		if (driver.findElements(ChatCheck).size() > 0) {
			ChatCheck();
			SendKey("Hi");
			SendKey("Pant chahiye");
			SendKey("aur dekhao");
		} else if (driver.findElements(WhatsAppCheck).size() > 0) {
			WhatsAppCheck();
		}
	}

	public void LongChat2() throws InterruptedException {
		By ChatCheck = By.xpath("//android.widget.Button[@text=\"\"]");
		By WhatsAppCheck = By.id("com.whatsapp:id/send");

		if (driver.findElements(ChatCheck).size() > 0) {
			ChatCheck();
			SendKey("COD milega??");
			SendKey("Delivery charge kitna lagega??");
			SendKey("Delivery kab tak hogi??");
		} else if (driver.findElements(WhatsAppCheck).size() > 0) {
			WhatsAppCheck();
		}
	}

	// Enquiry Methods
	public void DetailedEnquiry() {
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

			// WhatsApp Check
			WhatsAppCheck();

			// Answer feedback question
			FeedbackQue();

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

	// Feedback Question
	public void FeedbackQue() {
		try {
			By FeedbackQ = By.id("com.sot.bizup.debug:id/mtQuestion");

			if (driver.findElements(FeedbackQ).size() > 0) {
				ClickId("com.sot.bizup.debug:id/mbPositive");
				ClickId("com.sot.bizup.debug:id/mbMessage");
				driver.pressKey(new KeyEvent(AndroidKey.BACK));
				System.out.println("Feedback Question working ✔");
			}
		} catch (Exception e) {
			Assert.fail("Feedback Question error" + e);
		}
	}

	// WhatsApp Check
	public void WhatsAppCheck() {
		try {
			By WhatsAppCheck = By.id("com.whatsapp:id/send");

			if (driver.findElements(WhatsAppCheck).size() > 0) {
				System.out.println("Landed on WhatsApp ✔");
				Thread.sleep(2000);
				Back();
				Back();
			}
		} catch (Exception e) {
			Assert.fail("WhatsApp Landing Failed" + e);
		}
	}

	// Chat Check
	public void ChatCheck() {
		try {
			By ChatCheck = By.xpath("//android.widget.Button[@text=\"\"]");

			if (driver.findElements(ChatCheck).size() > 0) {
				System.out.println("Landed on Chat ✔");
			}
		} catch (Exception e) {
			Assert.fail("Chat Landing Failed" + e);
		}
	}

}
