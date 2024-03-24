package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import pageObjects.RegistrashionPage;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;


public class DemoQaWishPageObjectsTest extends TextBox {

    RegistrashionPage registrashionPage = new RegistrashionPage();

    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920х1080";
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.pageLoadStrategy = "eager";


    }

    @Test
    void fillForTests() {


        registrashionPage.openPage()
                .setFirstName("Anna")
                .setLastName("Ivanova")
                .setEmail("111@mai.ru")
                .setGender("Female")
                .setUserNumber("7777777777")
                .setDayOfBirth("30", "July", "2008")
                .setSubjects("a")
                .setHobby("Sports")
                .upLoadPicture()
                .setAdress("Address1")
                .setStateUttar()
                .setSity("Lucknow")
                .clickSumbut();


        registrashionPage.checkResults("Student Name", "Anna")
                .checkResults("Student Email", "111@mai.ru")
                .checkResults("Address", "Address1")


        ;




       // $(".modal-dialog").shouldBe(appear);
       // $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));
       // $(".table-responsive").shouldHave(text("Anna"), text("Anna"), text("111@mai.ru"), text("Female"));
        Configuration.holdBrowserOpen = true;

    }

    @Test
    void onlyNeedForRegistrationTest() {
        open("/automation-practice-form");
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");
        $("#firstName").setValue("Anna");
        $("#lastName").setValue("Ivanova");
        $("#userEmail").setValue("111@mai.ru");
        $("#genterWrapper").$(byText("Female")).click();
        $("#userNumber").setValue("7777777777");


        $("#submit").click();
        $(".modal-dialog").shouldBe(appear);
        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));
        $(".table-responsive").shouldHave(text("Anna"), text("Anna"), text("111@mai.ru"), text("Female"));

    }

    @Test
    void negativeRegistrationTest() {
        open("/automation-practice-form");
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");
        //$("#firstName").setValue("Anna");
        $("#lastName").setValue("Ivanova");
        $("#userEmail").setValue("111@mai.ru");
        $("#genterWrapper").$(byText("Female")).click();
        $("#userNumber").setValue("7777777777");

        $("#submit").click();
        $(".modal-dialog").shouldNot(appear);
        $("#example-modal-sizes-title-lg").shouldNotBe(visible);

    }
}

