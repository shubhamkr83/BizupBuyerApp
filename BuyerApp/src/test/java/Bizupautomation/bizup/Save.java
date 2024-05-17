package Bizupautomation.bizup;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Bizupautomation.testUtils.Base;
import buyer.pageObjects.Android.HomePageObj;
import buyer.pageObjects.Android.SaveObj;

public class Save extends Base {

	@BeforeMethod(alwaysRun = true)
	public void preSetup() throws InterruptedException {
		Terminate(driver);
		Launch(driver);
	}

	@Test
	public void SaveFlow() throws InterruptedException {
		SaveObj save = new SaveObj(driver);
		HomePageObj homePage = new HomePageObj(driver);

		// Home page to Video Feed
		homePage.HomeToFeed();

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
	public void DirectionAndSample() {
		SaveObj save = new SaveObj(driver);

		// Navigate to save page
		save.SavePage();
		
		// Check the direction
		save.Direction();
		
		//Sample Dekhe Check
		save.SampleDekhe();

	}


}
