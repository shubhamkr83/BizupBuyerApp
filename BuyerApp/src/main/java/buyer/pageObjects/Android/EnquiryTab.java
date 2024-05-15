package buyer.pageObjects.Android;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import buyer.utils.AndroidUtils;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class EnquiryTab extends AndroidUtils {

	AndroidDriver driver;

	public EnquiryTab(AndroidDriver driver)

	{
		super(driver);
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}

	// ----------------------------------------------------------------------
	// ------------------ Enquiry Tab Flow ------------------
	// ----------------------------------------------------------------------
	@AndroidFindBy(id = "com.sot.bizup.debug:id/dealsFragment")
	private WebElement mereSellerTab;

	@AndroidFindBy(id = "com.sot.bizup.debug:id/mbReplyNow")
	private WebElement replyNow;

	@AndroidFindBy(id = "com.sot.bizup.debug:id/mbButton")
	private By preEnquiryVideo;


	public void EnquiryTabEnquiry() throws InterruptedException {
		mereSellerTab.click();
		Thread.sleep(1000);
		CoachMarkCheck("com.sot.bizup.debug:id/ivDealsCoachmark");
		Thread.sleep(1000);
		replyNow.click();
		PreEnquiryVideoCheck();
		ShortChat1();
		Back();
	}

	// ----------------------------------------------------------------------
	// ------------------- Claimming Flow -------------------
	// ----------------------------------------------------------------------
	@AndroidFindBy(id = "com.sot.bizup.debug:id/mbClaim")
	private WebElement KB;

	@AndroidFindBy(id = "com.sot.bizup.debug:id/mbInvoiceUpload")
	private WebElement upload;

	@AndroidFindBy(id = "com.google.android.documentsui:id/icon_thumb")
	private WebElement Invoice;

	@AndroidFindBy(id = "com.sot.bizup.debug:id/mbClaimSuraksha")
	private WebElement claimButton;

	@AndroidFindBy(id = "com.sot.bizup.debug:id/mbClaimWhatsapp")
	private WebElement askNowButton;

	@AndroidFindBy(id = "com.sot.bizup.debug:id/mbPositive")
	private WebElement feedbackQue1;

	@AndroidFindBy(id = "com.sot.bizup.debug:id/mbMessage")
	private WebElement feedbackQue2;

	public void Claimming() throws InterruptedException {
		KB.click();
		upload.click();
		Invoice.click();
		claimButton.click();
		askNowButton.click();
		PreEnquiryVideoCheck();
		Thread.sleep(1500);
		Back();
		Back();
	}


	public void SelectFeedbackQue() {
		feedbackQue1.click();
		feedbackQue2.click();
		driver.pressKey(new KeyEvent(AndroidKey.BACK));
	}

	// ----------------------------------------------------------------------
	// ----------------- Claim Tab Flow --------------------
	// ----------------------------------------------------------------------
	@AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Claims\"]")
	private WebElement claimTab;

	@AndroidFindBy(id = "com.sot.bizup.debug:id/mbAskNow")
	private WebElement askNow;

	public void ClaimTabClick() throws InterruptedException {
		claimTab.click();
		askNow.click();
		PreEnquiryVideoCheck();
		Thread.sleep(1500);
		Back();
		Back();
	}

	

}
