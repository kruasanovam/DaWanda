import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static junit.framework.TestCase.assertEquals;

/**
 * Created by mrusanova on 12/16/16.
 */
public class RegPage {

    private final WebDriver driver;

    public RegPage(WebDriver driver) {
        this.driver = driver;
    }

    public boolean getError (String fieldName) {
        WebElement error = driver.findElement(By.xpath("//div[@class='validation-msg invalid' and @data-bind-invalid-show='account;"+fieldName+"']/span"));
        boolean result = error.isDisplayed();
        return result;
    }


    public void FillFname () {
        driver.findElement(By.id("firstname")).sendKeys(UserInfo.firstname);
    }

    public void FillLname () {
        driver.findElement(By.id("lastname")).sendKeys(UserInfo.lastname);
    }

    public void FillUserName () {
        driver.findElement(By.id("username")).sendKeys(UserInfo.username);
    }

    public void FillEmail () {
        driver.findElement(By.id("email")).sendKeys(UserInfo.email);
    }

    public void FillPassword () {
        driver.findElement(By.id("password")).sendKeys(UserInfo.password);
    }

    public void FillTerms () {
        driver.findElement(By.xpath("//input[@data-bind-class-invalid='account;terms']")).click();
    }

    public void ClickSubmit () {

        driver.findElement(By.id("register_submit")).click();
    }

    public void SubmitRegForm () {
        FillFname();
        FillLname();
        FillUserName();
        FillEmail();
        FillPassword();
        FillTerms();
        ClickSubmit();
    }


    public void happySubmitRegForm() {
        String verifyTextExp = "We sent a confirmation link to " + UserInfo.email + ". Clicking it will grant you full access to your DaWanda account.";
        WebElement verifyEmailSection = driver.findElement(By.id("validate_email_page"));
        Assert.assertEquals(true, verifyEmailSection.isDisplayed());

        WebElement hintSection = driver.findElement(By.id("validate_email_hint"));
        Assert.assertEquals(true, hintSection.isDisplayed());

        String verifyTextAct = driver.findElement(By.id("validate_email_hint")).getText();
        Assert.assertEquals(verifyTextAct, verifyTextExp);
    }


    public void ValidForm ()
    {
        UserInfo.SetValidInfo();
        SubmitRegForm ();
        happySubmitRegForm();
    }

    public void InvalidForm ()
    {
        UserInfo.SetInvalidInfo();
        SubmitRegForm ();
        Assert.assertEquals(true, getError("firstname"));
        Assert.assertEquals(true, getError("lastname"));
        Assert.assertEquals(true, getError("username"));
        Assert.assertEquals(true, getError("password"));
    }

    public void BlankForm () {
        ClickSubmit();
        Assert.assertEquals(true, getError("firstname"));
        Assert.assertEquals(true, getError("lastname"));
        Assert.assertEquals(true, getError("username"));
        Assert.assertEquals(true, getError("email"));
        Assert.assertEquals(true, getError("password"));
        Assert.assertEquals(true, getError("terms"));
    }

    public void OnlySpacesForm () {

        UserInfo.SetSpaceInfo();
        FillTerms();
        ClickSubmit();
        Assert.assertEquals(true, getError("firstname"));
        Assert.assertEquals(true, getError("lastname"));
        Assert.assertEquals(true, getError("username"));
        Assert.assertEquals(true, getError("password"));
        Assert.assertEquals(true, getError("email"));
    }

    public void BlankTerms () {
        UserInfo.SetValidInfo();
        FillTerms();
        SubmitRegForm ();
        Assert.assertEquals(true, getError("terms"));
    }

    public void EmailUsernameExists () {
        UserInfo.SetExistingInfo();
        SubmitRegForm ();
        Assert.assertEquals(true, getError("email"));
        Assert.assertEquals(true, getError("username"));


    }



}
