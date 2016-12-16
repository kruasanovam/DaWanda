import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

/**
 * Created by mrusanova on 11/25/16.
 */

public class Register {

    private static final String baseUrl = "https://de.dawanda.com/account/register";

    WebDriver driver = new FirefoxDriver();



    @Test
    public void main() throws InterruptedException {

        Homepage homepage = new Homepage(driver);
        homepage.OpenHomepage(baseUrl);
        //homepage.OpenRegPage();

        RegPage registration = new RegPage(driver);
        registration.BlankForm();
        registration.BlankTerms();
        //registration.happySubmitRegForm();


       // Helper helper = new Helper(driver);
        //helper.logout();
        //helper.openLoginPage();
        //helper.login(registration.Email, registration.Password);
        //helper.logout();

    }


}