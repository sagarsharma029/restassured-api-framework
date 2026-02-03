package tests;

import base.BaseTest;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;

public class UserSchemaValidationTest extends BaseTest {

    @Test
    public void validateUserSchemaTest() {

        logger.info("===== Starting User Schema Validation Test =====");

        given()
                .log().all()
                .when()
                .get("/users/1")
                .then()
                .log().all()
                .assertThat()
                .body(matchesJsonSchemaInClasspath("schema/user-schema.json"));

        logger.info("===== User Schema Validation Test Passed =====");
    }
}