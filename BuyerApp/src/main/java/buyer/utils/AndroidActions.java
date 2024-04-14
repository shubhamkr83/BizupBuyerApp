package buyer.utils;

import org.openqa.selenium.By;
import org.testng.Assert;

import buyer.pageObjects.Android.SellerPage;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;

public class AndroidActions {

	AndroidDriver driver;

	public AndroidActions(AndroidDriver driver)

	{
		this.driver = driver;
	}
	
	SellerPage sellerpage = new SellerPage(driver);

	public void Search() {
		// Check the serach
		// Click on the search icon
		// driver.findElement(By.id("com.sot.bizup:id/mbSearch")).click();
		driver.findElement(By.xpath("//android.widget.Button[@resource-id=\"com.sot.bizup:id/mbSearch\"]"))
				.click();

		// Type text on the search icon
		driver.findElement(By.id("com.sot.bizup:id/search_src_text")).sendKeys("shirt");
		driver.pressKey(new KeyEvent(AndroidKey.ENTER));

		String resultsSearch = driver.findElement(By.id("com.sot.bizup:id/mtTitle")).getText();
		Assert.assertEquals("Showing results for “shirt”", resultsSearch);
	}

	

}
