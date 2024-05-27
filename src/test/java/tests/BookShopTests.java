package tests;

import api.CollectionTests;
import data.DataTest;
import helpers.WithLogin;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import page.ProfilePageObject;

import static helpers.LoginExtension.authorizationResponse;
import static io.qameta.allure.Allure.step;

public class BookShopTests extends TestBase {
    DataTest dataTest = new DataTest();
    ProfilePageObject profilePageObject = new ProfilePageObject();

    @Test
    @DisplayName("Тест на удаление книги из корзины")
    @WithLogin
    @Tag("smoke")
    void bookDeleteTest() {
        step("Удаление книг из корзины", () -> CollectionTests.deleteAllBook(authorizationResponse.getUserId(), authorizationResponse.getToken()));
        step("Добавление книги в корзину", () -> CollectionTests.addBook(authorizationResponse.getUserId(), dataTest.bookId, authorizationResponse.getToken()));
        step("Переход на страницу профиля", () -> profilePageObject.openPage());
        step("Проверка успешной авторизации", () -> profilePageObject.authorizationSuccessCheck());
        step("Проверка наличия книги в корзине", () -> profilePageObject.bookAddCheck());
        step("Удаление книг из корзины", () -> profilePageObject.deleteAllBook());
        step("Проверка пустой корзины", () -> profilePageObject.bookDeleteCheck());


    }
}

