package tests;

import org.junit.jupiter.api.Test;
import pageobjects.RegistrationPage;


public class DemoQaWishPageObjectsTest  extends TestBase {

    RegistrationPage registrationPage = new RegistrationPage();


    @Test
    void fullForTests() {

        registrationPage.openPage()
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
                .setСity("Lucknow")
                .clickSubmit();

        registrationPage.titleExist();
        registrationPage.checkResults("Student Name", "Anna")
                .checkResults("Student Email", "111@mai.ru")
                .checkResults("Address", "Address1")
                .checkResults("State and City", "Uttar Pradesh Lucknow");


    }

    @Test
    void onlyNeedForRegistrationTest() {
        registrationPage.openPage()
                .setFirstName("Anna")
                .setLastName("Ivanova")
                .setGender("Female")
                .setUserNumber("7777777777")
                .clickSubmit();

        registrationPage.titleExist();
        registrationPage.checkResults("Student Name", "Anna")
                .checkResults("Student Email", " ")
                .checkResults("Address", " ")
                .checkResults("State and City", " ");


    }

    @Test
    void registrationWithoutFirstName() {
        registrationPage.openPage()
                .setLastName("Ivanova")
                .setGender("Female")
                .setUserNumber("7777777777")
                .clickSubmit();
        registrationPage.titleNotExist();

        registrationPage.firstNameEmpty();

    }
}

