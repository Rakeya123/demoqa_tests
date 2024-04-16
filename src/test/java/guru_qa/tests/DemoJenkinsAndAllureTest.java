package guru_qa.tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import com.github.javafaker.Faker;
import guru_qa.pageobjects.RegistrationPage;
import guru_qa.utils.Attach;
import guru_qa.utils.RandomUtils;
import io.qameta.allure.*;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.*;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Map;

import static com.codeborne.selenide.Selenide.closeWebDriver;
import static guru_qa.utils.RandomUtils.*;
import static io.qameta.allure.Allure.step;


@Tag("simple")
public class DemoJenkinsAndAllureTest extends TestBase {

    RegistrationPage registrationPage = new RegistrationPage();


    @BeforeAll
    static void setup() {


        Configuration.remote = "https://user1:1234@selenoid.autotests.cloud/wd/hub";

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("selenoid:options", Map.<String, Object>of(
                "enableVNC", true,
                "enableVideo", true
        ));

        Configuration.browserCapabilities = capabilities;
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());

    }

    @AfterEach
    void afterEach() {
        Attach.screenshotAs("Last screenshot");
        Attach.pageSource();
        Attach.browserConsoleLogs();
        Attach.addVideo();
        closeWebDriver();
    }

    @Test
    @Feature("Issue в репозитории")
    @Story("Поиск Issue")
    @Owner("rakeya")
    @Severity(SeverityLevel.CRITICAL)
    @DisplayName("Регистрация всех данных форме")
    void fullForTests() {
        Faker faker = Faker.instance(Locale.US);
        Date birthday = faker.date().birthday();
        SimpleDateFormat yearFormatter = new SimpleDateFormat("yyyy");
        SimpleDateFormat monthFormatter = new SimpleDateFormat("MMMM", Locale.US);
        SimpleDateFormat dayFormatter = new SimpleDateFormat("dd");


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

        step("Открыть страницу регистации", () -> {
            registrationPage.openPage();

        });

        step("Заполнить форму регистации ", () -> {
            registrationPage.setFirstName(firstName)
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

        });

        step("Проверить правильное заполение формы", () -> {
            registrationPage.titleExist();
            registrationPage.checkResults("Student Name", firstName)
                    .checkResults("Student Email", userEmail)
                    .checkResults("Address", streetAddress)
                    .checkResults("Subjects", subject)
                    .checkResults("State and City", choiceState(stateIndex));


        });


    }

    @Test
    @Feature("Issue в репозитории")
    @Story("Поиск Issue")
    @Owner("rakeya")
    @Severity(SeverityLevel.CRITICAL)
    @DisplayName("Регистрация необходимых в форме")
    void onlyNeedForRegistrationTest() {
        Faker faker = new Faker();


        String firstName = faker.name().firstName();
        String lastName = faker.name().lastName();
        String gender = choiceRandomGender();
        String userNumber = String.valueOf(getRandomLong(1000000000L, 9999999999L));


        step("Открыть страницу", () -> {
            registrationPage.openPage();


        });


        step("Заполнить только необходимые поля", () -> {
            registrationPage.setFirstName(firstName)
                    .setLastName(lastName)
                    .setGender(gender)
                    .setUserNumber(userNumber)
                    .clickSubmit();


        });

        step("Проверить окртытие формы регистации ", () -> {
            registrationPage.titleExist();
            registrationPage.checkResults("Student Name", firstName)
                    .checkResults("Student Email", " ")
                    .checkResults("Address", " ")
                    .checkResults("State and City", " ");


        });
    }


    @Test
    @Feature("Issue в репозитории")
    @Story("Поиск Issue")
    @Owner("rakeya")
    @Severity(SeverityLevel.CRITICAL)
    @DisplayName("Пустое поле имени")
    void registrationWithoutFirstName() {
        Faker faker = new Faker();


        String lastName = faker.name().lastName();

        String gender = choiceRandomGender();
        String userNumber = String.valueOf(getRandomLong(1000000000L, 9999999999L));

        step("Открыть страницу", () -> {
            registrationPage.openPage();


        });

        step("Открыть страницу", () -> {
            registrationPage.setLastName(lastName)
                    .setGender(gender)
                    .setUserNumber(userNumber)
                    .clickSubmit();


        });

        step("Ошибка", () -> {
        registrationPage.titleNotExist();

        registrationPage.firstNameEmpty();
        });

    }
}
