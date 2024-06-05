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

	@Test(groups = ("Smoke"))
	public void VideoEnquiryFlow() throws InterruptedException {
		HomeObj home = new HomeObj(driver);

		System.out.println("✨✨✨------------ Video Enquiry Flow start -----------✨✨✨");

		// Product Filter
		home.ProductSelect("Jeans");

		// Price Filter
		home.PriceSelect("300 and below");

		// Home to seller page
		home.HomeSeller();

		// Catalog Enquiry
		home.CatalogEnq();

		// Video Enquiry
		home.VideoEnquiry();

		// Enter the text on the Chat box
		home.LongChat2();

		// WhatsApp enable check
		home.WhatsAppEnable();

		System.out.println("✨✨✨------------ Video Enquiry Flow working -----------✨✨✨");
	}

	@Test
	public void SearchEnquiryFlow() throws InterruptedException {
		SearchObj search = new SearchObj(driver);

		System.out.println("✨✨✨------------ Search Enquiry Flow start -----------✨✨✨");

		// Click on the search icon
		search.SearchProduct("Jackets");

		// Video Tab
		search.VideoTab();

		// Video Enquiry
		search.VideoTabEnq();

		// Sample Tab
		search.SampleTab();

		// Sample Enquiry
		search.SampleTabEnq();

		// Seller Tab
		search.SellerTab();

		// Seller Enquiry
		search.SellerEnquiry();

		System.out.println("✨✨✨------------ Search Enquiry Flow working -----------✨✨✨");

	}

	@Test
	public void EnquiryTabFlow() throws InterruptedException {
		EnquiryTabObj enquiryTab = new EnquiryTabObj(driver);

		System.out.println("✨✨✨------------ Enquiry Tab Enquiry Flow start -----------✨✨✨");

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

		System.out.println("✨✨✨------------ Enquiry Tab Enquiry Flow working -----------✨✨✨");
	}

}
