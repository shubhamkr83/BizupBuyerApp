package buyer.pageObjects.Android;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class Search extends SellerPage{

	AndroidDriver driver;

	public Search(AndroidDriver driver)

	{
		super(driver);
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}

	@AndroidFindBy(xpath = "//android.widget.Button[@resource-id=\"com.sot.bizup:id/mbSearch\"]")
	private WebElement SearchIcon;
	
	@AndroidFindBy(id = "com.sot.bizup:id/search_src_text")
	private WebElement searchInputType;
	
	@AndroidFindBy(id = "com.sot.bizup:id/mtClear")
	private WebElement clearResult;
	
	@AndroidFindBy(xpath = "//android.widget.TextView[@resource-id=\"com.sot.bizup:id/tabText\" and @text=\"Videos (99+)\"]")
	private WebElement videoTab;
	
	@AndroidFindBy(xpath = "(//android.widget.ImageView[@resource-id=\"com.sot.bizup:id/ivThumbnail\"])[2]")
	private WebElement playVideo;
	
	@AndroidFindBy(id = "com.sot.bizup:id/mbGood")
	private WebElement videoLikeButton;
	
	@AndroidFindBy(xpath = "//android.widget.TextView[@resource-id=\"com.sot.bizup:id/tabText\" and @text=\"Samples\"]")
	private WebElement sampleTab;
	
	@AndroidFindBy(xpath = "(//android.widget.ImageView[@resource-id=\"com.sot.bizup:id/ivWhatsapp\"])[1]")
	private WebElement sampleEnquiry;
	
	@AndroidFindBy(xpath = "//android.widget.TextView[@resource-id=\"com.sot.bizup:id/tabText\" and @text=\"Sellers\"]")
	private WebElement sellerTab;
	
	@AndroidFindBy(xpath = "(//android.widget.Button[@resource-id=\"com.sot.bizup:id/mbExploreCatalog\"])[1]")
	private WebElement sellerCard;
	
	
	public void SearchIconClick() {
		SearchIcon.click();
	}

	public void SearchInputType(String product) {
		searchInputType.sendKeys(product);
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
	public void SearchVideoTab() {
		videoTab.click();
	}
	
	public void SearchSampleTab() {
		sampleTab.click();
	}
	
	public void SearchSampleEnquiry() {
		sampleEnquiry.click();
	}	
	
	public void SearchSellerTab() {
		sellerTab.click();
	}
	
	public void SellerCardSelect() {
		sellerCard.click();
	}
	
	
	

}
