package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import pages.HeaderTab;
import pages.SellerHubPage;

public class SellerHubTest extends BaseTest {
	
	
	@Test(priority = 15 , enabled = true)
	public static void verify_seller_hub_link() throws InterruptedException {
		HeaderTab tab = new HeaderTab();
		
		openUrlandWaitForPagetoLoad();
		driver.findElement(tab.seller_hub_link).click();
		testLog.log(LogStatus.PASS, "Click on seller hub link");
		Assert.assertEquals(driver.getCurrentUrl().split("\\?")[0], "https://seller.flipkart.com/sell-online/");
	}
	
	@Test(priority = 15 , enabled = true)
	public static void verify_spokeperson_name_on_sellerhub() throws InterruptedException {
		HeaderTab tab = new HeaderTab();
		SellerHubPage page = new SellerHubPage();
		
		openUrlandWaitForPagetoLoad();
		driver.findElement(tab.seller_hub_link).click();
		testLog.log(LogStatus.PASS, "Click on seller hub link");
		Assert.assertEquals(driver.findElement(page.spokeperson1_name).getText(), "Chaitanya Ramalingegowda");
		testLog.log(LogStatus.PASS, "verify spokeperson name 1");
		Assert.assertEquals(driver.findElement(page.spokeperson2_name).getText(), "Raju Lunawath");
		testLog.log(LogStatus.PASS, "verify spokeperson name 2");
		Assert.assertEquals(driver.findElement(page.spokeperson3_name).getText(), "Shubhash Chopra");
		testLog.log(LogStatus.PASS, "verify spokeperson name 3");
	}
}
