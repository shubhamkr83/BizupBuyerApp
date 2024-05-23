package buyer.pageObjects.Android;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class LoginObj {
	AndroidDriver driver;

	public LoginObj(AndroidDriver driver)

	{
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}

	@AndroidFindBy(id = "com.truecaller:id/tv_continueWithDifferentNumber")
	private WebElement trueCaller;

	@AndroidFindBy(id = "com.sot.bizup.debug:id/etMobileNo")
	private WebElement mobileNumber;

	public void MobileNumber(String number) throws InterruptedException {
		By trueCaller = By.id("com.truecaller:id/tv_continueWithDifferentNumber");
		if (driver.findElements(trueCaller).size() > 0) {
			// If the PreEnquiryVideo exists, skip it
			driver.findElement(trueCaller).click();
			System.out.println("TrueCaller Working ✔");
		}
		System.out.println("TrueCaller not enable in the device ❌");
		mobileNumber.sendKeys(number);
		Thread.sleep(4000);
		System.out.println("Login Sucessfull ✔");
	}

}
