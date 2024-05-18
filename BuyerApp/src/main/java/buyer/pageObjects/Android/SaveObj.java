package buyer.pageObjects.Android;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

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

	@AndroidFindBy(xpath = "(//android.widget.Button[@resource-id=\"com.sot.bizup.debug:id/mbDealKare\"])[1]")
	private WebElement sampleDekhe;

	@AndroidFindBy(id = "com.sot.bizup.debug:id/mbDealKare")
	private WebElement smallBaatKareBtn;

	@AndroidFindBy(id = "com.sot.bizup.debug:id/tvQuestion")
	private WebElement marketVisit;

	@AndroidFindBy(id = "com.sot.bizup.debug:id/mbTomorrow")
	private WebElement visitAnswer;

	@AndroidFindBy(id = "com.sot.bizup.debug:id/mbSend")
	private WebElement visitSend;

	// Navigate to save page
	public void SavePage() {
		savepage.click();
	}

	//Market visit
	public void MarketVisit() {
		visitAnswer.click();
		visitSend.click();
	}

	// Check the seller name
	public void SaveCheck(String seller) {
		driver.findElement(AppiumBy
				.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"" + seller + "\"));"));
		System.out.println("Seller is present on the save page ✔");
		System.out.println("Save flow working sucessfully ✔");

	}

	// Direction Check
	public void Direction() {
		By marketVisit = By.id("com.sot.bizup.debug:id/tvQuestion");
		boolean ismarketVisit = driver.findElements(marketVisit).size() > 0;

		direction.click();

		//Check Market Visit
		if (ismarketVisit) {
			System.out.println("MarketVisit Open");
			MarketVisit();
			System.out.println("MarketVisit Answered");
			
		}else {
			googleMap.isDisplayed();
			System.out.println("Map Open");
			Back();
			Back();
		}
		System.out.println("Direction Check working sucessfully ✔");
		
	}

	// Sample Check
	public void SampleDekhe() {
		SmallBaatKareBtn();
		smallBaatKareBtn.isDisplayed();
		System.out.println("Sample dekhe button works ✔");
	}

}
