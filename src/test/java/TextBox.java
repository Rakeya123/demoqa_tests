import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import java.io.File;
import java.util.Date;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class TextBox {
    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920*1080";
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.pageLoadStrategy = "eager";

    }

    @Test
    void fillForTests() {
        File file = new File("src/test/resources/bio-photo.jpg");

        open("/automation-practice-form");
        $("#firstName").setValue("Anna");
        $("#lastName").setValue("Ivanova");
        $("#userEmail").setValue("111@mai.ru");
        $(byText("Female")).click();
        $("#userNumber").setValue("7777777777");
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOptionByValue(String.valueOf(3));
        $(".react-datepicker__year-select").selectOptionByValue(String.valueOf(1985));
        $(byText("8")).click();
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

        $$("tr").get(1).shouldHave(text("Anna Ivanova"));
        $$("tr").get(2).shouldHave(text("111@mai.ru"));
        $$("tr").get(3).shouldHave(text("Female"));
        $$("tr").get(4).shouldHave(text("7777777777"));
        $$("tr").get(5).shouldHave(text("08 April,1985"));
        $$("tr").get(6).shouldHave(text("subjects"));
        $$("tr").get(7).shouldHave(text("Sports"));
        $$("tr").get(8).shouldHave(text("test"));
        $$("tr").get(9).shouldHave(text("Address1"));
        $$("tr").get(10).shouldHave(text("Uttar Pradesh Lucknow"));
    }
}

