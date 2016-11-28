import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Created by mrusanova on 11/28/16.
 */
public class AccountLogin
{
    private WebDriver browser;

    public AccountLogin(WebDriver browser)
    {
        this.browser = browser;
    }

    public WebElement RegisterLink()
    {
        return this.browser.findElement(By.xpath("//p/a[@href=\"/account/register\"]"));
    }

}