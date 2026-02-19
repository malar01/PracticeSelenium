package TestScripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import Base.BaseClass;
import PageClass.CheckBoxPageClass;

public class CheckboxTest extends BaseClass {
	CheckBoxPageClass checkbox;
	
	@Test(priority=4,enabled=false)
	 
	public void verifySelectCheckboxIfNotSelected() {
		  driver.get("https://the-internet.herokuapp.com/checkboxes");
		  checkbox=new CheckBoxPageClass(driver);
		 
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
}
