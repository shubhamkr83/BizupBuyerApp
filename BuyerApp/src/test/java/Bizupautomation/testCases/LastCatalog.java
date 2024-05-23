package Bizupautomation.testCases;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Bizupautomation.testUtils.Base;
import buyer.pageObjects.Android.SellerPageObj;

public class LastCatalog extends Base {

	@BeforeMethod(alwaysRun = true)
	public void preSetup() throws InterruptedException {
		Restart(driver);
	}

	@Test
	public void LastCatalogFlow() throws InterruptedException {
		SellerPageObj sellerPage = new SellerPageObj(driver);

		// Navgate to seller page
		sellerPage.HomeToSeller();

		// Select Catalog
		sellerPage.CatalogSelect();

		// Check the Toast message
		sellerPage.LastCatalogMsg();

	}
}