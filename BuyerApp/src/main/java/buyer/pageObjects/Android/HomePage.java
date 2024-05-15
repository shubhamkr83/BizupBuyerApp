package buyer.pageObjects.Android;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import buyer.utils.AndroidUtils;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class HomePage extends AndroidUtils {
	AndroidDriver driver;

	public HomePage(AndroidDriver driver)

	{
		super(driver);
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}

	@AndroidFindBy(id = "com.android.permissioncontroller:id/permission_allow_button")
	private WebElement notipermission;

	@AndroidFindBy(id = "com.sot.bizup.debug:id/mbSearch")
	private WebElement searchBar;

	@AndroidFindBy(id = "com.sot.bizup.debug:id/ivSavedSeller")
	private WebElement save;

	@AndroidFindBy(id = "com.sot.bizup.debug:id/mtUserProfile")
	private WebElement profle;

	@AndroidFindBy(id = "com.sot.bizup.debug:id/ivBanner")
	private WebElement banner;

	@AndroidFindBy(id = "com.sot.bizup.debug:id/mtTopAll")
	private WebElement genderAll;

	@AndroidFindBy(id = "com.sot.bizup.debug:id/mtTopMen")
	private WebElement genderMen;

	@AndroidFindBy(id = "com.sot.bizup.debug:id/mtTopMen")
	private WebElement genderWomen;

	@AndroidFindBy(id = "com.sot.bizup.debug:id/mtTopKids")
	private WebElement genderKids;

	@AndroidFindBy(id = "com.sot.bizup.debug:id/ivCoachmarkText")
	private WebElement coachmark;

	@AndroidFindBy(id = "com.sot.bizup.debug:id/mbCategory")
	private WebElement productFilter;

	@AndroidFindBy(xpath = "(//android.widget.ImageView[@resource-id=\"com.sot.bizup.debug:id/ivSelected\"])")
	private List<WebElement> productSelect;

	@AndroidFindBy(id = "com.sot.bizup.debug:id/mbDone")
	private WebElement productApply;

	@AndroidFindBy(id = "com.sot.bizup.debug:id/ivFilter1")
	private WebElement directProductSelect;

	@AndroidFindBy(id = "com.sot.bizup.debug:id/mbMainCategory")
	private WebElement priceFilter;

	@AndroidFindBy(xpath = "//android.widget.Button[@text=\"400 तक\"]")
	private WebElement priceSelect;

	@AndroidFindBy(id = "com.sot.bizup.debug:id/mbCity")
	private WebElement cityFilter;

	@AndroidFindBy(xpath = "(//android.widget.ImageView[@resource-id=\"com.sot.bizup.debug:id/ivThumbnail\"])")
	private List<WebElement> videoPlay;

	@AndroidFindBy(xpath = "(//android.widget.ImageView[@resource-id=\"com.sot.bizup.debug:id/navigation_bar_item_icon_view\"])[1]")
	private WebElement homeTab;

	@AndroidFindBy(xpath = "(//android.widget.ImageView[@resource-id=\"com.sot.bizup.debug:id/navigation_bar_item_icon_view\"])[2]")
	private WebElement searchTab;

	@AndroidFindBy(xpath = "(//android.widget.ImageView[@resource-id=\"com.sot.bizup.debug:id/navigation_bar_item_icon_view\"])[3]")
	private WebElement mereSellerTab;

	@AndroidFindBy(id = "com.sot.bizup.debug:id/mbCity")
	private WebElement agent;

	public void NotificationPermission() {
		notipermission.click();
	}

	public void CoachMark() {
		save.click();
	}

	public void ProductSelect(int index) {
		productFilter.click();
		productSelect.get(index).click();
		productApply.click();
	}

	public void PriceSelect() {
		priceFilter.click();
		priceSelect.click();
		Wait(genderAll, "All");
	}

	public void HomeFeedPlay(int index) throws InterruptedException {
		videoPlay.get(index).click();
		Thread.sleep(2000);
	}

	public void Save() {
		save.click();
	}

	public void Profle() {
		profle.click();
	}

	public void Banner() {
		banner.click();
	}

	public void GenderFilter(String text) {
		if (text == "All") {
			genderAll.click();
		} else if (text == "Men") {
			genderAll.click();
		} else if (text == "Women") {
			genderWomen.click();
		} else if (text == "Kids") {
			genderKids.click();
		}
	}

	public void DirectProductSelect()

	{
		directProductSelect.click();
	}

	public void HomeTab()

	{
		homeTab.click();
	}

	public void Agent()

	{
		agent.click();
	}

	public void SearchBar()

	{
		searchBar.click();
	}
	
	public void SellerPage() throws InterruptedException {
		ClickId("com.sot.bizup.debug:id/mbGood");
		DetailedEnquiry();
	}

}
