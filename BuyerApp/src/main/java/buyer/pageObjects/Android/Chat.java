package buyer.pageObjects.Android;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class Chat {

	AndroidDriver driver;

	public Chat(AndroidDriver driver)

	{
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}

	@AndroidFindBy(id = "com.sot.bizup:id/fab")
	private WebElement AgentIcon;

	@AndroidFindBy(xpath = "//android.widget.EditText")
	private WebElement message1;

	@AndroidFindBy(xpath = "//android.widget.Button[@text=\"\"]")
	private WebElement send;

	@AndroidFindBy(xpath = "//android.widget.EditText")
	private WebElement message2;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text=\"ओनर से बात करे\"]")
	private WebElement whatsAppEnableTop;

	@AndroidFindBy(xpath = "//android.widget.Button[@text=\"बात करे\"]")
	private WebElement whatsAppEnableBottom;

	public void clickAgent() {
		AgentIcon.click();
	}

	public void ShortChat1() throws InterruptedException {
		driver.findElement(By.xpath("//android.widget.EditText")).sendKeys("Hello");
		send.click();
		Thread.sleep(4000);
	}

	public void ShortChat2() throws InterruptedException {
		driver.findElement(By.xpath("//android.widget.EditText")).sendKeys("Catalog Dekhiye");
		send.click();
		Thread.sleep(4000);
	}

	public void LongChat1() throws InterruptedException {
		driver.findElement(By.xpath("//android.widget.EditText")).sendKeys("Hello");
		send.click();
		Thread.sleep(4000);

		driver.findElement(By.xpath("//android.widget.EditText")).sendKeys("Pant chahiye");
		send.click();
		Thread.sleep(4000);

		driver.findElement(By.xpath("//android.widget.EditText")).sendKeys("aur dekhao");
		send.click();
		Thread.sleep(4000);
	}

	public void LongChat2() throws InterruptedException {
		driver.findElement(By.xpath("//android.widget.EditText")).sendKeys("COD milega??");
		send.click();
		Thread.sleep(4000);

		driver.findElement(By.xpath("//android.widget.EditText")).sendKeys("Delivery charge kitna lagega??");
		send.click();
		Thread.sleep(4000);

		driver.findElement(By.xpath("//android.widget.EditText")).sendKeys("Delivery kab tak hogi??");
		send.click();
		Thread.sleep(4000);
	}

	public void send() {
		send.click();
	}

	


}
