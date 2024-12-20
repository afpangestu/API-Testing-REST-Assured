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

    @Test
    public void createUserTest() {
        Response response = UserEndPoints.createUser(user);
        response.then().log().body();
        Assert.assertEquals(response.statusCode(), 200);
        System.out.println("CREATE USER SUCCESS");
        System.out.println("=================================");
    }

    @Test
    public void loginUserTest() {
        Response response = UserEndPoints.loginUser(user.getUsername(), user.getPassword());
        response.then().log().body();
        Assert.assertEquals(response.statusCode(), 200);
        System.out.println("LOGIN USER SUCCESS");
        System.out.println("=================================");
    }
}
