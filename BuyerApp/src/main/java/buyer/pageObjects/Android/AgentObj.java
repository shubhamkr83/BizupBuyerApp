package buyer.pageObjects.Android;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

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

	public void AgentScroll() {
		agent.click();
		System.out.println("Agent Clicked ✔");
	}

	public void Heading() {
		agentName.isDisplayed();
		agentHeadline.isDisplayed();
		System.out.println("Agent Heading Checked ✔");
	}

	public void CatalogFullView() throws InterruptedException {
		ShortChat2();
		catalogFullView.click();
		Scroll();
		fullViewClose.click();
		System.out.println("Agent Catalog Full View Checked ✔");
	}

	public void Chat() throws InterruptedException {
		LongChat1();
		LongChat2();
		driver.hideKeyboard();
		System.out.println("Agent Chat Sucessfull ✔");
	}

	public void FeedbackPosMessage() {

		Back();

		String Feedback = feedbackMsg.getText();
		assertEquals(Feedback, "आपका सुरेश सिंह से बात करने का अनुभव कैसा रहा ?");

		feedbackYes.click();

		String PositiveMsg = feedbackYesMsg.getText();
		assertEquals(PositiveMsg, "हमे खुशी है की आपका अनुभव अच्छा रहा .");

		feedbackClose.click();
		
		System.out.println("Agent Positive feedback Checked ✔");

	}

	public void FeedbackNegMessage() throws InterruptedException {

		RestartApp();
		agent.click();
		Back();
		
		String Feedback = feedbackMsg.getText();
		assertEquals(Feedback, "आपका सुरेश सिंह से बात करने का अनुभव कैसा रहा ?");

		feedbackNo.click();

		String NegativeMsg = feedbackNoMsg.getText();
		assertEquals(NegativeMsg, "हमे खेद है की आपका अनुभव अच्छा नहीं रहा ");

		feedbackClose.click();
		
		System.out.println("Agent Negative feedback Checked ✔");

	}

	public void Feedback() throws InterruptedException {
		FeedbackPosMessage();
		FeedbackNegMessage();
	}

}
