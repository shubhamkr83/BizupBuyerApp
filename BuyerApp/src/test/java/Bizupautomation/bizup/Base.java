package Bizupautomation.bizup;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class Base {

	public AndroidDriver driver;
	public AppiumDriverLocalService service;

	public static String NodeJsMainPath = "C:\\\\Users\\\\lenovo\\\\AppData\\\\Roaming\\\\npm\\\\node_modules\\\\appium\\\\build\\\\lib\\\\main.js";
	public static String ServerAddress = "127.0.0.1";
	public static String ServerURL = "http://127.0.0.1:4723";
	public static Integer Port = 4723;
	public static String Device1 = "samsung SM-E146B";
	public static String Device2 = "Xiaomi Redmi Y1";
	public static String DemoApp = "C:\\\\Users\\\\lenovo\\\\eclipse-workspace\\\\bizup\\\\src\\\\test\\\\java\\\\resources\\\\Bizup-2.14.4.apk";

	@BeforeClass
	public void ConfigureAppium() throws MalformedURLException, URISyntaxException {
		// Run appium server automatically
		service = new AppiumServiceBuilder().withAppiumJS(new File(NodeJsMainPath)).withIPAddress(ServerAddress)
				.usingPort(Port).build();

		// Create capablities
		UiAutomator2Options options = new UiAutomator2Options();
		options.setDeviceName(Device1);
		// options.setApp("DemoApp");

		driver = new AndroidDriver(new URI(ServerURL).toURL(), options);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

	}

	@AfterClass
	public void TearDown() {
		driver.quit();
		service.stop();
	}

	public void HomeWait() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.attributeContains(driver.findElement(By.id("com.sot.bizup:id/mtTopAll")), "text",
				"All"));
	}

	public void SellerEnquiry() throws InterruptedException {
		// Coachmark
		driver.findElement(By.id("com.sot.bizup:id/ivDealsCoachmarkText")).click();

		// ------Catalog Enquiry------

		// Go to Catalog Tab
		driver.findElement(By.id("com.sot.bizup:id/mtSellerCatalog")).click();

		// Selecting Catalog
		driver.findElement(By.xpath("(//android.widget.Button[@resource-id=\"com.sot.bizup:id/mbShortlist\"])[1]"))
				.click();
		// driver.findElement(By.xpath("(//android.widget.Button[@resource-id=\"com.sot.bizup:id/mbShortlist\"])[2]")).click();
		// driver.findElement(By.xpath("(//android.widget.Button[@resource-id=\"com.sot.bizup:id/mbShortlist\"])[5]")).click();

		// Click on Baat Kare button
		driver.findElement(By.id("com.sot.bizup:id/mbPlaceOrder")).click();
		Thread.sleep(2000);
		
		/*
		 * ///Answer Enquiry activation question
		 * //driver.findElement(By.id("com.sot.bizup:id/mbPositive")).click();
		 */
		
		Thread.sleep(10000);

		// Skip Enquiry video
		driver.findElement(By.id("com.sot.bizup:id/mbButton")).click();
		Thread.sleep(7000);

		// Enter the text on the Chat box
		driver.findElement(By.xpath("//android.widget.EditText")).sendKeys("Hello");
		driver.findElement(By.xpath("//android.widget.Button[@text=\"\"]")).click();
		Thread.sleep(4000);

		driver.findElement(By.xpath("//android.widget.EditText")).sendKeys("Pant chahiye");
		driver.findElement(By.xpath("//android.widget.Button[@text=\"\"]")).click();
		Thread.sleep(4000);

		driver.findElement(By.xpath("//android.widget.EditText")).sendKeys("aur dekhao");
		driver.findElement(By.xpath("//android.widget.Button[@text=\"\"]")).click();
		Thread.sleep(4000);

		driver.pressKey(new KeyEvent(AndroidKey.BACK));

		// ------Video Enquiry------
		// Search Video Tab Change
		driver.findElement(By.id("com.sot.bizup:id/mtSellerVideos")).click();
		driver.findElement(By.id("com.sot.bizup:id/mtSellerVideos")).click();

		// Click on the video
		driver.findElement(By.xpath("(//android.widget.ImageView[@resource-id=\"com.sot.bizup:id/ivThumbnail\"])[1]"))
				.click();

		// Seller video baat kare button click
		driver.findElement(By.id("com.sot.bizup:id/mbChat")).click();

		// Enter the text on the Chat box
		driver.findElement(By.xpath("//android.widget.EditText")).sendKeys("COD milega??");
		driver.findElement(By.xpath("//android.widget.Button[@text=\"\"]")).click();
		Thread.sleep(4000);

		driver.findElement(By.xpath("//android.widget.EditText")).sendKeys("Delivery charge kitna lagega??");
		driver.findElement(By.xpath("//android.widget.Button[@text=\"\"]")).click();
		Thread.sleep(4000);

		driver.findElement(By.xpath("//android.widget.EditText")).sendKeys("Delivery kab tak hogi??");
		driver.findElement(By.xpath("//android.widget.Button[@text=\"\"]")).click();
		Thread.sleep(4000);

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

		Thread.sleep(10000);

		// Skip Enquiry video
		driver.findElement(By.id("com.sot.bizup:id/mbButton")).click();
		Thread.sleep(4000);

		// Send Kacha bill
		// driver.findElement(By.id("com.whatsapp:id/send")).click();
		// Thread.sleep(2000);

		// Back to Chat
		driver.pressKey(new KeyEvent(AndroidKey.BACK));
		driver.pressKey(new KeyEvent(AndroidKey.BACK));

		// Answer feedback
		driver.findElement(By.id("com.sot.bizup:id/mbPositive")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("com.sot.bizup:id/mbMessage")).click();
		Thread.sleep(2000);
	}

	public void shortSellerEnquiry() throws InterruptedException {
		// Click on Baat Kare button
		driver.findElement(By.id("com.sot.bizup:id/mbPlaceOrder")).click();
		Thread.sleep(3000);

		// Enter the text on the Chat box
		driver.findElement(By.xpath("//android.widget.EditText")).sendKeys("Hello");
		driver.findElement(By.xpath("//android.widget.Button[@text=\"\"]")).click();
		Thread.sleep(4000);

		// Back from Chat
		driver.pressKey(new KeyEvent(AndroidKey.BACK));
		Thread.sleep(2000);

		// Video Tab Change
		driver.findElement(By.id("com.sot.bizup:id/mtSellerVideos")).click();
		driver.findElement(By.id("com.sot.bizup:id/mtSellerVideos")).click();
		// Thread.sleep(2000);

		// Play video
		driver.findElement(By.xpath("(//android.widget.ImageView[@resource-id=\"com.sot.bizup:id/ivThumbnail\"])[1]"))
				.click();

		// Seller video baat kare button click
		driver.findElement(By.id("com.sot.bizup:id/mbChat")).click();
		Thread.sleep(3000);

		// Enter the text on the Chat box
		driver.findElement(By.xpath("//android.widget.EditText")).sendKeys("Catalog Dekhiye");
		driver.findElement(By.xpath("//android.widget.Button[@text=\"\"]")).click();
		Thread.sleep(4000);

		// Back from Chat
		driver.pressKey(new KeyEvent(AndroidKey.BACK));
	}

}
