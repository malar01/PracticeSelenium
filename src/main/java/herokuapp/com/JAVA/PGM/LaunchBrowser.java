package herokuapp.com.JAVA.PGM;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LaunchBrowser {
//Open browser and launch url
	public static void main(String[] args) {
		//System.setProperty(key, value);
		System.setProperty("Webdriver.chrome.driver","/path/chromedriver");
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.google.com");
		System.out.println("Title"+ driver.getTitle());
		driver.quit();
		
	}
}
