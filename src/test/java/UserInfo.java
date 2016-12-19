

/**
 * Created by mrusanova on 12/15/16.
 */
public class UserInfo {
    public static String firstname;
    public static String lastname;
    public static String username;
    public static String email;
    //public static String email = "mariatesting89+1095389771@gmail.com";
    public static String password;


    public static void SetValidInfo()

    {
        int randomID = Helper.generateRandID();
        firstname = "Some First Name";
        lastname = "Some Last Name";
        username = "frontend-test-user-" + randomID;
        email = "mariatesting89+" + randomID + "@gmail.com";
        password = "Welcome1";
    }

    public static void SetSpaceInfo()

    {
        firstname = " ";
        lastname = " ";
        username = " ";
        email = " ";
        password = " ";
    }

    public static void SetExistingInfo() {
        firstname = "Some First Name";
        lastname = "Some Last Name";
        username = "frontend-test-user-1095389771";
        email = "mariatesting89+1911876990@gmail.com";
        password = "Welcome1";
    }

    public static void SetInvalidInfo() {
        firstname = "...";
        lastname = ",";
        username = "fr";
        email = "mariatesting89+1911876990@gmail.";
        password = "1234";
    }
}
