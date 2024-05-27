package spec;

import helpers.CustomAllureListener;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import static io.restassured.RestAssured.with;
import static io.restassured.filter.log.LogDetail.*;
import static io.restassured.http.ContentType.JSON;
import tests.TestBase;

public class spec extends TestBase {
    public static RequestSpecification requestSpec = with()
            .filter(CustomAllureListener.withCustomTemplates())
            .log().all()
            .contentType(JSON);

    public static ResponseSpecification responseSpec = new ResponseSpecBuilder()
            .log(ALL)
            .expectStatusCode(200)
            .build();

public static ResponseSpecification responseAddBookSpecification = new ResponseSpecBuilder()
        .log(ALL)
        .expectStatusCode(201)
        .build();


    public static ResponseSpecification responseDeleteBookSpecification = new ResponseSpecBuilder()
            .log(ALL)
            .expectStatusCode(204)
            .build();
}