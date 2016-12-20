import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.interactions.Actions;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import static org.junit.Assert.assertTrue;


    /** common methods that are non-page specific and can be reused. **/
    public final class Helper {
    private static WebDriver driver;


    public Helper(final WebDriver driver) {
        Helper.driver = driver;
    }
    /** create Firefox browser session. **/
    public static WebDriver startBrowser() {
        FirefoxProfile profile = new FirefoxProfile();
        profile.setPreference("focusmanager.testmode", true);
        driver = new FirefoxDriver(profile);
        driver.manage().window().maximize();
        return driver;
    }

    /**Select site language from footer menu. **/
    public void selectLang(final String lang) {
        driver.findElement(By.id("platform_select")).click();
        driver.findElement(By.xpath("//li[@value='http://" + lang + ".dawanda.com/']")).click();
    }

    /**Open Homepage via URL **/
    public void openHomepage(final String baseUrl) {
        driver.get(baseUrl);
        WebElement homepageDesc = driver.findElement(By.className("homepage-description"));
        Assert.assertEquals(true, homepageDesc.isDisplayed());
    }

    /**Click on a submenu item from Header menu. **/
    private static void openHeaderSubMenu(final String submenu)  {
        Actions builder = new Actions(driver);
        WebElement headerMenu = driver.findElement(By.id("shared_header_user_nav"));
        builder.moveToElement(headerMenu).build().perform();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.findElement(By.xpath(submenu)).click();
    }

    /**Open Registration Page via Register link in Header Menu **/
    public void openRegPage()  {
        final String submenu = "//a[@href='/account/register']";
        openHeaderSubMenu(submenu);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        WebElement regpageArticle = driver.findElement(By.xpath("//article[@id='registration_page']"));
        Assert.assertEquals(true, regpageArticle.isDisplayed());
    }

    /**Generate random number between 1000000000-2000000000. **/
    public static int generateRandID() {
        int max = 2000000000;
        int min = 1000000000;
        Random rand = new Random();
        return rand.nextInt((max - min) + 1) + min;
    }

    /**logout via Header Menu. **/
    public void logout() {
        final String submenu = "//a[@href='/account/logout']";
        openHeaderSubMenu(submenu);
        WebElement logoutArticle = driver.findElement(By.id("logout"));
        Assert.assertEquals(true, logoutArticle.isDisplayed());

    }

    /**open login page via Header Menu. **/
    public void openLoginPage() {
        final String submenu = "//a[@href='/account/login']";
        openHeaderSubMenu(submenu);
        WebElement loginArticle = driver.findElement(By.id("login_page"));
        Assert.assertEquals(true, loginArticle.isDisplayed());

    }

    /**log in with valid username/password. **/
    public void login(final String email, final String password) throws InterruptedException {

        driver.findElement(By.id("username")).sendKeys(email);
        driver.findElement(By.id("login_credentials_password")).sendKeys(password);
        driver.findElement(By.id("login_submit")).click();
        Thread.sleep(5000);
        assertTrue(driver.getTitle().equals("My DaWanda - DaWanda"));

    }


}






