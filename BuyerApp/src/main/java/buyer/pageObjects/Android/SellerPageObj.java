package buyer.pageObjects.Android;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class SellerPageObj extends VideoFeedObj {

	AndroidDriver driver;

	public SellerPageObj(AndroidDriver driver)

	{
		super(driver);
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}

	@AndroidFindBy(id = "com.sot.bizup.debug:id/ivDealsCoachmarkText")
	private WebElement coachmark;

	@AndroidFindBy(id = "com.sot.bizup.debug:id/mtSellerName")
	private WebElement sellerName;

	@AndroidFindBy(id = "com.sot.bizup.debug:id/mbSave")
	private WebElement saveButton;

	@AndroidFindBy(id = "com.sot.bizup.debug:id/mbDealKare")
	private WebElement smallBaatKareBtn;

	@AndroidFindBy(id = "com.sot.bizup.debug:id/ivSuperProfileBadge")
	private WebElement superSellerIcon;

	@AndroidFindBy(id = "com.sot.bizup.debug:id/ivSuperSellerline")
	private WebElement superSellerLine;

	@AndroidFindBy(id = "com.sot.bizup.debug:id/mtSellerVideos")
	private WebElement VideoTab;

	@AndroidFindBy(id = "com.sot.bizup.debug:id/mtSellerCatalog")
	private WebElement CatalogTab;

	@AndroidFindBy(id = "com.sot.bizup.debug:id/mtSellerAboutStroke")
	private WebElement InfoTab;

	@AndroidFindBy(id = "com.sot.bizup.debug:id/ivBackBg")
	private WebElement BackButton;

	@AndroidFindBy(id = "com.sot.bizup.debug:id/mbChat")
	private WebElement VideoBaatKareButton;

	@AndroidFindBy(id = "com.sot.bizup.debug:id/mbPlaceOrder")
	private WebElement baatKareButton;

	@AndroidFindBy(id = "com.sot.bizup.debug:id/mbPositive")
	private WebElement EnquiryActiQue;

	@AndroidFindBy(id = "com.sot.bizup.debug:id/mbButton")
	private WebElement SkipEnqVideo;

	@AndroidFindBy(id = "com.sot.bizup.debug:id/gpSelectedItem")
	private WebElement gpSelectedItems;

	public void Coachmark() {
		coachmark.click();
	}

	public void SellerPage() throws InterruptedException {
		try {
			if (smallBaatKareBtn.isDisplayed()) {
				DetailedEnquiry();
				System.out.println("✨✨✨------------ Enquiry Video Flow working -----------✨✨✨");
			}
		} catch (Exception e) {
			Assert.fail("Enquiry Video Flow failed ❌");
		}
	}

	public void SmallBaatKareBtn() {
		if (smallBaatKareBtn.isDisplayed()) {
			smallBaatKareBtn.click();
		} else {
			System.out.println("Not redirect to seller page ❌");
			Assert.fail("Condition failed, marking test as failed ❌");
		}

	}

	public void VideoTabClick() {
		VideoTab.click();
		VideoTab.click();
	}

	public void CatalogTabClick() {
		CatalogTab.click();
	}

	public void InfoTabClick() {
		InfoTab.click();
	}

	public void VideoPlay() {
		driver.findElement(
				By.xpath("(//android.widget.ImageView[@resource-id=\"com.sot.bizup.debug:id/ivThumbnail\"])[2]"))
				.click();
	}

	public void VideoBaatKare() {
		VideoBaatKareButton.click();
	}

	public void BaatKareButton() throws InterruptedException {
		baatKareButton.click();
		Thread.sleep(3000);
	}

	public void CatalogSelect() {
		driver.findElement(
				By.xpath("(//android.widget.Button[@resource-id=\"com.sot.bizup.debug:id/mbShortlist\"])[1]")).click();
	}

	public void ProdFilterSelect() {
		driver.findElements(AppiumBy.className("android.widget.TextView")).get(1).click();
	}

	public void EnquiryActivationQue() {
		EnquiryActiQue.click();
	}

	public void SkipEnquiryVideo() {
		SkipEnqVideo.click();
	}

	public void FeedbackAnswer() throws InterruptedException {
		driver.findElement(By.id("com.sot.bizup.debug:id/mbPositive")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("com.sot.bizup.debug:id/mbMessage")).click();
		Thread.sleep(2000);
	}

	public void HomeToSeller() throws InterruptedException {

		String VSeller = HomeSeller();
		String seller = sellerName.getText();

		if (VSeller.equals(seller)) {
			System.out.println("Seller matched " + seller + "✔");
		} else {
			System.out.println("Seller name not match ❌");
		}
	}

	// save Seller
	public String SaveSeller() throws InterruptedException {

		// Check the save seller in video
		String videoSeller = VideoCheck();

		String seller = sellerName.getText();

		String saveText = saveButton.getText();

		if (videoSeller.equals(seller) && saveText.equals("सेव करें")) {
			System.out.println("Seller matched " + seller + "✔");
			saveButton.click();
			Back();
			Thread.sleep(2000);
		} else {
			System.out.println("Seller name not match ❌");
		}
		return seller;

	}

	public void SuperSeller(String SearchSeller) {
		try {

			String sellerProfile = sellerName.getText();

			if (SearchSeller.equals(sellerProfile)) {
				System.out.println("Seller matched " + sellerProfile);
				if (superSellerIcon.isDisplayed() && superSellerLine.isDisplayed()) {
					System.out.println(sellerProfile + " is super seller ✔");
				} else {
					System.out.println(sellerProfile + " is not super seller ❌");
					Assert.fail("Condition failed, he is not super seller ❌");
				}
			} else {
				System.out.println("Seller name not match ❌");
				Assert.fail("Condition failed, Seller name not match ❌");
			}

			System.out.println("✨✨✨------------ Super Seller Checked -----------✨✨✨");

		} catch (Exception e) {
			System.out.println("Super Seller error " + e);
		}
	}

	public void LastCatalogMsg() {
		Back();
		SampleDekhe();
		gpSelectedItems.isDisplayed();
	}

}
