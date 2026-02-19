package herokuapp.com;

import org.testng.Assert;
import org.testng.annotations.Test;
import Base.BaseClass;

public class LoginTest extends BaseClass {

    @Test(invocationCount=2)
    public void verifyLoginPageTitle() {
        String title = driver.getTitle();
        Assert.assertEquals(title, "The Internet");
        System.out.println("Page Title: " + title);
        System.out.println(System.getProperty("java.class.path"));
    }
}