package buyer.pageObjects.Android;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class EnquiryTab {

	AndroidDriver driver;

	public EnquiryTab(AndroidDriver driver)

	{
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}

	// ----------------------------------------------------------------------
	// ------------------ Enquiry Tab Flow ------------------
	// ----------------------------------------------------------------------
	@AndroidFindBy(id = "com.sot.bizup:id/dealsFragment")
	private WebElement mereSellerTab;

	@AndroidFindBy(id = "com.sot.bizup:id/ivDealsCoachmark")
	private WebElement coachMark;

	@AndroidFindBy(id = "com.sot.bizup:id/mbReplyNow")
	private WebElement replyNow;

	public void MereSellerTabClick() {
		mereSellerTab.click();
	}

	public void CoachMark() {
		coachMark.click();
	}

	public void ReplyNowClick() {
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

	public void AskNowButtonClick() {
		askNowButton.click();
	}

	public void SelectFeedbackQue() {
		feedbackQue1.click();
		feedbackQue2.click();
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
