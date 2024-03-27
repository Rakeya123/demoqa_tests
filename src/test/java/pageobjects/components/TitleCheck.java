package pageobjects.components;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;

public class TitleCheck {
    public void titleAppear() {

        $(".modal-dialog").shouldBe(appear);
        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));
    }

    public void titleDisAppear() {

        $(".modal-dialog").shouldNot(appear);
        $("#example-modal-sizes-title-lg").shouldNotBe(visible);


    }
}
