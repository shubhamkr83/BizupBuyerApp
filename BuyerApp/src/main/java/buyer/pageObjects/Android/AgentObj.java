package buyer.pageObjects.Android;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import buyer.utils.AndroidUtils;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class AgentObj extends AndroidUtils {

	AndroidDriver driver;

	public AgentObj(AndroidDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}

	@AndroidFindBy(id = "com.sot.bizup.debug:id/fab")
	private WebElement agent;

	@AndroidFindBy(id = "com.sot.bizup.debug:id/mcFab")
	private WebElement messageAgent;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text=\"सुरेश सिंह\"]")
	private WebElement agentName;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text=\"आपका बिज़अप एजेंट (24x7)\"]")
	private WebElement agentHeadline;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text=\"View All\"]")
	private WebElement catalogFullView;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text=\"\"]")
	private WebElement fullViewClose;

	@AndroidFindBy(id = "com.sot.bizup.debug:id/mtSellerQuestion")
	private WebElement feedbackMsg;

	@AndroidFindBy(id = "com.sot.bizup.debug:id/mbYes")
	private WebElement feedbackYes;

	@AndroidFindBy(id = "com.sot.bizup.debug:id/mtSellerQuestion")
	private WebElement feedbackYesMsg;

	@AndroidFindBy(id = "com.sot.bizup.debug:id/mbNo")
	private WebElement feedbackNo;

	@AndroidFindBy(id = "com.sot.bizup.debug:id/mtSellerQuestion")
	private WebElement feedbackNoMsg;

	@AndroidFindBy(id = "com.sot.bizup.debug:id/mbFeedback")
	private WebElement feedbackClose;

	public void Agent() {
		try {
			if (agent.isDisplayed()) {
				agent.click();
				System.out.println("Agent Clicked ✔");
			}
		} catch (Exception e) {
			Assert.fail("Agent failed " + e);
		}

	}

	public void Heading() {
		agentName.isDisplayed();
		agentHeadline.isDisplayed();
		System.out.println("Agent Heading Checked ✔");
	}

	public void CatalogFullView() throws InterruptedException {
		try {
			if (agentName.isDisplayed()) {
				ShortChat2();
				Send();
				Wait(catalogFullView, "View All");
				catalogFullView.click();
				fullViewClose.click();
				System.out.println("Agent Catalog Full View Checked ✔");
			}
		} catch (Exception e) {
			Assert.fail("Agent Catalog Full View failed " + e);
		}
	}

	public void AgentChat() {
		try {
			LongChat2();
			driver.hideKeyboard();
			System.out.println("Agent Chat Sucessfull ✔");
		} catch (Exception e) {
			Assert.fail("Agent Chat error" + e);
		}
	}

	public void FeedbackPosMessage() {

		Back();
		if (feedbackMsg.isDisplayed()) {
			String Feedback = feedbackMsg.getText();
			assertEquals(Feedback, "How was your experience talking to Suresh Singh?");

			feedbackYes.click();

			String PositiveMsg = feedbackYesMsg.getText();
			assertEquals(PositiveMsg, "We are glad that your experience was good.");

			feedbackClose.click();

			System.out.println("Agent Positive feedback Checked ✔");
		} else {
			Assert.fail("Agent Positive feedback failed ❌");
		}

	}

	public void FeedbackNegMessage() throws InterruptedException {

		RestartApp();
		agent.click();
		Wait(catalogFullView, "View All");
		Back();

		if (feedbackMsg.isDisplayed()) {
			String Feedback = feedbackMsg.getText();
			assertEquals(Feedback, "How was your experience talking to Suresh Singh?");

			feedbackNo.click();

			String NegativeMsg = feedbackNoMsg.getText();
			assertEquals(NegativeMsg, "We are sorry that your experience was not good.");

			feedbackClose.click();

			System.out.println("Agent Negative feedback Checked ✔");

		} else {
			Assert.fail("Agent Negative feedback failed ❌");
		}

	}

	public void Feedback() throws InterruptedException {
		FeedbackPosMessage();
		FeedbackNegMessage();
	}

}
