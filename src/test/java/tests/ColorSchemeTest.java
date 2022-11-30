package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import pages.HeaderTab;

public class ColorSchemeTest extends BaseTest {

	@Test(priority = 11 , enabled = true)
	public void verify_color_scheme() throws InterruptedException {
		HeaderTab tab = new HeaderTab();
		openUrlandWaitForPagetoLoad();
		String bgcolor = driver.findElement(tab.header_bar).getCssValue("background-color") ; 
		testLog.log(LogStatus.PASS, "observe background color of heading bar");
		Assert.assertEquals(bgcolor , "rgba(0, 0, 0, 0)");
	}
	
}
