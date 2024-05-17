package Bizupautomation.bizup;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Bizupautomation.testUtils.Base;
import buyer.pageObjects.Android.EnquiryTabObj;
import buyer.pageObjects.Android.HomePageObj;
import buyer.pageObjects.Android.SearchObj;

public class EnquiryFlows extends Base {

	@BeforeMethod(alwaysRun = true)
	public void preSetup() throws InterruptedException {
		Terminate(driver);
		Launch(driver);
	}

	// ----------------------------------------------------------------------
	// ------------------ Video Enquiry Flow --------------------
	// ----------------------------------------------------------------------
	@Test(groups = ("Smoke"))
	public void EnquiryVideoFlow() throws InterruptedException {
		HomePageObj homePage = new HomePageObj(driver);
		// ---------------HomePage---------------
		// Product Filter
		homePage.ProductSelect(3);

		// Price Filter
		homePage.PriceSelect();

		// Video Feed
		homePage.HomeToFeed();

		// ------------Seller Page-----------------
		// Seller Enquiry
		homePage.SellerPage();

	}

	// ----------------------------------------------------------------------
	// ------------------ Search Enquiry Flow --------------------
	// ----------------------------------------------------------------------
	@Test
	public void SearchEnquiryFlow() throws InterruptedException {
		SearchObj search = new SearchObj(driver);
		// Click on the search icon
		search.SearchProduct("jacket");

		// Video Enquiry
		search.VideoEnquiry();

		// Sample Enquiry
		search.SampleEnquiry();

		// Seller Enquiry
		search.SellerEnquiry();

	}

	// ----------------------------------------------------------------------
	// ------------------ Enquiry Tab Flow ------------------
	// ----------------------------------------------------------------------
	@Test
	public void EnquiryTabFlow() throws InterruptedException {
		EnquiryTabObj enquiryTab = new EnquiryTabObj(driver);
		// Enquiry Tab Enquiry
		enquiryTab.EnquiryTabEnquiry();

		// Claimming
		enquiryTab.Claimming();

		// Order Feedback question
		enquiryTab.SelectFeedbackQue();

		// Claim Tab
		enquiryTab.ClaimTabClick();

		// Order Feedback question
		enquiryTab.SelectFeedbackQue();
	}

}
