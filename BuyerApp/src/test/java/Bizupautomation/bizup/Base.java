package Bizupautomation.bizup;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import buyer.utils.AndroidActions;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class Base extends AndroidActions {

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


}
