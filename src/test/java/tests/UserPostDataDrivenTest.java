package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.TestDataProvider;

import static io.restassured.RestAssured.*;

public class UserPostDataDrivenTest extends BaseTest {

    @Test(dataProvider = "userData", dataProviderClass = TestDataProvider.class)
    public void createUserWithMultipleData(String email, String username, String password) {

        logger.info("===== Starting Data Driven Create User Test =====");
        logger.info("Test Data -> Email: " + email + ", Username: " + username);

        String requestBody = "{\n" +
                "  \"email\": \"" + email + "\",\n" +
                "  \"username\": \"" + username + "\",\n" +
                "  \"password\": \"" + password + "\"\n" +
                "}";

        logger.info("Request Body: " + requestBody);

        int statusCode =
                given()
                        .header("Content-Type", "application/json")
                        .body(requestBody)
                        .log().all()
                        .when()
                        .post("/users")
                        .then()
                        .log().all()
                        .extract()
                        .statusCode();

        logger.info("Response Status Code: " + statusCode);

        Assert.assertEquals(statusCode, 201, "User not created!");

        logger.info("===== Data Driven Create User Test Passed =====");
    }
}