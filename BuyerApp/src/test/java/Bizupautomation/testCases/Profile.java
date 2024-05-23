package Bizupautomation.testCases;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Bizupautomation.testUtils.Base;
import buyer.pageObjects.Android.ProfileObj;

public class Profile extends Base {

	@BeforeMethod(alwaysRun = true)
	public void preSetup() throws InterruptedException {
		Restart(driver);
	}

	@Test
	public void ProfileFlow() throws InterruptedException {
		ProfileObj profilePage = new ProfileObj(driver); 
		
		profilePage.Profile();
		
		profilePage.EditProfile("Demo Test", "Test Seller", "Delhi");	
		
		profilePage.Refer();
		
		profilePage.Setting();
		
		profilePage.MyVideo();
		
		
		
	}
}