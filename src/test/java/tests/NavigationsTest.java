package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import pages.NavigationTab;

public class NavigationsTest extends BaseTest {
	
	@Test(priority = 1 , enabled = true , groups = {"navigation"})
	public static void  verify_grocery_link() throws InterruptedException {
		openUrlandWaitForPagetoLoad();
		NavigationTab tab = new NavigationTab();
		driver.findElement(tab.grocery_icon).click();
		testLog.log(LogStatus.PASS, "Click on grocery icon");
		
		Assert.assertEquals(driver.getCurrentUrl().split("\\?")[0], "https://www.flipkart.com/grocery-supermart-store");
	
	}
	
	@Test(priority = 2 , enabled = true , groups = {"navigation"})
	public static void  verify_mobile_link() throws InterruptedException {
		openUrlandWaitForPagetoLoad();
		NavigationTab tab = new NavigationTab();
		driver.findElement(tab.mobile_icon).click();
		testLog.log(LogStatus.PASS, "Click on mobile icon");
		
		
		Assert.assertEquals(driver.getCurrentUrl().split("\\?")[0], "https://www.flipkart.com/mobile-phones-store");
	
	}
	
	@Test(priority = 3 , enabled = true , groups = {"navigation"})
	public static void  verify_appliance_link() throws InterruptedException {
		openUrlandWaitForPagetoLoad();
		NavigationTab tab = new NavigationTab();
		driver.findElement(tab.appliances_icon).click();
		testLog.log(LogStatus.PASS, "Click on appliance icon");
		
		
		Assert.assertEquals(driver.getCurrentUrl().split("\\?")[0], "https://www.flipkart.com/tvs-and-appliances-new-clp-store");
	
	}
	
	
	@Test(priority = 4 , enabled = true , groups = {"navigation"})
	public static void  verify_travel_link() throws InterruptedException {
		openUrlandWaitForPagetoLoad();
		NavigationTab tab = new NavigationTab();
		driver.findElement(tab.travel_icon).click();
		testLog.log(LogStatus.PASS, "Click on travel icon");
		
		
		Assert.assertEquals(driver.getCurrentUrl().split("\\?")[0], "https://www.flipkart.com/travel/flights");
	
	}
	
	@Test(priority = 5 , enabled = true , groups = {"navigation"})
	public static void  verify_top_offers_link() throws InterruptedException {
		openUrlandWaitForPagetoLoad();
		NavigationTab tab = new NavigationTab();
		driver.findElement(tab.top_offers_icon).click();
		testLog.log(LogStatus.PASS, "Click on top offers icon");
		
		Assert.assertEquals(driver.getCurrentUrl().split("\\?")[0], "https://www.flipkart.com/offers-store");
	
	}
	
	@Test(priority = 6 , enabled = true , groups = {"navigation"})
	public static void  verify_two_wheelers_link() throws InterruptedException {
		openUrlandWaitForPagetoLoad();
		NavigationTab tab = new NavigationTab();
		driver.findElement(tab.two_wheelers_icon).click();
		testLog.log(LogStatus.PASS, "Click on two wheeler icon");
		
		
		Assert.assertEquals(driver.getCurrentUrl().split("\\?")[0], "https://www.flipkart.com/two-wheelers-store");
	
	}

}
