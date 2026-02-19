package PageClass;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

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
}
