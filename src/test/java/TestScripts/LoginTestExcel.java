package TestScripts;

import java.io.IOException;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import Base.BaseClass;
import PageClass.LoginPageClass;
import UtilityPackage.ExcelUtility;

public class LoginTestExcel extends BaseClass {
	LoginPageClass login;

	@DataProvider(name="LoginTestExcel")
	public Object[][] loginData() throws IOException{
		return ExcelUtility.getExcelData("/Users/macbook/Documents/TestData.xlsx", "Sheet1");
	}
	@Test(dataProvider="LoginTestExcel")
	public void loginDataFromExcel(String username,String password, String expectedResult) {
		login=new LoginPageClass(driver);
		login.enterUsername(username);
		login.enterPassword(password);
		login.clickLoginButton();
		SoftAssert softAssert = new SoftAssert();
		 String message = login.getFlashMessage();
	        System.out.println("Expected: " + expectedResult + " | Flash message: " + message);

	        if (expectedResult.equalsIgnoreCase("Success")) {
	            softAssert.assertTrue(message.contains("You logged into a secure area"),
	                    "Valid login failed");
	            // Logout to reset session for next iteration
	            login.clickLogout();
	            login.clearFields();
	        } else {
	            softAssert.assertTrue(
	                    message.contains("Your password is invalid!") ||
	                    message.contains("Your username is invalid!"),
	                    "Expected invalid login message not displayed"
	            );
	        }

	        softAssert.assertAll();
	}
}
