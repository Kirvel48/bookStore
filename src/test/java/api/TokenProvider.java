package api;

import models.ApiLoginModel;
import models.ApiLoginResponseModel;

import static io.restassured.RestAssured.*;
import static spec.spec.requestSpec;
import static spec.spec.responseSpec;

public class TokenProvider {

    public static ApiLoginResponseModel requestToken(String login, String password){

        ApiLoginModel body = new ApiLoginModel();
        body.setUserName(login);
        body.setPassword(password);
        return
                given(requestSpec)
                        .body(body)
                        .when()
                        .post("/Account/v1/Login")
                        .then()
                        .spec(responseSpec)
                        .extract().as(ApiLoginResponseModel.class);
    }
}

