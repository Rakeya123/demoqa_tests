package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.*;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class SimpleJunitTest {
    int result;
    @BeforeAll
    static void beforeAll(){
        System.out.println("###   BeforeAll()\n");

    }
    @BeforeEach
    void beforeEach(){
        System.out.println("###   BeforeEach()");
        result = getResult();
    }

    @AfterEach
    void afterEach(){
        System.out.println("###   AfterEach()\n");
        result = 0;
    }
    @AfterAll
    static void afterAll(){
        System.out.println("\n###   AfterAll()\n");

    }
    @Test
    void firstTest() {

        System.out.println("###  FirstTest");
        Assertions.assertTrue(result > 2);
    }


    @Test
    void secondTest() {

        System.out.println("###  SecondTest");
        Assertions.assertTrue(result>2);
    }

    @Test
    void thirdTest() {

        System.out.println("###  TirdTest");
        Assertions.assertTrue(result>2);
    }
    private int getResult () {
        return 3;
    }
}
