package TestScripts;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import Base.BaseClass;
import PageClass.LoginPageClass;

public class LoginTestClass extends BaseClass {
	
	LoginPageClass login;
	
	@Test(enabled=false,description = "TC_001_Verify user login with valid user credentials", groups = {"smoke"})
	  public void verifyLoginWithValidCredencials() {
		login=new LoginPageClass(driver);
		login.login("username","password");
		String flashMessg=login.getFlashMessage();
		Assert.assertTrue(flashMessg.contains("You logged into a secure area!"),"Login failed!");
		System.out.println("Valid login test passed. Flash message: " + flashMessg);
		}
	
	//DataDriven Testing
	
	@Test(dataProvider="loginData", description="Data-driven login test")
    public void loginData(String username, String password, String expectedResult) {

        SoftAssert softAssert = new SoftAssert();
        login = new LoginPageClass(driver);

        login.login(username, password);
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

    // DataProvider
    @DataProvider(name="loginData")
    public Object[][] getloginData() {
        return new Object[][] {
            {"tomsmith","SuperSecretPassword!","Success"},
            {"tomsmith","wrongPass","Failure"},
            {"wrongUser","SuperSecretPassword!","Failure"}
        };
    }
}