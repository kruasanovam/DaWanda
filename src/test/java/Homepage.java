
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;


/**
 * Created by mrusanova on 11/28/16.
 */
public class Homepage {
    WebDriver driver = new FirefoxDriver();
    String baseUrl = "http://dawanda.com";

    public void OpenHomepage ()
    {

        driver.get(baseUrl);
        if(!driver.findElements(By.xpath("//*[@class='homepage-description']")).isEmpty()){
            System.out.println("Homepage loaded");
        } else {
            System.out.println("Homepage not loaded");
        }

    }

    public void OpenRegPage () {
        driver.findElement(By.className("header-user-welcome")).click();
    }




}