package buyer.pageObjects.Android;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class Login {
	AndroidDriver driver;

	public Login(AndroidDriver driver)

	{
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	@AndroidFindBy(id = "com.truecaller:id/tv_continueWithDifferentNumber")
	private WebElement trueCaller;
	
	@AndroidFindBy(id = "com.sot.bizup:id/etMobileNo")
	private WebElement mobileNumber;
	
	public void TrueCaller() {
		trueCaller.click();
	}

	public void MobileNumber(String number) {
		mobileNumber.sendKeys(number);
	}
	
}
