package buyer.pageObjects.Android;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class HomePageObj extends SellerPageObj {
	AndroidDriver driver;

	public HomePageObj(AndroidDriver driver) {
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

	@AndroidFindBy(xpath = "(//android.widget.ImageView[@resource-id=\"com.sot.bizup.debug:id/ivThumbnail\"])[1]")
	private WebElement videoPlay;
	// private List<WebElement> videoPlay;

	@AndroidFindBy(xpath = "(//android.widget.ImageView[@resource-id=\"com.sot.bizup.debug:id/navigation_bar_item_icon_view\"])[1]")
	private WebElement homeTab;

	@AndroidFindBy(xpath = "(//android.widget.ImageView[@resource-id=\"com.sot.bizup.debug:id/navigation_bar_item_icon_view\"])[2]")
	private WebElement searchTab;

	@AndroidFindBy(xpath = "(//android.widget.ImageView[@resource-id=\"com.sot.bizup.debug:id/navigation_bar_item_icon_view\"])[3]")
	private WebElement mereSellerTab;

	public void NotificationPermission() throws InterruptedException {
		notipermission.click();
		Thread.sleep(3000);
		System.out.println("Notification working ✔");
		System.out.println("✨✨✨------------ Install and Login Working -----------✨✨✨");
	}

	public void CoachMark() {
		save.click();
	}

	public void ProductSelect(int index) {
		try {
			if (productFilter.isDisplayed()) {
				productFilter.click();
				productSelect.get(index).click();
				productApply.click();
				System.out.println("Product selected ✔");
			}
		} catch (Exception e) {
			Assert.fail("Product filter failed " + e);
		}
	}

	public void PriceSelect() {
		try {
			if (priceFilter.isDisplayed()) {
				priceFilter.click();
				priceSelect.click();
				Wait(genderAll, "All");
				System.out.println("Price selected ✔");
			}
		} catch (Exception e) {
			Assert.fail("Price filter failed ❌" + e);
		}
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

	public void DirectProductSelect() {
		directProductSelect.click();
	}

	public void HomeTab() {
		homeTab.click();
	}

	public void SearchBar() {
		searchBar.click();
	}

	public void SellerPresentCheck(String seller) throws InterruptedException {
		try {
			// Restart the App
			RestartApp();

			// Scroll to the Seller Journey Section
			ScrollEle("अपने सेलर्स देखना जारी रखें");

			// Target the seller
			By FindSeller = By
					.xpath("//android.widget.TextView[@resource-id=\"com.sot.bizup.debug:id/mtSellerName\" and @text=\""
							+ seller + "\"]");

			// Condition if seller present then do the Enquiry
			if (driver.findElements(FindSeller).size() > 0) {
				System.out.println("Seller " + seller + " is present in the Seller Journey section ✔");
				ClickXp("//android.widget.TextView[@resource-id=\"com.sot.bizup.debug:id/mtSellerName\" and @text=\""
						+ seller + "\"]");

				// Enquiry
				shortestEnquiry();

				// Restart App
				RestartApp();
			}
		} catch (Exception e) {
			Assert.fail("Seller Present Check " + e);
		}
	}

	public void sellerRemoveCheck(String seller) {
		try {

			// Scroll to the Seller Journey Section
			ScrollEle("अपने सेलर्स देखना जारी रखें");

			// Target the seller
			By FindSeller = By
					.xpath("//android.widget.TextView[@resource-id=\"com.sot.bizup.debug:id/mtSellerName\" and @text=\""
							+ seller + "\"]");

			// Condition if seller is present after doing the Enquiry
			if (driver.findElements(FindSeller).size() > 0) {
				System.out.println("Seller " + seller + " is not removed from the section after doing Enquiry ❌");
			} else {
				System.out.println("Seller " + seller + " is remove from the section after doing Enquiry ✔");
			}

			System.out.println("✨✨✨------------ Seller Journey Flow working -----------✨✨✨");

		} catch (Exception e) {
			Assert.fail("seller Remove Check failed " + e);
		}
	}
}
