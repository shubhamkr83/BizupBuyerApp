package buyer.pageObjects.Android;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class EnquiryTab extends SellerPage {

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
	@AndroidFindBy(id = "com.sot.bizup:id/dealsFragment")
	private WebElement mereSellerTab;

	@AndroidFindBy(id = "com.sot.bizup:id/ivDealsCoachmark")
	private By coachMark;

	@AndroidFindBy(id = "com.sot.bizup:id/mbReplyNow")
	private WebElement replyNow;

	@AndroidFindBy(id = "com.sot.bizup:id/mbButton")
	private By preEnquiryVideo;

	public void MereSellerTabClick() throws InterruptedException {
		mereSellerTab.click();
	}

	public void ReplyNowClick() throws InterruptedException {
		replyNow.click();
	}

	// ----------------------------------------------------------------------
	// ------------------- Claimming Flow -------------------
	// ----------------------------------------------------------------------
	@AndroidFindBy(id = "com.sot.bizup:id/mbClaim")
	private WebElement KB;

	@AndroidFindBy(id = "com.sot.bizup:id/mbInvoiceUpload")
	private WebElement upload;

	@AndroidFindBy(id = "com.google.android.documentsui:id/icon_thumb")
	private WebElement Invoice;

	@AndroidFindBy(id = "com.sot.bizup:id/mbClaimSuraksha")
	private WebElement claimButton;

	@AndroidFindBy(id = "com.sot.bizup:id/mbClaimWhatsapp")
	private WebElement askNowButton;

	@AndroidFindBy(id = "com.sot.bizup:id/mbPositive")
	private WebElement feedbackQue1;

	@AndroidFindBy(id = "com.sot.bizup:id/mbMessage")
	private WebElement feedbackQue2;

	public void KBClick() {
		KB.click();
	}

	public void UploadClick() {
		upload.click();
	}

	public void selectInvoice() {
		Invoice.click();
	}

	public void ClaimButtonClick() {
		claimButton.click();
	}

	public void AskNowButtonClick() throws InterruptedException {
		askNowButton.click();
		Thread.sleep(1500);
		driver.pressKey(new KeyEvent(AndroidKey.BACK));
		driver.pressKey(new KeyEvent(AndroidKey.BACK));
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

	@AndroidFindBy(id = "com.sot.bizup:id/mbAskNow")
	private WebElement askNow;

	public void ClaimTabClick() {
		claimTab.click();
	}

	public void AskNowClick() {
		askNow.click();
	}

}
