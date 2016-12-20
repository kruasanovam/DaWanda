import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


/**Methods related to Registration Page. **/
public final class RegPage {

    private final WebDriver driver;

    public  RegPage(final WebDriver driver) {
        this.driver = driver;
    }

    /**Populate First Name field on Registration Form. **/
    private void fillFirstName() {
        driver.findElement(By.id("firstname")).sendKeys(UserInfo.firstname);
    }

    /**Populate Last Name field on Registration Form. **/
    private void fillLastName() {
        driver.findElement(By.id("lastname")).sendKeys(UserInfo.lastname);
    }

    /**Populate Username field on Registration Form. **/
    private void fillUserName() {
        driver.findElement(By.id("username")).sendKeys(UserInfo.username);
    }

    /**Populate Email field on Registration Form. **/
    private void fillEmail() {
        driver.findElement(By.id("email")).sendKeys(UserInfo.email);
    }

    /**Populate Password field on Registration Form. **/
    private void fillPassword() {
        driver.findElement(By.id("password")).sendKeys(UserInfo.password);
    }

    /**Tick on the Terms ad Conditions checkbox on Registration Form. **/
    private void selectTerms() {
        driver.findElement(By.xpath("//input[@data-bind-class-invalid='account;terms']")).click();
    }

    /**Click Submit CTA on Registration Form. **/
    private void clickSubmit() {

        driver.findElement(By.id("register_submit")).click();
    }

    /** Validate error message is displayed for a given field. **/
    private boolean getError(final String fieldName) {
        WebElement error = driver.findElement(By.xpath("//div[@class='validation-msg invalid' and @data-bind-invalid-show='account;" + fieldName + "']/span"));
        return error.isDisplayed();
    }

    /**Populate all fields on Registration Form and submit form. **/
    private void submitRegForm() {
        fillFirstName();
        fillLastName();
        fillUserName();
        fillEmail();
        fillPassword();
        selectTerms();
        clickSubmit();
    }

    /**Validate correct page is displayed on successful registration. **/
    private void registrationSuccessful() {
        String verifyTextExp = "We sent a confirmation link to " + UserInfo.email + ". Clicking it will grant you full access to your DaWanda account.";
        WebElement verifyEmailSection = driver.findElement(By.id("validate_email_page"));
        Assert.assertEquals(true, verifyEmailSection.isDisplayed());

        WebElement hintSection = driver.findElement(By.id("validate_email_hint"));
        Assert.assertEquals(true, hintSection.isDisplayed());

        String verifyTextAct = driver.findElement(By.id("validate_email_hint")).getText();
        Assert.assertEquals(verifyTextAct, verifyTextExp);
    }

    /**Register user with valid data and validate registration successful **/
    public void registerWithValidData() {
        UserInfo.setValidInfo();
        submitRegForm();
        registrationSuccessful();
    }

    /**Attempt to register user with some data that fails validation rules and validate registration fails. **/
    public void atemptRegisterWithIvalidData() {
        UserInfo.setInvalidInfo();
        submitRegForm();
        Assert.assertEquals(true, getError("firstname"));
        Assert.assertEquals(true, getError("lastname"));
        Assert.assertEquals(true, getError("username"));
        Assert.assertEquals(true, getError("password"));
    }

    /**Attempt to register user with blank fields and validate registration fails. **/
    public void attemptRegisterWithBlankForm() {
        clickSubmit();
        Assert.assertEquals(true, getError("firstname"));
        Assert.assertEquals(true, getError("lastname"));
        Assert.assertEquals(true, getError("username"));
        Assert.assertEquals(true, getError("email"));
        Assert.assertEquals(true, getError("password"));
        Assert.assertEquals(true, getError("terms"));
    }

    /**Attempt to register user with fields that contain spaces only and validate registration fails. **/
    public void attemptRegisterWithSpacesOnly() {

        UserInfo.setSpaceInfo();
        selectTerms();
        clickSubmit();
        Assert.assertEquals(true, getError("firstname"));
        Assert.assertEquals(true, getError("lastname"));
        Assert.assertEquals(true, getError("username"));
        Assert.assertEquals(true, getError("password"));
        Assert.assertEquals(true, getError("email"));
    }

    /**Attempt to register user with without checking terms and conditions flag and validate registration fails. **/
    public void attemptRegisterNoTerms() {
        UserInfo.setValidInfo();
        selectTerms();
        submitRegForm();
        Assert.assertEquals(true, getError("terms"));
    }

    /**Attempt to register user with email and username that already exist and validate registration fails. **/
    public void attemptRegisterWithExistingEmailUsername() {
        UserInfo.setExistingInfo();
        submitRegForm();
        Assert.assertEquals(true, getError("email"));
        Assert.assertEquals(true, getError("username"));

    }



}
