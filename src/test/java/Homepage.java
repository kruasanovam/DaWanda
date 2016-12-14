import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;

/**
 * Created by mrusanova on 11/28/16.
 */
public class Homepage {


    public void OpenHomepage(WebDriver driver, String baseUrl) {

        driver.get(baseUrl);
        WebElement homepageDesc = driver.findElement(By.className("homepage-description"));
        Assert.assertEquals(true, homepageDesc.isDisplayed());

    }

    public void OpenRegPage(WebDriver driver) {
        String javaScript = "document.getElementById('shared_header_user_nav').classList.add('open')";
        ((JavascriptExecutor) driver).executeScript(javaScript);

        driver.findElement(By.xpath("//a[@href='/account/register']")).click();

        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        WebElement regpageArticle = driver.findElement(By.xpath("//article[@id='registration_page']"));

        Assert.assertEquals(true, regpageArticle.isDisplayed());
    }
}



