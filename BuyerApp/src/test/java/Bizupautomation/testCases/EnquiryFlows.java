package Bizupautomation.testCases;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Bizupautomation.testUtils.Base;
import buyer.pageObjects.Android.EnquiryTabObj;
import buyer.pageObjects.Android.HomeObj;
import buyer.pageObjects.Android.SearchObj;

public class EnquiryFlows extends Base {

	@BeforeMethod(alwaysRun = true)
	public void preSetup() throws InterruptedException {
		Restart(driver);
	}

	// ----------------------------------------------------------------------
	// ------------------ Video Enquiry Flow --------------------
	// ----------------------------------------------------------------------
	@Test(groups = ("Smoke"))
	public void EnquiryVideoFlow() throws InterruptedException {
		HomeObj home = new HomeObj(driver);

		// ---------------HomePage---------------
		// Product Filter
		home.ProductSelect("जीन्स");

		// Price Filter
		home.PriceSelect("300 तक");

		// Video Feed
		home.HomeSeller();

		// ------------Seller Page-----------------
		// Seller Enquiry
		home.SellerPage();

	}

	// ----------------------------------------------------------------------
	// ------------------ Search Enquiry Flow --------------------
	// ----------------------------------------------------------------------
	@Test
	public void SearchEnquiryFlow() throws InterruptedException {
		SearchObj search = new SearchObj(driver);

		// Click on the search icon
		search.SearchProduct("jacket");

		//Video Tab
		search.VideoTab();
		
		// Video Enquiry
		search.VideoEnquiry();
		
		//Sample Tab
		search.SampleTab();

		// Sample Enquiry
		search.SampleEnquiry(2);
		
		//Seller Tab
		search.SellerTab();

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
		enquiryTab.FeedbackQue();

		// Claim Tab
		enquiryTab.ClaimTabClick();

		// Order Feedback question
		enquiryTab.FeedbackQue();
	}

}
