package buyer.pageObjects.Android;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import buyer.utils.AndroidUtils;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class EnquiryTabObj extends AndroidUtils {

	AndroidDriver driver;

	public EnquiryTabObj(AndroidDriver driver)

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

	// ----------------------------------------------------------------------
	// ----------------- Claim Tab Flow --------------------
	// ----------------------------------------------------------------------
	@AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Claims\"]")
	private WebElement claimTab;

	@AndroidFindBy(id = "com.sot.bizup.debug:id/mbAskNow")
	private WebElement askNow;

	public void EnquiryTabEnquiry() throws InterruptedException {
		try {
			if (mereSellerTab.isDisplayed()) {
				mereSellerTab.click();
				Wait(claimTab, "Claims");
				CoachMarkCheck("com.sot.bizup.debug:id/ivDealsCoachmark");
				Wait(KB, "कच्चा बिल भेजें");
				replyNow.click();
				PreEnquiryVideoCheck();
				ShortChat1();
				Back();

				System.out.println("Enquiry Tab Enquires working ✔");
			}
		} catch (Exception e) {
			Assert.fail("Enquiry Tab Enquires error" + e);
		}
	}

	// ----------------------------------------------------------------------
	// ------------------- Claimming Flow -------------------
	// ----------------------------------------------------------------------

	public void Claimming() throws InterruptedException {
		try {
			if (KB.isDisplayed()) {
				KB.click();
				upload.click();
				ClickXp("//android.widget.Button[@text=\"Images\"]");
				// ClickXp("(//android.widget.ImageView[@resource-id=\"com.google.android.documentsui:id/icon_thumb\"])[1]");
				Invoice.click();
				claimButton.click();
				askNowButton.click();
				PreEnquiryVideoCheck();
				Thread.sleep(1500);
				Back();
				Back();

				System.out.println("Kacha bill claim working ✔");
			}
		} catch (Exception e) {
			Assert.fail("Kacha bill claim error" + e);
		}

	}

	public void SelectFeedbackQue() {
		try {
			if (feedbackQue1.isDisplayed()) {
				feedbackQue1.click();
				feedbackQue2.click();
				driver.pressKey(new KeyEvent(AndroidKey.BACK));
				System.out.println("Feedback Question working ✔");
			}
		} catch (Exception e) {
			Assert.fail("Feedback Question error" + e);
		}

	}

	// ----------------------------------------------------------------------
	// ----------------- Claim Tab Flow --------------------
	// ----------------------------------------------------------------------

	public void ClaimTabClick() throws InterruptedException {
		try {
			if (claimTab.isDisplayed()) {
				claimTab.click();
				askNow.click();
				PreEnquiryVideoCheck();
				Thread.sleep(1500);
				Back();
				Back();
				System.out.println("Claim Tab Enquires working ✔");
			}
		} catch (Exception e) {
			Assert.fail("Claim Tab Enquires error" + e);

		}

	}

}
