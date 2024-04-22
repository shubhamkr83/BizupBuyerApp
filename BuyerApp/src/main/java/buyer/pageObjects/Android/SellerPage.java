package buyer.pageObjects.Android;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class SellerPage extends Chat {

	AndroidDriver driver;

	public SellerPage(AndroidDriver driver)

	{
		super(driver);
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}

	@AndroidFindBy(id = "com.sot.bizup:id/ivDealsCoachmarkText")
	private WebElement coachmark;

	@AndroidFindBy(id = "com.sot.bizup:id/mbSaveTitle")
	private WebElement SaveButton;

	@AndroidFindBy(id = "com.sot.bizup:id/mtSellerVideos")
	private WebElement VideoTab;

	@AndroidFindBy(id = "com.sot.bizup:id/mtSellerCatalog")
	private WebElement CatalogTab;

	@AndroidFindBy(id = "com.sot.bizup:id/mtSellerAboutStroke")
	private WebElement InfoTab;

	@AndroidFindBy(id = "com.sot.bizup:id/ivBackBg")
	private WebElement BackButton;

	@AndroidFindBy(id = "com.sot.bizup:id/mbChat")
	private WebElement VideoBaatKareButton;

	@AndroidFindBy(id = "com.sot.bizup:id/mbPlaceOrder")
	private WebElement BaatKareButton;

	@AndroidFindBy(id = "com.sot.bizup:id/mbPositive")
	private WebElement EnquiryActiQue;

	@AndroidFindBy(id = "com.sot.bizup:id/mbButton")
	private WebElement SkipEnqVideo;

	public void Coachmark() {
		coachmark.click();
	}

	public void SaveButtonClick() {
		SaveButton.click();
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
		driver.findElement(By.xpath("(//android.widget.ImageView[@resource-id=\"com.sot.bizup:id/ivThumbnail\"])[2]"))
				.click();
	}

	public void VideoBaatKare() {
		VideoBaatKareButton.click();
	}

	public void BaatKareButton() throws InterruptedException {
		BaatKareButton.click();
		Thread.sleep(3000);
	}

	public void CatalogSelect() {
		driver.findElement(By.xpath("(//android.widget.Button[@resource-id=\"com.sot.bizup:id/mbShortlist\"])[2]"))
				.click();
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
		driver.findElement(By.id("com.sot.bizup:id/mbPositive")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("com.sot.bizup:id/mbMessage")).click();
		Thread.sleep(2000);
	}

	public void DetailedEnquiry() throws InterruptedException {
		// Coachmark
		Coachmark();

		// Go to Catalog Tab
		CatalogTabClick();

		// Selecting Catalog
		CatalogSelect();

		// Click on Baat Kare button
		BaatKareButton();

		// Check for PreEnquiryVideo
		By preEnquiryVideo = By.id("com.sot.bizup:id/mbButton");
		if (driver.findElements(preEnquiryVideo).size() > 0) {
			// If the PreEnquiryVideo exists, skip it
			Thread.sleep(8000);
			driver.findElement(preEnquiryVideo).click();
		}

		// Enter the text on the Chat box
		LongChat1();

		driver.pressKey(new KeyEvent(AndroidKey.BACK));

		// ------Video Enquiry------
		// Search Video Tab Change
		VideoTabClick();

		// Click on the video
		VideoPlay();

		// Seller video baat kare button click
		VideoBaatKare();

		// Check for PreEnquiryVideo
		if (driver.findElements(preEnquiryVideo).size() > 0) {
			// If the PreEnquiryVideo exists, skip it
			Thread.sleep(8000);
			driver.findElement(preEnquiryVideo).click();
		}

		// Enter the text on the Chat box
		LongChat2();

		// WhatsApp Enable Click
		By secondElement = By.xpath("//android.widget.TextView[@text=\"ओनर से बात करे\"]");
		By firstElement = By.xpath("//android.widget.Button[@text=\"बात करे\"]");

		// Check if the first element exists
		if (driver.findElements(firstElement).size() > 0) {
			// If the first element exists, click it
			driver.findElement(firstElement).click();
		} else {
			// If the first element doesn't exist, check if the second element exists
			driver.findElement(secondElement).click();
		}

		// Check for PreEnquiryVideo
		if (driver.findElements(preEnquiryVideo).size() > 0) {
			// If the PreEnquiryVideo exists, skip it
			Thread.sleep(8000);
			driver.findElement(preEnquiryVideo).click();
		}

		// Back to Chat
		Thread.sleep(3000);
		driver.pressKey(new KeyEvent(AndroidKey.BACK));
		driver.pressKey(new KeyEvent(AndroidKey.BACK));

		// Answer feedback
		FeedbackAnswer();
	}

	public void shortSellerEnquiry() throws InterruptedException {

		// Click on Baat Kare button
		BaatKareButton();

		// Check for PreEnquiryVideo
		By preEnquiryVideo = By.id("com.sot.bizup:id/mbButton");
		if (driver.findElements(preEnquiryVideo).size() > 0) {
			// If the PreEnquiryVideo exists, skip it
			Thread.sleep(8000);
			driver.findElement(preEnquiryVideo).click();
		}

		// Enter the text on the Chat box
		ShortChat1();

		// Back from Chat
		driver.pressKey(new KeyEvent(AndroidKey.BACK));

		// Video Tab Change
		VideoTabClick();

		// Play video
		VideoPlay();

		// Seller video baat kare button click
		VideoBaatKare();

		// Check for PreEnquiryVideo
		if (driver.findElements(preEnquiryVideo).size() > 0) {
			// If the PreEnquiryVideo exists, skip it
			Thread.sleep(8000);
			driver.findElement(preEnquiryVideo).click();
		}

		// Enter the text on the Chat box
		ShortChat2();

		// Back from Chat
		driver.pressKey(new KeyEvent(AndroidKey.BACK));

	}

	public void shortestEnquiry() throws InterruptedException {

		// Click on Baat Kare button
		BaatKareButton();

		// Check for PreEnquiryVideo
		By preEnquiryVideo = By.id("com.sot.bizup:id/mbButton");
		if (driver.findElements(preEnquiryVideo).size() > 0) {
			// If the PreEnquiryVideo exists, skip it
			Thread.sleep(8000);
			driver.findElement(preEnquiryVideo).click();
		}

		// Enter the text on the Chat box
		ShortChat1();

	}

}
