package Bizupautomation.testCases;

import org.testng.annotations.Test;

import Bizupautomation.testUtils.Base;
import buyer.pageObjects.Android.HomeObj;
import buyer.pageObjects.Android.LoginObj;
import buyer.pageObjects.Android.VideoFeedObj;

public class SellerRecomm extends Base {

	@Test
	public void SellerRecommFlow() throws InterruptedException {
		HomeObj home = new HomeObj(driver);
		VideoFeedObj video = new VideoFeedObj(driver);
		LoginObj login = new LoginObj(driver);

		System.out.println("✨✨✨------------ Seller Recommendation Flow start -----------✨✨✨");

		// Clear App data
		login.clearAppData();

		// Launch App
		login.LaunchApp();

		// Enter Number
		login.MobileNumber("1223334444");

		// Product select
		home.ProductSelect("Baba suit");

		// Navigation to video feed
		home.HomeFeed();

		// Seller Recommendation Enquiry
		video.RecomProdEnq(3);

		// Clear Filters
		video.ClearFilters();

		// Product select
		video.ProductSelect("Shirts");

		// Seller Recommendation Enquiry
		video.RecomProdEnq(2);

		System.out.println("✨✨✨------------ Seller Recommendation Flow checked successfully -----------✨✨✨");

	}
}