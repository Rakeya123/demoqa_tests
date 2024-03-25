package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class DemoQaClearTest extends TextBox {
    @BeforeAll
    static void beforeAll() {
        //  Configuration.browserSize = "1920*1080";
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.pageLoadStrategy = "eager";


    }

    @Test
    void fillForTests() {

        open("/automation-practice-form");
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");
        $("#firstName").setValue("Anna");
        $("#lastName").setValue("Ivanova");
        $("#userEmail").setValue("111@mai.ru");
        $("#genterWrapper").$(byText("Female")).click();
        $("#userNumber").setValue("7777777777");

        // Календарь
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption("July");
        $(".react-datepicker__year-select").selectOption("2008");
        $(".react-datepicker__day--030:not(.react-datepicker__day--outside-month)").click();

        $("#subjectsInput").setValue("a");
        $(byText("Arts")).click();
        $("#hobbiesWrapper").$(byText("Sports")).click();
        // Загрузка картинки
        $("#uploadPicture").uploadFromClasspath("img/bio-photo.jpg");
        $("#currentAddress").setValue("Address1");
        // Выбор штата
        $("#state").click();
        $("#react-select-3-option-1").click();
        $("#city").click();
        $("#stateCity-wrapper").$(byText("Lucknow")).click();


        $("#submit").click();
        $(".modal-dialog").shouldBe(appear);
        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));
        $(".table-responsive").shouldHave(text("Anna"), text("Anna"), text(" "), text("Female"));

    }
    @Test
    void onlyNeedForRegistration (){
        open("/automation-practice-form");
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");
        $("#firstName").setValue("Anna");
        $("#lastName").setValue("Ivanova");
        $("#genterWrapper").$(byText("Female")).click();
        $("#userNumber").setValue("7777777777");


        $("#submit").click();
        $(".modal-dialog").shouldBe(appear);
        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));
        $(".table-responsive").shouldHave(text("Anna"), text("Anna"), text("111@mai.ru"), text("Female"));

    }

    @Test
    void registrationWithoutFirstName(){
        open("/automation-practice-form");
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");
        $("#lastName").setValue("Ivanova");
        $("#userEmail").setValue("111@mai.ru");
        $("#genterWrapper").$(byText("Female")).click();
        $("#userNumber").setValue("7777777777");

        $("#submit").click();
        $(".modal-dialog").shouldNot(appear);
        $("#example-modal-sizes-title-lg").shouldNotBe(visible);
        $("#firstName").shouldHave((cssValue("border-color", "rgb(220, 53, 69)")));
        $("#firstName").shouldBe((empty));

    }
}



