import io.restassured.RestAssured;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pojo.PojoLogin;


import java.util.HashMap;

public class MainRun {
    @BeforeClass
    public void setup() {
        RestAssured.baseURI = "https://secondhand.binaracademy.org";
//        RestAssured.baseURI = "https://reqres.in";
    }

    @Test
    public void testReqres() {
//        HashMap data = new HashMap();
//        data.put("email","ajiseller@mail.com");
//        data.put("password","ajiseller");
        PojoLogin data = new PojoLogin();
        data.setEmail("ajifauzi@mail.com");
        data.setPassword("ajiseller");

        RestAssured.given()
                .when()
//                .contentType("application/json")
                .body(data)
//                .post("/api/users")
                .post("/users/sign_in.json")
                .then().statusCode(201)
                .log().body();
    }
}
