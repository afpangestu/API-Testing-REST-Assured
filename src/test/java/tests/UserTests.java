package tests;

import endpoints.UserEndPoints;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pojo.User;

public class UserTests {
    User user;
    @BeforeClass
    public void setup() {
        user = new User();
        user.setFirstName("Aji Fauzi");
        user.setLastname("Pangestu");
        user.setUsername("afpgntng");
        user.setEmail("ajifauzi@rocketmail.com");
        user.setPassword("rahasia");
        user.setPhone("08742313");
    }

    @Test(priority = 1)
    public void createUserTest() {
        Response response = UserEndPoints.createUser(user);
        response.then().log().body();
        Assert.assertEquals(response.statusCode(), 200);
        System.out.println("CREATE USER SUCCESS");
        System.out.println("=================================");
    }

    @Test(priority = 2)
    public void loginUserTest() {
        Response response = UserEndPoints.loginUser(this.user.getUsername(), this.user.getPassword());
        response.then().log().body();
        Assert.assertEquals(response.statusCode(), 200);
        System.out.println("LOGIN USER SUCCESS");
        System.out.println("=================================");
    }

    @Test(priority = 3)
    public void updateUserTest() {
        user = new User();
        user.setFirstName("UPDATE Aji Fauzi");
        user.setLastname("UPDATEPangestu");
        user.setUsername("UPDATE afpgntng");
        user.setEmail("UPDATE@rocketmail.com");
        user.setPassword("UPDATErahasia");
        user.setPhone("14242142");
        Response response = UserEndPoints.updateUser(user.getUsername(), user);
        response.then().log().body();
        Assert.assertEquals(response.statusCode(), 200);
        System.out.println("UPDATE USER SUCCESS");
        System.out.println("=================================");
    }

    @Test(priority = 4)
    public void logoutUserTest() {
        Response response = UserEndPoints.logoutUser();
        response.then().log().body();
        Assert.assertEquals(response.statusCode(), 200);
        System.out.println("LOGOUT USER SUCCESS");
        System.out.println("=================================");
    }

    @Test(priority = 5)
    public void deleteUserTest() {
        Response response = UserEndPoints.deleteUser(this.user.getUsername());
        response.then().log().body();
        Assert.assertEquals(response.statusCode(), 200);
        System.out.println("DELETE USER SUCCESS");
        System.out.println("=================================");
    }
}
