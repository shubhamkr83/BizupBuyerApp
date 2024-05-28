package buyer.pageObjects.Android;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class SaveObj extends SellerPageObj {
	AndroidDriver driver;

	public SaveObj(AndroidDriver driver)

	{
		super(driver);
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}

	@AndroidFindBy(id = "com.sot.bizup.debug:id/ivSavedSeller")
	private WebElement savepage;

	@AndroidFindBy(xpath = "(//android.widget.Button[@resource-id=\"com.sot.bizup.debug:id/mbDirections\"])[1]")
	private WebElement direction;

	@AndroidFindBy(id = "com.google.android.apps.maps:id/custom_header_container")
	private WebElement googleMap;

//	@AndroidFindBy(xpath = "(//android.widget.Button[@resource-id=\"com.sot.bizup.debug:id/mbDealKare\"])[1]")
//	private WebElement sampleDekhe;

	@AndroidFindBy(id = "com.sot.bizup.debug:id/mbDealKare")
	private WebElement sampleDekhe;

	@AndroidFindBy(id = "com.sot.bizup.debug:id/tvQuestion")
	private WebElement marketVisit;

	@AndroidFindBy(id = "com.sot.bizup.debug:id/mbTomorrow")
	private WebElement visitAnswer;

	@AndroidFindBy(id = "com.sot.bizup.debug:id/mbSend")
	private WebElement visitSend;

	// Navigate to save page
	public void SavePage() throws InterruptedException {
		savepage.click();
		Thread.sleep(2000);
		System.out.println("Landed on save page");
	}

	// Market visit
	public void MarketVisit() {
		By marketVisit = By.id("com.sot.bizup.debug:id/tvQuestion");

		if (driver.findElements(marketVisit).size() > 0) {
			System.out.println("MarketVisit Open ✔");
			visitAnswer.click();
			visitSend.click();
			if (googleMap.isDisplayed()) {
				System.out.println("Map Open ✔");
				Back();
				Back();
			}
		} else if (googleMap.isDisplayed()) {
			System.out.println("Map Open ✔");
			Back();
			Back();
		} else {
			Assert.fail("Market Visit failed ❌");
		}

	}

	// Check the seller name
	public void SaveCheck(String seller) {
		try {
			if (sampleDekhe.isDisplayed()) {
				driver.findElement(AppiumBy.androidUIAutomator(
						"new UiScrollable(new UiSelector()).scrollIntoView(text(\"" + seller + "\"));"));
				System.out.println("Seller is present on the save page ✔");
				System.out.println("✨✨✨------------ Save flow working -----------✨✨✨");
			}
		} catch (Exception e) {
			Assert.fail("Save flow failed " + e);
		}

	}

	// Direction Check
	public void Direction() {
		try {
			if (direction.isDisplayed()) {
				direction.click();
				MarketVisit();
				System.out.println("Direction Check working sucessfully ✔");
			}
		} catch (Exception e) {
			Assert.fail("Direction Check failed " + e);
		}

	}

	// Sample Check
	public void SampleDekhe() {
		try {
			if (sampleDekhe.isDisplayed()) {
				sampleDekhe.click();
				SmallBaatKareBtn();
				System.out.println("Sample dekhe button works ✔");
				System.out.println("✨✨✨------------ Direction And Sample Flow working -----------✨✨✨");
			}

		} catch (Exception e) {
			Assert.fail("Sample dekhe button failed " + e);
		}

	}

}
