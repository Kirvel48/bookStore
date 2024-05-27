package api;

import models.ApiLoginTest;
import models.ApiLoginTestResponse;

import static io.restassured.RestAssured.*;
import static spec.spec.requestSpec;
import static spec.spec.responseSpec;

public class TokenProvider {

    public static ApiLoginTestResponse requestToken(String login,String password){

        ApiLoginTest body = new ApiLoginTest();
        body.setUserName(login);
        body.setPassword(password);
        return
                given(requestSpec)
                        .when()
                        .post("https://demoqa.com/Account/v1/Login")
                        .then()
                        .spec(responseSpec)
                        .extract().as(ApiLoginTestResponse.class);
    }
}

