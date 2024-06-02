package Bizupautomation.testUtils;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import io.appium.java_client.android.AndroidDriver;

public class Listeners extends AndroidActions implements ITestListener{
	AndroidDriver  driver;
	
	ExtentTest test;
	
	ExtentReports extent = ExtentReporterNG.getReporterObject();
	
	@Override
	public void onTestStart(ITestResult result) {
		test = extent.createTest(result.getMethod().getMethodName());
	}
	
	@Override
	public void onTestSuccess(ITestResult result) {
		test.log(Status.PASS, "Test Passed");
	}
	
//	@Override
//	public void onTestFailure(ITestResult result) {
//		test.fail(result.getThrowable());
//		try {
//			driver = (AndroidDriver) result.getTestClass().getRealClass().getField("driver").get(result.getInstance());
//		} catch (Exception e) {
//			// TODO: handle exception
//			e.printStackTrace();
//		}
//		try {
//			test.addScreenCaptureFromPath(getScreenshotPath(result.getMethod().getMethodName(), driver), result.getMethod().getMethodName());
//		} catch (Exception e) {
//			// TODO: handle exception
//			e.printStackTrace();
//		}
//	}
	
	@Override
	public void onTestFailure(ITestResult result) {
	    test.fail(result.getThrowable());
	    try {
	        driver = (AndroidDriver) result.getTestClass().getRealClass().getField("driver").get(result.getInstance());
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    try {
	        String screenshotPath = getScreenshotPath(result.getMethod().getMethodName(), driver);
	        String screenshotDescription = result.getMethod().getMethodName() + " failed";
	        test.addScreenCaptureFromPath(screenshotPath, screenshotDescription);
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	}
	
	@Override
	public void onFinish(ITestContext context) {
		extent.flush();
	}

}
