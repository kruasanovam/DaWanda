import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Created by mrusanova on 12/16/16.
 */
public class RegPage {

    private final WebDriver driver;
    public UserInfo userInfo = new UserInfo();

    public RegPage(WebDriver driver) {
        this.driver = driver;
    }

    public boolean getError (String fieldName)
    {
        WebElement error = driver.findElement(By.xpath("//div[@class='validation-msg invalid' and @data-bind-invalid-show='account;"+fieldName+"']"));
        boolean result = error.isDisplayed();
        return result;
    }


    public void FillFname ()

    {
        driver.findElement(By.id("firstname")).sendKeys(userInfo.firstname);
    }

    public void FillLname ()

    {
        driver.findElement(By.id("lastname")).sendKeys(userInfo.lastname);
    }

    public void FillUserName ()
    {
        driver.findElement(By.id("username")).sendKeys(userInfo.username);

    }

    public void FillEmail ()
    {
        driver.findElement(By.id("email")).sendKeys(userInfo.email);

    }

    public void FillPassword ()
    {
        driver.findElement(By.id("password")).sendKeys(userInfo.password);

    }

    public void FillTerms ()
    {
        driver.findElement(By.xpath("//input[@data-bind-class-invalid='account;terms']")).click();

    }

    public void ClickSubmit ()
    {
        driver.findElement(By.id("register_submit")).click();
    }


    public void PopulateForm(String ... params)
    {
        

    }


    public void ValidForm ()
    {
        userInfo.SetValidInfo();
        FillFname();
        FillLname();
        FillUserName();
        FillEmail();
        FillPassword();
        FillTerms();
        ClickSubmit();
        Assert.assertEquals(true, getError("firstname"));
    }

    public void BlankForm () {
        ClickSubmit();
        Assert.assertEquals(true, getError("firstname"));
        Assert.assertEquals(true, getError("lastname"));
        Assert.assertEquals(true, getError("username"));
        Assert.assertEquals(true, getError("email"));
        Assert.assertEquals(true, getError("terms"));
    }

    public void BlankTerms () {
        userInfo.SetValidInfo();
        FillFname();
        FillLname();
        FillUserName();
        FillEmail();
        FillPassword();
        ClickSubmit();
        Assert.assertEquals(true, getError("terms"));
    }

}
