package tests;

import base.BaseTest;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.lang.ref.SoftReference;

import static io.restassured.RestAssured.*;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;

public class UserSchemaValidationTest extends BaseTest{

    @Test
    public void validateUserResponseFields(){

        Response response = given().
                when().
                get("/users/1");

        response.then().log().all();

        Assert.assertEquals(response.getStatusCode(),200);

        String email = response.jsonPath().getString("email");
        String username = response.jsonPath().getString("username");
        String firstName = response.jsonPath().getString("name.firstname");

        Assert.assertNotNull(email);
        Assert.assertNotNull(username);
        Assert.assertNotNull(firstName);
    }

    @Test
    public void validateUserSchema() {

        given()
                .when()
                .get("/users/1")
                .then()
                .assertThat()
                .statusCode(200)
                .body(matchesJsonSchemaInClasspath("schema/user-schema.json"));
    }
}
