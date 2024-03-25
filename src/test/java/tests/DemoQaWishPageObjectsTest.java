package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import pageObjects.RegistrashionPage;


public class DemoQaWishPageObjectsTest {

    RegistrashionPage registrashionPage = new RegistrashionPage();

    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920х1080";
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.pageLoadStrategy = "eager";


    }

    @Test
    void fullForTests() {

        registrashionPage.openPage()
                .setFirstName("Anna")
                .setLastName("Ivanova")
                .setEmail("111@mai.ru")
                .setGender("Female")
                .setUserNumber("7777777777")
                .setDayOfBirth("12", "July", "2002")
                .setSubjects("a")
                .setHobby("Sports")
                .upLoadPicture()
                .setAdress("Address1")
                .setStateUttar()
                .setSity("Lucknow")
                .clickSumbut();

        registrashionPage.titleExist();
        registrashionPage.checkResults("Student Name", "Anna")
                .checkResults("Student Email", "111@mai.ru")
                .checkResults("Address", "Address1")
                .checkResults("State and City", "Uttar Pradesh Lucknow");


    }

    @Test
    void onlyNeedForRegistrationTest() {
        registrashionPage.openPage()
                .setFirstName("Anna")
                .setLastName("Ivanova")
                .setGender("Female")
                .setUserNumber("7777777777")
                .clickSumbut();

        registrashionPage.titleExist();
        registrashionPage.checkResults("Student Name", "Anna")
                .checkResults("Student Email", " ")
                .checkResults("Address", " ")
                .checkResults("State and City", " ");


        Configuration.holdBrowserOpen = true;

    }

    @Test
    void registrationWithoutFirstName() {
        registrashionPage.openPage()
                .setLastName("Ivanova")
                .setGender("Female")
                .setUserNumber("7777777777")
                .clickSumbut();
        registrashionPage.titleNotExist();

        registrashionPage.firstNameEmpty();

    }
}

