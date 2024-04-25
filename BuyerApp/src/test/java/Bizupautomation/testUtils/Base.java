package Bizupautomation.testUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URISyntaxException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class Base extends AppiumUtils {

	public AndroidDriver driver;
	public AppiumDriverLocalService service;
	public static String NodeJsMainPath = "C:\\\\Users\\\\lenovo\\\\AppData\\\\Roaming\\\\npm\\\\node_modules\\\\appium\\\\build\\\\lib\\\\main.js";
	
	@BeforeClass(alwaysRun=true)
	public void ConfigureAppium() throws URISyntaxException, IOException {
		// Run appium server automatically
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream(
				System.getProperty("user.dir") + "\\src\\main\\java\\buyer\\resources\\data.properties");
		prop.load(fis);

		String ipAddress = prop.getProperty("ipAddress");
		String port = prop.getProperty("port");
		String Device1 = prop.getProperty("Device1");

		service = new AppiumServiceBuilder().withAppiumJS(new File(NodeJsMainPath)).withIPAddress(ipAddress)
				.usingPort(Integer.parseInt(port)).build();

		// Create capablities
		UiAutomator2Options options = new UiAutomator2Options();
		options.setDeviceName(Device1);
		// options.setApp("DemoApp");

		driver = new AndroidDriver(service.getUrl(), options);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

	}

	@AfterClass(alwaysRun=true)
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
