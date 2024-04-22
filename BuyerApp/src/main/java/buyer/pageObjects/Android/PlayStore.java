package buyer.pageObjects.Android;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class PlayStore {

	AndroidDriver driver;

	public PlayStore(AndroidDriver driver)

	{
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}

	@AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Search\"]")
	private WebElement searchIcon;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Search Apps & Games\"]")
	private WebElement searchInput;

	@AndroidFindBy(xpath = "//android.widget.EditText")
	private WebElement searchApp;

	@AndroidFindBy(xpath = "//androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View/android.view.View[1]/android.view.View[3]")
	private WebElement appIcon;

	@AndroidFindBy(xpath = "//androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View/android.view.View/android.view.View[1]/android.view.View[2]/android.widget.Button")
	private WebElement install;


	public void SearchIcon() {
		searchIcon.click();
	}

	public void SearchInput() {
		searchInput.click();
	}

	public void SearchApp(String app) {
		searchApp.sendKeys(app);
	}

	public void AppIcon() {
		appIcon.click();
	}

	public void Install() {
		install.click();
	}

	public void LaunchApp() throws InterruptedException {

		By uninstall = By.xpath("//android.widget.TextView[@content-desc=\"Uninstall\"]");
		By open = By.xpath("//android.widget.TextView[@content-desc=\"Open\"]");
		
		// Check if the first element exists
		if (driver.findElements(uninstall).size() > 0) {
			// If the first element exists, click it
			driver.findElement(open).click();
		} else {
			// If the first element doesn't exist, check if the second element exists
			Thread.sleep(30000);
			driver.findElement(open).click();
		}
	}
}
