package helpers;

import data.DataTest;
import models.ApiLoginTestResponse;
import org.junit.jupiter.api.extension.BeforeEachCallback;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.openqa.selenium.Cookie;

import static api.TokenProvider.requestToken;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class LoginExtension implements BeforeEachCallback {


    public static ApiLoginTestResponse authorizationResponse;

    public void beforeEach(ExtensionContext context) {
        DataTest dataTest = new DataTest();
        authorizationResponse = requestToken(dataTest.login, dataTest.password);

        open("/favicon.png");
        getWebDriver().manage().addCookie(new Cookie("userID", authorizationResponse.getUserId()));
        getWebDriver().manage().addCookie(new Cookie("expires", authorizationResponse.getExpires()));
        getWebDriver().manage().addCookie(new Cookie("token", authorizationResponse.getToken()));
    }

}
