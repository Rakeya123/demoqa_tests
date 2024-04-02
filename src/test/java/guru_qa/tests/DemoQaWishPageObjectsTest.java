package guru_qa.tests;

import com.github.javafaker.Faker;
import guru_qa.utils.RandomUtils;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;
import guru_qa.pageobjects.RegistrationPage;

import static guru_qa.utils.RandomUtils.*;

public class DemoQaWishPageObjectsTest extends TestBase {

    RegistrationPage registrationPage = new RegistrationPage();



    @Test
    @Tag("smoke")
    void fullForTests() {
        Faker faker = Faker.instance();


        String firstName = faker.name().firstName();
        String lastName = faker.name().lastName();
        String userEmail = faker.internet().emailAddress();
        String streetAddress = faker.address().streetAddress();
        String gender = choiceRandomGender();
        String userNumber = String.valueOf(getRandomLong(1000000000L, 9999999999L));
        String hobby = choiceRandomHobby();
        String subject = choiceSubject();
        String day = choiceDayOfBirth();
        String year = String.valueOf(getRandomInt(1980, 2021));
        String month = choiceMonth();
        int stateIndex = getRandomInt(0, states.length - 1);

        registrationPage.openPage()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setEmail(userEmail)
                .setGender(gender)
                .setUserNumber(userNumber)
                .setDayOfBirth(day, month, year)
                .setSubjects(subject)
                .setHobby(hobby)
                .upLoadPicture()
                .setAdress(streetAddress)
                .setState(RandomUtils.choiceState(stateIndex))
                .setСity(RandomUtils.getSateValue(stateIndex))
                .clickSubmit();

        registrationPage.titleExist();
        registrationPage.checkResults("Student Name", firstName)
                .checkResults("Student Email", userEmail)
                .checkResults("Address", streetAddress)
                .checkResults("Subjects", subject)
                .checkResults("State and City", choiceState(stateIndex));

    }

    @Test
    void onlyNeedForRegistrationTest() {
        Faker faker = new Faker();


        String firstName = faker.name().firstName();
        String lastName = faker.name().lastName();
        String gender = choiceRandomGender();
        String userNumber = String.valueOf(getRandomLong(1000000000L, 9999999999L));

        registrationPage.openPage()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setGender(gender)
                .setUserNumber(userNumber)
                .clickSubmit();

        registrationPage.titleExist();
        registrationPage.checkResults("Student Name", firstName)
                .checkResults("Student Email", " ")
                .checkResults("Address", " ")
                .checkResults("State and City", " ");


    }

    @Test
    void registrationWithoutFirstName() {
        Faker faker = new Faker();


        String lastName = faker.name().lastName();

        String gender = choiceRandomGender();
        String userNumber = String.valueOf(getRandomLong(1000000000L, 9999999999L));

        registrationPage.openPage()
                .setLastName(lastName)
                .setGender(gender)
                .setUserNumber(userNumber)
                .clickSubmit();
        registrationPage.titleNotExist();

        registrationPage.firstNameEmpty();

    }
}

