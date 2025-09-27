package Com.Ejada.Core.Base.ApiTestBase;

import io.restassured.RestAssured;

public class Get {
    public static void  listOfBooks() {
        RestAssured
                .given()
                .header("type", "non-fiction")
                .header("limit", "20")
                .when()
                .get("https://simple-books-api.click/books")
                .then()
                .statusCode(200)
                .log().body();
    }
}
