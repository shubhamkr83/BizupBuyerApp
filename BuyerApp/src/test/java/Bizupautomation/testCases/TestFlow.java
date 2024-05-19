package Bizupautomation.testCases;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import Bizupautomation.testUtils.Base;
import buyer.pageObjects.Android.HomePageObj;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;

public class TestFlow extends Base {

	@Test
	public void Save() throws InterruptedException {
	
		HomePageObj homePage = new HomePageObj(driver);

		homePage.HomeToFeed();
		Thread.sleep(2000);

		// Go to seller page
		driver.findElement(By.id("com.sot.bizup.debug:id/mbGood")).click();
		
		//Get seller name
		String sellerName = driver.findElement(By.id("com.sot.bizup.debug:id/mtSellerName")).getText();
		
		//Save click
		driver.findElement(By.id("com.sot.bizup.debug:id/mbSave")).click();
		
		String save = driver.findElement(By.id("com.sot.bizup.debug:id/mbSave")).getText();
		Assert.assertEquals(save, "सेव है");
		
		
		driver.pressKey(new KeyEvent(AndroidKey.BACK));
		
		driver.findElement(By.id("com.sot.bizup.debug:id/ivSavedSeller")).isDisplayed();
		
		driver.pressKey(new KeyEvent(AndroidKey.BACK));
		
		homePage.Save();
		
		// Check the seller on save page
		driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text("+sellerName+"));")); 
		
		
       
	}

}
