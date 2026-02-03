package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class UserGetApiTest extends BaseTest {

    @Test
    public void getAllUsersTest() {

        logger.info("===== Starting GET All Users Test =====");

        int statusCode =
                given()
                        .log().all()
                        .when()
                        .get("/users")
                        .then()
                        .log().all()
                        .extract()
                        .statusCode();

        logger.info("Response status code: " + statusCode);

        Assert.assertEquals(statusCode, 200, "Status code is not 200");

        logger.info("===== GET All Users Test Passed =====");
    }
}