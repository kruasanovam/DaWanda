import org.junit.Assert;
import org.openqa.selenium.*;

import java.util.concurrent.TimeUnit;

/**
 * Created by mrusanova on 12/14/16.
 */
public class RegPage {

    DaActions actions = new DaActions();
    int randomID = actions.generateRandID();

    String FirstName = "Some First Name";
    String LastName = "Some Last Name";
    String Username = "frontend-test-user-" + randomID;
    String Email = "mariatesting89+" + randomID + "@gmail.com";
    //String Email = "mariatesting89+1095389771@gmail.com";
    String Password = "Welcome1";

    public void FillForm(WebDriver driver) {

        driver.findElement(By.id("firstname")).sendKeys(FirstName);

        driver.findElement(By.id("lastname")).sendKeys(LastName);

        driver.findElement(By.id("username")).sendKeys(Username);

        driver.findElement(By.id("email")).sendKeys(Email);

        driver.findElement(By.id("password")).sendKeys(Password);

        driver.findElement(By.id("accept_privacy")).click();

    }

    public void FillBlankForm(WebDriver driver) {

        driver.findElement(By.id("register_submit")).click();

    }


    public void HappySubmitRegForm(WebDriver driver) {
        String verifyTextExp = "We sent a confirmation link to " + Email + ". Clicking it will grant you full access to your DaWanda account.";

        FillForm(driver);

        driver.findElement(By.id("register_submit")).click();

        WebElement verifyEmailSection = driver.findElement(By.id("validate_email_page"));
        Assert.assertEquals(true, verifyEmailSection.isDisplayed());

        WebElement hintSection = driver.findElement(By.id("validate_email_hint"));
        Assert.assertEquals(true, hintSection.isDisplayed());

        String verifyTextAct = driver.findElement(By.id("validate_email_hint")).getText();

        Assert.assertEquals(verifyTextAct, verifyTextExp);

    }

    public void BlankSubmitRegForm(WebDriver driver)
    {
        FillBlankForm(driver);
        WebElement regpageArticle = driver.findElement(By.xpath("//article[@id='registration_page']"));
        Assert.assertEquals(true, regpageArticle.isDisplayed());
        int errorCount = driver.findElements(By.xpath("//div[@class='validation-msg invalid']")).size();
        Assert.assertEquals(7, errorCount);
    }






    }

