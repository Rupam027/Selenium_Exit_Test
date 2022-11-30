package pages;

import org.openqa.selenium.By;

public class LoginPage {
	
	
	public By login_btn = By.xpath("//*[@id=\"container\"]/div/div[1]/div[1]/div[2]/div[3]/div/div/div/a");
	public By cross = By.xpath("/html/body/div[2]/div/div/button");
	public  By phone = By.xpath("/html/body/div[2]/div/div/div/div/div[2]/div/form/div[1]/input");
	public 	By password = By.xpath("/html/body/div[2]/div/div/div/div/div[2]/div/form/div[2]/input");
	public  By submit = By.xpath("/html/body/div[2]/div/div/div/div/div[2]/div/form/div[4]/button");
	
}
