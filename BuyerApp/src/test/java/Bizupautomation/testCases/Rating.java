package Bizupautomation.testCases;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Bizupautomation.testUtils.Base;
import buyer.pageObjects.Android.EnquiryTabObj;

public class Rating extends Base {

	@BeforeMethod(alwaysRun = true)
	public void preSetup() throws InterruptedException {
		Restart(driver);
	}

	@Test
	public void RatingFlow() throws InterruptedException {
		EnquiryTabObj enquiryPage = new EnquiryTabObj(driver);

		// Navigate to enquiry tab
		enquiryPage.EnquiryTab();

		// Rating
		enquiryPage.RatingCheck();

		// Navigate to save page
		enquiryPage.SavePage();

		// Rating
		enquiryPage.RatingCheck();

	}
}