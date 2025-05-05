package LoginPageOHRM;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.SkipException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class NewTest {
	WebDriver driver;
	ExtentSparkReporter htmlReport;
	// Report file
	ExtentReports report;
	// Actual report
	ExtentTest test;
	
	@Test(priority = 1)
	public void loginToOHRM_Success() throws InterruptedException {
		test = report.createTest("OHRM_Login_Success");
		
		driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[1]/div/div[2]/input")).sendKeys("admin");
		driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[2]/div/div[2]/input")).sendKeys("admin123");
		driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[3]/button")).sendKeys(Keys.ENTER);
		
		Assert.assertTrue(driver.getCurrentUrl().contains("dash"));
		
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[1]/header/div[1]/div[3]/ul/li/span/p")).click();
		driver.findElement(By.partialLinkText("Log")).click();
	}
	@Test(priority = 2)
	public void loginToOHRM_Fail() {
		test = report.createTest("OHRM_Login_Fail");
		
		driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[1]/div/div[2]/input")).sendKeys("bharat");
		driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[2]/div/div[2]/input")).sendKeys("bharat123");
		driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[3]/button")).sendKeys(Keys.ENTER);
		
		Assert.assertTrue(driver.getCurrentUrl().contains("dash"));
	}
	
	@Test(priority = 3)
	public void loginToOHRM_Skip() {
		test = report.createTest("OHRM_Login_Skip");
		
		throw new SkipException("Skipping the test for reporting purpose");
	}

	@AfterMethod
	public void afterMethod(ITestResult result) 
	//ITestResult will give you detailed information about the @Test 
	{
		if(result.getStatus() == ITestResult.SUCCESS)
		{
			test.log(Status.PASS, MarkupHelper.createLabel(result.getName(), ExtentColor.GREEN));
		}
		else if(result.getStatus() == ITestResult.FAILURE)
		{
			test.log(Status.FAIL, MarkupHelper.createLabel(result.getName(), ExtentColor.RED));
			test.fail(result.getThrowable());		//getThrowable() will get the failure log
		}
		else if(result.getStatus() == ITestResult.SKIP)
		{
			test.log(Status.SKIP, MarkupHelper.createLabel(result.getName(), ExtentColor.ORANGE));
			test.skip(result.getThrowable());
		}
	}

	@BeforeTest
	public void beforeTest() {
		htmlReport = new ExtentSparkReporter("MyDetailedReport.html");	//Report File
		report = new ExtentReports();
		//Attach report to file
		report.attachReporter(htmlReport);
		
		report.setSystemInfo("Machine Name", "Dell");
		report.setSystemInfo("OS", "Windows 11");
		report.setSystemInfo("User", "Pushpalatha");
		report.setSystemInfo("Browser", "Google Chrome");
		
		htmlReport.config().setDocumentTitle("OHRM Login Report");
		htmlReport.config().setReportName("My Report");
		htmlReport.config().setTheme(Theme.DARK);
		htmlReport.config().setTimeStampFormat("EEEE MMMM dd yyyy, hh:mm a '('zzz')'");
		
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
	}

	@AfterTest
	public void afterTest() {
		report.flush();
		driver.close();
	}

}