package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.TestDataProvider;

import static io.restassured.RestAssured.*;

public class UserPostDataDrivenTest extends BaseTest{

    @Test(dataProvider = "userData", dataProviderClass = TestDataProvider.class)
    public void createUserWithMultipleData(String email, String username, String password){

        String requestBody = "{\n" +
                "  \"email\": \"" + email + "\",\n" +
                "  \"username\": \"" + username + "\",\n" +
                "  \"password\": \"" + password + "\"\n" +
                "}";

        int statusCode =
                given()
                        .header("Content-Type", "application/json")
                        .body(requestBody)
                .when()
                        .post("/users")
                .then()
                        .log().all().extract().statusCode();

        Assert.assertEquals(statusCode, 201, "User not created.");
    }
}