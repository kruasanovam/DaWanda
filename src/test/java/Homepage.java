import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Created by mrusanova on 11/28/16.
 */
public class Homepage {


    public void OpenHomepage(WebDriver driver, String baseUrl) {

        driver.get(baseUrl);
        DaActions actions = new DaActions();
        actions.checkPageIsReady(driver);
        WebElement homepageDesc = driver.findElement(By.className("homepage-description"));
        Assert.assertEquals(true, homepageDesc.isDisplayed());

    }

    public void OpenRegPage(WebDriver driver) {
        String javaScript = "document.getElementById('shared_header_user_nav').classList.add('open')";
        ((JavascriptExecutor) driver).executeScript(javaScript);

        driver.findElement(By.xpath("//a[@href='/account/register']")).click();

        DaActions actions = new DaActions();
        actions.checkPageIsReady(driver);

        WebElement regpageArticle = driver.findElement(By.xpath("//article[@id='registration_page']"));
        Assert.assertEquals(true, regpageArticle.isDisplayed());
    }
}



