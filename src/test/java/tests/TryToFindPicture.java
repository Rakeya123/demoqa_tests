package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selectors;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

public class TryToFindPicture {
    @BeforeAll
    static void beforeAll() {

        Configuration.baseUrl = "https://github.com/"
        ;
    }
    @Test
    void shouldFindeSelenideRepositoreAtTheTop(){

        // Откройте страницу Selenide в Github
        open("/selenide/selenide");
        $("div.Layout-sidebar").$(byText("Contributors"))
                .closest("h2").sibling(0).$$("li").first().hover();
        $$(".Popover").findBy(visible).shouldHave(text("Andrei Solntsev"));

        sleep(600);
    }}
// .closest( "BorderGrid-cell").$("ul li").hover();