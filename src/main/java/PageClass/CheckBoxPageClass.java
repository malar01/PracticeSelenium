	package PageClass;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import Base.BaseClass;

public class CheckBoxPageClass  extends BaseClass {

	private WebDriver driver;
	
	public CheckBoxPageClass(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(xpath="(//input[@type='checkbox'])[1]")
	WebElement checkbox1;
	
	@FindBy(xpath="(//input[@type='checkbox'])[2]")
	WebElement checkbox2;
	
	public void checkboxIsSelected() {
		checkbox1.isSelected();
		
	}
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
	  
}
