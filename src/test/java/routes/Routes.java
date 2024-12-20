package routes;

public class Routes {
    public static String baseUrl = "https://petstore.swagger.io/v2";

    // USER MODULE
    public static String userCreatePostUrl = baseUrl + "/user";
    public static String userLoginGetUrl = baseUrl + "/user/login";
    public static String userLogoutGetUrl = baseUrl + "/user/logout";
    public static String userUpdatePutUrl = baseUrl + "/user/{username}";
    public static String userDeleteUrl = baseUrl + "/user/{username}";

    // Second Hand
    public static String baseUrlSH = "https://secondhand.binaracademy.org";
    public static String postRegisterSH = baseUrlSH + "/users.json";
    public static String postLoginSH = baseUrlSH + "/users/sign_in.json";
    public static String getCategoriesSH = baseUrlSH + "/categories.json";

}
