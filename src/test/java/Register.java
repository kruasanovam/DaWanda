import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * Created by mrusanova on 11/25/16.
 */

public class Register
{
    WebDriver driver = new FirefoxDriver();
    String baseUrl = "http://dawanda.com";

    @Test
    public void main () throws InterruptedException {
        Homepage homepage = new Homepage();
        homepage.OpenHomepage(driver, baseUrl);
        homepage.OpenRegPage(driver);
        RegPage registration = new RegPage();
        //registration.HappySubmitRegForm(driver);
        registration.BlankSubmitRegForm(driver);
        //DaActions actions = new DaActions();
        //actions.Logout(driver);
        //actions.OpenLoginPage(driver);
        //actions.Login(driver, registration.Email, registration.Password);
       //actions.Logout(driver);

    }










}