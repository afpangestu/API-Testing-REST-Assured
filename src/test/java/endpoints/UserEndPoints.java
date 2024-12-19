package endpoints;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import pojo.PojoLogin;
import routes.Routes;

import static io.restassured.RestAssured.given;

public class UserEndPoints {
    public static Response createUser(PojoLogin payload) {
        return given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .body(payload)
                .when()
                .post(Routes.userCreatePostUrl);
    }

    public static Response loginUser(String username) {
        return given()
                .pathParam("username", username)
                .when()
                .get(Routes.userLoginGetUrl);
    }

    public static Response logoutUser() {
        return given()
                .get(Routes.userLogoutGetUrl);
    }

    public static Response updateUser(String username) {
        return given()
                .pathParam("username", username)
                .when()
                .put(Routes.userUpdatePutUrl);
    }

    public static Response deleteUser(String username) {
        return given()
                .pathParam("username", username)
                .when()
                .put(Routes.userDeleteUrl);
    }

}
