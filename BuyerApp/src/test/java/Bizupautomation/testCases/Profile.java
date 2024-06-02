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
		
		System.out.println("✨✨✨------------ Profile Flow start -----------✨✨✨");
		
		// Navgate to profile page
		profilePage.Profile();
		
		// Edit profile
		profilePage.EditProfile("Demo Test", "Test Seller", "Delhi");	
		
		// Refer
		profilePage.Refer();
		
		// Setting
		profilePage.Setting();
		
		// My Video
		profilePage.MyVideo();
		
		System.out.println("✨✨✨------------ Profile Flow checked ✅ -----------✨✨✨");
		
	}
}