import org.openqa.selenium.WebElement;

/**
 * Created by mrusanova on 11/28/16.
 */
public class DaActions
{

    public static void OpenRegpageViaHeader(Homepage home)
    {
        home.HeaderRegLink().click();
    }


    public static void ClickRegister(AccountLogin accountlogin)
    {
        accountlogin.RegisterLink().click();
    }


    }
