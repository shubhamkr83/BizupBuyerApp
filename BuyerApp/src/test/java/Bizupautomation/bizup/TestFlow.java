package Bizupautomation.bizup;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import buyer.pageObjects.Android.Search;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;

public class TestFlow extends Base {

	@Test
	public void SearchEnquiryFlow() throws InterruptedException {
		
		Search search = new Search(driver);

		// Click on the search icon
		search.SearchIconClick();

		// Type text on the search icon
		search.SearchInputType("pant");
		driver.pressKey(new KeyEvent(AndroidKey.ENTER));

		// Check the Result
		String resultsSearch = driver.findElement(By.id("com.sot.bizup:id/mtTitle")).getText();
		Assert.assertEquals("Showing results for “pant”", resultsSearch);

		// Video Tab
		search.VideoTabClick();

		// Play video
		search.PlayVideo();

		// Video Enquiry button click
		search.VideoLikeButton();

		// Short Seller Enquiry
		shortSellerEnquiry();
		driver.pressKey(new KeyEvent(AndroidKey.BACK));
		driver.pressKey(new KeyEvent(AndroidKey.BACK));
		driver.pressKey(new KeyEvent(AndroidKey.BACK));

		// Sample Tab Change
		search.SampleTabClick();
	}
}
