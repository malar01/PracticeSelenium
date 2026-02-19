package TestScripts;

import java.io.BufferedReader;
import java.io.FileReader;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import Base.BaseClass;
import PageClass.LoginPageClass;

public class LoginTestCSVFile extends BaseClass{
	LoginPageClass login;
	@Test
	public void testLoginFromCSV() throws Exception {
		login=new LoginPageClass(driver);
        BufferedReader br = new BufferedReader(new FileReader("/Users/macbook/Documents/testdata.csv"));
        String line;

        // Skip header
        br.readLine();

        SoftAssert softAssert = new SoftAssert(); // Soft assertion to continue tests even if one fails

        while ((line = br.readLine()) != null) {
            String[] data = line.split(",");
            String username = data[0];
            String password = data[1];
            String expectedResult = data[2];
            
            login.enterUsername(username);
            login.enterPassword(password);
            login.clickLoginButton();

           String actualResult=login.getFlashMessage();
           System.out.println("Expected: " + expectedResult + " | Flash message: " + actualResult);

            // Use soft assertion instead of hard assert
            if (actualResult.contains(expectedResult)) {
                System.out.println("Test Passed for user: " + username);
                softAssert.assertTrue(actualResult.contains("You logged into a secure area"),"Valid login failed");
                login.clickLogout();
            } else {
            	System.out.println("Test Failed for user: " + username);
                softAssert.assertTrue(actualResult.contains("Your password is invalid!") ||
                		actualResult.contains("Your username is invalid!"),
                        "Expected invalid login message not displayed"
                );
            }
         // Prepare for next iteration
            login.clearFields();
    }
        br.close();
        softAssert.assertAll(); // Collate all failures at the end
	}
}
