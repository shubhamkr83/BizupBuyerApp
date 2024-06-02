package Bizupautomation.testCases;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Bizupautomation.testUtils.Base;
import buyer.pageObjects.Android.HomeObj;

public class SellerJourney extends Base {

	@BeforeMethod(alwaysRun = true)
	public void preSetup() throws InterruptedException {
		Restart(driver);
	}

	@Test
	public void SellerJourneyFlow() throws InterruptedException {
		HomeObj homePage = new HomeObj(driver);
		
		System.out.println("✨✨✨------------ Seller Journey Flow start -----------✨✨✨");

		// Navigate from Home page to Seller page
		String seller = homePage.HomeSeller();

		// Check the seller present in the section and do Enquiry
		homePage.SellerPresentCheck(seller);

		// Check the seller remove from the section after Enquiry
		homePage.sellerRemoveCheck(seller);

		System.out.println("✨✨✨------------ Seller Journey Flow checked successfully -----------✨✨✨");
		
	}

}