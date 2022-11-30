package tests;


import org.testng.Assert;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import pages.HeaderTab;

public class LogoTest extends BaseTest {
	
	@Test(priority = 7 , enabled = true)
	public void verify_logo_text() throws InterruptedException {
		HeaderTab tab = new HeaderTab();
		openUrlandWaitForPagetoLoad();
		Assert.assertEquals(driver.findElement(tab.Logo).getAttribute("title") , "Flipkart");
		testLog.log(LogStatus.PASS, "verify logo name of application");
	}
	
	
	@Test(priority = 8 , enabled = true)
	public void verify_flipkart_plus() throws InterruptedException {
		
		HeaderTab tab = new HeaderTab();
		
		openUrlandWaitForPagetoLoad();
		
		driver.findElement(tab.flipkart_plus_link).click();
		Assert.assertEquals(driver.getCurrentUrl() , "https://www.flipkart.com/plus");
		testLog.log(LogStatus.PASS, "Verify flipkart plus link on logo");
			
		
	}

}
