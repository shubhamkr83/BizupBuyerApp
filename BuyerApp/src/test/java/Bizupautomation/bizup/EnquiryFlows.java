package Bizupautomation.bizup;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Bizupautomation.testUtils.Base;
import buyer.pageObjects.Android.EnquiryTab;
import buyer.pageObjects.Android.HomePage;
import buyer.pageObjects.Android.Search;

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
		HomePage homePage = new HomePage(driver);
		// ---------------HomePage---------------
		// Product Filter
		homePage.ProductSelect(3);

		// Price Filter
		homePage.PriceSelect();

		// Video Feed
		homePage.HomeFeedPlay(1);

		// ------------Seller Page-----------------
		// Seller Enquiry
		homePage.SellerPage();

	}

	// ----------------------------------------------------------------------
	// ------------------ Search Enquiry Flow --------------------
	// ----------------------------------------------------------------------
	@Test
	public void SearchEnquiryFlow() throws InterruptedException {
		Search search = new Search(driver);
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
		EnquiryTab enquiryTab = new EnquiryTab(driver);
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
