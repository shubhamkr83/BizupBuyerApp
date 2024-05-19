package buyer.pageObjects.Android;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import buyer.utils.AndroidUtils;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class SearchObj extends AndroidUtils {

	AndroidDriver driver;

	public SearchObj(AndroidDriver driver)

	{
		super(driver);
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}

	@AndroidFindBy(xpath = "//android.widget.Button[@resource-id=\"com.sot.bizup.debug:id/mbSearch\"]")
	private WebElement SearchIcon;

	@AndroidFindBy(id = "com.sot.bizup.debug:id/search_src_text")
	private WebElement searchInputType;

	@AndroidFindBy(id = "com.sot.bizup.debug:id/mtClear")
	private WebElement clearResult;

	@AndroidFindBy(xpath = "//android.widget.TextView[@resource-id=\"com.sot.bizup.debug:id/tabText\" and @text=\"Videos (99+)\"]")
	private WebElement videoTab;

	@AndroidFindBy(xpath = "(//android.widget.ImageView[@resource-id=\"com.sot.bizup.debug:id/ivThumbnail\"])[2]")
	private WebElement playVideo;

	@AndroidFindBy(id = "com.sot.bizup.debug:id/mbGood")
	private WebElement videoLikeButton;

	@AndroidFindBy(xpath = "//android.widget.TextView[@resource-id=\"com.sot.bizup.debug:id/tabText\" and @text=\"Samples\"]")
	private WebElement sampleTab;

	@AndroidFindBy(xpath = "(//android.widget.ImageView[@resource-id=\"com.sot.bizup.debug:id/ivWhatsapp\"])[2]")
	private WebElement sampleEnquiry;

	@AndroidFindBy(xpath = "//android.widget.TextView[@resource-id=\"com.sot.bizup.debug:id/tabText\" and @text=\"Sellers\"]")
	private WebElement sellerTab;

	@AndroidFindBy(xpath = "(//android.widget.Button[@resource-id=\"com.sot.bizup.debug:id/mbExploreCatalog\"])[1]")
	private WebElement sellerCard;

	public void SearchProduct(String product) {
		SearchIcon.click();
		searchInputType.sendKeys(product);
//		String resultsSearch = driver.findElement(By.id("com.sot.bizup.debug:id/mtTitle")).getText();
//		Assert.assertEquals("Showing results for \"" + product + "\"", resultsSearch);
	}

	public void ClearResult() {
		clearResult.click();
	}

	public void PlayVideo() {
		playVideo.click();
	}

	public void VideoLikeButton() {
		videoLikeButton.click();
	}

	public void VideoEnquiry() throws InterruptedException {
		videoTab.click();
		playVideo.click();
		videoLikeButton.click();
		shortSellerEnquiry();
		Back();
		Back();
		Back();
		Back();
	}

	public void SampleEnquiry() throws InterruptedException {
		sampleTab.click();
		Thread.sleep(4000);
		sampleEnquiry.click();
		Back();
		Back();
		Thread.sleep(2000);
	}

	public void SellerEnquiry() throws InterruptedException {
		sellerTab.click();
		sellerCard.click();
		shortSellerEnquiry();
	}

	public void SellerCard() {
		sellerTab.click();
		sellerCard.click();
		System.out.println("Seller Card Clicked ✔");
	}

	public void NavSeller() {
		ClickId("com.sot.bizup.debug:id/tvViewCatalog");
	}

}
