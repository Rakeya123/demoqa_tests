package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Keys;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byTagName;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;


public class SelenideRepositorySearch {

    @BeforeAll
    static void beforeAll() {

        Configuration.baseUrl = "https://github.com/"
        ;
        }
    @Test
    void shouldFindeSelenideRepositoreAtTheTop(){

        // Откройте страницу Selenide в Github
open("/selenide/selenide");

        // Перейдите в раздел Wiki проекта
        $("#wiki-tab").click();

       // Убедитесь, что в списке страниц (Pages) есть страница SoftAssertions
       // $("a[href$=\"SoftAssertions\"]").shouldHave(text("Soft assertions")).shouldBe(visible);
        $$("a[class='internal present']").findBy(text("Soft assertions")).shouldBe(visible);
        // Откройте страницу SoftAssertions, проверьте что внутри есть пример кода для JUnit5
        $$("a[class='internal present']").findBy(text("Soft assertions")).click();
$("#user-content-3-using-junit5-extend-test-class").parent().shouldHave(text("Using JUnit5"));


        Configuration.holdBrowserOpen=true;
    }
}

