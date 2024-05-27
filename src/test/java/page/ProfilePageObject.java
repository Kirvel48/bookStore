package page;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import data.DataTest;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class ProfilePageObject {
    DataTest dataTest = new DataTest();
    private final SelenideElement loginName = $("#userName-value"),
            bookTable = $(".rt-table");

    public ProfilePageObject openPage() {
        open("/profile");
        return this;
    }

    public ProfilePageObject authorizationSuccessCheck() {
        loginName.shouldHave(Condition.text(dataTest.login));
        return this;
    }

    public ProfilePageObject bookAddCheck() {
        bookTable.shouldHave(Condition.text(dataTest.bookName));
        return this;
    }

    public void bookDeleteCheck() {
        bookTable.shouldNotHave(Condition.text(dataTest.bookName));
    }

    public ProfilePageObject deleteAllBook() {
        $(byText("Delete All Books")).click();
        $(byText("OK")).click();
        Selenide.confirm();
        return this;
    }
}
