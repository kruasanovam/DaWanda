import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Created by mrusanova on 11/28/16.
 */
public class DaActions {

    public void checkPageIsReady(WebDriver driver) {

        JavascriptExecutor js = (JavascriptExecutor)driver;


        //Initially bellow given if condition will check ready state of page.
        if (js.executeScript("return document.readyState").toString().equals("complete")){
            String thetitle = driver.getCurrentUrl();
        System.out.println(thetitle + " Page Is loaded.");
        return;
        }

        for (int i=0; i< 25; i++)
        {
            try
        {
                Thread.sleep(1000);
            }
            catch (InterruptedException e) {}



        //To check page ready state.
        if (js.executeScript("return document.readyState").toString().equals("complete")){
        break;
        }
        }
        }
}