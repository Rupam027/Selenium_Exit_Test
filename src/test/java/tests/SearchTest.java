package tests;



import java.io.IOException;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import pages.HeaderTab;
import utilities.ExtractDataFromExcel;


public class SearchTest extends BaseTest {
	
	@Test(priority = 9 , enabled = true , dataProvider = "searchData" , groups = {"header" , "search"})
	public static void  verify_product_search_using_click(Object data , Object execution_required) throws InterruptedException {
		
		if(execution_required.toString().equalsIgnoreCase("no"))
			throw new SkipException("Execution Not Required");
		
		openUrlandWaitForPagetoLoad();
		HeaderTab tab = new HeaderTab();
		driver.findElement(tab.searchBar).sendKeys(data.toString());
		testLog.log(LogStatus.PASS, "enter " + data.toString() + " in search bar");
		driver.findElement(tab.searchIcon).click();
		testLog.log(LogStatus.PASS, "Click on search icon");
		Assert.assertEquals(driver.getCurrentUrl().split("\\&")[0], "https://www.flipkart.com/search?q=" + data);
	
	}
	
	@Test(priority = 10 , enabled = true , dataProvider = "searchData" , groups = {"header" , "search"})
	public static void  verify_product_search_using_keyPress(Object data , Object execution_required) throws InterruptedException {
		
		if(execution_required.toString().equalsIgnoreCase("no"))
			throw new SkipException("Execution Not Required");
		
		openUrlandWaitForPagetoLoad();
		HeaderTab tab = new HeaderTab();
		driver.findElement(tab.searchBar).sendKeys(data.toString());
		testLog.log(LogStatus.PASS, "enter " + data.toString() + " in search bar");
		driver.findElement(tab.searchIcon).sendKeys(Keys.ENTER);
		testLog.log(LogStatus.PASS, "press enter key on grocery icon");
		Assert.assertEquals(driver.getCurrentUrl().split("\\&")[0], "https://www.flipkart.com/search?q=" + data);
	
	}
	
	@Test(priority = 14 , enabled = true , groups = {"header" , "search"})
	public static void verify_search_bar_placeholder() throws InterruptedException {
		
		openUrlandWaitForPagetoLoad();
		HeaderTab tab = new HeaderTab();
		Assert.assertEquals(driver.findElement(tab.searchBar).getAttribute("placeholder"),  "Search for products, brands and more");
		testLog.log(LogStatus.PASS, "verify placeholder of search bar");
		
	}
	
	@DataProvider
	public Object[][] searchData() throws IOException {
		return ExtractDataFromExcel.getTestData(System.getProperty("user.dir") + "//resources//test_data.xlsx", "Search_Test_Data");
	}

}
