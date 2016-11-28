
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


/**
 * Created by mrusanova on 11/28/16.
 */
public class Homepage {

    private WebDriver browser;

    public Homepage(WebDriver browser)
    {
        this.browser = browser;
    }

    public WebElement HeaderRegLink() {
        return this.browser.findElement(By.cssSelector(".header-user-welcome"));
    }

}
