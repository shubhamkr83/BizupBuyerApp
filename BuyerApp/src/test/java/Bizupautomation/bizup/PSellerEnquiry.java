package Bizupautomation.bizup;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.By;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Bizupautomation.testUtils.Base;
import buyer.pageObjects.Android.Search;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;

public class PSellerEnquiry extends Base {

	@BeforeMethod
	public void preSetup() throws InterruptedException {
		// Launch the app
		driver.activateApp("com.sot.bizup");
		Thread.sleep(2000);
	}

	@Test(dataProvider = "getData")
	public void PSellerFlow(HashMap<String, String> input) throws InterruptedException {

		Search search = new Search(driver);

		// Click on the search icon
		Thread.sleep(2000);
		search.SearchIconClick();

		// Type text on the search icon
		search.SearchInputType(input.get("name"));
		driver.pressKey(new KeyEvent(AndroidKey.ENTER));

		// Seller Tab Change
		search.SearchSellerTab();

		// Get seller
		driver.findElement(By.xpath("//android.widget.TextView[@resource-id=\"com.sot.bizup:id/mtName\" and @text='"
				+ input.get("name") + "']")).click();

		// Seller Enquiry
		search.shortestEnquiry();

	}

	@DataProvider
	public Object[][] getData() throws IOException {

		List<HashMap<String, String>> data = getJsonData(
				System.getProperty("user.dir") + "\\src\\test\\java\\Bizupautomation\\testData\\seller.json");
		return new Object[][] { { data.get(0) }, { data.get(1) } };
	}

}
