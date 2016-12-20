import org.junit.Test;
import org.openqa.selenium.WebDriver;

public class RegistrationTests {

    private static final String BASEURL = "https://dawanda.com/";
    private final WebDriver driver = Helper.startBrowser();

    @Test
    public void happyRegister() throws InterruptedException {

        Helper helper = new Helper(driver);

        helper.openHomepage(BASEURL);

        helper.selectLang("en");

        helper.openRegPage();

        RegPage registration = new RegPage(driver);

        registration.registerWithValidData();

        helper.logout();

        helper.openLoginPage();

        helper.login(UserInfo.email, UserInfo.password);

        helper.logout();

    }

    @Test
    public void negativeRegister() throws InterruptedException {

        Helper helper = new Helper(driver);

        helper.openHomepage(BASEURL);

        helper.selectLang("en");

        helper.openRegPage();

        RegPage registration = new RegPage(driver);

        registration.attemptRegisterWithBlankForm();

        driver.navigate().refresh();

        registration.atemptRegisterWithIvalidData();

        driver.navigate().refresh();

        registration.attemptRegisterWithSpacesOnly();

        driver.navigate().refresh();

        registration.attemptRegisterNoTerms();

        driver.navigate().refresh();

        registration.attemptRegisterWithExistingEmailUsername();

    }
}