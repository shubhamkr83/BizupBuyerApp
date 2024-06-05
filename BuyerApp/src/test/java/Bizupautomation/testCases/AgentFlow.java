package Bizupautomation.testCases;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Bizupautomation.testUtils.Base;
import buyer.pageObjects.Android.AgentObj;
import buyer.pageObjects.Android.EnquiryTabObj;
import buyer.pageObjects.Android.SaveObj;

public class AgentFlow extends Base {

	@BeforeMethod(alwaysRun = true)
	public void preSetup() throws InterruptedException {
		Restart(driver);
	}

	@Test
	public void HomeAgent() throws InterruptedException {
		AgentObj agent = new AgentObj(driver);

		System.out.println("✨✨✨------------ Home Agent start -----------✨✨✨");

		// Agent scroll message check
		agent.Agent();

		// Heading Check
		agent.Heading();

		// Catalog full view check
		agent.CatalogFullView();

		// Chat with agent
		agent.AgentChat();

		// Feedback Check
		agent.Feedback();

		System.out.println("✨✨✨------------Home Agent checked ✅-----------✨✨✨");
	}

	@Test
	public void EnquiryTabAgent() throws InterruptedException {
		EnquiryTabObj enquiry = new EnquiryTabObj(driver);

		System.out.println("✨✨✨------------ Enquiry Tab Agent start -----------✨✨✨");

		// Enquiry tab navigation
		enquiry.EnquiryTab();

		// Agent scroll message check
		enquiry.Agent();

		// Chat with agent
		enquiry.Chat();

		System.out.println("✨✨✨------------Enquiry Tab Agent checked ✅-----------✨✨✨");
	}

	@Test
	public void SaveAgent() throws InterruptedException {
		SaveObj save = new SaveObj(driver);

		System.out.println("✨✨✨------------Save Agent Start -----------✨✨✨");

		// save page navigation
		save.SavePage();

		// Agent scroll message check
		save.Agent();

		// Chat with agent
		save.Chat();

		System.out.println("✨✨✨------------Save Agent checked ✅-----------✨✨✨");
	}

	// @Test
//	public void SellerPageAgent() throws InterruptedException {
//		SellerPageObj seller = new SellerPageObj(driver);
//		
//		System.out.println("✨✨✨------------ Seller Page Agent start -----------✨✨✨");
//		
//		//home to seller page
//		seller.HomeSeller();
//
//		// Agent scroll message check
//		seller.Agent();
//
//		// Chat with agent
//		seller.Chat();
//		
//		System.out.println("✨✨✨------------Seller Page Agent checked ✅ -----------✨✨✨");
//		
//	}
}