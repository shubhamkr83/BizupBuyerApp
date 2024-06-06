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

		String seller = homePage.HomeSeller();

		homePage.SellerPresentCheck(seller);

		homePage.sellerRemoveCheck(seller);

		System.out.println("✨✨✨------------ Seller Journey Flow checked successfully -----------✨✨✨");

	}

}