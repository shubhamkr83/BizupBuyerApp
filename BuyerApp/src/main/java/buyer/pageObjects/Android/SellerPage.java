package buyer.pageObjects.Android;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class SellerPage{

	AndroidDriver driver;

	public SellerPage(AndroidDriver driver)

	{
		
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}

	@AndroidFindBy(id = "com.sot.bizup.debug:id/ivDealsCoachmarkText")
	private WebElement coachmark;

	@AndroidFindBy(id = "com.sot.bizup.debug:id/mbSaveTitle")
	private WebElement SaveButton;

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
	private WebElement BaatKareButton;

	@AndroidFindBy(id = "com.sot.bizup.debug:id/mbPositive")
	private WebElement EnquiryActiQue;

	@AndroidFindBy(id = "com.sot.bizup.debug:id/mbButton")
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
		driver.findElement(By.xpath("(//android.widget.ImageView[@resource-id=\"com.sot.bizup.debug:id/ivThumbnail\"])[2]"))
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
		driver.findElement(By.xpath("(//android.widget.Button[@resource-id=\"com.sot.bizup.debug:id/mbShortlist\"])[2]"))
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
		driver.findElement(By.id("com.sot.bizup.debug:id/mbPositive")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("com.sot.bizup.debug:id/mbMessage")).click();
		Thread.sleep(2000);
	}

}
