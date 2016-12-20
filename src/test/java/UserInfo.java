/**Methods used to set certain info for User. */

public class UserInfo {
    public static String firstname;
    public static String lastname;
    public static String username;
    public static String email;
    public static String password;


    /** Set all fields for a user to be valid. */
    public static void setValidInfo() {
        int randomID = Helper.generateRandID();
        firstname = "Some First Name";
        lastname = "Some Last Name";
        username = "frontend-test-user-" + randomID;
        email = "mariatesting89+" + randomID + "@gmail.com";
        password = "Welcome1";
    }

    /** Set all fields for a user to contain spaces only. */
    public static void setSpaceInfo() {
        firstname = " ";
        lastname = " ";
        username = " ";
        email = " ";
        password = " ";
    }

    /** Set a user with existing email and username in DB. */
    public static void setExistingInfo() {
        firstname = "Some First Name";
        lastname = "Some Last Name";
        username = "frontend-test-user-1095389771";
        email = "mariatesting89+1911876990@gmail.com";
        password = "Welcome1";
    }

    /** Set all fields for a user to be invalid. */
    public static void setInvalidInfo() {
        firstname = "...";
        lastname = ",";
        username = "fr";
        email = "mariatesting89+1911876990@gmail.";
        password = "1234";
    }
}
