package tests;




import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import pages.Dashboard;

public class HelpCenterTest extends BaseTest {
	
	@Test(priority = 13 , enabled = true)
	public static void verify_help_center_link() throws InterruptedException {
		Dashboard dashboard = new Dashboard();
		Actions action = new Actions(driver);
		
		openUrlandWaitForPagetoLoad();
		
		WebElement help_center_link = driver.findElement(dashboard.help_center);
		action.scrollToElement(help_center_link);
		action.moveToElement(help_center_link);
		testLog.log(LogStatus.PASS, "scroll to help center link");
		
		help_center_link.click();
		testLog.log(LogStatus.PASS, "click on help center");
		
		Assert.assertEquals(driver.getCurrentUrl().split("\\?")[0], "https://www.flipkart.com/helpcentre");
		
		
		
	}

}
