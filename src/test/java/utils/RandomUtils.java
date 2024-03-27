package utils;

import java.security.SecureRandom;
import java.util.concurrent.ThreadLocalRandom;

public class RandomUtils {
public static void main (String[] args){
    System.out.println(getRandomString(10));
    System.out.println(getRandomEmail());
    System.out.println(getRandomAdress());
    System.out.println(getRandomGender());
}
    public static String getRandomString (int len){
String AB ="ABCDEFGHIJKLMNOPQRSTUVWXYZabcdifghigklmnopqrstuvwxyz";
        SecureRandom rnd = new SecureRandom();
        StringBuilder sb = new StringBuilder();
        for (int i =0; i < len; i++)
            sb.append(AB.charAt(rnd.nextInt(AB.length())));
        return sb.toString();
    }
    public static String getRandomEmail(){
    return getRandomString(10) + "@ga.guru.ru";
    }

    public static String getRandomAdress(){
        return getRandomString(10) + " "+ getRandomString(10)+" "+getRandomString(10);
    }

    public static int getRandomInt(int min, int max){
        return ThreadLocalRandom.current().nextInt(min, max+1);
    }

    public static String getRandomGender(){
        String[] genders = {"Male", "Other", "Female"};
        return getRandomItemFromArray(genders);
    }
    public static String getRandomItemFromArray(String[] array) {

        int index = getRandomInt(0, array.length-1);
        return array[index];
    }
}
