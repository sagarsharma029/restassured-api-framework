package tests;

import base.BaseTest;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class UserPutApiTest extends BaseTest{

    @Test
    public void updateUserTest(){

        int userId = 1;

        String requestBody = "{\n" +
                "  \"email\": \"updateduser@test.com\",\n" +
                "  \"username\": \"updatedUser\",\n" +
                "  \"password\": \"newpassword123\",\n" +
                "  \"name\": {\n" +
                "    \"firstname\": \"Updated\",\n" +
                "    \"lastname\": \"User\"\n" +
                "  },\n" +
                "  \"address\": {\n" +
                "    \"city\": \"Mumbai\",\n" +
                "    \"street\": \"Street 10\",\n" +
                "    \"number\": 5,\n" +
                "    \"zipcode\": \"400001\",\n" +
                "    \"geolocation\": {\n" +
                "      \"lat\": \"10.000\",\n" +
                "      \"long\": \"20.000\"\n" +
                "    }\n" +
                "  },\n" +
                "  \"phone\": \"9999999999\"\n" +
                "}";

        Response response = given().contentType(ContentType.JSON).
                body(requestBody)
                .when()
                .put("/users/{id}", userId);

        response.then().log().all();

        Assert.assertEquals(response.getStatusCode(), 200, "User not updated.");

        String updatedEmail = response.jsonPath().getString("email");
        Assert.assertEquals(updatedEmail, "updateduser@test.com");

        String updatedUsername = response.jsonPath().getString("username");
        Assert.assertEquals(updatedUsername, "updatedUser");
    }
}
