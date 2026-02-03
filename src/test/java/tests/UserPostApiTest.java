package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class UserPostApiTest extends BaseTest {

    @Test
    public void createUserTest() {

        logger.info("===== Starting Create User (POST) API Test =====");

        String requestBody = "{\n" +
                "  \"email\": \"testuser@email.com\",\n" +
                "  \"username\": \"testuser\",\n" +
                "  \"password\": \"password123\"\n" +
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

        logger.info("===== Create User Test Passed =====");
    }
}