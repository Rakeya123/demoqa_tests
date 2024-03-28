package guru_qa.utils;

import java.security.SecureRandom;

import java.util.concurrent.ThreadLocalRandom;

public class RandomUtils {
    public static String[] states = {"NCR","Uttar Pradesh", "Haryana", "Rajasthan"};
    public static String[] state0Values = {"Delhi", "Gurgaon", "Merrut"};
    public static String[] state1Values = {"Lucknow", "Merrut", "Agra"};
    public static String[] state2Values = {"Karnal", "Panipat"};
    public static String[] state3Values = {"Jaipur", "Jaiselmer"};

    public static void main(String[] args) {
        System.out.println(getRandomString(10));
        System.out.println(getRandomEmail());
        System.out.println(getRandomAdress());
        System.out.println(getRandomInt(111, 9999));
        System.out.println(choiceRandomGender());
        System.out.println(getRandomLong(1000000000l, 9999999999l));

    }

    public static String getRandomString(int len) {
        String AB = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdifghigklmnopqrstuvwxyz";
        SecureRandom rnd = new SecureRandom();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < len; i++)
            sb.append(AB.charAt(rnd.nextInt(AB.length())));
        return sb.toString();
    }

    public static String getRandomEmail() {
        return getRandomString(10) + "@ga.guru.ru";
    }

    public static String getRandomAdress() {
        return getRandomString(10) + " " + getRandomString(10) + " " + getRandomString(10);
    }

    public static int getRandomInt(int min, int max) {
        return ThreadLocalRandom.current().nextInt(min, max + 1);
    }

    public static String choiceRandomGender() {
        String[] genders = {"Male", "Other", "Female"};
        return getRandomItemFromArray(genders);
    }

    public static String getRandomItemFromArray(String[] array) {

        int index = getRandomInt(0, array.length - 1);
        return array[index];
    }

    public static long getRandomLong(long min, long max) {
        return ThreadLocalRandom.current().nextLong(min, max + 1);
    }

    public static String choiceRandomHobby() {
        String[] hobby = {"Sports", "Reading", "Music"};
        return getRandomItemFromArray(hobby);
    }

    public static String choiceSubject() {
        String[] subjects = {"Hindi", "English", "Maths", "Physics", "Chemistry", "Biology", "Computer Science",
                "Commerce", "Accounting", "Economics", "Arts", "Social Studies", "History", "Civics"};
        return getRandomItemFromArray(subjects);
    }

    public static String choiceMonth() {
        String[] month = {"March", "April", "May", "June", "July", "August", "September",
                "October", "November", "December", "January", "February"};
        return getRandomItemFromArray(month);
    }

    public static String choiceState(int index) {
        return states[index];
    }

    public static String getSateValue(int index) {

       if (index==0){
           int valueIndex =getRandomInt(0,state0Values.length-1);
           return state0Values[valueIndex];
        }
       else if (index==1){
           int valueIndex =getRandomInt(0,state1Values.length-1);
           return state1Values[valueIndex];

       }
       else if (index == 2){
           int valueIndex = getRandomInt(0,state2Values.length-1);
           return state2Values[valueIndex];
       }
       else {
           int valueIndex =getRandomInt(0,state3Values.length-1);
           return state3Values[valueIndex];
       }
    }
}
