import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;

import java.util.concurrent.TimeUnit;

/**
 * Created by mrusanova on 11/25/16.
 */

public class Register {

    private static final String baseUrl = "https://dawanda.com/";


    Helper.SetBrowser();

    @Test
    public void HappyRegister() throws InterruptedException {

        Homepage homepage = new Homepage(driver);

        homepage.OpenHomepage(baseUrl);

        homepage.selectLang("en");

        homepage.OpenRegPage();

        RegPage registration = new RegPage(driver);

        registration.ValidForm();

        Helper helper = new Helper(driver);

        helper.logout();

        helper.openLoginPage();

        helper.login(UserInfo.email, UserInfo.password);

        helper.logout();

    }

    @Test
    public void NegativeRegister() throws InterruptedException {

        Homepage homepage = new Homepage(driver);

        homepage.OpenHomepage(baseUrl);

        homepage.selectLang("en");

        homepage.OpenRegPage();

        RegPage registration = new RegPage(driver);

        registration.BlankForm();

        driver.navigate().refresh();

        registration.InvalidForm();

        driver.navigate().refresh();

        registration.OnlySpacesForm();

        driver.navigate().refresh();

        registration.BlankTerms();

        driver.navigate().refresh();

        registration.EmailUsernameExists();

    }


}