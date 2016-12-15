import org.junit.Assert;
import org.openqa.selenium.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

/**
 * Created by mrusanova on 12/14/16.
 */
public class RegPage {

    private final static int randomID = Helper.generateRandID();

    public WebDriver driver;
    UserInfo userInfo = new UserInfo();


    public WebElement FillFname ()
    {
        driver.findElement(By.id("firstname")).sendKeys(UserInfo.firstname);
        WebElement errID = driver.findElement(By.xpath("//div[@class='validation-msg invalid' and @data-bind-invalid-show='account;firstname']"));
        return errID;
    }

    public WebElement FillLname ()
    {
        driver.findElement(By.id("lastname")).sendKeys(UserInfo.lastname);
        WebElement errID = driver.findElement(By.xpath("//div[@class='validation-msg invalid' and @data-bind-invalid-show='account;lastname']"));
        return errID;
    }

    public WebElement FillUserName ()
    {
        driver.findElement(By.id("username")).sendKeys(UserInfo.username);
        WebElement errID = driver.findElement(By.xpath("//div[@class='validation-msg invalid' and @data-bind-invalid-show='account;username']"));
        return errID;
    }

    public WebElement FillEmail ()
    {
        driver.findElement(By.id("email")).sendKeys(email);
        WebElement errID = driver.findElement(By.xpath("//div[@class='validation-msg invalid' and @data-bind-invalid-show='account;email']"));
        return errID;
    }

    public WebElement FillPassword ()
    {
        driver.findElement(By.id("password")).sendKeys(password);
        WebElement errID = driver.findElement(By.xpath("//div[@class='validation-msg invalid' and @data-bind-invalid-show='account;password']"));
        return errID;
    }

    public WebElement FillTC ()
    {
        driver.findElement(By.id("accept_privacy")).click();
        WebElement errID = driver.findElement(By.xpath("//div[@class='validation-msg invalid' and @data-bind-invalid-show='account;terms']"));
        return errID;
    }

    public void ClickSubmit ()
    {
        driver.findElement(By.id("register_submit")).click();
    }


    public void ValidForm (WebDriver driver)
    {
        firstname="Some FirstName";
        lastname="Some LastName";
        username="frontend-test-user-" + randomID;
        email="mariatesting89+" + randomID + "@gmail.com";
        password="Welcome1";
        FillFname();
        FillLname();
        FillUserName();
        FillEmail();
        FillPassword();
        FillTC();
        ClickSubmit();
    }

    public void BlankForm (WebDriver driver)
    {
        FillFname();
        FillLname();
        FillUserName();
        FillEmail();
        FillPassword();
        FillTC();
        ClickSubmit();

    }


    public void happySubmitRegForm() {
        String verifyTextExp = "We sent a confirmation link to " + email + ". Clicking it will grant you full access to your DaWanda account.";

        ValidForm(driver);

        WebElement verifyEmailSection = driver.findElement(By.id("validate_email_page"));
        assertEquals(true, verifyEmailSection.isDisplayed());

        WebElement hintSection = driver.findElement(By.id("validate_email_hint"));
        assertEquals(true, hintSection.isDisplayed());

        String verifyTextAct = driver.findElement(By.id("validate_email_hint")).getText();

        assertEquals(verifyTextAct, verifyTextExp);

    }

    public void blankSubmitRegForm() {

        boolean test =
        assertEquals(true,FillLname().isDisplayed());
        assertEquals(true,FillUserName().isDisplayed());
        assertEquals(true,FillEmail().isDisplayed());
        assertEquals(true,FillPassword().isDisplayed());
        assertEquals(true,FillTC().isDisplayed());
        WebElement regpageArticle = driver.findElement(By.xpath("//article[@id='registration_page']"));
        assertEquals(true, regpageArticle.isDisplayed());

    }

      //  int errorCount = driver.findElements(By.xpath("//div[@class='validation-msg invalid']")).size();
      //  assertEquals(7, errorCount);
   // }


}

