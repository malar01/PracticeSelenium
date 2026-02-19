package herokuapp.com;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;

import java.io.File;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;

public class NewTest {
	WebDriver driver;
	//TC1="Verify valid credentials"
	@Test (priority=1,enabled=true,dataProvider="LoginData")
  public void verifyLoginWithValidCredencials(String username, String password,String expectedResult) {
		driver=new ChromeDriver();
	  driver.get("https://the-internet.herokuapp.com/login");
	  driver.findElement(By.id("username")).sendKeys(username);
	  driver.findElement(By.id("password")).sendKeys(password);
	  driver.findElement(By.xpath("//button[@class='radius']")).click();
	  
	  
	  WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

	  WebElement flashMessage = wait.until(
	          ExpectedConditions.visibilityOfElementLocated(By.id("flash"))
	  );

	  String actualMessage = flashMessage.getText();
	  if(expectedResult.equalsIgnoreCase("success")) {
		  
	  Assert.assertTrue(actualMessage.contains("You logged into a secure area!"),"Login success message not displayed");
	  System.out.println("The actual Message displayed is : "+actualMessage);
	  //driver.findElement(By.linkText("Logout")).click();
	} else  {
		Assert.assertTrue(actualMessage.contains("Your password is invalid!")
				||actualMessage.contains("Your username is invalid!"),
						"Expected invalid login message not displayed"
						);
		System.out.println("Login failed message displayed is : " + actualMessage);
		
	}
	  driver.quit();
	  
  }
  
	@DataProvider(name="LoginData")
    public Object[][] getLoginData() {
    	return new Object[][] {
    		{"tomsmith","SuperSecretPassword!","success"},
    		{"tomsmith","invalid password","failure"},
    		{"invalid username","SuperSecretPassword","failure"}
    	};
    }
  
}
	/*//Tc2="Verify invalid Credentials"
	@Test(priority=2,enabled=false)
	public void verifyInvalidCredentials() {
		driver.get("https://the-internet.herokuapp.com/login");
		driver.findElement(By.id("username")).sendKeys("tomsmith");
		driver.findElement(By.id("password")).sendKeys("test!");
		driver.findElement(By.xpath("//button[@class='radius']")).click();
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
	
		WebElement invalidMessage=wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("flash")));
		
		
		String actualM=invalidMessage.getText();
		Assert.assertTrue(actualM.contains("Your password is invalid!"),"Login failed Message not displayed");
		System.out.println("The message displayed for invalid login is : "+ actualM);
	}
	//TC4="Verify logout functionality credentials"
  @Test(priority=3,enabled=false) 
  public void verifyLogoutFunctionality() {
	  driver.get("https://the-internet.herokuapp.com/login");
	  driver.findElement(By.id("username")).sendKeys("tomsmith");
	  driver.findElement(By.id("password")).sendKeys("SuperSecretPassword!");
	  driver.findElement(By.xpath("//button[@class='radius']")).click();
	  
	  driver.findElement(By.xpath("//i[contains(@class,'icon-2x icon-signout')]")).click();// used contains when there is multiple class exists
	  WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
	  WebElement logoutmessage=wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("flash")));
	  String logoutM=logoutmessage.getText();
	  Assert.assertTrue(logoutM.contains("You logged out of the secure area!"),"Loggedout message not displayed");
	  System.out.println("The message displayed for Logout functionality is : "+ logoutM);
  }
  
  @Test(priority=4,enabled=false)
  public void verifySelectCheckboxIfNotSelected() {
	  driver.get("https://the-internet.herokuapp.com/checkboxes");
	// Checkbox 1 – Select if not selected
	  WebElement checkbox1=driver.findElement(By.xpath("(//input[@type='checkbox'])[1]"));
	  if(!checkbox1.isSelected()) {
		  checkbox1.click();
		  System.out.println("Checkbox1 was not selected, now selected");
	  } else {
			  System.out.println("Checkbox1 is already selected");
	  }
	// Checkbox 2 – Unselect if already selected
	  WebElement checkbox2=driver.findElement(By.xpath("(//input[@type='checkbox'])[2]"));
	  if(checkbox2.isSelected()) {
		  checkbox2.click();
		  System.out.println("Checkbox2 was selected, now unselected");
	  }
		  else {
			  System.out.println("Checkbox2 is already unselected");
		  }
	  }
	  
  @Test(enabled=false)
  public void verifySelectOptionByVisibleText() {
	  driver.get("https://the-internet.herokuapp.com/dropdown");
	  WebElement dropdown=driver.findElement(By.id("dropdown"));
	Select sc=new Select(dropdown);  
	sc.selectByVisibleText("Option 1");
	String selectedOption=sc.getFirstSelectedOption().getText();
	Assert.assertEquals(selectedOption, "Option 1","Incorrect Option selected");
	System.out.println("Option selected by Visible Text is "+ selectedOption);
	
	sc.selectByValue("2");
	//sc.selectByIndex(2);
  }
  
  //JavaScript Alert
  @Test
  public void verifyAcceptJSAlert() {
	  driver.get("https://the-internet.herokuapp.com/javascript_alerts");
	  driver.findElement(By.xpath("//button[text()='Click for JS Alert']")).click();
	  Alert alert=driver.switchTo().alert();
	  String alertText=alert.getText();
	  alert.accept();
	  Assert.assertEquals(alertText,"I am a JS Alert");
	  System.out.println(alertText);
	//dismiss a confirmation alert
	//Click JS Confirm button
	  driver.findElement(By.xpath("//button[text()='Click for JS Confirm']")).click();
	  
	// Switch to alert
	  Alert alertConf=driver.switchTo().alert();
	  
	// Validate alert text
	  String confirmAlert=alertConf.getText();
	  Assert.assertEquals(confirmAlert, "I am a JS Confirm");
	  alertConf.dismiss();//click cancel
	  
	  //Validate result text displayed on page
	  WebElement result=driver.findElement(By.id("result"));
	  String resultText=result.getText();
	  Assert.assertEquals(resultText, "You clicked: Cancel");
	  System.out.println(confirmAlert);
	  System.out.println(resultText);
	  
	  //Enter Text in prompt alert
	  
	  driver.findElement(By.xpath("//button[text()='Click for JS Prompt']")).click();
	  Alert promptAlert=driver.switchTo().alert();
	  promptAlert.sendKeys("Hello Selenium");
	  promptAlert.accept();
	  
	  WebElement prompResult=driver.findElement(By.id("result"));
	  Assert.assertEquals(prompResult.getText(),"You entered: Hello Selenium");
	  System.out.println(prompResult.getText());
	  
  }
  
  //Multiple Window
  @Test
  public void verifyClickLinkToOpenNewWindow() {
	  driver.get("https://the-internet.herokuapp.com/windows");
	  
	  //Store parent Window
	  String parentWindow=driver.getWindowHandle();
	  System.out.println("ParentWindow:"+parentWindow);
	  
	// Click "Click Here" to open new window
	  driver.findElement(By.linkText("Click Here")).click();
	  
	// Get all window handles
	  Set<String> allWindows=driver.getWindowHandles();
	  System.out.println("Child Windows:"+allWindows);
	  //switch to new window
	  for(String window:allWindows) {
		  if(!window.equals(parentWindow)) {
			  driver.switchTo().window(window);
		  }
	  }
	  //Validate text in new/child Window
	  
	  String childText=driver.findElement(By.tagName("h3")).getText();
	  Assert.assertEquals(childText, "New Window", "Text mismatch in child window");
	  System.out.println(childText);
	  
	  //close child window
	  driver.close();
	  
	  //switch back to parent window
	  driver.switchTo().window(parentWindow);	
	  
	  //validate parent window titile
	  Assert.assertEquals(driver.getTitle(), "The Internet");
	  
	    //getWindowHandle() → stores current (parent) window
		//getWindowHandles() → gets all open windows
		//switchTo().window() → switches between windows
		//By.linkText("Click Here") → clicks the link opening new window
  }
  
  
  //Frames
  
  @Test
  public void verifySwitchToiFrame() {
	  driver.get("https://the-internet.herokuapp.com/frames");
	  
	  // Navigate to the "iFrame" example link
	  driver.findElement(By.linkText("iFrame")).click();
	  
	// Switch to the iframe by id or name
	  driver.switchTo().frame("mce_0_ifr");
	  
	// Find the text area inside iframe and enter text
	  WebElement textBox=driver.findElement(By.id("tinymce"));
	 //textBox.clear();
	 // textBox.sendKeys("Hello, this text is inside the iframe!");
	  
	  //using java script
	  
	// Clear existing text using JSExecutor (robust for TinyMCE)
	  JavascriptExecutor js=(JavascriptExecutor) driver;
	  js.executeScript("arguments[0].innerHTML='';", textBox);
	  
	// Enter new text using JSExecutor
	  js.executeScript("arguments[0].innerHTML='Hello Selenium!';", textBox);
	  
	  // Optional: verify text was entered
	  String enteredText = textBox.getText();
      System.out.println("Text entered in iframe: " + enteredText);
	  
	// Switch back to main page
	  driver.switchTo().defaultContent();
	  //driver.switchTo().parentFrame();
	 
	//Verify total number of frames
	  int frameCount = driver.findElements(By.tagName("iframe")).size();
	  System.out.println("Total frames: " + frameCount);
	  
	// Verify element on parent page (outside iframe)
	  WebElement heading = driver.findElement(By.tagName("h3"));
	  Assert.assertEquals(heading.getText(), "An iFrame containing the TinyMCE WYSIWYG Editor");

	  System.out.println("Successfully switched back to main page");
	  
	// Optional: verify by printing page title
      System.out.println("Page title: " + driver.getTitle());
  }
  
  //DYNAMIC LOADING - WAITS
  @Test
  public void verifyDynamicLoading() {
	  //1.open the url
  	driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");
  	//2.Click the start button
  	driver.findElement(By.xpath("//div[@id='start']/button")).click();
  	
  	//3.wait until the text appears
  	WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
  	WebElement text=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='finish']/h4")));
  	
  	//4.Validate the text
  	String actualText=text.getText();
  	Assert.assertEquals(actualText, "Hello World!");
  	System.out.println("Dynmaic text displayed :"+actualText);
  }
  @Test
  //Dynamic controls
  public void verifyDynamicControls() {
	  
	  driver.get("https://the-internet.herokuapp.com/dynamic_controls");
	  
	  //click remove button
	  driver.findElement(By.xpath("//button[text()='Remove']")).click();
	  
	  //wait for checkbox to disappear
	  WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(40));
	 wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("checkbox")));
	 
	 //Validate message when checkbox is removed
	 WebElement element=wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("message")));
	 String actualMssg=element.getText();
	 Assert.assertEquals(actualMssg, "It's gone!");
	 System.out.println(actualMssg);
	  
	 
	 //Add checkbox back and verify message
	 
	 driver.findElement(By.xpath("//button[text()='Add']")).click();
	 //wait for checkbox to appear
	 wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("checkbox")));
	 //verify message 
	 WebElement messg=driver.findElement(By.id("message"));
	 Assert.assertEquals(messg.getText(), "It's back!");
	 System.out.println(messg.getText());
	 
	 
	 //Enable disabled input filed and enter text
	 
	 driver.findElement(By.xpath("//button[text()='Enable']")).click();
	 //Wait until input field is enabled
	 
	 WebElement textBox=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@type='text']")));
	 //enter text
	 textBox.sendKeys("Selenium Test");
	 
	 //Verify message
	 WebElement message=driver.findElement(By.id("message"));
	 Assert.assertEquals(message.getText(), "It's enabled!");
	 System.out.println(message.getText());
	 
	 //disable input filed and verify
	 
	 driver.findElement(By.xpath("//button[text()='Disable']")).click();
	 
	 wait.until(ExpectedConditions.not(ExpectedConditions.elementToBeClickable(By.xpath("//input[@type='text']"))));
	 
	 //Verify message
	 WebElement mess=driver.findElement(By.id("message"));
	 Assert.assertEquals(mess.getText(),"It's disabled!");
	 System.out.println(mess.getText());
  }
  
  @Test
  public void verifyFileUpload() {
	  
	 driver.get("https://the-internet.herokuapp.com/upload");
	 //Locate file input
	 WebElement fileUpload=driver.findElement(By.id("file-upload"));
	 //provide file path
	 fileUpload.sendKeys("/Users/macbook/Desktop/Screenshot 2025-06-02 at 15.00.11.png");
	  
	 //Click the upload button
	 driver.findElement(By.id("file-submit")).click();
	 
	 //Verify the file is uploaded
	 WebElement mssg=driver.findElement(By.id("uploaded-files"));
	 Assert.assertEquals(mssg.getText(), "Screenshot 2025-06-02 at 15.00.11.png");
	 System.out.println("File uploaded Successfully"+mssg.getText());
	 
  }
  
  /*@Test
  public void verifyFileDownload() throws IOException, InterruptedException {
    String downloadUrl = "https://the-internet.herokuapp.com/download/hello.txt";
    String downloadDir = "/Users/macbook/Downloads";
    
    // Command to download
    String command = "wget -P " + downloadDir + " " + downloadUrl;
    
    // Execute wget
    Process process = Runtime.getRuntime().exec(command);
    int exitCode = process.waitFor(); // Wait for download to finish
    
    if (exitCode != 0) {
        throw new IOException("wget failed with exit code " + exitCode);
    }

    // Verify file exists
    File file = new File(downloadDir + "/hello.txt");
    Assert.assertTrue(file.exists(), "File not downloaded");
}
//Mouse Hover
  @Test
  public void verifyHover() throws InterruptedException {
	  driver.get("https://the-internet.herokuapp.com/hovers");
	  //maximise window
	  driver.manage().window().maximize();
	  
	  //Locate the first image to hover
	  WebElement send_image=driver.findElement(By.xpath("(//div[@class='figure'])[2]"));
	  //create Action object
	  Actions a=new Actions(driver);
	  a.moveToElement(send_image).perform();
	  //
	  WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(20));
	  WebElement text_messg=wait.until(ExpectedConditions.visibilityOf(send_image.findElement(By.tagName("h5"))));
	  Assert.assertEquals(text_messg.getText(), "name: user2");
	  System.out.println("The Text Message is: "+text_messg.getText());
  }
 @Test
  public void verifyBrokenImages() {
	  driver.get("https://the-internet.herokuapp.com/broken_images");
	  driver.manage().window().maximize();
	  //find all images on the page
	  List<WebElement> allImages=driver.findElements(By.tagName("img"));
	  System.out.println("Total images found : "+allImages.size());
	  boolean brokenImageFound=false;
	  for(WebElement images:allImages) {
		  String src=images.getAttribute("src");
		  
		  try {
			URL url=new URL(src);
			HttpURLConnection http=(HttpURLConnection) url.openConnection();
			http.setRequestMethod("HEAD");
			http.connect();
			int responseCode=http.getResponseCode();
			
			if(responseCode>=400) {
				System.out.println("BROKEN IMAGE:"+src+"|Response code: "+responseCode);
				brokenImageFound=true;
			} else {
				System.out.println("Valid Iamge"+src+"|Response code: "+responseCode);
			}
		} catch (Exception e) {
		System.out.println("Error checking Image: "+src);
		brokenImageFound=true;//consider error as broken
		}
	  }
	  //Fail the test if broken images Exists
	 Assert.assertFalse(brokenImageFound, "There are broken images on the page!");
  } 
  @BeforeMethod
  public void beforeMethod() {
	  //WebDriverManager.chromedriver().setup();
	  driver=new ChromeDriver();
  }
 
  @AfterMethod
  public void afterMethod() {
	 driver.quit();
  }

}
*/