package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class TextBox {
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
        // $("#submit").scrollTo();
        $("#hobbiesWrapper").$(byText("Sports")).click();

        // Загрузка картинки
        $("#uploadPicture").uploadFromClasspath("img/bio-photo.jpg");
        $("#currentAddress").setValue("Address1");

        // Выбор штата
        $("#state").click();
        $("#react-select-3-option-1").click();
        $("#city").click();
        // $("#react-select-4-option-1").click();
        $("#stateCity-wrapper").$(byText("Lucknow")).click();


        $("#submit").click();
$(".modal-dialog").shouldBe(appear);
$("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));
$(".table-responsive").shouldHave(text("Anna"),text("Anna"),text("111@mai.ru"),text("Female"));

        $$("tr").get(1).shouldHave(text("Anna"));
        $$("tr").get(2).shouldHave(text("111@mai.ru"));
        $$("tr").get(3).shouldHave(text("Female"));
        $$("tr").get(4).shouldHave(text("7777777777"));
        $$("tr").get(5).shouldHave(text("30 July,2008"));
        $$("tr").get(6).shouldHave(text("Arts"));
        $$("tr").get(7).shouldHave(text("Sports"));
        $$("tr").get(8).shouldHave(text("bio-photo.jpg"));
        $$("tr").get(9).shouldHave(text("Address1"));
        $$("tr").get(10).shouldHave(text("Uttar Pradesh Lucknow"));
    }
}

