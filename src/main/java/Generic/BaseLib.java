package Generic;


import java.awt.Toolkit;
import java.io.File;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;


public class BaseLib {
	
	public WaitstatementLib Wait;
	public WebDriver driver;
    public static ExtentReports reports;
    public static ExtentTest testinfo;
    public static ExtentHtmlReporter htmlReporter;
    private static ThreadLocal<ExtentTest> parentTest = new ThreadLocal<ExtentTest>();
    
    @BeforeSuite
    public void ReportSetup(){
    	String fileSuffix = new SimpleDateFormat("dd-MM-yyyy HH:mm").format(new Date());
    	htmlReporter = new ExtentHtmlReporter(new File(System.getProperty("user.dir")+"/Report/Report"+"("+fileSuffix+")"+".html"));
    	htmlReporter.loadXMLConfig(new File(System.getProperty("user.dir")+"/extent-config.xml"));
    	htmlReporter.config().setDocumentTitle("Demo");
        htmlReporter.config().setReportName("DemoTassk");
        htmlReporter.config().setTestViewChartLocation(ChartLocation.BOTTOM);
        htmlReporter.config().setTheme(Theme.DARK);
    	reports = new ExtentReports();
    	reports.setSystemInfo("Environment", "QA");
    	reports.attachReporter(htmlReporter);
    }
    
	@BeforeMethod
	@Parameters(value = "browser")
	public void preCondition(String browser, Method method) throws InterruptedException {
		String testName = method.getName();
		testinfo= reports.createTest(testName);
		parentTest.set(testinfo);
		
		if (browser.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
			
			// driver.switchTo().alert().accept();
		} else if (browser.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", "./ExeFile/chromedriver");
			driver = new ChromeDriver();
		}
		
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		Dimension screenResolution = new Dimension((int) toolkit.getScreenSize().getWidth(),(int) toolkit.getScreenSize().getHeight());
		driver.manage().window().setSize(screenResolution);

		driver.get("http://jupiter.cloud.planittesting.com");
		Wait = new WaitstatementLib();
		Wait.implicitWaitForSeconds(driver, 60);

	}

	@AfterMethod
	public void postCondition(ITestResult r) throws Exception {
		if (r.getStatus()==ITestResult.SUCCESS) {
			
			testinfo.log(Status.PASS, "The method name as "+r.getName().toUpperCase()+" is passed");

		} 
		
		else if(r.getStatus()==ITestResult.FAILURE) {
			testinfo.log(Status.FAIL, "The method name as "+r.getName().toUpperCase()+" is Failed");

			
			
			String screenshotPath = ScreenShotLib.getScreenshot(driver, r.getName());
			testinfo.log(Status.FAIL, "Screen capture"+testinfo.addScreenCaptureFromPath(screenshotPath));

		}
		else if (r.getStatus()==ITestResult.SKIP) {
			
			testinfo.log(Status.SKIP, "The method name as "+r.getName().toUpperCase()+" is SKIPPED");

		} 
		driver.quit();
		Reporter.log("Browser is closed", true);
		

	}
	@AfterSuite
	public void created(){
		reports.flush();
		
	}

}
