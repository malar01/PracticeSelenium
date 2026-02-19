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
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import UtilityPackage.ConfigReader;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Base {

	protected WebDriver driver;
	
	@BeforeMethod
	public void setUp() {
		String browser=ConfigReader.getProperty("browser");
		String url=ConfigReader.getProperty("url");
		int wait=Integer.parseInt(ConfigReader.getProperty("timeout"));
		
		//instatitating Wedriver 
		
		switch(browser.toLowerCase()){
			case "chrome":
				WebDriverManager.chromedriver().setup();
				driver=new ChromeDriver();
				break;
			case "edge":
				WebDriverManager.edgedriver().setup();
				driver=new EdgeDriver();
				break;
				default: 
					throw new RuntimeException("Unsupported Browser");
		}
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(wait));
		driver.get(url);
		System.out.println("Browser:"+browser+"Navigate to : "+ url);
	}
	@AfterMethod
	public void tearDown(ITestResult result) throws IOException {
		if(result.getStatus()==ITestResult.FAILURE && driver !=null) {
			
			TakesScreenshot ss=(TakesScreenshot) driver;
			File screenshot=ss.getScreenshotAs(OutputType.FILE);
			
			String screenshotFolder="./Screnshots/"; // stores the folder path in a variable
			File folder=new File(screenshotFolder); //creates a java File object that represents the folder
			if(!folder.exists()) folder.mkdir();
			String fileName=screenshotFolder+result.getName()+"_"+System.currentTimeMillis()+".png";
			FileUtils.copyFile(screenshot, new File(fileName));
			System.out.println("Screenshot saved at :"+fileName);
		}
		if (driver != null) {
	        driver.quit();
		
	}
	
	}
}



