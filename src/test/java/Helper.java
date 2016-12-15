import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertTrue;

/**
 * Created by mrusanova on 11/28/16.
 */
public class Helper {

    private final WebDriver driver;

    public Helper(WebDriver driver) {
        this.driver = driver;
    }

    public static int generateRandID() {
        int max = 2000000000;
        int min = 1000000000;
        Random rand = new Random();
        int randID = rand.nextInt((max - min) + 1) + min;
        return randID;
    }

    public void logout() {

        String javaScript = "document.getElementById('shared_header_user_nav').classList.add('open')";
        ((JavascriptExecutor) driver).executeScript(javaScript);

        driver.findElement(By.xpath("//a[@href='/account/logout']")).click();

        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        WebElement logoutArticle = driver.findElement(By.xpath("//article[@id='logout']"));

        Assert.assertEquals(true, logoutArticle.isDisplayed());


    }

    public void openLoginPage() {


        String javaScript = "document.getElementById('shared_header_user_nav').classList.add('open')";
        ((JavascriptExecutor) driver).executeScript(javaScript);

        driver.findElement(By.xpath("//a[@href='/account/login']")).click();

        WebElement loginArticle = driver.findElement(By.xpath("//article[@id='login_page']"));

        Assert.assertEquals(true, loginArticle.isDisplayed());

    }

    public void login(String Email, String Password) throws InterruptedException {

        driver.findElement(By.id("username")).sendKeys(Email);

        driver.findElement(By.id("login_credentials_password")).sendKeys(Password);

        driver.findElement(By.id("login_submit")).click();

        Thread.sleep(5000);

        assertTrue(driver.getTitle().equals("My DaWanda - DaWanda"));


    }

}






