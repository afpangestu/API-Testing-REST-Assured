package tests.ddt;

import endpoints.UserEndPoints;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import pojo.User;
import utility.DataProviders;

public class DDTest {
    @Test(priority = 1, dataProvider = "all_data", dataProviderClass = DataProviders.class)
    public void createUserTest(String uname, String fname, String lname, String mairu, String pwd, String phnmber) {
        User user = new User();
        user.setFirstName(fname);
        user.setLastname(lname);
        user.setUsername(uname);
        user.setEmail(mairu);
        user.setPassword(pwd);
        user.setPhone(phnmber);

        Response response = UserEndPoints.createUser(user);
        response.then().log().body();
        Assert.assertEquals(response.getStatusCode(), 200);
        System.out.println("CREATE USER SUCCESS");
        System.out.println("=================================");}

    @Test(priority = 2, dataProvider = "by_user_n_pass", dataProviderClass = DataProviders.class)
    public void loginUserTest(String uname, String pwd) {
        Response response = UserEndPoints.loginUser(uname, pwd);
        response.then().log().body();
        Assert.assertEquals(response.getStatusCode(), 200);
        System.out.println("LOGIN USER SUCCESS");
        System.out.println("=================================");
    }

    @Test(priority = 3, dataProvider = "by_username", dataProviderClass = DataProviders.class)
    public void deleteUserTest(String uname) {
        Response response = UserEndPoints.deleteUser(uname);
        response.then().log().body();
        Assert.assertEquals(response.getStatusCode(), 200);
        System.out.println("DELETE USER SUCCESS");
        System.out.println("=================================");
    }
}
