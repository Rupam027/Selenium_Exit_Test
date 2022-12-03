package tests;

import java.io.IOException;

import org.openqa.selenium.NoSuchElementException;
import org.testng.SkipException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import pages.LoginPage;
import utilities.ExtractDataFromExcel;

public class LoginTest extends BaseTest {
	
	@Test(priority = 0 , enabled = true , dataProvider = "getLoginData" , groups = {"header" , "login"})
	public static void validate_login(String phone , String password , String execution_required , String blank) throws InterruptedException {
		
		
		if(execution_required.equalsIgnoreCase("no"))
			throw new SkipException("Test Data Skipped");
		
		testLog.log(LogStatus.INFO, "Verifying login with data : " + phone + " " + password);
		LoginPage page = new LoginPage();
		
		openUrlandWaitForPagetoLoad();
		driver.findElement(page.login_btn).click();
		driver.findElement(page.phone).sendKeys(phone) ;
		driver.findElement(page.password).sendKeys(password) ;
		driver.findElement(page.submit).click();
		
	}
	
	@DataProvider(name = "getLoginData")
	public String[][] getLoginData() throws IOException{
		return ExtractDataFromExcel.getTestData(System.getProperty("user.dir") + "//resources//test_data.xlsx", "Login_Test_Data");
	}
}
