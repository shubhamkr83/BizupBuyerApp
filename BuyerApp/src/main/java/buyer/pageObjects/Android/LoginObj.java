package buyer.pageObjects.Android;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class LoginObj extends HomeObj {
	AndroidDriver driver;

	public LoginObj(AndroidDriver driver)

	{
		super(driver);
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}

	@AndroidFindBy(id = "com.sot.bizup.debug:id/ivHindiBg")
	private WebElement hindi;

	@AndroidFindBy(id = "com.sot.bizup.debug:id/tvEnglish")
	private WebElement english;

	@AndroidFindBy(id = "com.sot.bizup.debug:id/mbContinue")
	private WebElement continueBtn;

	@AndroidFindBy(id = "com.truecaller:id/tv_continueWithDifferentNumber")
	private WebElement trueCaller;

	@AndroidFindBy(id = "com.sot.bizup.debug:id/etMobileNo")
	private WebElement mobileNumber;

	public void Install() {
		try {
			boolean isInstalled = driver.isAppInstalled("com.sot.bizup.debug");
			if (isInstalled) {
				System.out.println("App already installed ✔");
				LaunchApp();
			} else {
				driver.installApp(
						"C:\\Users\\lenovo\\git\\BizupBuyerApp\\BuyerApp\\src\\main\\java\\buyer\\resources\\Bizup-2.15.2-debug.apk");
				System.out.println("Installation Complete ✔");
				LaunchApp();
				LanguageSelect();
				MobileNumber("1111100000");
				NotificationPermission();
			}

		} catch (Exception e) {
			System.out.println("App not installed " + e);
		}

	}

	public void MobileNumber(String number) throws InterruptedException {

		By trueCaller = By.id("com.truecaller:id/tv_continueWithDifferentNumber");

		if (driver.findElements(trueCaller).size() > 0) {
			driver.findElement(trueCaller).click();
			System.out.println("TrueCaller Working ✔");
		} else {
			System.out.println("TrueCaller not enable in the device ❌");
		}

		mobileNumber.sendKeys(number);
		Thread.sleep(4000);
		System.out.println("Login Sucessfull ✔");
	}

	public void LanguageSelect() {
		By langTitle = By.id("com.sot.bizup.debug:id/tvChooseLanguage");
		if (driver.findElements(langTitle).size() > 0) {
			english.click();
			continueBtn.click();
		}
	}

}
