package guru_qa.tests;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static guru_qa.tests.TestData.*;

public class DemoQaClearWithTestDataTest extends TestBase {

//  static   String firstName,
//            lastName,
//            userEmail;
//
//
//    @BeforeEach
//    void prepareTestData()

//    {
//        firstName = "Anna";
//        lastName = "Ivanona";
//        userEmail = "pomidor@mai.ru";
//    }


    @Test
    void fullForTests() {

        open("/automation-practice-form");
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");
        $("#firstName").setValue(firstName);
        $("#lastName").setValue(lastName);
        $("#userEmail").setValue(userEmail);
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
        $(".table-responsive").shouldHave(text(firstName), text(firstName), text(" "), text("Female"));

    }
    @Test
    void onlyNeedForRegistration (){
        open("/automation-practice-form");
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");
        $("#firstName").setValue(firstName);
        $("#lastName").setValue(lastName);
        $("#genterWrapper").$(byText("Female")).click();
        $("#userNumber").setValue("7777777777");


        $("#submit").click();
        $(".modal-dialog").shouldBe(appear);
        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));
        $(".table-responsive").shouldHave(text(firstName), text(firstName), text(userEmail), text("Female"));

    }

    @Test
    void registrationWithoutFirstName(){
        open("/automation-practice-form");
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");
        $("#lastName").setValue(lastName);
        $("#userEmail").setValue(userEmail);
        $("#genterWrapper").$(byText("Female")).click();
        $("#userNumber").setValue("7777777777");

        $("#submit").click();
        $(".modal-dialog").shouldNot(appear);
        $("#example-modal-sizes-title-lg").shouldNotBe(visible);
        $("#firstName").shouldHave((cssValue("border-color", "rgb(220, 53, 69)")));
        $("#firstName").shouldBe((empty));

    }
}



