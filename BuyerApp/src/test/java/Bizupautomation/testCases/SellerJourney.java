package Bizupautomation.testCases;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Bizupautomation.testUtils.Base;
import buyer.pageObjects.Android.HomePageObj;

public class SellerJourney extends Base {

	@BeforeMethod(alwaysRun = true)
	public void preSetup() throws InterruptedException {
		Restart(driver);
	}

	@Test
	public void SellerJourneyFlow() throws InterruptedException {
		HomePageObj homePage = new HomePageObj(driver);

		// Navigate from Home page to Seller page
		String seller = homePage.HomeSeller();

		// Check the seller present in the section and do Enquiry
		homePage.SellerPresentCheck(seller);

		// Check the seller remove from the section after Enquiry
		homePage.sellerRemoveCheck(seller);

	}

}