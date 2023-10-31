package api.tests;

import io.restassured.RestAssured;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class ApiBaseTest {
    @Parameters("baseUrl")
    @BeforeClass
    public void setup(String baseUrl){
        RestAssured.baseURI = baseUrl;
    }
}
