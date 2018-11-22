package github_ng;

import org.testng.annotations.Test;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

public class Masterscript {
	
	public static WebDriver driver;
	public static ExtentReports reporter;
	public static ExtentTest test_report;
	
	@BeforeClass
	public void buildup() {
		
		reporter = new ExtentReports(System.getProperty("user.dir") + "\\test-output\\Extent_reports\\TestResults.html",true); 
		
	}
	
	 @BeforeMethod
	  public void beforeMethod() {
		 
		 test_report = reporter.startTest("E2E Testcase");
	  }
	
	
  @Test
  public void Maximo() {
	  
	  ChromeOptions options = new ChromeOptions();
	  options.setExperimentalOption("useAutomationExtension", false);
	  options.addArguments("start-maximized");
	  options.addArguments("chrome.switches","--disable-extensions");
	  options.addArguments("--disable-dev-shm-usage");
	
	  driver = new ChromeDriver(options);
	  test_report.log(LogStatus.PASS, "Chrome browser launched");
	  System.out.println("Hello universe!");

  }
  
  @Test
  public void Salesforce() {
	  
	  String IEfilepath = "C:\\Users\\athangaraj001\\Documents\\ng_poc\\src\\test\\resources\\IEDriverServer.exe";
	  System.setProperty("webdriver.ie.driver", IEfilepath);
	  driver = new InternetExplorerDriver();
	  driver.manage().window().maximize();
	  test_report.log(LogStatus.PASS, "Internet Explorer launched");
  }
  
  
 

  @AfterMethod
  public void afterMethod() {
	  driver.close();
  }
  
  
  
  @AfterClass
  public void teardown() {
	  
	  reporter.endTest(test_report);
	  reporter.flush();
  }

}
