package pageobjects;

import com.codeborne.selenide.SelenideElement;
import pageobjects.components.CalendarComponents;
import pageobjects.components.TitleCheck;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.executeJavaScript;

public class RegistrationPage {
    private final SelenideElement firstNameInput = $("#firstName"),
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
            cityInput = $("#stateCity-wrapper"),
            stateClick = $("#state"),
            cityClick = $("#city"),
            tableCheck = $(".table-responsive"),
            submitInput = $("#submit");

    CalendarComponents calendarComponents = new CalendarComponents();
    TitleCheck titleCheck = new TitleCheck();

    public RegistrationPage openPage() {
        open("/automation-practice-form");
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");
        return this;
    }

    public RegistrationPage setFirstName(String value) {
        firstNameInput.setValue(value);
        return this;

    }

    public RegistrationPage setLastName(String value) {
        lastNameInput.setValue(value);
        return this;
    }

    public RegistrationPage setEmail(String value) {
        emailInput.setValue(value);
        return this;
    }

    public RegistrationPage setUserNumber(String value) {
        userNumberInput.setValue(value);
        return this;
    }

    public RegistrationPage setGender(String value) {
        genderInput.$(byText(value)).click();
        return this;
    }

    public RegistrationPage setDayOfBirth(String day, String month, String year) {
        calendarInput.click();
        calendarComponents.setDate(day, month, year);

        return this;
    }

    public RegistrationPage setSubjects(String value) {
        subjectsInput.setValue(value);
        $(byText("Arts")).click();
        return this;
    }

    public RegistrationPage setHobby(String value) {
        hobbiesInput.$(byText(value)).click();
        return this;
    }

    public RegistrationPage upLoadPicture() {
        pictureInput.uploadFromClasspath("img/bio-photo.jpg");
        return this;
    }

    public RegistrationPage setAdress(String value) {
        adressInput.setValue(value);
        return this;
    }

    public RegistrationPage setStateUttar() {
        stateClick.click();
        stateUttarInput.click();
        return this;
    }

    public RegistrationPage setСity(String value) {

        cityClick.click();
        cityInput.$(byText(value)).click();
        return this;
    }

    public RegistrationPage clickSubmit() {
        submitInput.click();
        return this;
    }

    public RegistrationPage checkResults(String key, String value) {
        tableCheck.$(byText(key)).parent().shouldHave(text(value));
        return this;
    }

    public RegistrationPage titleExist() {
        titleCheck.titleAppear();

        return this;
    }

    public RegistrationPage titleNotExist() {
        titleCheck.titleDisAppear();

        return this;
    }

    public RegistrationPage firstNameEmpty() {
        firstNameInput.shouldHave((cssValue("border-color", "rgb(220, 53, 69)")));
        firstNameInput.shouldBe((empty));

        return this;
    }
}