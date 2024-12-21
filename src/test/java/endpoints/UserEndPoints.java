package endpoints;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import pojo.User;

import java.util.ResourceBundle;

import static io.restassured.RestAssured.given;

public class UserEndPoints {
    // get value from properties file
    static ResourceBundle getValue() {
        return ResourceBundle.getBundle("routes");
    }

    public static Response createUser(User payload) {
        String userCreateUrl = getValue().getString("userCreatePostUrl");
        return given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .body(payload)
                .when()
                .post(userCreateUrl);
    }

    public static Response loginUser(String username, String password) {
        String userLoginUrl = getValue().getString("userLoginGetUrl");
        return given()
                .header("Content-Type","application/json; charset=utf-8")
                .queryParams(username, password)
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .when()
                .get(userLoginUrl);
    }

    public static Response logoutUser() {
        String userLogoutUrl = getValue().getString("userLogoutGetUrl");
        return given()
                .get(userLogoutUrl);
    }

    public static Response updateUser(String username, User payload) {
        String userUpdateUrl = getValue().getString("userUpdatePutUrl");
        return given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .pathParam("username", username)
                .body(payload)
                .when()
                .put(userUpdateUrl);
    }

    public static Response deleteUser(String username) {
        String userDeleteUrl = getValue().getString("userDeleteUrl");
        return given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .pathParam("username", username)
                .when()
                .delete(userDeleteUrl);
    }

}
