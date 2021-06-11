package utils;

import java.io.File;
import java.io.IOException;


import org.apache.tools.ant.util.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;


import BaseTest.BaseTest;

public class SuitListner implements ITestListener {


	

	public void onTestStart(ITestResult result) {
		
	}

	
	public void onTestSuccess(ITestResult result) {
		
	}

	public void onTestFailure(ITestResult result) {
		String filename = System.getProperty("user.dir") + File.separator + "screenshot" + File.separator + result.getMethod().getMethodName();
	File file1 = ((TakesScreenshot)BaseTest.driver).getScreenshotAs(OutputType.FILE);
	try {
		FileUtils.getFileUtils().copyFile(file1, new File(filename + ".png") );
	} catch (IOException e) {
		e.printStackTrace();
	}

		
	}

	public void onTestSkipped(ITestResult result) {
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		
	}

	public void onTestFailedWithTimeout(ITestResult result) {
		
	}

	public void onStart(ITestContext context) {
		
	}

	public void onFinish(ITestContext context) {
		
	}


}
