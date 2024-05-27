package api;

import static io.restassured.RestAssured.*;
import static spec.spec.*;

public class CollectionTests {

    public static void addBook(String userId, String bookId, String token) {
        String body = "{\"userId\": \"" + userId + "\",\"collectionOfIsbns\":[{\"isbn\":\"" + bookId + "\"}]}";
        given(requestSpec)
                .headers("Authorization", "Bearer " + token)
                .body(body)
                .post("https://demoqa.com/BookStore/v1/Books")
                .then()
                .spec(responseAddBookSpecification)
                .assertThat().statusCode(201);
    }

    public static void deleteAllBook(String userId, String token) {
        given(requestSpec)

                .headers("Authorization", "Bearer " + token)
                .params("UserId", userId)
                .delete("/BookStore/v1/Books/")
                .then()
                .spec(responseDeleteBookSpecification)
                .assertThat().statusCode(204);

    }
}