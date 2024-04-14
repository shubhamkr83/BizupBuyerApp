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

public class SellerPage{

	AndroidDriver driver;

	public SellerPage(AndroidDriver driver)

	{
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}

	Chat chat = new Chat(driver);

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

	@AndroidFindBy(xpath = "(//android.widget.Image[@text=\\\"Vector\\\"])[2]")
	private WebElement whatsEnableClick;

	public void SaveButtonClick() {
		SaveButton.click();
	}

	public void VideoTabClick() {
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
				By.xpath("(//android.widget.ImageView[@resource-id=\"com.sot.bizup:id/ivThumbnail\"])[2]"))
				.click();
	}

	public void VideoBaatKareButtonClick() {
		VideoBaatKareButton.click();
	}

	public void BaatKareButtonClick() {
		BaatKareButton.click();
	}

	public void CatalogSelect() {
		driver.findElement(
				By.xpath("(//android.widget.Button[@resource-id=\"com.sot.bizup:id/mbShortlist\"])[2]")).click();
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

	public void WhatsAppEnableClick() {
		whatsEnableClick.click();
	}

	public void FeedbackAnswer() throws InterruptedException {
		driver.findElement(By.id("com.sot.bizup:id/mbPositive")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("com.sot.bizup:id/mbMessage")).click();
		Thread.sleep(2000);
	}
	
	public void shortSellerEnquiry() throws InterruptedException
	{
		//Click on Baat Kare button
		driver.findElement(By.id("com.sot.bizup:id/mbPlaceOrder")).click();
		Thread.sleep(3000);
		
		//Enter the text on the Chat box
		driver.findElement(By.xpath("//android.widget.EditText")).sendKeys("Hello");
		driver.findElement(By.xpath("//android.widget.Button[@text=\"\"]")).click();
		Thread.sleep(4000);
		
		//Back from Chat
		driver.pressKey (new KeyEvent (AndroidKey.BACK));
		Thread.sleep(2000);
		
		//Video Tab Change
		driver.findElement(By.id("com.sot.bizup:id/mtSellerVideos")).click();
		driver.findElement(By.id("com.sot.bizup:id/mtSellerVideos")).click();
		//Thread.sleep(2000);
		
		//Play video
		driver.findElement(By.xpath("(//android.widget.ImageView[@resource-id=\"com.sot.bizup:id/ivThumbnail\"])[1]")).click();
						
		//Seller video baat kare button click
		driver.findElement(By.id("com.sot.bizup:id/mbChat")).click();
		Thread.sleep(3000);
		
		//Enter the text on the Chat box
		driver.findElement(By.xpath("//android.widget.EditText")).sendKeys("Catalog Dekhiye");
		driver.findElement(By.xpath("//android.widget.Button[@text=\"\"]")).click();
		Thread.sleep(4000);
		
		//Back from Chat
		driver.pressKey (new KeyEvent (AndroidKey.BACK));
	}
	

}
