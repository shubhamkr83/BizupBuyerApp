package Bizupautomation.testCases;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Bizupautomation.testUtils.Base;
import buyer.pageObjects.Android.AgentObj;
import buyer.pageObjects.Android.EnquiryTabObj;
import buyer.pageObjects.Android.SaveObj;
import buyer.pageObjects.Android.SellerPageObj;

public class AgentFlow extends Base {

	@BeforeMethod(alwaysRun = true)
	public void preSetup() throws InterruptedException {
		Restart(driver);
	}

	@Test
	public void AgentHome() throws InterruptedException {
		AgentObj agent = new AgentObj(driver);

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
	}
	
	@Test
	public void AgentSave() throws InterruptedException {
		SaveObj save = new SaveObj(driver);
		
		//save page navigation
		save.SavePage();

		// Agent scroll message check
		save.Agent();

		// Chat with agent
		save.Chat();
	}

	@Test
	public void AgentEnquiryTab() throws InterruptedException {
		EnquiryTabObj enquiry = new EnquiryTabObj(driver);

		//Enquiry tab navigation
		enquiry.EnquiryTab();
		
		// Agent scroll message check
		enquiry.Agent();

		// Chat with agent
		enquiry.Chat();
	}

	@Test
	public void AgentSellerPage() throws InterruptedException {
		SellerPageObj seller = new SellerPageObj(driver);
		
		//home to seller page
		seller.HomeSeller();

		// Agent scroll message check
		seller.Agent();

		// Chat with agent
		seller.Chat();
	}
}