package buyer.pageObjects.Android;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import buyer.utils.AndroidUtils;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class VideoFeedObj extends AndroidUtils {

	AndroidDriver driver;

	public VideoFeedObj(AndroidDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}

	@AndroidFindBy(id = "com.sot.bizup.debug:id/mtSellerNameD")
	private WebElement sellerName;

	@AndroidFindBy(id = "com.sot.bizup.debug:id/ivSavedSeller")
	private WebElement saveIcon;

	@AndroidFindBy(id = "com.sot.bizup.debug:id/mbGood")
	private WebElement sampleDekhe;

	
	//-------------- Save --------------
	public String VideoCheck() {
		String videoSeller = "";

		By saveIcon = By.id("com.sot.bizup.debug:id/ivSavedSeller");
		By sampleDekheLocator = By.id("com.sot.bizup.debug:id/mbGood");

		boolean isSaveIconPresent = driver.findElements(saveIcon).size() > 0;

		if (isSaveIconPresent) {
			Scroll();

		} else {
			videoSeller = sellerName.getText();
			WebElement sampleDekhe = driver.findElement(sampleDekheLocator);
			sampleDekhe.click();
		}
		return videoSeller;

	}
	
	public void VideoSaveCheck() {
		By saveIcon = By.id("com.sot.bizup.debug:id/ivSavedSeller");
		boolean isSaveIconPresent = driver.findElements(saveIcon).size() > 0;
	
		if (isSaveIconPresent) {
			System.out.println("Video Save Icon Present ✔");
			Back();
		}else {
			System.out.println("Video Save Icon not Present ❌");
		}
	}

}
