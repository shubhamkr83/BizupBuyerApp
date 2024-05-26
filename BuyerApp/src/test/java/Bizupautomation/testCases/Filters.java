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

		// ---------- Product reset message check
		home.ClearFilters();

		home.ProductSelect("ब्लेजर्स");

		home.ResetMsg();

		// ---------- Price reset mesage check
		home.ProductSelect("बाबा सूटस");

		home.CitySelect(2);

		home.PriceSelect("400 से ज़ादा");

		home.ResetMsg();

		// ----------- City reset message check
		home.ClearFilters();

		home.ProductSelect("साड़ी");

		home.CitySelect(2);

		home.ResetMsg();

	}

	@Test
	public void VideoReset() throws InterruptedException {
		VideoFeedObj video = new VideoFeedObj(driver);

		video.HomeFeed();

		// ---------- Product reset message check
		video.ClearFilters();

		video.ProductSelect("दस्ताने");

		video.ResetMsg();

		// ---------- Price reset mesage check
		video.ProductSelect("फ़राक");

		video.CitySelect(2);

		video.PriceSelect("400 से ज़ादा");

		video.ResetMsg();

		// ----------- City reset message check
		video.ClearFilters();

		video.ProductSelect("साड़ी");

		video.CitySelect(2);

		video.ResetMsg();

	}

}