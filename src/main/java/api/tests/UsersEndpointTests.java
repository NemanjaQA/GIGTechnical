package api.tests;

import api.pojo.User;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.Arrays;

public class UsersEndpointTests extends ApiBaseTest{
    @Parameters("usersEndpoint")
    @Test(testName = "Verify at least one user is returned.")
    public void firstTest(String usersEndpoint) {
        Response response = RestAssured.get(usersEndpoint);
        response.then().statusCode(200);

        User[] users = response.then()
                .extract()
                .as(User[].class);

        Assert.assertTrue(users.length>0, "At least one user should exist in response.");
    }

    @Parameters("usersEndpoint")
    @Test(testName = "Verify at least one username is starting with letter C.")
    public void secondTest(String usersEndpoint) {
        Response response = RestAssured.get(usersEndpoint);
        response.then().statusCode(200);

        User[] users = response.then()
                .extract()
                .as(User[].class);

        boolean usernameStartingWithC = Arrays.stream(users).anyMatch(user -> user.getName().startsWith("C"));

        Assert.assertTrue(usernameStartingWithC, "At least one username should start with 'C'.");
    }

    @Parameters("usersEndpoint")
    @Test(testName = "Verify at least one user is returned and print user details.")
    public void thirdTest(String usersEndpoint) {
        Response response = RestAssured.get(usersEndpoint);
        response.then().statusCode(200);

        User[] users = response.then()
                .extract()
                .as(User[].class);

        Assert.assertTrue(users.length>0, "At least one user should exist in response.");

        for(User user : users){
            System.out.println("User ID: " + user.getId());
            System.out.println("Name of user: " + user.getName());
            System.out.println("Email of user: " + user.getEmail());
            System.out.println("Gender of user: " + user.getGender());
            System.out.println("Status of user: " + user.getStatus());
            System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
        }
    }
}
