package utilities;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class ScreenShot {
	public static void captureScreenShot(WebDriver driver , String filename) throws IOException {
		TakesScreenshot screenshot = (TakesScreenshot)driver ;
		File output = new File(System.getProperty("user.dir") + "\\screenshots\\" + filename);
		
		FileUtils.copyFile(screenshot.getScreenshotAs(OutputType.FILE) , output);
	}
}
