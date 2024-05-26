package Bizupautomation.testCases;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Bizupautomation.testUtils.Base;
import buyer.pageObjects.Android.SearchObj;

public class SellerRecomm extends Base {

	@BeforeMethod(alwaysRun = true)
	public void preSetup() throws InterruptedException {
		Restart(driver);
	}

	@Test
	public void SellerRecommFlow() throws InterruptedException {
		SearchObj search = new SearchObj(driver);

		// Click on the search icon
		search.SearchProduct("Saree");

		// Sample Tab select
		search.SampleTab();

		// First product enquiry
		search.FirstProduct();

		// Second product enquiry
		search.SecondProduct();

		Restart(driver);

		// Reach to Seller recommendations section
		search.SellerRec();

	}
}