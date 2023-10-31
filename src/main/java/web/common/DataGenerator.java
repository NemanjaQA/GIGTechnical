package web.common;

import com.github.javafaker.Faker;

import java.util.Locale;

public class DataGenerator {
    public static String generateFirstName(){
        return new Faker(new Locale("en-GB")).name().firstName();
    }
    public static String generateLastName(){
        return new Faker(new Locale("en-GB")).name().lastName();
    }
    public static String generatePostalCode(){
        return new Faker(new Locale("en-GB")).address().zipCode();
    }
}