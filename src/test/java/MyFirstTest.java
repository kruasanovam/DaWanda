import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * Created by mrusanova on 11/25/16.
 */
public class MyFirstTest {
    @Test
    public void openHomepage() {
        WebDriver driver = new FirefoxDriver();
        driver.navigate().to("http://dawanda.com");
        Assert.assertTrue("title should start with DaWanda",
                driver.getTitle().startsWith("DaWanda"));

        Homepage home = new Homepage(driver);
        home.HeaderRegLink().click();
        Assert.assertTrue("title should start with DaWanda",
                driver.getTitle().startsWith("DaWanda"));
        AccountLogin accountLogin = new AccountLogin(driver);
        accountLogin.RegisterLink().click();
        Assert.assertTrue("title should start with DaWanda",
                driver.getTitle().startsWith("DaWanda"));



    }

}
