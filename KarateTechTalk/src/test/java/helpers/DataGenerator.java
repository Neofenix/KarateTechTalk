package helpers;

import com.github.javafaker.Faker;

public class DataGenerator {

  public static String getRandomEmail(){
    Faker faker = new Faker();
    String email = faker.name().firstName().toLowerCase() + faker.random().nextInt(0, 100) + "@test.com";
    return email;
  }

  public static String getRandomUser(){
    Faker faker = new Faker();
    return faker.name().username().toUpperCase().replace(".","");
  }

  public static String getToken(){
    Faker faker = new Faker();
    return faker.random().hex();
  }

  public static int getRandomId(){
    Faker faker = new Faker();
    return faker.random().nextInt(0,50000);
  }

}
