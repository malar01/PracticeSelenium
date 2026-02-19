package PageClass;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Base.BaseClass;

public class LoginPageClass extends BaseClass{
	private WebDriver driver;
	// 1️⃣ Constructor to pass driver from Base class
	
	public LoginPageClass(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
//page Locators
	@FindBy(id="username")
	private WebElement username;
	@FindBy(id="password")
	private WebElement password;
	@FindBy(xpath = "//button[@class='radius' and @type='submit']")
	private WebElement loginButton;
	@FindBy(id="flash")
	private WebElement flashMessage;
	@FindBy(linkText="Logout")
	private WebElement logoutButton;
	
	
	public void enterUsername(String user) {
		username.clear();
		username.sendKeys(user);
	}
	public void enterPassword(String pass) {
		password.clear();
		password.sendKeys(pass);
	}
	public void clickLoginButton() {
		loginButton.click();
	}
	public String getFlashMessage() {
		return flashMessage.getText().trim().replace("x", "").trim();
	}
	public void login(String user, String pass) {
		enterUsername(user);
		enterPassword(pass);
		clickLoginButton();
	}
	public void clickLogout() {
		logoutButton.click();
	}
	public void clearFields() {
		username.clear();
		password.clear();
	}
}
