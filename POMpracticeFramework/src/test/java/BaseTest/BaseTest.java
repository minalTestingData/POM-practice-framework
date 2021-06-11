package BaseTest;
import java.io.File;
import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import utils.constants;

public class BaseTest {

	public static WebDriver driver;

	public ExtentHtmlReporter htmlReporter;
	public ExtentReports extent;
	public static ExtentTest test;

	@BeforeTest
	public void BeforeTestMethod() {
		htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir") + File.separator + "reports"
				+ File.separator + "POMAutomationReport.html");
		htmlReporter.config().setDocumentTitle("Automation Extent Report");
		htmlReporter.config().setReportName("Automation Test Report");
		htmlReporter.config().setTheme(Theme.STANDARD);
		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
		extent.setSystemInfo("Automation Tester", "Minal");
	}
	
	
	@BeforeMethod	
	@Parameters({"browserName"})
	public void BeforeMethodMethod(String browserName, Method testMethod) {
		test = extent.createTest(testMethod.getName());
		setupDriver(browserName);
		driver.manage().window().maximize();		
		driver.get(constants.url);
		 driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		 
	}

	@AfterMethod
	public void AfterMethodMethod(ITestResult result) {
		if (result.getStatus() == ITestResult.SUCCESS) {
			String methodName = result.getMethod().getMethodName();
			String logText = "TestCase" + methodName + "Passed";
			Markup m = MarkupHelper.createLabel(logText, ExtentColor.GREEN);
			test.log(Status.PASS, m);
		} else if (result.getStatus() == ITestResult.FAILURE) {
			String methodName = result.getMethod().getMethodName();
			String logText = "TestCase" + methodName + "Failed";
			Markup m = MarkupHelper.createLabel(logText, ExtentColor.RED);
			test.log(Status.FAIL, m);
		}

	else if (result.getStatus() == ITestResult.SKIP) {
			String methodName = result.getMethod().getMethodName();
			String logText = "TestCase" + methodName + "Skiped";
			Markup m = MarkupHelper.createLabel(logText, ExtentColor.YELLOW);
			test.log(Status.SKIP, m);
		}

		driver.quit();
	}

	@AfterTest
	public void AfterTestMethod() {
		extent.flush();
	}

	public void setupDriver(String browserName) {
		if (browserName.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver",
					System.getProperty("user.dir") + File.separator + "driver" + File.separator + "chromedriver.exe");
			driver = new ChromeDriver();

		} else if (browserName.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.chrome.driver",
					System.getProperty("user.dir") + File.separator + "driver" + File.separator + "geckodriver.exe");
			driver = new FirefoxDriver();
		} else {
			System.setProperty("webdriver.chrome.driver",
					System.getProperty("user.dir") + File.separator + "driver" + File.separator + "chromedriver.exe");
			driver = new ChromeDriver();
		}
	}

}