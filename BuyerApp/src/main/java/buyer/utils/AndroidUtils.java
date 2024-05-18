package buyer.utils;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;

public class AndroidUtils {

	AndroidDriver driver;

	public AndroidUtils(AndroidDriver driver) {
		this.driver = driver;
	}

	public void Back() {
		driver.pressKey(new KeyEvent(AndroidKey.BACK));
	}

	public void Enter() {
		driver.pressKey(new KeyEvent(AndroidKey.ENTER));
	}

	public void ClickId(String element) {
		driver.findElement(By.id(element)).click();
	}

	public void ClickXp(String element) {
		driver.findElement(By.xpath(element)).click();
	}
	
	public void RestartApp() throws InterruptedException {
		driver.terminateApp("com.sot.bizup.debug");
		driver.activateApp("com.sot.bizup.debug");
		Thread.sleep(3000);
	}

	public void Send() {
		driver.findElement(By.xpath("//android.widget.Button[@text=\"\"]")).click();
	}

	public void SendKey(String element, String message) {
		driver.findElement(By.xpath(element)).sendKeys(message);
		Send();
	}

	public void Wait(WebElement element, String text) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.attributeContains(((element)), "text", text));
	}

	public String SellerName()
	{
		String sellerName = driver.findElement(By.id("com.sot.bizup.debug:id/mtSellerName")).getText();
		System.out.println("Seller name is :- " + sellerName);
		return sellerName;
	}
	
	public void Scroll() {

		((JavascriptExecutor) driver).executeScript("mobile: scrollGesture", ImmutableMap.of("left", 100, "top", 100,
				"width", 200, "height", 600, "direction", "down", "percent", 3.0));
	}

	public void ScrollEle(String ele) {

		driver.findElement(AppiumBy
				.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"" + ele + "\"));"));
	}

	// Enquiry Methods
	public void DetailedEnquiry() throws InterruptedException {
		// Coachmark
		By coachMark = By.id("com.sot.bizup.debug:id/ivDealsCoachmarkText");
		// Check for coachMark
		if (driver.findElements(coachMark).size() > 0) {
			// If the coachMark exists, click it
			driver.findElement(coachMark).click();
			// Go to Catalog Tab
			ClickId("com.sot.bizup.debug:id/mtSellerCatalog");
		} else {
			// Go to Catalog Tab
			ClickId("com.sot.bizup.debug:id/mtSellerCatalog");
		}

		// Selecting Catalog
		ClickXp("(//android.widget.Button[@resource-id=\"com.sot.bizup.debug:id/mbShortlist\"])[1]");

		// Click on Baat Kare button
		ClickId("com.sot.bizup.debug:id/mbPlaceOrder");
		Thread.sleep(3000);

		// Check for PreEnquiryVideo
		By preEnquiryVideo = By.id("com.sot.bizup.debug:id/mbButton");
		if (driver.findElements(preEnquiryVideo).size() > 0) {
			// If the PreEnquiryVideo exists, skip it
			Thread.sleep(8000);
			driver.findElement(preEnquiryVideo).click();
		}

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
		if (driver.findElements(preEnquiryVideo).size() > 0) {
			// If the PreEnquiryVideo exists, skip it
			Thread.sleep(8000);
			driver.findElement(preEnquiryVideo).click();
		}

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
		if (driver.findElements(preEnquiryVideo).size() > 0) {
			// If the PreEnquiryVideo exists, skip it
			Thread.sleep(8000);
			driver.findElement(preEnquiryVideo).click();
		}

		// Back to Chat
		Thread.sleep(3000);
		Back();
		Back();

		// Answer feedback
		ClickId("com.sot.bizup.debug:id/mbPositive");
		Thread.sleep(2000);
		ClickId("com.sot.bizup.debug:id/mbMessage");
		Thread.sleep(2000);
	}

	public void shortSellerEnquiry() throws InterruptedException {

		// Click on Baat Kare button
		ClickId("com.sot.bizup.debug:id/mbDealKare");
		Thread.sleep(3000);

		// Check for PreEnquiryVideo
		By preEnquiryVideo = By.id("com.sot.bizup.debug:id/mbButton");
		if (driver.findElements(preEnquiryVideo).size() > 0) {
			// If the PreEnquiryVideo exists, skip it
			Thread.sleep(8000);
			driver.findElement(preEnquiryVideo).click();
		}

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
		if (driver.findElements(preEnquiryVideo).size() > 0) {
			// If the PreEnquiryVideo exists, skip it
			Thread.sleep(8000);
			driver.findElement(preEnquiryVideo).click();
		}

		// Enter the text on the Chat box
		ShortChat2();

		// Back from Chat
		Back();

	}

	public void shortestEnquiry() throws InterruptedException {

		// Click on Baat Kare button
		ClickId("com.sot.bizup.debug:id/mbDealKare");
		Thread.sleep(1000);

		// Check for PreEnquiryVideo
		By preEnquiryVideo = By.id("com.sot.bizup.debug:id/mbButton");
		if (driver.findElements(preEnquiryVideo).size() > 0) {
			// If the PreEnquiryVideo exists, skip it
			Thread.sleep(8000);
			driver.findElement(preEnquiryVideo).click();
		}

		// Enter the text on the Chat box
		ShortChat1();

	}

	// Chat
	public void ShortChat1() throws InterruptedException {
		SendKey("//android.widget.EditText", "Hello");
		Thread.sleep(4000);
	}

	public void ShortChat2() throws InterruptedException {

		SendKey("//android.widget.EditText", "Catalog Dekhiye");
		Send();
		Thread.sleep(4000);
	}

	public void LongChat1() throws InterruptedException {
		SendKey("//android.widget.EditText", "Hello");
		Send();
		Thread.sleep(4000);

		SendKey("//android.widget.EditText", "Pant chahiye");
		Send();
		Thread.sleep(4000);

		SendKey("//android.widget.EditText", "aur dekhao");
		Send();
		Thread.sleep(4000);
	}

	public void LongChat2() throws InterruptedException {
		SendKey("//android.widget.EditText", "COD milega??");
		Send();
		Thread.sleep(4000);

		SendKey("//android.widget.EditText", "Delivery charge kitna lagega??");
		Send();
		Thread.sleep(4000);

		SendKey("//android.widget.EditText", "Delivery kab tak hogi??");
		Send();
		Thread.sleep(4000);
	}

	// CoachMark Check
	public void CoachMarkCheck(String CoachEle) {
		By coachMark = By.id(CoachEle);

		if (driver.findElements(coachMark).size() > 0) {
			// If the coachMark exists, click it
			driver.findElement(coachMark).click();
		}
	}

	// Check for PreEnquiryVideo
	public void PreEnquiryVideoCheck() throws InterruptedException {
		By preEnquiryVideo = By.id("com.sot.bizup.debug:id/mbButton");
		if (driver.findElements(preEnquiryVideo).size() > 0) {
			// If the PreEnquiryVideo exists, skip it
			Thread.sleep(8000);
			driver.findElement(preEnquiryVideo).click();
		}

	}

}
