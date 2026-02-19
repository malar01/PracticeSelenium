package Base;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import UtilityPackage.ConfigReader;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {

	protected WebDriver driver;
	
    
	@Parameters("browser")
	@BeforeMethod // TestNG will run this before each test method.
	public void setUp(@Optional("chrome") String browser) {
		//String browser = ConfigReader.getProperty("browser");
		String url = ConfigReader.getProperty("url");
		int wait = Integer.parseInt(ConfigReader.getProperty("timeout"));
		
	
		// Instantiate webdriver based on browser type
		switch (browser.toLowerCase()) { // switch-case → decides which browser to launch.
		case "chrome":
			WebDriverManager.chromedriver().setup(); // → ensures the ChromeDriver binary is available.
			driver = new ChromeDriver(); // → creates a new browser instance
			break;
		case "edge":
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			break;
		case "safari":
			driver = new SafariDriver();
			//driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(60));
			break;
		default:
			throw new RuntimeException("Unsupported Browser:" + browser);
		}
		// browser setup
		driver.manage().window().maximize(); // → removes any stored cookies for a clean session.
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(wait)); // → tells Selenium to wait up to wait
																				// seconds for elements to appear before
																				// throwing an exception.

		driver.get(url);
		System.out.println("Browser : " + browser+" "+"Navigate to :" + url);
	}

	@AfterMethod // → runs after each test method.
	public void tearDown(ITestResult result) throws IOException {
	
		if (result.getStatus() == ITestResult.FAILURE && driver != null) {
			
			// Take Screen shot
			TakesScreenshot sn = (TakesScreenshot) driver;
			File screenshot = sn.getScreenshotAs(OutputType.FILE);
			
			// Ensure folder exists
			String screenshotFolder = "./Screenshots/"; // stores the folder path in a variable
			File folder = new File(screenshotFolder); //creates a java File object that represents the folder
			if (!folder.exists())
				folder.mkdirs();
			
			// save file with timestamp to avoid overwriting
			String fileName = screenshotFolder + result.getName() + "_" + System.currentTimeMillis() + ".png";
			FileUtils.copyFile(screenshot, new File(fileName));
			System.out.println("Screenshot saved at: " + fileName);
			
		/*	Selenium takes a screenshot (temporary)
			Code checks/creates Screenshots folder
			Generates a unique filename
			Saves screenshot inside the folder*/
		}
		
		// Quit safely
		if (driver != null) { // -> Checks if the driver exists
			driver.quit(); // ->closes all browser windows and ends the session.
			System.out.println("Browser closed successfully");
	
		}
	}
}
