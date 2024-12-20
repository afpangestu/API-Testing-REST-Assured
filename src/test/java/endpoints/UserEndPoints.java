package endpoints;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import pojo.User;
import routes.Routes;
import static io.restassured.RestAssured.given;

public class UserEndPoints {
    public static Response createUser(User payload) {
        return given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .body(payload)
                .when()
                .post(Routes.userCreatePostUrl);
    }

    public static Response loginUser(String username, String password) {
        return given()
                .header("Content-Type","application/json; charset=utf-8")
                .queryParams(username, password)
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .when()
                .get(Routes.userLoginGetUrl);
    }

    public static Response logoutUser() {
        return given()
                .get(Routes.userLogoutGetUrl);
    }

    public static Response updateUser(String username, User payload) {
        return given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .pathParam("username", username)
                .body(payload)
                .when()
                .put(Routes.userUpdatePutUrl);
    }

    public static Response deleteUser(String username) {
        return given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .pathParam("username", username)
                .when()
                .delete(Routes.userDeleteUrl);
    }

}
