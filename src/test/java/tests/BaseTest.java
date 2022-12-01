package tests;

import java.io.File;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;


import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import pages.PopUp;
import utilities.ScreenShot;

public class BaseTest {
	     public static WebDriver driver ; 
	     public static File configFile , dataFile ;  
	     public static Properties config_prop  ;
	     
	     static FileInputStream fis1 , fis2;
	     
	     public static ExtentReports report ;
	     public static ExtentTest testLog ;
	     public static int testcaseid ; 
	     
	     public static Logger logger = Logger.getLogger("Flipkart Test");
	     
	     
	     static {
	    	 
	    	 configFile = new File(System.getProperty("user.dir") +  "\\resources\\configuration.properties");
	    	 dataFile = new File(System.getProperty("user.dir") + "\\resources\\test_data.xlsx");
	    	 config_prop = new Properties();
	    	 
	    	 
	    	 try {
				fis1 = new FileInputStream(configFile);
				fis2 = new FileInputStream(dataFile);
			} catch (FileNotFoundException e) {
				
				e.printStackTrace();
			}
	    	 
	    	 try {
				config_prop.load(fis1);
				
			
	    	 } 
	    	 catch (IOException e) {
				
				e.printStackTrace();
			}
	    	 
	   }
	     
	     
	     
	     
	     @BeforeSuite
	     public static void testSetup() {
	    	 
	    	 logger.info("using browser " + config_prop.get("browser_name"));
	    	 if(config_prop.get("browser_name").toString().equals("chrome")) {
	    		 System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\resources\\chromedriver.exe");
		    	 ChromeOptions options = new ChromeOptions();
		    	 
		    	 if(config_prop.get("headless").equals("true"))
		    	 options.addArguments("--headless");
		    	 
		    	 driver = new ChromeDriver(options);
		    	 logger.info("Initilising Driver");
		    	 driver.manage().timeouts().implicitlyWait(Long.parseLong(config_prop.get("global_wait_time").toString()), TimeUnit.SECONDS);
		    	 logger.info("Managing Timeouts");
		    	 driver.manage().window().maximize();
		    	 logger.info("Initilising Driver");
		    	 logger.info("Maximize browser window");
	    	 
	    	 }
	    	 else  if(config_prop.get("browser_name").toString().equals("firefox")) {
	    		 System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "\\resources\\geckodriver.exe");
		    	 FirefoxOptions options = new FirefoxOptions();
		    	 
		    	 if(config_prop.get("headless").equals("true"))
		    	 options.setHeadless(true);
		    	 
		    	 driver = new FirefoxDriver(options);
		    	 logger.info("Initilising Driver");
		    	 driver.manage().timeouts().implicitlyWait(Long.parseLong(config_prop.get("global_wait_time").toString()), TimeUnit.SECONDS);
		    	 logger.info("Managing Timeouts");
		    	 driver.manage().window().maximize();
		    	 logger.info("Initilising Driver");
		    	 logger.info("Maximize browser window");
		    	 
	    	 }
	    	 else if(config_prop.get("browser_name").toString().equals("IE")) {
	    		 System.setProperty("webdriver.edge.driver", System.getProperty("user.dir") + "\\resources\\msedgedriver.exe");
		    	 EdgeOptions options = new EdgeOptions();
		    	 
		    	 if(config_prop.get("headless").equals("true"))
		    	 options.setHeadless(true);
		    	 
		    	 driver = new EdgeDriver(options);
		    	 logger.info("Initilising Driver");
		    	 driver.manage().timeouts().implicitlyWait(Long.parseLong(config_prop.get("global_wait_time").toString()), TimeUnit.SECONDS);
		    	 logger.info("Managing Timeouts");
		    	 driver.manage().window().maximize();
		    	 logger.info("Initilising Driver");
		    	 logger.info("Maximize browser window");
		    	 
	    	 }
	    	 
	    	 report = new ExtentReports(System.getProperty("user.dir") + "\\test_reports\\report.html");
	    	 logger.info("Report Generation at : " + System.getProperty("user.dir") + "\\test_reports\\report.html");
	    	 
	    	 
	     }
	     
	     
	   @BeforeTest
	   public static void testStart() {
		   testcaseid = 0 ;
		   logger.info("Starting Test");

	   }
	     
	    
	    @BeforeMethod
	     public static void testCaseStart(Method testMethod) throws InterruptedException {
	    	 
	    	logger.info("Starting Test Case :" + testMethod.getName());
	    	testLog = report.startTest(testMethod.getName());
	    	 
	    	
	    		 
	     }
	    
	    public static void openUrlandWaitForPagetoLoad() throws InterruptedException {
	    	driver.get(config_prop.getProperty("application_url"));
	    	 
	    	Thread.sleep(10000);  //Wait for the page to load completely
		    	 
		    if(driver.getCurrentUrl().equals(config_prop.getProperty("application_url")))
		    	testLog.log(LogStatus.PASS , "Lauching Application Url");
		    else
		    	testLog.log(LogStatus.FAIL,  "Url inaccessible or timeout");
		    
		    boolean IsPopUpPresent ; 
		    PopUp pop_up = new PopUp();
		    try {
		    	
				driver.findElement(pop_up.cross);
				IsPopUpPresent = true ;
			}
			catch(NoSuchElementException e) {
				IsPopUpPresent = false ;
			}
				
			if(IsPopUpPresent) {
				driver.findElement(pop_up.cross).click();
			}
	    }
	    
	    
	    
	     
	   
	     @AfterMethod
	     public static void testCaseReport(ITestResult result) throws IOException {
	    	
	    	
	    	 if(result.isSuccess()) {
	    		testLog.log(LogStatus.PASS , "Test Successful");
	    		logger.info("Test case success");
	    		
		     }
	    	
	    	else if(result.getStatus() == ITestResult.FAILURE){
	    		
	    		testLog.log(LogStatus.FAIL , result.getThrowable().toString());
	    		logger.info("Test Case Failure");
	    		ScreenShot.captureScreenShot(driver, testLog.getTest().getName() + ".jpg");
	    		logger.info("Screenshot Taken");
	    	 
	    	 }
	    	else if(result.getStatus() == ITestResult.SKIP)
	    		testLog.log(LogStatus.ERROR , "Test skipped");
	    	 
	    	 testcaseid ++ ;
	    	 report.endTest(testLog);
	    	 logger.info("Ending Test Case :" + testLog.getTest().getName().toString());
	    			 
	    	 
	   }
	     
	   
	     
	  
	    @AfterSuite
	     public static void destroy() {
	    	 report.flush();
	    	 logger.info("Saving reports");
	    	 driver.quit();
	    	 logger.info("Quiting");
	    	 
	     }
	     
	    
	     
	     
	     
	     

		
}
