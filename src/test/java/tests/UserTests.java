package tests;

import endpoints.UserEndPoints;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pojo.PojoLogin;

public class UserTests {
    PojoLogin userPayload;

    @BeforeClass
    public void setup() {
        userPayload = new PojoLogin();
        userPayload.setUsername("ini username");
        userPayload.setEmail("ini email");
        userPayload.setFirstname("ini firstname");
        userPayload.setLastname("ini lastname");
        userPayload.setPassword("ini password");
    }

    @Test
    public void createUser() {
        Response response = UserEndPoints.createUser(userPayload);
        response.then().log().body();

        Assert.assertEquals(response.statusCode(), 200);
    }
}
