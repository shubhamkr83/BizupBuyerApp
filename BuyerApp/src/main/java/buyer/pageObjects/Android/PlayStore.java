package buyer.pageObjects.Android;

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
}
