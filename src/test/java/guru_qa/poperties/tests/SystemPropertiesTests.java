package guru_qa.poperties.tests;


import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;

import static java.lang.String.format;

public class SystemPropertiesTests {

    @Test
    void systemPropertiesTest(){
        String browser = System.getProperty("browser");
        System.out.println(browser);
    }

    @Test
    void systemProperties1Test(){
        System.setProperty("browser", "chrome");
        String browser = System.getProperty("browser");
        System.out.println(browser);
    }

    @Test
    void systemProperties2Test(){

        String browser = System.getProperty("browser", "mozilla");
        System.out.println(browser);
    }

    @Test
    @Tag("property")
    void systemProperties3Test(){

        String browser = System.getProperty("browser", "mozilla");
        String size = System.getProperty("size", "12133");
        System.out.println(browser+" "+size);


        //gradle property_test -Dbrowser=opera
    }

    @Test
    @Tag("hello")
    void systemProperties4Test(){

        String name = System.getProperty("name", "default ");
        String massage  = format("hello", name);
        System.out.println(massage);


        //gradle property_test -Dbrowser="Alex Egorov"
        //gradle property_test "-Dbrowser=Alex Egorov"
    }
}


