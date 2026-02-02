package tests;

import base.BaseTest;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import static io.restassured.RestAssured.*;

import org.testng.Assert;
import org.testng.annotations.Test;

public class UserPostApiTest extends BaseTest {

    @Test
    public void createUserTest() {
        String requestBody = "{\n" +
                "  \"email\": \"testuser@test.com\",\n" +
                "  \"username\": \"testuser123\",\n" +
                "  \"password\": \"password123\",\n" +
                "  \"name\": {\n" +
                "    \"firstname\": \"John\",\n" +
                "    \"lastname\": \"Doe\"\n" +
                "  },\n" +
                "  \"address\": {\n" +
                "    \"city\": \"Delhi\",\n" +
                "    \"street\": \"Street 1\",\n" +
                "    \"number\": 10,\n" +
                "    \"zipcode\": \"110001\",\n" +
                "    \"geolocation\": {\n" +
                "      \"lat\": \"-37.3159\",\n" +
                "      \"long\": \"81.1496\"\n" +
                "    }\n" +
                "  },\n" +
                "  \"phone\": \"1234567890\"\n" +
                "}";

        Response response =
                given()
                        .contentType(ContentType.JSON)
                        .body(requestBody)
                        .when()
                        .post("/users");

        response.then().log().all();

        Assert.assertEquals(response.getStatusCode(), 201, "User not created!");

        String id = response.jsonPath().getString("id");
        Assert.assertNotNull(id, "User ID is null.");

    }
}