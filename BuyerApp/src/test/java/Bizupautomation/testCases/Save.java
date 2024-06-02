package Bizupautomation.testCases;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Bizupautomation.testUtils.Base;
import buyer.pageObjects.Android.HomeObj;
import buyer.pageObjects.Android.SaveObj;

public class Save extends Base {

	@BeforeMethod(alwaysRun = true)
	public void preSetup() throws InterruptedException {
		Restart(driver);
	}

	@Test
	public void SaveFlow() throws InterruptedException {
		SaveObj save = new SaveObj(driver);
		HomeObj homePage = new HomeObj(driver);

		System.out.println("✨✨✨------------ Save Flow start -----------✨✨✨");

		// Home page to Video Feed
		homePage.HomeFeed();

		// If seller is not save then go to seller page and Save the seller
		String seller = save.SaveSeller();

		// Save Check on video
		save.VideoSaveCheck();

		// Navigate to save page
		save.SavePage();

		// Check the seller name on the save page
		save.SaveCheck(seller);

	}

	@Test
	public void DirectionAndSample() throws InterruptedException {
		SaveObj save = new SaveObj(driver);

		System.out.println("✨✨✨-------- Direction And Sample Flow starts ---------✨✨✨");

		// Navigate to save page
		save.SavePage();

		// Check the direction
		save.Direction();

		// Sample Dekhe Check
		save.SampleDekhe();

		System.out.println("✨✨✨------------ Save Flow working -----------✨✨✨");

	}

}
