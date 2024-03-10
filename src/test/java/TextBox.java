import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import java.io.File;
import java.util.Date;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class TextBox {
    @BeforeAll
    static void beforeAll(){
        Configuration.browserSize="1920*1080";
        Configuration.baseUrl="https://demoqa.com";

    }
    @Test
    void fillForTests() {
        File file = new File("src/test/resources/bio-photo.jpg");
        Configuration.pageLoadStrategy= "eager" ;
        open("/automation-practice-form");
        $("#firstName").setValue("Anna");
        $("#lastName").setValue("Ivanova");
        $("#userEmail").setValue("111@mai.ru");
        $(byText("Female")).click();

        $("#userNumber").setValue("7777777777");


      $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOptionByValue(String.valueOf(3));
        $(".react-datepicker__year-select").selectOptionByValue(String.valueOf(1985));
        $(byText("22")).click();
        $("#subjectsInput").setValue("subjects");
        $(byText("Sports")).click();
       $("#uploadPicture").uploadFromClasspath("");
        $("#currentAddress").setValue("Address1");
        $("#state").click();
        $("#react-select-3-option-1").click();
        $("#city").click();
        $("#react-select-4-option-1").click();

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
         $("#submit").click();


    }
}

