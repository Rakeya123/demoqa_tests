package pageObjects.components;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;

public class TitleChek {
    public void titleApper() {

        $(".modal-dialog").shouldBe(appear);
        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));
    }

    public void titleDisApper() {

        $(".modal-dialog").shouldNot(appear);
        $("#example-modal-sizes-title-lg").shouldNotBe(visible);


    }
}
