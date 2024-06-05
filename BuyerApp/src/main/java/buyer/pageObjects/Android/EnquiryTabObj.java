package buyer.pageObjects.Android;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class EnquiryTabObj extends SaveObj {

	AndroidDriver driver;

	public EnquiryTabObj(AndroidDriver driver)

	{
		super(driver);
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}

	// Enquiry Tab Flow
	@AndroidFindBy(xpath = "//android.widget.TextView[@resource-id=\"com.sot.bizup.debug:id/navigation_bar_item_small_label_view\" and @text=\"Enquiry\"]")
	private WebElement mereSellerTab;

	@AndroidFindBy(id = "com.sot.bizup.debug:id/mbReplyNow")
	private WebElement replyNow;

	@AndroidFindBy(id = "com.sot.bizup.debug:id/mbButton")
	private By preEnquiryVideo;

	// Claimming Flow
	@AndroidFindBy(id = "com.sot.bizup.debug:id/mbClaim")
	private WebElement KB;

	@AndroidFindBy(id = "com.sot.bizup.debug:id/mbInvoiceUpload")
	private WebElement upload;

	@AndroidFindBy(xpath = "(//android.widget.ImageView[@resource-id=\"com.google.android.documentsui:id/icon_thumb\"])[1]")
	private WebElement Invoice;

	@AndroidFindBy(id = "com.sot.bizup.debug:id/mbClaimSuraksha")
	private WebElement claimButton;

	@AndroidFindBy(id = "com.sot.bizup.debug:id/mbClaimWhatsapp")
	private WebElement askNowButton;

	@AndroidFindBy(id = "com.sot.bizup.debug:id/mbPositive")
	private WebElement feedbackQue1;

	@AndroidFindBy(id = "com.sot.bizup.debug:id/mbMessage")
	private WebElement feedbackQue2;

	// Claim Tab Flow
	@AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Claims\"]")
	private WebElement claimTab;

	@AndroidFindBy(id = "com.sot.bizup.debug:id/mbAskNow")
	private WebElement askNow;

	// Rating
	@AndroidFindBy(id = "com.sot.bizup.debug:id/mtHeading")
	private WebElement ratingCheck;

	@AndroidFindBy(id = "com.sot.bizup.debug:id/mtQuestion")
	private WebElement ratingQue;

	@AndroidFindBy(id = "com.sot.bizup.debug:id/mbYes")
	private WebElement ratingYes;

	@AndroidFindBy(id = "com.sot.bizup.debug:id/mbNo")
	private WebElement ratingNo;
	
	@AndroidFindBy(id = "com.sot.bizup.debug:id/mtBusinessName")
	private WebElement ratingSeller;

	public void EnquiryTab() throws InterruptedException {
		mereSellerTab.click();
		Thread.sleep(2000);
	}

	public void EnquiryTabEnquiry() {
		try {
			if (mereSellerTab.isDisplayed()) {
				mereSellerTab.click();
				Wait(claimTab, "Claims");
				CoachMarkCheck("com.sot.bizup.debug:id/ivDealsCoachmark");
				Wait(KB, "Upload Raw Bill");
				replyNow.click();
//				PreEnquiryQue();
				PreEnquiryVideoCheck();
				ShortChat1();
				Back();

				System.out.println("Enquires working ✔");
			}
		} catch (Exception e) {
			Assert.fail("Enquires error" + e);
		}
	}

	// Claimming Flow

	public void Claimming() {
		try {
			if (KB.isDisplayed()) {
				KB.click();
				upload.click();
				Invoice.click();
				claimButton.click();
				askNowButton.click();
				PreEnquiryVideoCheck();
				WhatsAppCheck();

				System.out.println("Kacha bill claim working ✔");
			}
		} catch (Exception e) {
			Assert.fail("Kacha bill claim error" + e);
		}

	}

	// Claim Tab Flow
	public void ClaimTabClick() {
		try {
			if (claimTab.isDisplayed()) {
				claimTab.click();
				askNow.click();
				PreEnquiryVideoCheck();
				WhatsAppCheck();
				System.out.println("Claim Tab Enquires working ✔");
				
			}
		} catch (Exception e) {
			Assert.fail("Claim Tab Enquires error" + e);

		}

	}

	// Rating Check
	public void RatingCheck() {
		By rating = By.id("com.sot.bizup.debug:id/mtQuestion");

		if (driver.findElements(rating).size() > 0) {
			System.out.println("Rating widget is showing");
			AnsRating();
		} else {
			System.out.println("Rating widget is not showing");
		}
	}

	//Rating answer
	public void AnsRating() {
		String ratingQ = ratingQue.getText();
		String sellerN = ratingSeller.getText();

		System.out.println("Seller Name is :- " + sellerN);
		System.out.println("Rating Question is :- " + ratingQ);
		ratingYes.click();
		System.out.println("Rating Question Answered");
		Back();
	}
	
	

}
