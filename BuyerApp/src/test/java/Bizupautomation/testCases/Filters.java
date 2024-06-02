package Bizupautomation.testCases;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Bizupautomation.testUtils.Base;
import buyer.pageObjects.Android.HomeObj;
import buyer.pageObjects.Android.VideoFeedObj;

public class Filters extends Base {

	@BeforeMethod(alwaysRun = true)
	public void preSetup() throws InterruptedException {
		Restart(driver);
	}

	@Test
	public void HomeReset() throws InterruptedException {
		HomeObj home = new HomeObj(driver);
		
		System.out.println("✨✨✨------- Home Reset Flow start ------✨✨✨");

		// ---------- Product reset message check
		home.ClearFilters();
		
		home.GenderFilter("Men");

		home.ProductSelect("Saree");

		home.ResetMsg();

		// ---------- Price reset mesage check
		home.ProductSelect("Baba suit");

		home.CitySelect(2);

		home.PriceSelect("400 and above");

		home.ResetMsg();

		// ----------- City reset message check
		home.ClearFilters();

		home.ProductSelect("Saree");

		home.CitySelect(2);

		home.ResetMsg();

		System.out.println("✨✨✨-------- Home Reset Flow checked ✅ ------✨✨✨");
	}

	@Test
	public void VideoReset() throws InterruptedException {
		VideoFeedObj video = new VideoFeedObj(driver);

		System.out.println("✨✨✨------- Video Reset Flow start -------✨✨✨");
		
		video.HomeFeed();

		// ---------- Product reset message check
		video.ClearFilters();
		
		video.PriceSelect("100 and below");

		video.ProductSelect("Men suits");

		video.ResetMsg();

		// ---------- Price reset mesage check
		video.ClearFilters();
		
		video.ProductSelect("Lehenga ");

		video.CitySelect(2);

		video.PriceSelect("100 and below");

		video.ResetMsg();

		// ----------- City reset message check
		video.ClearFilters();

		video.ProductSelect("Saree");

		video.CitySelect(2);

		video.ResetMsg();
		
		System.out.println("✨✨✨------- Video Reset Flow checked ✅ ------✨✨✨");

	}

}