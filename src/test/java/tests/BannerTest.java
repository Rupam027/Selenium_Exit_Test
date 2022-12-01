package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import pages.Dashboard;

public class BannerTest extends BaseTest {
	
	@Test(priority = 12 , enabled = true , groups = {"dashboard"})
	public static void verify_banner_width() throws InterruptedException {
		
		Dashboard dashboard = new Dashboard();
		
		openUrlandWaitForPagetoLoad();
		int size = driver.findElement(dashboard.banner).getSize().height;
		testLog.log(LogStatus.PASS, "measure size of banner");
		
		Assert.assertEquals(size, 280);
		
	}

}
