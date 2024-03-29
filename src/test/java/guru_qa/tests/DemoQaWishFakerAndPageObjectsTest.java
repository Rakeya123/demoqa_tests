package guru_qa.tests;

import com.github.javafaker.Faker;
import guru_qa.pageobjects.RegistrationPage;
import guru_qa.utils.RandomUtils;
import org.junit.jupiter.api.Test;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import static guru_qa.utils.RandomUtils.*;

public class DemoQaWishFakerAndPageObjectsTest extends TestBase {

    RegistrationPage registrationPage = new RegistrationPage();


    @Test
    void fullForTests() {
        Faker faker = new Faker(Locale.US);
        Date birthday = faker.date().birthday();
        SimpleDateFormat yearFormatter = new SimpleDateFormat("yyyy");
        SimpleDateFormat monthFormatter = new SimpleDateFormat("MMMM", Locale.US) ;
        SimpleDateFormat dayFormatter= new SimpleDateFormat("dd");


        String firstName = faker.name().firstName();
        String lastName = faker.name().lastName();
        String userEmail = faker.internet().emailAddress();
        String streetAddress = faker.address().streetAddress();
        String gender = choiceRandomGender();
        String userNumber = String.valueOf(getRandomLong(1000000000L, 9999999999L));
        String hobby = choiceRandomHobby();
        String subject = choiceSubject();
        String day = dayFormatter.format(birthday); // format: 2 digits, example - "01"
        String month = monthFormatter.format(birthday);
        String year = yearFormatter.format(birthday);
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

