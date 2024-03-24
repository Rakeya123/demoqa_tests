package pageObjects;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import pageObjects.components.CalendarComponents;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.executeJavaScript;

public class RegistrashionPage {
    private SelenideElement firstNameInput = $("#firstName"),
            lastNameInput = $("#lastName"),
            emailInput = $("#userEmail"),
            userNumberInput = $("#userNumber"),
            genderInput = $("#genterWrapper"),
            calendarInput = $("#dateOfBirthInput"),
            subjectsInput = $("#subjectsInput"),
            hobbiesInput = $("#hobbiesWrapper"),
            pictureInput = $("#uploadPicture"),
            adressInput = $("#currentAddress"),
            stateUttarInput = $("#react-select-3-option-1"),
            cityInput = $("#stateCity-wrapper");

    CalendarComponents calendarComponents = new CalendarComponents();


    public RegistrashionPage openPage() {
        open("/automation-practice-form");
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");
        return this;
    }

    public RegistrashionPage setFirstName(String value) {
        firstNameInput.setValue(value);
        return this;

    }

    public RegistrashionPage setLastName(String value) {
        lastNameInput.setValue(value);
        return this;
    }

    public RegistrashionPage setEmail(String value) {
        emailInput.setValue(value);
        return this;
    }

    public RegistrashionPage setUserNumber(String value) {
        userNumberInput.setValue(value);
        return this;
    }

    public RegistrashionPage setGender(String value) {
        genderInput.$(byText(value)).click();
        return this;
    }

    public RegistrashionPage setDayOfBirth(String day, String month, String year) {
        calendarInput.click();
        calendarComponents.setDate(day, month, year);

        return this;
    }

    public RegistrashionPage setSubjects(String value) {
        subjectsInput.setValue(value);
        $(byText("Arts")).click();
        return this;
    }

    public RegistrashionPage setHobby(String value) {
        hobbiesInput.$(byText(value)).click();
        return this;
    }

    public RegistrashionPage upLoadPicture() {
        pictureInput.uploadFromClasspath("img/bio-photo.jpg");
        return this;
    }
    public RegistrashionPage setAdress (String value) {
        adressInput.setValue(value);
        return this;
    }

    public RegistrashionPage setStateUttar () {
        $("#state").click();
        stateUttarInput.click();
        return this;
    }
    public RegistrashionPage setSity (String value) {

        $("#city").click();
        cityInput.$(byText(value)).click();
        return this;
    }
}