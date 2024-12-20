package tests.ddt;

import org.testng.annotations.Test;
import pojo.User;
import utility.DataProviders;

public class DDTest {
    @Test(priority = 1, dataProvider = "Data", dataProviderClass = DataProviders.class)
    public void createUserTest(String uname, String fname, String lname, String mairu, String pwd, String phnmber) {
        User user = new User();
        user.setFirstName(fname);
        user.setLastname(lname);
        user.setUsername(uname);
        user.setEmail(mairu);
        user.setPassword(pwd);
        user.setPhone(phnmber);
    }
}
