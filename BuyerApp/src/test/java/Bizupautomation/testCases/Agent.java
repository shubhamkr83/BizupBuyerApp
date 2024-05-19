package Bizupautomation.testCases;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Bizupautomation.testUtils.Base;
import buyer.pageObjects.Android.AgentObj;

public class Agent extends Base {

	@BeforeMethod(alwaysRun = true)
	public void preSetup() throws InterruptedException {
		Restart(driver);
	}

	
	@Test
	public void AgentFlow() throws InterruptedException {
		AgentObj agent = new AgentObj(driver);

		// Agent scroll message check
		agent.AgentScroll();

		// Heading Check
		agent.Heading();

		// Catalog full view check
		agent.CatalogFullView();

		// Chat with agent
		agent.Chat();

		// Feedback Check
		agent.Feedback();

	}
}