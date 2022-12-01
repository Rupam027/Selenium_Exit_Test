package tests;

import java.io.IOException;

import org.openqa.selenium.NoSuchElementException;
import org.testng.SkipException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pages.LoginPage;
import utilities.ExtractDataFromExcel;

public class LoginTest extends BaseTest {
	
	@Test(priority = 0 , enabled = true , dataProvider = "getLoginData" , groups = {"header" , "login"})
	public static void validate_login(Object phone , Object password , Object execution_required , Object blank) throws InterruptedException {
		
		if(execution_required.toString().equalsIgnoreCase("no"))
			throw new SkipException("Execution Not Required");
		
		
		LoginPage page = new LoginPage();
		
		openUrlandWaitForPagetoLoad();
		driver.findElement(page.login_btn).click();
		driver.findElement(page.phone).sendKeys(phone.toString()) ;
		driver.findElement(page.password).sendKeys(password.toString()) ;
		driver.findElement(page.submit).click();
		
	}
	
	@DataProvider(name = "getLoginData")
	public Object[][] getLoginData() throws IOException{
		return ExtractDataFromExcel.getTestData(System.getProperty("user.dir") + "//resources//test_data.xlsx", "Login_Test_Data");
	}
}
