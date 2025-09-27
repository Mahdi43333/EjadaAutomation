package Com.Ejada.Core.Base.ApiTestBase;

import io.restassured.RestAssured;
import io.restassured.response.Response;

import java.util.UUID;

public class Post {
    static String accessToken, orderId;
    public static String dynamicEmail;

    public static String generateEmail() {
        return "test" + UUID.randomUUID().toString().substring(0, 6) + "@ejada.com";
    }
    public static void accessToken() {
        String email = Post.generateEmail();
        String requestBody = "{\n" +
                "   \"clientName\": \"Postman\",\n" +
                "   \"clientEmail\": \""+email+"\"\n" +
                "}";
        Response response = RestAssured
                .given()
                .body(requestBody)
                .when()
                .post("https://simple-books-api.click/api-clients/");
        System.out.println("Status code: " + response.getStatusCode());
        System.out.println("Response: " + response.asString());
        accessToken = response.jsonPath().getString("accessToken");
    }

    public static void submitOrder() {
        String requestBody = "{\n" +
                "  \"bookId\": 1,\n" +
                "  \"customerName\": \"John\"\n" +
                "}";
        Response response = RestAssured
                .given()
                .header("Authorization", accessToken)
                .body(requestBody)
                .when()
                .post("https://simple-books-api.click/orders");
        System.out.println("Status code: " + response.getStatusCode());
        System.out.println("Response: " + response.asString());
        orderId = response.jsonPath().getString("orderId");
    }

    public static void deleteOrder() {
        Response response = RestAssured
                .given()
                .header("Authorization", accessToken)
                .when()
                .delete("https://simple-books-api.click/orders/" + orderId);
        System.out.println("Status code: " + response.getStatusCode());
        System.out.println("Response: " + response.asString());
    }
}
