package pages;

import org.openqa.selenium.By;

public class HeaderTab {

		public By Logo = By.xpath("//*[@id=\"container\"]/div/div[1]/div[1]/div[2]/div[1]/div/a[1]/img");
		public By flipkart_plus_link = By.xpath("//*[@id=\"container\"]/div/div[1]/div[1]/div[2]/div[1]/div/a[2]");
		
		public By searchBar = By.xpath("//*[@id=\"container\"]/div/div[1]/div[1]/div[2]/div[2]/form/div/div/input");
		public By searchIcon = By.xpath("//*[@id=\"container\"]/div/div[1]/div[1]/div[2]/div[2]/form/div/button");
		
		public By header_bar = By.xpath("//*[@id=\"container\"]/div/div[1]");
		
		public By seller_hub_link = By.xpath("//*[@id=\"container\"]/div/div[1]/div[1]/div[2]/div[4]/a/span");
}
