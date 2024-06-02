package Bizupautomation.testCases;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Bizupautomation.testUtils.Base;
import buyer.pageObjects.Android.SearchObj;
import buyer.pageObjects.Android.SellerPageObj;

public class Super extends Base {

	@BeforeMethod(alwaysRun = true)
	public void preSetup() throws InterruptedException {
		Restart(driver);
	}

	@Test
	public void SuperSeller() throws InterruptedException {
		SellerPageObj sellerPage = new SellerPageObj(driver);
		SearchObj search = new SearchObj(driver);
		
		System.out.println("✨✨✨------------ Super Seller Checking -----------✨✨✨");

		// Click on the search icon
		search.SearchProduct("Renuka Garment");

		// Click on the Seller in seller page
		search.SellerCard();

		// Go to the seller page
		sellerPage.SuperSeller("Renuka Garment");
		
		System.out.println("✨✨✨------------ Super Seller Checked successfully -----------✨✨✨");

	}
	
	
}