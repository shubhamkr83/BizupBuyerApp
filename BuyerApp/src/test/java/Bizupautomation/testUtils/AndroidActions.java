package Bizupautomation.testUtils;
import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.appium.java_client.android.AndroidDriver;

public class AndroidActions{

AndroidDriver driver;

	public List<HashMap<String, String>> getJsonData(String jsonFilePath) throws IOException {

		// Covert json file content to json string
		String jsonContent = FileUtils.readFileToString(new File(jsonFilePath), StandardCharsets.UTF_8);

		ObjectMapper mapper = new ObjectMapper();
		List<HashMap<String, String>> data = mapper.readValue(jsonContent,
				new TypeReference<List<HashMap<String, String>>>() {
				});
		return data;
	}

	public String getScreenshotPath(String testCaseName, AndroidDriver driver) throws IOException {
		File source = driver.getScreenshotAs(OutputType.FILE);
		String destinationFile = System.getProperty("user.dir") + "\\reports" + testCaseName + ".png";
		FileUtils.copyFile(source, new File(destinationFile));
		return destinationFile;
		// 1. capture and place in folder //2. extent report pick file and attach to
		// report

	}
	
	public void Launch(AndroidDriver driver) throws InterruptedException {
		driver.activateApp("com.sot.bizup.debug");
		Thread.sleep(5000);
	}

	public void Terminate(AndroidDriver driver) {
		driver.terminateApp("com.sot.bizup.debug");
	}
	
	public void Install(AndroidDriver driver) {
		driver.installApp("C:\\Users\\lenovo\\git\\BizupBuyerApp\\BuyerApp\\src\\main\\java\\buyer\\resources\\Bizup-2.14.6-debug.apk");
	}
	
	public void RemoveApp(AndroidDriver driver) {
		driver.removeApp("com.sot.bizup.debug");
	}

}